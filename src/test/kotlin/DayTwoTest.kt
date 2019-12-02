import day2.PartOne
import org.junit.Test
import kotlin.test.assertEquals

internal class DayTwoTest {
    @Test
    fun `part one`() {
        assertEquals(2, PartOne.solve(arrayListOf(1, 0, 0, 0, 99)))
    }
}