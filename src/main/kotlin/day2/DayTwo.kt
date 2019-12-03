package day2

import java.io.File

private fun getInput() = ArrayList<Int>(
    File("src/input/day2.txt")
        .readText()
        .split(",")
        .map { Integer.parseInt(it) }
)

object PartOne {
    fun solve(input: ArrayList<Int>) = Computer(input).run(noun = 12, verb = 2)
}

object PartTwo {
    fun solve(input: ArrayList<Int>): Int {
        val computer = Computer(input)

        for (noun in 0..99) {
            for (verb in 0..99) {
                if (computer.run(noun, verb) == 19690720) {
                    return 100 * noun + verb
                }
            }
        }

        return 0
    }
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part one: ${PartTwo.solve(input)}")
}