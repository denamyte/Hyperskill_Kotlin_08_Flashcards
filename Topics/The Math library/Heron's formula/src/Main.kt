import kotlin.math.*

fun main() {
    val (a, b, c) = List(3) { readln().toDouble() }
    val p = (a + b + c) / 2
    val s = sqrt(p * (p - a) * (p - b) * (p - c))
    println(s)
}