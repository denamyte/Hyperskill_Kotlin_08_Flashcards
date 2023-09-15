fun main() = readln().split(", ")
    .toMutableList()
    .apply { add(readln()) }
    .joinToString()
    .let(::println)