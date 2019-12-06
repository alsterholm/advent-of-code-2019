package day6

import org.junit.Test
import kotlin.test.assertEquals

internal class DaySixTest {
    @Test
    fun `part two`() {
        val input = listOf(
                Pair("COM", "B"),
                Pair("B", "C"),
                Pair("C", "D"),
                Pair("D", "E"),
                Pair("E", "F"),
                Pair("B", "G"),
                Pair("G", "H"),
                Pair("D", "I"),
                Pair("E", "J"),
                Pair("J", "K"),
                Pair("K", "L"),
                Pair("K", "YOU"),
                Pair("I", "SAN")
        )

        assertEquals(4, PartTwo.solve(input))
    }
}