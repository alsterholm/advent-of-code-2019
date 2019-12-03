package day1

import java.io.File

private fun getInput() = File("src/input/day1.txt")
        .useLines { it.toList() }
        .map { Integer.parseInt(it) }

open class FuelCalculator {
    open fun calculateFuel(mass: Int) = mass / 3 - 2
    fun solve(masses: List<Int>) = masses.sumBy { calculateFuel(it) }
}

class RecursiveFuelCalculator : FuelCalculator() {
    override fun calculateFuel(mass: Int): Int {
        val fuel = super.calculateFuel(mass)
        if (fuel <= 0) return 0
        return fuel + calculateFuel(fuel)
    }
}

fun main() {
    val input = getInput()

    println("Part one: ${FuelCalculator().solve(input)}")
    println("Part two: ${RecursiveFuelCalculator().solve(input)}")
}