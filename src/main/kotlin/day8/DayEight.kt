package day8

import java.io.File

private const val IMAGE_WIDTH = 25
private const val IMAGE_HEIGHT = 6

private fun getInput() = ArrayList<Int>(
        File("src/input/day8.txt")
                .readText()
                .toCharArray()
                .map { it.toString().toInt() }
)

object PartOne {
    fun solve(input: ArrayList<Int>): Int {
        val layers = createImageLayers(input)
        val layerWithLeastZeroes = layers.minBy { l -> l.count { it == 0 } }!!

        return layerWithLeastZeroes.count { it == 1 } * layerWithLeastZeroes.count { it == 2 }
    }
}

object PartTwo {
    fun solve(input: ArrayList<Int>): String {
        val layers = createImageLayers(input)
        val numberOfPixels = layers.sumBy { it.size }
        val pixelsPerLayer = numberOfPixels / layers.size

        var output = ""

        for (i in 0 until pixelsPerLayer) {
            if (i % IMAGE_WIDTH == 0) {
                output += "\n"
            }
            output += getPixelCharacter(layers, i)
        }

        return output
    }
}

fun createImageLayers(input: ArrayList<Int>): List<List<Int>> {
    val layers = mutableListOf<List<Int>>()
    val pixelsPerLayer = IMAGE_WIDTH * IMAGE_HEIGHT
    val numberOfLayers = input.size / pixelsPerLayer

    for (n in 1..numberOfLayers) {
        val layer = mutableListOf<Int>()

        for (pixel in 0 until pixelsPerLayer) {
            layer.add(input[pixelsPerLayer * layers.size + pixel])
        }

        layers.add(layer)
    }

    return layers
}

private fun getPixelCharacter(layers: List<List<Int>>, index: Int): String {
    for (layer in layers) {
        if (layer[index] != 2) {
            return if (layer[index] == 1) "■" else " "
        }
    }

    return ""
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}