package day3

import org.junit.Test
import kotlin.test.assertEquals

internal class DayThreeTest {
    private fun transformInput(input: List<String>) = input.map { line ->
        line.split(",").map {
            val direction = it[0]
            val steps = Integer.parseInt(it.replace(direction.toString(), ""))
            Instruction(direction, steps)
        }
    }

    @Test
    fun `part one, example one`() {
        val input = transformInput(listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R8"))

        assertEquals(159, PartOne.solve(input))
    }

    @Test
    fun `part one, example two`() {
        val input = transformInput(listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))

        assertEquals(135, PartOne.solve(input))
    }

    @Test
    fun `part two, example one`() {
        val input = transformInput(listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"))

        assertEquals(610, PartTwo.solve(input))
    }

    @Test
    fun `part two, example two`() {
        val input = transformInput(listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))

        assertEquals(410, PartTwo.solve(input))
    }
}