fun main() = println(readList() == readList())

fun readList() = readln()
    .split(", ")
    .toMutableList()
    .sorted()