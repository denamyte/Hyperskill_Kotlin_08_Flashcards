import kotlin.math.floor

fun main() {
    // (floor(b/n) - floor((a-1)/n))
    val (a, b, n) = List(3) { readln().toInt() }
    val nd = n.toDouble()
    println((floor(b / nd) - floor((a - 1) / nd)).toInt())
}