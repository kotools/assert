import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

plugins {
    kotlin("multiplatform") version embeddedKotlinVersion
    id("org.jetbrains.dokka") version embeddedKotlinVersion
    `maven-publish`
    signing
}

group = "io.github.kotools"
version = "3.0.3-SNAPSHOT"

repositories(RepositoryHandler::mavenCentral)

val isSnapshot: Boolean by lazy { version.toString().endsWith("SNAPSHOT") }

object LibrarySourceSets {
    const val COMMON: String = "All platforms"
    const val JS: String = "JS"
    const val JVM: String = "JVM"
    const val NATIVE: String = "Native"

    private val mutableMap: MutableMap<String, KotlinSourceSet> = mutableMapOf()

    fun add(vararg sourceSets: Pair<String, KotlinSourceSet>): Unit =
        sourceSets.forEach { mutableMap += it }

    infix fun configure(task: DokkaTask) {
        task.dokkaSourceSets {
            mutableMap.forEach {
                named(it.value.name) { displayName.set(it.key) }
            }
        }
    }
}

java.targetCompatibility = JavaVersion.VERSION_1_8

kotlin {
    explicitApi = ExplicitApiMode.Strict
    jvm {
        compilations.all { kotlinOptions.jvmTarget = "1.8" }
    }
    js(BOTH, KotlinJsTargetDsl::browser)
    linuxX64()
    macosX64()
    mingwX64()
    sourceSets {
        val commonMain: KotlinSourceSet by getting {
            dependencies {
                implementation(project.dependencies.platform(kotlin("bom")))
                implementation(kotlin("test"))
            }
        }
        val jvmMain: KotlinSourceSet by getting {
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter-api:[5.6,5.7[")
            }
        }
        LibrarySourceSets.run { add(COMMON to commonMain, JVM to jvmMain) }
    }
}

// ---------- Tasks ----------

tasks.withType<Jar> {
    fun key(suffix: String): String = "Implementation-$suffix"
    val name: Pair<String, String> = key("Title") to project.name
    val version: Pair<String, Any> = key("Version") to project.version
    manifest.attributes(name, version)
}

val dokkaDirectory: File = buildDir.resolve("dokka")
tasks.dokkaHtml {
    outputDirectory.set(dokkaDirectory)
    LibrarySourceSets configure this
}
val cleanDokkaHtml: TaskProvider<Delete> =
    tasks.register<Delete>("cleanDokkaHtml") { delete(dokkaDirectory) }

val javadocJar: TaskProvider<Jar> = tasks.register<Jar>("javadocJar") {
    dependsOn(cleanDokkaHtml, tasks.dokkaHtml)
    archiveClassifier.set("javadoc")
    from(tasks.dokkaHtml)
}

tasks.assemble { dependsOn(javadocJar) }

tasks.withType<Sign> {
    onlyIf {
        val taskNames: List<String> = project.gradle.startParameter.taskNames
        val isPublishingToMavenLocal: Boolean =
            tasks.publishToMavenLocal.name in taskNames
        !isSnapshot && !isPublishingToMavenLocal
    }
}

// ---------- Publishing & signing ----------

publishing {
    repositories {
        maven {
            name = "GitHub"
            url = uri("https://maven.pkg.github.com/kotools/assert")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            name = "OSSRH"
            val uriSuffix: String =
                if (isSnapshot) "content/repositories/snapshots/"
                else "service/local/staging/deploy/maven2/"
            url = uri("https://s01.oss.sonatype.org/$uriSuffix")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
    publications {
        val kotlinMultiplatform by getting(MavenPublication::class) {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }
    publications.forEach {
        if (it !is MavenPublication) return@forEach
        it.artifact(javadocJar)
        it.pom {
            name.set("Kotools Assert")
            description.set("Lightweight and elegant assertions library.")
            val gitRepository = "https://github.com/kotools/assert"
            url.set(gitRepository)
            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            issueManagement {
                system.set("GitHub")
                url.set("$gitRepository/issues")
            }
            scm {
                connection.set("$gitRepository.git")
                url.set(gitRepository)
            }
            developers {
                developer {
                    val gitUser: String? = System.getenv("GIT_USER")
                    name.set(gitUser)
                    val gitEmail: String? = System.getenv("GIT_EMAIL")
                    email.set(gitEmail)
                }
            }
        }
        signing {
            val secretKey: String? = System.getenv("GPG_PRIVATE_KEY")
            val password: String? = System.getenv("GPG_PASSWORD")
            useInMemoryPgpKeys(secretKey, password)
            sign(it)
        }
    }
}

System.getenv("OS")?.let {
    setOf("GitHubRepository", "OSSRHRepository").forEach { repository: String ->
        tasks.getByName("publishAllPublicationsTo$repository") {
            val platforms: MutableList<String> = mutableListOf()
            when {
                it.startsWith("macos") -> platforms += "MacosX64"
                it.startsWith("windows") -> platforms += "MingwX64"
                it.startsWith("ubuntu") ->
                    setOf("KotlinMultiplatform", "Js", "Jvm", "LinuxX64")
                        .forEach { platforms += it }
            }
            val paths: Array<Task> = platforms.map { prefix: String ->
                tasks.getByName("publish${prefix}PublicationTo$repository")
            }.toTypedArray()
            dependsOn(*paths)
        }
    }
}
