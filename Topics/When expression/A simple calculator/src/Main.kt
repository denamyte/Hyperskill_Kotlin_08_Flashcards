import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val v1 = scanner.nextLong()
    val op = scanner.next()
    val v2 = scanner.nextLong()

    val res = when (op) {
        "+" -> v1 + v2
        "-" -> v1 - v2
        "/" -> if (v2 == 0L) "Division by 0!" else v1 / v2
        "*" -> v1 * v2
        else -> "Unknown operator"
    }

    println(res)
}