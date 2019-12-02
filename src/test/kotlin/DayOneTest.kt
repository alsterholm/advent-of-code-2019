import org.junit.Test
import kotlin.test.assertEquals

internal class DayOneTest {
    @Test
    fun `mass of 12`() {
        assertEquals(2, PartOne.calculateFuel(12))
    }

    @Test
    fun `mass of 14`() {
        assertEquals(2, PartOne.calculateFuel(14))
    }

    @Test
    fun `mass of 1969`() {
        assertEquals(654, PartOne.calculateFuel(1969))
    }

    @Test
    fun `mass of 100756`() {
        assertEquals(33583, PartOne.calculateFuel(100756))
    }
}