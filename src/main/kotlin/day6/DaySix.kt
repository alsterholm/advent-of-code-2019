package day6

import java.io.File

private fun getInput() = File("src/input/day6.txt")
        .useLines { it.toList() }
        .map{ it.split(")") }
        .map { Pair(it[0], it[1]) }

private fun createTree(input: List<Pair<String, String>>): Node {
    val orbits = input.toMutableList()
    val root = orbits.find { it.first == "COM" }!!

    orbits.remove(root)

    val rootNode = Node(name = root.first)
    rootNode.addChild(root.second)

    while (orbits.isNotEmpty()) {
        val next = orbits.first()

        val parent = rootNode.find(next.first)

        orbits.remove(next)

        if (parent != null) {
            parent.addChild(next.second)
        } else {
            orbits.add(next)
        }
    }

    return rootNode
}

class Node(private val name: String, val parent: Node? = null) {
    private val children = mutableListOf<Node>()

    fun find(name: String): Node? {
        if (this.name == name) {
            return this
        }

        for (child in children) {
            val foundNode = child.find(name)

            if (foundNode != null) {
                return foundNode
            }
        }

        return null
    }

    fun addChild(name: String) {
        val child = Node(name, this)
        children.add(child)
    }

    fun depth(): Int {
        if (this.parent == null) {
            return 0
        }

        return 1 + this.parent.depth()
    }

    fun getParents(): List<Node> {
        if (parent == null) {
            return emptyList<Node>()
        }

        return parent.getParents() + parent
    }

    override fun toString(): String {
        return "Node(\"$name\")"
    }
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

        val myParents = me.getParents()
        val santaParents = santa.getParents()

        val firstCommonParent = myParents.reversed().find { santaParents.contains(it) }!!

        println("First common parent depth: ${firstCommonParent.depth()}")
        println("Me depth: ${me.parent!!.depth()}")
        println("Santa depth: ${santa.parent!!.depth()}")

        return (me.parent!!.depth() - firstCommonParent.depth()) + (santa.parent!!.depth() - firstCommonParent.depth())
    }
}

fun main() {
    val input = getInput()

    println("Part one: ${PartOne.solve(input)}")
    println("Part two: ${PartTwo.solve(input)}")
}