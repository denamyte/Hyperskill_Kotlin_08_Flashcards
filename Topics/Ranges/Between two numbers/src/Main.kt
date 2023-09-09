fun main() = Array(3) { readln().toInt() }
    .let { it[0] in it[1]..it[2] }
    .run(::println)