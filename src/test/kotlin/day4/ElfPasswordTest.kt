package day4

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ElfPasswordTest {
    @Test
    fun `111111 passes part one`() {
        val password = ElfPassword(111111)
        assertTrue(password.neverDecreases() && password.hasDigitsOccurringAtLeastTwice())
    }

    @Test
    fun `223450 fails part one because decreasing digits`() {
        val password = ElfPassword(223450)
        assertFalse(password.hasDigitsOccurringAtLeastTwice() && password.neverDecreases())
    }

    @Test
    fun `123789 fails part one because no double`() {
        val password = ElfPassword(123789)
        assertFalse(password.neverDecreases() && password.hasDigitsOccurringAtLeastTwice())
    }

    @Test
    fun `112233 passes part two`() {
        val password = ElfPassword(112233)
        assertTrue(password.neverDecreases() && password.hasDigitsOccurringExactlyTwice())
    }

    @Test
    fun `123444 fails part two it has no exactly two digit repeat`() {
        val password = ElfPassword(123444)
        assertFalse(password.neverDecreases() && password.hasDigitsOccurringExactlyTwice())
    }

    @Test
    fun `111122 passes part two`() {
        val password = ElfPassword(111122)
        assertTrue(password.neverDecreases() && password.hasDigitsOccurringExactlyTwice())
    }

    @Test
    fun `112222 passes part two`() {
        val password = ElfPassword(112222)
        assertTrue(password.neverDecreases() && password.hasDigitsOccurringExactlyTwice())
    }
}