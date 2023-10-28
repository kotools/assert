# Kotools Assert - Changelog

All notable changes to this project will be documented in this file.

> The format of this file is based on [Keep a Changelog][keep-a-changelog] and
> this project adheres to [Semantic Versioning][semantic-versioning].

## Types of changes

- `Added` for new features.
- `Changed` for changes in existing functionality.
- `Deprecated` for soon-to-be removed features.
- `Removed` for now removed features.
- `Fixed` for any bug fixes.
- `Security` in case of vulnerabilities.

## Unreleased

### Changed

- Reformat CHANGELOG documentation (issue [#39]).

## v3.0.2 <a id="v3.0.2"></a>

_Release date: 2022-09-10 | Commits: [v3.0.1...v3.0.2]._

### Fixed

- Correct the publication of artifacts for macOS and MinGW platforms (issue
  [#33]).

## v3.0.1 <a id="v3.0.1"></a>

_Release date: 2022-09-09 | Commits: [v3.0.0...v3.0.1]._

### Fixed

- Correct value in versioning annotations for indicating the first version of
  Kotools Assert where a given declaration has appeared (issue [#26]).

## v3.0.0 <a id="v3.0.0"></a>

_Release date: 2022-09-07 | Commits: [v2.1.0...v3.0.0]._

### Added

- Support for the following platforms: [Kotlin/JS] and
  [Kotlin Native][kotlin-native] for Linux x64, macOS x64 and MinGW x64 systems
  (issue [#21]).
- Functions `assertTrue`, `assertFalse`, `assertEquals`, `assertNotEquals`,
  `assertFails`, `assertFailsWith`, `assertNull` and `assertNotNull` for all
  platforms (issue [#21]).

### Removed

- Deprecated assertions in the `io.github.kotools.assert` package (issue [#19]).

## v2.1.0 <a id="v2.1.0"></a>

_Release date: 2022-08-03 | Commits: [v2.0.0...v2.1.0]._

### Added

- Boolean, nullability, equality and failure assertions in the `kotools.assert`
  package (issue [#15]).
- The `@SinceKotoolsAssert` annotation for indicating the first version of
  Kotools Assert where each declaration has appeared (issue [#16]).
- Add `@Test` and `@Nested` type aliases (issue [#20]).

### Deprecated

- Assertions in the `io.github.kotools.assert` package (issue [#15]).

## v2.0.0 <a id="v2.0.0"></a>

_Release date: 2022-04-11 | Commits: [v1.2.0...v2.0.0]._

### Removed

- Equality and nullability assertions with lazy messages (issue [#11]).

## v1.2.0 <a id="v1.2.0"></a>

_Release date: 2022-04-09 | Commits: [v1.1.0...v1.2.0]._

### Changed

- Split specific failure assertions `assertFailsWith` from untyped failure
  assertions `assertFails` (issue [#5]).

### Deprecated

- Equality and nullability assertions with lazy messages (issue [#5]).

### Removed

- Default messages from equality assertions (issue [#10]).

## v1.1.0 <a id="v1.1.0"></a>

_Release date: 2022-02-12 | Commits: [v1.0.0...v1.1.0]._

### Added

- Failure assertions with `assertFails` (issue [#1]).

## v1.0.0 <a id="v1.0.0"></a>

_Release date: 2022-02-12 | Commits: [v0.0.0...v1.0.0]._

### Added

- Equality assertions with `assertEquals` and `assertNotEquals`.
- Nullability assertions with `assertNull` and `assertNotNull`.

[#1]: https://github.com/kotools/assert/issues/1
[#5]: https://github.com/kotools/assert/issues/5
[#10]: https://github.com/kotools/assert/issues/10
[#11]: https://github.com/kotools/assert/issues/11
[#15]: https://github.com/kotools/assert/issues/15
[#16]: https://github.com/kotools/assert/issues/16
[#19]: https://github.com/kotools/assert/issues/19
[#20]: https://github.com/kotools/assert/issues/20
[#21]: https://github.com/kotools/assert/issues/21
[#26]: https://github.com/kotools/assert/issues/26
[#33]: https://github.com/kotools/assert/issues/33
[#39]: https://github.com/kotools/assert/issues/39
[keep-a-changelog]: https://keepachangelog.com/en
[kotlin/js]: https://kotlinlang.org/docs/js-overview.html
[kotlin-native]: https://kotlinlang.org/docs/native-overview.html
[semantic-versioning]: https://semver.org
[v3.0.1...v3.0.2]: https://github.com/kotools/assert/compare/v3.0.1...v3.0.2
[v3.0.0...v3.0.1]: https://github.com/kotools/assert/compare/v3.0.0...v3.0.1
[v2.1.0...v3.0.0]: https://github.com/kotools/assert/compare/v2.1.0...v3.0.0
[v2.0.0...v2.1.0]: https://github.com/kotools/assert/compare/v2.0.0...v2.1.0
[v1.2.0...v2.0.0]: https://github.com/kotools/assert/compare/v1.2.0...v2.0.0
[v1.1.0...v1.2.0]: https://github.com/kotools/assert/compare/v1.1.0...v1.2.0
[v1.0.0...v1.1.0]: https://github.com/kotools/assert/compare/v1.0.0...v1.1.0
[v0.0.0...v1.0.0]: https://github.com/kotools/assert/compare/v0.0.0...v1.0.0
