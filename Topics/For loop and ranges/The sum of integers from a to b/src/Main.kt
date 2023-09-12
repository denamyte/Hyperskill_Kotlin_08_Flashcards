fun main() {
    val (a, b) = Array(2) { readln().toInt() }
    val sum = (a + b) * (b - a + 1) / 2
    println(sum)
}