val F = listOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55)
val T = listOf(0, 1, 3, 6, 10, 15, 21, 28, 36, 45)
val P = listOf(1, 10, 100, 1000, 10000, 100000)

fun main() = when (readln().toInt()) {
    in F -> "F"
    in T -> "T"
    in P -> "P"
    else -> "N"
}.let(::println)