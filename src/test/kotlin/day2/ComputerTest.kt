package day2

import intcode.Computer
import org.junit.Test
import kotlin.test.assertEquals

internal class ComputerTest {
    @Test
    fun `input of 1,0,0,0,99`() {
        val input = arrayListOf(1,0,0,0,99)
        val computer = Computer(input)

        assertEquals(2, computer.run())
    }

    @Test
    fun `input of 2,3,0,3,99`() {
        val input = arrayListOf(2,3,0,3,99)
        val computer = Computer(input)

        assertEquals(2, computer.run())
    }

    @Test
    fun `input of 2,4,4,5,99,0`() {
        val input = arrayListOf(2,4,4,5,99,0)
        val computer = Computer(input)

        assertEquals(2, computer.run())
    }

    @Test
    fun `input of 1,1,1,4,99,5,6,0,99`() {
        val input = arrayListOf(1,1,1,4,99,5,6,0,99)
        val computer = Computer(input)

        assertEquals(30, computer.run())
    }
}