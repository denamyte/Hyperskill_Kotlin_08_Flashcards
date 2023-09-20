package flashcards

class Cards {
    private val map = mutableMapOf<String, String>()
    private val oppMap = mutableMapOf<String, String>()
    val cards get() = map.toMap()

    fun add(term: String, definition: String) {
        map[term] = definition
        oppMap[definition] = term
    }

    fun addAll(newCards: Map<String, String>) =
        newCards.forEach {
            val def = map.remove(it.key)
            if (def != null) oppMap.remove(def)
            val term = oppMap.remove(it.value)
            if (term != null) map.remove(term)
            add(it.key, it.value)
        }

    fun containsTerm(term: String) = term in map.keys

    fun containsDefinition(definition: String) = definition in map.values

    fun definition(term: String) = map[term]!!

    fun term(definition: String) = oppMap[definition]!!

    fun randomCard(): Pair<String, String> {
        val term = map.keys.shuffled()[0]
        return Pair(term, map[term]!!)
    }

    fun remove(term: String) = oppMap.remove(map.remove(term))

}