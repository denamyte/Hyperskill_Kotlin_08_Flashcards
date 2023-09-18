package flashcards

class Cards {
    private val map = mutableMapOf<String, String>()
    private val oppMap = mutableMapOf<String, String>()
    val cards get() = map.toMap()

    fun add(term: String, definition: String) {
        map[term] = definition
        oppMap[definition] = term
    }

    fun containsTerm(term: String) = term in map.keys

    fun containsDefinition(definition: String) = definition in map.values

    fun definition(term: String) = map[term]!!

    fun term(definition: String) = oppMap[definition]!!

}