import kotlin.math.*

fun main() = readln().toDouble()
    .let { (it * 10).toInt() % 10 }
    .run(::print)