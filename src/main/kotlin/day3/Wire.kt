package day3

class Wire(private val instructions: List<Instruction>) {
    val path: ArrayList<Point>
        get() {
            val path = ArrayList<Point>()
            for (instruction in instructions) {
                for (step in 1..instruction.steps) {
                    val last = if (path.isEmpty()) Point(0, 0) else path.last()

                    when (instruction.direction) {
                        'U' -> path.add(Point(last.x, last.y - 1))
                        'D' -> path.add(Point(last.x, last.y + 1))
                        'L' -> path.add(Point(last.x - 1, last.y))
                        'R' -> path.add(Point(last.x + 1, last.y))
                    }
                }
            }

            return path
        }

    infix fun stepsToReach(intersection: Point) = path.indexOf(intersection) + 1
}