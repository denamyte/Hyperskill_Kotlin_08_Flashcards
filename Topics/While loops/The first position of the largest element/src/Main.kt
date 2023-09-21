import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val list = mutableListOf<Int>()
    while (sc.hasNextInt()) list += sc.nextInt()
    val max = list.maxOrNull()
    val index = list.indexOf(max) + 1
    println("$max $index")
}