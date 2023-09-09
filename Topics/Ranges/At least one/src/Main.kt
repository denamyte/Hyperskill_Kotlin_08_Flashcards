const val SIZE = 5

fun main() {
    val ints = List(SIZE) { readln().toInt() }
    println(
        ints.last() in ints[0]..ints[1] ||
            ints.last() in ints[2]..ints[3]
    )
}