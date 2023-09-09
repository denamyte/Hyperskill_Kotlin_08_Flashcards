package flashcards

class Cards {
    private val map = mutableMapOf<String, String>()

    fun add(term: String, definition: String) {
        map[term] = definition
    }

    fun check(term: String, definition: String) = map[term] == definition

    fun str(term: String) = """
        Card:
        $term
        Definition:
        ${map[term]}
    """.trimIndent()
}