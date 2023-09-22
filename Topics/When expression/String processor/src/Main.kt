fun main() {
    val v1 = readln()
    val op = readln()
    val v2 = readln()

    val res = when (op) {
        "equals" -> v1 == v2
        "plus" -> v1 + v2
        "endsWith" -> v1.endsWith(v2)
        else -> "Unknown operation"
    }

    println(res)
}