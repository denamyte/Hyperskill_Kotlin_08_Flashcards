fun main() = Array(readln().toInt()) { readln().toInt() }
    .sorted()
    .takeLast(2)
    .reduce(Int::times)
    .run(::println)