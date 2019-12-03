package day3

import java.io.File

private fun getInput() = File("src/input/day3.txt")
        .useLines { it.toList() }
        .map { line ->
            line.split(",").map {
                val direction = it[0]
                val steps = Integer.parseInt(it.replace(direction.toString(), ""))
                Instruction(direction, steps)
            }
        }

data class Instruction(val direction: Char, val steps: Int)

object PartOne {
    fun solve(instructions: List<List<Instruction>>): Int {
        val w1 = Wire(instructions[0])
        val w2 = Wire(instructions[1])

        return (w1.path intersect w2.path).map { it.manhattan(Point(0, 0)) }.min()!!
    }
}

object PartTwo {
    fun solve(instructions: List<List<Instruction>>): Int {
        val w1 = Wire(instructions[0])
        val w2 = Wire(instructions[1])
        val intersections = w1.path intersect w2.path

        return intersections.map { (w1 stepsToReach it) + (w2 stepsToReach it) }.min()!!
    }
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}