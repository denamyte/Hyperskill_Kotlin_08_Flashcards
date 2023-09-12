import kotlin.math.max

fun main() = Array(readln().toInt()) { readln().toInt() }.let {
    var maxSeq = 1
    var curr = 1
    for (i in 1..it.lastIndex) {
        if (it[i] >= it[i - 1]) maxSeq = max(maxSeq, ++curr)
        else curr = 1
    }
    println(maxSeq)
}