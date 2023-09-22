val list = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun main() = readln()
    .let { list.indexOf(it) }
    .let(::println)