package flashcards

class Cards {
    private val termMap = mutableMapOf<String, Card>()
    private val defMap = mutableMapOf<String, Card>()

    val cards get() = termMap.values.toList()
    val hardest: List<Card> get() {
        val maxErrors = (if (termMap.isEmpty()) 0 else termMap.values.maxOf { it.errors })
        return if (maxErrors == 0) listOf()
            else termMap.values.filter { it.errors == maxErrors }
    }

    fun add(card: Card) {
        termMap[card.term] = card
        defMap[card.definition] = card
    }

    fun addAll(newCards: List<Card>) =
        newCards.forEach {
            val termCard = termMap.remove(it.term)
            if (termCard != null) defMap.remove(termCard.definition)
            val defCard = defMap.remove(it.definition)
            if (defCard != null) termMap.remove(defCard.term)
            add(it)
        }

    fun containsTerm(term: String) = term in termMap

    fun containsDefinition(definition: String) = definition in defMap

    fun definition(term: String) = termMap[term]!!.definition

    fun term(definition: String) = defMap[definition]!!.term

    fun randomCard(): Card {
        val term = termMap.keys.shuffled()[0]
        return termMap[term]!!
    }

    fun remove(term: String): Boolean {
        val card = termMap.remove(term) ?: return false
        defMap.remove(card.definition)
        return true
    }

    fun resetStats() = termMap.values.forEach(Card::reset)
}