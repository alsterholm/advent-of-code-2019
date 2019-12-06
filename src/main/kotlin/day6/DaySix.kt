package day6

import java.io.File

private fun getInput() = File("src/input/day6.txt")
        .useLines { it.toList() }
        .map{ it.split(")") }
        .map { Pair(it[0], it[1]) }

private fun createTree(input: List<Pair<String, String>>): TreeNode {
    val orbits = input.toMutableList()
    val root = orbits.find { it.first == "COM" }!!

    orbits.remove(root)

    val rootNode = TreeNode(name = root.first)
    rootNode.addChild(root.second)

    while (orbits.isNotEmpty()) {
        val next = orbits.first()
        val parent = rootNode.find(next.first)

        parent?.addChild(next.second) ?: orbits.add(next)
        orbits.remove(next)
    }

    return rootNode
}


object PartOne {
    fun solve(input: List<Pair<String, String>>): Int {
        val objects = input.flatMap { listOf(it.first, it.second)}.toSet()
        val tree = createTree(input)

        return objects.sumBy { tree.find(it)!!.depth() }
    }
}

object PartTwo {
    fun solve(input: List<Pair<String, String>>): Int {
        val tree = createTree(input)
        val me = tree.find("YOU")!!
        val santa = tree.find("SAN")!!

        val firstCommonParent = me.firstCommonParent(santa)!!

        return (me.parent!!.depth() - firstCommonParent.depth()) + (santa.parent!!.depth() - firstCommonParent.depth())
    }
}

fun main() {
    val input = getInput()
    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}