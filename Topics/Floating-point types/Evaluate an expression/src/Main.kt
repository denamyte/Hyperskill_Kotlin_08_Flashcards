fun main() {
    val (a, b, c, d) = Array(4) { readln().toDouble() }
    println(a * 10.5 + b * 4.4 + (c + d) / 2.2)
}