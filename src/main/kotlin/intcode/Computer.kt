package intcode

enum class Operation(val code: Int, val numberOfParameters: Int) {
    ADD(1, 4),
    MULTIPLY(2, 4),
    INPUT(3, 2),
    OUTPUT(4, 2),
    JUMP_IF_TRUE(5, 3),
    JUMP_IF_FALSE(6, 3),
    LESS_THAN(7, 4),
    EQUALS(8, 4),
    EXIT(99, 1)
}

class Computer(private val initialMemory: List<Int>, val input: Int = 1) {
    private var output: Int? = null
    private var memory = initialMemory.toIntArray()
    private var pointer = 0

    private var noun: Int? = null
    private var verb: Int? = null

    fun withNoun(noun: Int): Computer {
        this.noun = noun
        return this
    }

    fun withVerb(verb: Int): Computer {
        this.verb = verb
        return this
    }

    fun run(): Int {
        resetState()

        loop@ while (pointer < memory.size) {
            val opcode = memory[pointer].toString().padStart(5, '0')
            val operation = Operation.values().find { it.code == opcode.substring(3, 5).toInt() }!!

            val instruction = Instruction(
                    operation,
                    parameters = memory.slice(pointer + 1 until pointer + operation.numberOfParameters),
                    parameterModes = opcode.substring(0, 3).reversed().toList().map { it == '0' }
            )

            pointer = instruction.execute()
        }

        return if (output == null) memory[0] else output!!
    }

    private fun resetState() {
        pointer = 0
        memory = initialMemory.toIntArray()

        if (noun != null) memory[1] = noun!!
        if (verb != null) memory[2] = verb!!
    }

    inner class Instruction(private val operation: Operation,
                            private val parameters: List<Int>,
                            private val parameterModes: List<Boolean>
    ) {
        fun execute(): Int {
            when (operation) {
                Operation.ADD           -> memory[parameters[2]] = parameter(0) + parameter(1)
                Operation.MULTIPLY      -> memory[parameters[2]] = parameter(0) * parameter(1)
                Operation.INPUT         -> memory[parameters[0]] = input
                Operation.OUTPUT        -> output = parameter(0)
                Operation.JUMP_IF_TRUE  -> if (parameter(0) != 0) return parameter(1)
                Operation.JUMP_IF_FALSE -> if (parameter(0) == 0) return parameter(1)
                Operation.LESS_THAN     -> memory[parameters[2]] = if (parameter(0) < parameter(1)) 1 else 0
                Operation.EQUALS        -> memory[parameters[2]] = if (parameter(0) == parameter(1)) 1 else 0
                Operation.EXIT          -> return memory.size
            }

            return pointer + operation.numberOfParameters
        }

        private fun parameter(index: Int): Int =
                if (parameterModes[index]) memory[parameters[index]] else parameters[index]
    }
}