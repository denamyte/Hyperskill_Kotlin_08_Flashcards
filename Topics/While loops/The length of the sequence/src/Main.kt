import java.util.Scanner

fun main() = Scanner(System.`in`)
    .tokens()
    .takeWhile { it != "0" }
    .toArray()
    .size
    .let(::println)