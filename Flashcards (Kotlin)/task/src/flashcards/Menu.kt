package flashcards

import java.io.File

class Menu {
    private val cards = Cards()

    fun run() {
        var cmd = ""
        while (cmd != "exit") {
            println("Input the action (add, remove, import, export, ask, exit):")
            cmd = readln()
            when (cmd) {
                "add" -> add()
                "remove" -> remove()
                "import" -> import()
                "export" -> export()
                "ask" -> ask()
                "exit" -> exit()
            }
            if (cmd != "exit") println()
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
            cards.add(term, def)
            println("The pair (\"$term\":\"$def\") has been added.")
        } catch (e: AlreadyExistsException) {
            println(e.message)
        }
    }

    private fun remove() {
        println("Which card?")
        val term = readln()
        println(
            if (cards.remove(term) == null) "Can't remove \"$term\": there is no such card."
            else "The card has been removed"
        )
    }

    private fun import() {
        println("File name:")
        val file = File(readln())
        if (!file.exists()) println("File not found.")
        else {
            file.readLines()
                .map { it.split("===") }
                .associate { Pair(it[0], it[1]) }
                .also(cards::addAll)
                .also { println("${it.size} cards have been loaded.") }
        }
    }

    private fun export() {
        println("File name:")
        val name = readln()
        cards.cards
            .also { println("${it.size} cards have been saved.") }
            .map { (k, v) -> "$k===$v" }.joinToString("\n")
            .let { File(name).writeText(it) }
    }

    private fun ask() {
        println("How many times to ask?")
        repeat(readln().toInt()) { checkCards() }
    }

    private fun exit() = println("Bye bye!")

    private fun inputCardPart(prompt: String,
                              exists: (String) -> Boolean,
                              error: String): String {
        println(prompt)
        val value = readln()
        if (exists(value))
            throw AlreadyExistsException(error.format(value))
        return value
    }

    private fun checkCards() {
        val (term, def) = cards.randomCard()
        println("Print the definition of \"$term\":")
        val userDef = readln()
        println(when {
            userDef == def -> "Correct!"
            cards.containsDefinition(userDef) -> "Wrong. The right answer is \"$def\", " +
                    "but your definition is correct for \"${cards.term(userDef)}\"."
            else -> "Wrong. The right answer is \"$def\"."
        })
    }
}

class AlreadyExistsException(msg: String): RuntimeException(msg)
