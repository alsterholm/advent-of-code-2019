package day1

import org.junit.Test
import kotlin.test.assertEquals

internal class RecursiveFuelCalculatorTest {
    private val calculator = RecursiveFuelCalculator()

    @Test
    fun `mass of 14`() {
        assertEquals(2, calculator.calculateFuel(14))
    }

    @Test
    fun `mass of 1969`() {
        assertEquals(966, calculator.calculateFuel(1969))
    }

    @Test
    fun `mass of 100756`() {
        assertEquals(50346, calculator.calculateFuel(100756))
    }
}