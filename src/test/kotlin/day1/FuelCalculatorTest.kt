package day1

import org.junit.Test
import kotlin.test.assertEquals

internal class FuelCalculatorTest {
    private val calculator = FuelCalculator()

    @Test
    fun `mass of 12`() {
        assertEquals(2, calculator.calculateFuel(12))
    }

    @Test
    fun `mass of 14`() {
        assertEquals(2, calculator.calculateFuel(14))
    }

    @Test
    fun `mass of 1969`() {
        assertEquals(654, calculator.calculateFuel(1969))
    }

    @Test
    fun `mass of 100756`() {
        assertEquals(33583, calculator.calculateFuel(100756))
    }
}