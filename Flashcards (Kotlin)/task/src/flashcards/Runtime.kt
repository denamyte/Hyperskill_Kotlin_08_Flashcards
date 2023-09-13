package flashcards

class Runtime {
    val cards = Cards()

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
            println("Card #$i:")
            val term = readln()
            println("The definition for card #$i:")
            cards.add(term, readln())
        }
    }

    private fun checkCards() = cards.cards.forEach { (t, d) ->
        println("Print the definition of \"$t\":")
        (if (readln() == d) "Correct!"
        else "Wrong. The right answer is \"$d\".")
            .run(::println)
    }
}