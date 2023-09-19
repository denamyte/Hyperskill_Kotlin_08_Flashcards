import kotlin.math.*

fun main() {
    val (ax, ay) = inputV()
    val (bx, by) = inputV()
    val dotProduct = ax * bx + ay * by
    val mA = hypot(ax, ay)
    val mB = hypot(bx, by)

    val cos = dotProduct / (mA * mB)
    val angle = acos(cos)

    println(angle / PI * 180)
}

fun inputV() = readln().split(" ").map(String::toDouble).toList()
