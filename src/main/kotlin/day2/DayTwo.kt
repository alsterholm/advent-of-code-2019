package day2

import intcode.Computer
import java.io.File

private fun getInput() = ArrayList<Int>(
    File("src/input/day2.txt")
        .readText()
        .split(",")
        .map { Integer.parseInt(it) }
)

object PartOne {
    fun solve(input: ArrayList<Int>) = Computer(input).withNoun(12).withVerb(2).run()
}

object PartTwo {
    fun solve(input: ArrayList<Int>): Int {
        val computer = Computer(input)

        for (noun in 0..99) {
            for (verb in 0..99) {
                if (computer.withNoun(noun).withVerb(verb).run() == 19690720) {
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