package day3

import kotlin.math.abs

data class Point(val x: Int, val y: Int) {
    fun manhattan(p: Point) = abs(x - p.x) + abs(y - p.y)
}