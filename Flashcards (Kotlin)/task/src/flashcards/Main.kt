package flashcards

fun main() {
    val cards = Cards()
    val (term, definition, answer) = Array(3) { readln() }
    cards.add(term, definition)
    val check = cards.check(term, answer)
    println(if (check) "right" else "wrong")
}
