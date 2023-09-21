package flashcards

const val SEP = "==="

class Card(
    val term: String,
    val definition: String,
    _errors: Int = 0
) {
    var errors = _errors
        private set

    fun inc() = errors++

    fun reset() {
        errors = 0
    }

    override fun toString() = "$term$SEP$definition$SEP$errors"

    companion object {
        fun parse(s: String): Card {
            val data = s.split(SEP)
            return Card(data[0], data[1], data[2].toInt())
        }
    }
}