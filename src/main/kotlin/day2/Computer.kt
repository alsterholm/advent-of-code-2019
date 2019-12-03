package day2

class Computer(private val initialMemory: List<Int>) {
    fun run(noun: Int, verb: Int): Int {
        val memory = initialMemory.toIntArray()

        memory[1] = noun
        memory[2] = verb

        loop@ for (i in memory.indices step 4) {
            when (memory[i]) {
                1 -> memory[memory[i + 3]] = memory[memory[i + 1]] + memory[memory[i + 2]]
                2 -> memory[memory[i + 3]] = memory[memory[i + 1]] * memory[memory[i + 2]]
                else -> break@loop
            }
        }

        return memory[0]
    }
}