fun solution() {
    try {
        println(readln().toInt() / readln().toInt())
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}
