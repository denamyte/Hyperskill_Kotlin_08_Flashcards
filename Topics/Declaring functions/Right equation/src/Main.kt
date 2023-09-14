fun isRightEquation(a: Int, b: Int, c: Int) = a * b == c

fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }
    println(isRightEquation(a, b, c))
}

