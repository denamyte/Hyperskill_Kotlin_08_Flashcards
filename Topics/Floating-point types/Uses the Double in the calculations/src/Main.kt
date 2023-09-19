import kotlin.math.pow

fun main() = readln().toDouble()
    .run { (0..3).sumOf { this.pow(it) } }
    .run(::println)