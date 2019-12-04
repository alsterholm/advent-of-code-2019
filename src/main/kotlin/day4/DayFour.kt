package day4

class ElfPassword(digits: Int) {
    private val password = digits.toString().padStart(6, '0')

    fun hasDigitsOccurringAtLeastTwice() = password.any{ c -> password.count{ it == c } >= 2 }
    fun hasDigitsOccurringExactlyTwice() = password.any{ c -> password.count{ it == c } == 2 }
    fun neverDecreases() = password.indices.all { it == password.length - 1 || password[it] <= password[it + 1] }
}

object PartOne {
    fun solve(numbers: IntRange) =
            numbers.map(::ElfPassword)
                   .count { it.neverDecreases() && it.hasDigitsOccurringAtLeastTwice() }
}

object PartTwo {
    fun solve(numbers: IntRange) =
            numbers.map(::ElfPassword)
                   .count { it.neverDecreases() && it.hasDigitsOccurringExactlyTwice() }
}

fun main() {
    val range = 264793..803935

    println("Part one: ${PartOne.solve(range)}")
    println("Part two: ${PartTwo.solve(range)}")
}