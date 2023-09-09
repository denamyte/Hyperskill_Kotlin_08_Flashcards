import kotlin.math.min

fun main() {
    val cap = readln().toInt()
    var num = 1
    var counter = 0
    do {
        val times = min(num, cap - counter)
        print("$num ".repeat(times))
        counter += times
        num++
    } while (counter < cap)
}