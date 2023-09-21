fun main() = readln().toInt()
    .let { cap ->
        var i = 1
        while (i * i <= cap) println(i * i)
            .also { i++ }
    }