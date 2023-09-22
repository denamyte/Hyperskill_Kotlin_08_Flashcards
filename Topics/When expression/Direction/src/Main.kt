val list = listOf("do not move", "move up", "move down", "move left", "move right")

fun main() = readln().toInt()
    .let {
        if (it in list.indices) list[it]
        else "error!"
    }
    .let(::println)
