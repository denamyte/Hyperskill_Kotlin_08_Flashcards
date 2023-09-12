fun main() {
    val (a, b, c, d) = List(4) { readln().toInt() }
    for (x in 0..1000) {
        if (a * x * x * x + b * x * x + c * x + d == 0) {
            println(x)
        }
    }
}