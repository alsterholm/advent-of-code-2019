package day7

import intcode.Computer
import java.io.File

private fun getInput() = ArrayList<Int>(
        File("src/input/day7.txt")
                .readText()
                .split(",")
                .map { Integer.parseInt(it) }
)

fun generateCombinations(initial: List<Int>): List<List<Int>> {
    val res = mutableListOf<List<Int>>()

    fun permutations(values: MutableList<Int>, size: Int, n: Int) {
        if (size == 1) {
            res.add(values.toList())
        }

        for (i in 0 until size) {
            permutations(values,  size - 1, n)

            if (size % 2 == 1) {
                val t = values[0]
                values[0] = values[size - 1]
                values[size - 1] = t
            } else {
                val t = values[i]
                values[i] = values[size - 1]
                values[size - 1] = t
            }
        }
    }

    permutations(initial.toMutableList(), initial.size, initial.size)

    return res
}

object PartOne {
    fun solve(input: List<Int>): Int {
        var highest = 0

        for (combination in generateCombinations((0..4).toList())) {
            var inputSignal = 0

            for (phaseSetting in combination) {
                inputSignal = Computer(input, mutableListOf(phaseSetting, inputSignal)).run()
            }

            if (inputSignal > highest) highest = inputSignal
        }

        return highest
    }
}

object PartTwo {
    fun solve(input: List<Int>): Int {
        var highest = 0
        val combinations = generateCombinations((5..9).toList())

        for (combination in combinations) {
            val computers = mutableListOf<Computer>()
            var computerPointer = 0

            for (phaseSetting in combination) {
                computers.add(Computer(input, phaseSetting))
            }

            computers.first().addInput(0)

            while (computers.last().isRunning()) {
                val computer = computers[computerPointer]

                val output = computer.run()

                computerPointer = (computerPointer + 1) % computers.size
                computers[computerPointer].addInput(output)
            }

            val output = computers.last().getOutput()!!

            if (output > highest) {
                highest = output
            }
        }

        return highest
    }
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}