package flashcards

class Runtime {
    private val cards = Cards()

    fun run() {
        val n = inputN()
        inputCards(n)
        checkCards()
    }

    private fun inputN(): Int {
        println("Input the number of cards:")
        return readln().toInt()
    }

    private fun inputCards(n: Int) {
        for (i in 1..n) {
            val term = inputCardPart(
                "Card #$i:",
                cards::containsTerm,
                "The term \"%s\" already exists. Try again:"
            )
            val def = inputCardPart(
                "The definition for card #$i:",
                cards::containsDefinition,
                "The definition \"%s\" already exists. Try again:"
            )

            cards.add(term, def)
        }
    }

    private fun inputCardPart(prompt: String,
                              exists: (String) -> Boolean,
                              error: String): String {
        println(prompt)
        while (true) {
            val value = readln()
            if (exists(value))
                println(error.format(value))
            else return value
        }
    }

    private fun checkCards() = cards.cards.forEach { (t, d) ->
        println("Print the definition of \"$t\":")
        val userDef = readln()
        println(when {
            userDef == d -> "Correct!"
            cards.containsDefinition(userDef) -> "Wrong. The right answer is \"$d\", " +
                    "but your definition is correct for \"${cards.term(userDef)}\"."
            else -> "Wrong. The right answer is \"$d\"."
        })
    }
}
