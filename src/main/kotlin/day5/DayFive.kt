package day5

import intcode.Computer
import java.io.File

private fun getInput() = ArrayList<Int>(
        File("src/input/day5.txt")
                .readText()
                .split(",")
                .map { Integer.parseInt(it) }
)

object PartOne {
    fun solve(input: ArrayList<Int>): Int {
        return Computer(input).run()
    }
}

object PartTwo {
    fun solve(input: ArrayList<Int>): Int {
        return Computer(input, 5).run()
    }
}
fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part one: ${PartTwo.solve(input)}")
}