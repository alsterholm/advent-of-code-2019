package day6

class TreeNode(private val name: String, val parent: TreeNode? = null) {
    private val children = mutableListOf<TreeNode>()

    fun find(name: String): TreeNode? {
        if (this.name == name) return this

        for (child in children) {
            val foundNode = child.find(name)

            if (foundNode != null) {
                return foundNode
            }
        }

        return null
    }

    fun addChild(name: String) = children.add(TreeNode(name, this))

    fun depth(): Int = this.parent?.depth()?.plus(1) ?: 0

    fun firstCommonParent(other: TreeNode) = parents().find { other.parents().contains(it) }

    private fun parents(): List<TreeNode> {
        if (parent == null) {
            return emptyList()
        }

        return listOf(parent) + parent.parents()
    }

    override fun toString() = "Node(\"$name\")"
}