package io.github.kotools.assert

import kotlin.test.assertNull

/** Asserts that the result of [block] is `null`. */
public inline fun <T : Any?> assertNull(block: () -> T): Unit =
    assertNull(block())

/**
 * Asserts that the result of [block] is `null`, or report the [message] if not.
 */
public inline fun <T : Any?> assertNull(message: String, block: () -> T): Unit =
    assertNull(block(), message)

/** Asserts that the current value is `null`. */
public fun <T : Any?> T.assertNull(): Unit = assertNull(this)

/**
 * Asserts that the current value is `null`, or compute and report the
 * [lazyMessage]'s result if not.
 */
public inline infix fun <T : Any?> T.assertNull(
    lazyMessage: () -> String
): Unit = assertNull(this, lazyMessage())

/** Asserts that the current value is `null`, or report the [message] if not. */
public infix fun <T : Any?> T.assertNull(message: String): Unit =
    assertNull(this, message)