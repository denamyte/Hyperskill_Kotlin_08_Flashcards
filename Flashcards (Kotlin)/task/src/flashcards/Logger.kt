package flashcards

class Logger {
    private val _logs = mutableListOf<String>()
    val logText get() = _logs.joinToString("\n")

    fun println(s: Any?) {
        _logs += s.toString()
        kotlin.io.println(s)
    }

    fun println() = println("")

    fun readln(): String {
        _logs += kotlin.io.readln()
        return _logs.last()
    }
}