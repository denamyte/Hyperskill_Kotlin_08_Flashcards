fun main() {
    val numbers = MutableList(100) { 0 }
    listOf(1, 10, 100).forEach { numbers[it - 1] = it }
    println(numbers.joinToString())
}