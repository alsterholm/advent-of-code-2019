package day4

class ElfPassword(digits: Int) {
    private val password = digits.toString().padStart(6, '0')

    fun hasDigitsOccurringAtLeastTwice() = hasOccurringDigitsWhere { it >= 2 }
    fun hasDigitsOccurringExactlyTwice() = hasOccurringDigitsWhere { it == 2 }
    fun neverDecreases() = password.toCharArray().sorted() == password.toList()

    private fun hasOccurringDigitsWhere(cb: (count: Int) -> Boolean) =
            password.any{ char -> cb(password.count{ it == char }) }
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