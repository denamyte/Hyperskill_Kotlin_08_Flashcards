fun main() = readln().split(" ")
    .let { "${it[0][0]}. ${it[1]}, ${it[2]} years old" }
    .let(::println)