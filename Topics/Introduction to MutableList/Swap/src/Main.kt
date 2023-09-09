fun main() {    
    val numbers = readln().split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    // Write only exchange actions here.
    Pair(numbers.first(), numbers.last()).let {
        numbers[0] = it.second
        numbers[numbers.lastIndex] = it.first
    }
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}