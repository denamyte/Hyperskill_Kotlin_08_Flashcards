import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    val rnd = Random(seed)
    return (1..10)
        .map { rnd.nextInt(33, 127) }
        .map { it.toChar() }
        .joinToString("")
}
