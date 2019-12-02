package day2

import java.io.File

private fun getInput() = ArrayList<Int>(
    File("src/input/day2.txt")
        .readText()
        .split(",")
        .map { Integer.parseInt(it) }
)

object Computer {
    fun run(memory: ArrayList<Int>, noun: Int, verb: Int): Int {
        memory[1] = noun
        memory[2] = verb

        loop@ for (i in 0..memory.size step 4) {
            when (memory[i]) {
                1 -> memory[memory[i + 3]] = memory[memory[i + 1]] + memory[memory[i + 2]]
                2 -> memory[memory[i + 3]] = memory[memory[i + 1]] * memory[memory[i + 2]]
                else -> break@loop
            }
        }

        return memory[0]
    }
}

object PartOne {
    fun solve(input: ArrayList<Int>) = Computer.run(input, 12, 2)
}

object PartTwo {
    fun solve(input: ArrayList<Int>): Int {
        for (noun in 0..99) {
            for (verb in 0..99) {
                if (Computer.run(ArrayList(input), noun, verb) == 19690720) {
                    return 100 * noun + verb
                }
            }
        }

        return 0
    }
}

fun main() {
    println("Part one: ${PartOne.solve(getInput())}")
    println("Part one: ${PartTwo.solve(getInput())}")
}