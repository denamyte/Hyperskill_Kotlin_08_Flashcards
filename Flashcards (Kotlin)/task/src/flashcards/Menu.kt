package flashcards

import java.io.File

val L = Logger()
const val HARDEST_SINGULAR = "The hardest card is %s. You have %d errors answering it."
const val HARDEST_MULTI = "The hardest cards are %s. You have %d errors answering them."

class Menu(args: Array<String>) {
    private val cards = Cards()
    private var exportOnExitName: String? = null

    init {
        var arguments = args.toList()
        while (arguments.size >= 2) {
            val (type, data) = arguments
            when (type) {
                "-import" -> import(data)
                "-export" -> exportOnExitName = data
            }
            arguments = arguments.drop(2)
        }
    }

    fun run() {
        var cmd = ""
        while (cmd != "exit") {
            L.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
            cmd = L.readln()
            when (cmd) {
                "add" -> add()
                "remove" -> remove()
                "import" -> import(fileName())
                "export" -> export(fileName())
                "ask" -> ask()
                "exit" -> exit()
                "log" -> log()
                "hardest card" -> hardestCard()
                "reset stats" -> resetStats()
            }
            if (cmd != "exit") L.println()
        }
    }

    private fun add() {
        try {
            val term = inputCardPart(
                "The card:",
                cards::containsTerm,
                "The card \"%s\" already exists."
            )
            val def = inputCardPart(
                "The definition of the card:",
                cards::containsDefinition,
                "The definition \"%s\" already exists."
            )
            cards.add(Card(term, def))
            L.println("The pair (\"$term\":\"$def\") has been added.")
        } catch (e: AlreadyExistsException) {
            L.println(e.message)
        }
    }

    private fun remove() {
        L.println("Which card?")
        val term = L.readln()
        val remove = cards.remove(term)
        L.println(
            if (!remove) "Can't remove \"$term\": there is no such card."
            else "The card has been removed"
        )
    }

    private fun import(name: String) {
        val file = File(name)
        if (!file.exists()) L.println("File not found.")
        else file.readLines()
            .map(Card::parse)
            .also(cards::addAll)
            .also { L.println("${it.size} cards have been loaded.") }
    }

    private fun export(name: String) = cards.cards
        .also { L.println("${it.size} cards have been saved.") }
        .joinToString("\n")
        .let { File(name).writeText(it) }

    private fun ask() {
        L.println("How many times to ask?")
        repeat(L.readln().toInt()) { checkCard() }
    }

    private fun exit() {
        if (exportOnExitName != null) export(exportOnExitName!!)
        L.println("Bye bye!")
    }

    private fun log() {
        File(fileName()).writeText(L.logText)
        L.println("The log has been saved.")
    }

    private fun hardestCard() {
        val hardest = cards.hardest
        L.println(
            if (hardest.isEmpty()) "There are no cards with errors."
            else (if (hardest.size == 1) HARDEST_SINGULAR else HARDEST_MULTI)
                .format(hardest.joinToString { "\"${it.term}\"" }, hardest[0].errors)
        )
    }

    private fun resetStats() {
        cards.resetStats()
        L.println("Card statistics have been reset.")
    }

    private fun inputCardPart(prompt: String,
                              exists: (String) -> Boolean,
                              error: String): String {
        L.println(prompt)
        val value = L.readln()
        if (exists(value))
            throw AlreadyExistsException(error.format(value))
        return value
    }

    private fun checkCard() {
        val card = cards.randomCard()
        L.println("Print the definition of \"${card.term}\":")
        val userDef = L.readln()

        val correct = userDef == card.definition
        if (!correct) card.inc()

        L.println(when {
            correct -> "Correct!"
            cards.containsDefinition(userDef) -> "Wrong. The right answer is \"${card.definition}\", " +
                    "but your definition is correct for \"${cards.term(userDef)}\"."
            else -> "Wrong. The right answer is \"${card.definition}\"."
        })
    }

    private fun fileName(): String {
        L.println("File name:")
        return L.readln()
    }
}

class AlreadyExistsException(msg: String): RuntimeException(msg)
