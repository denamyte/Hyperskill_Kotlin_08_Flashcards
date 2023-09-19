import kotlin.random.Random

fun generateTemperature(seed: Int) = Random(seed)
    .run { Array(7) {
        this.nextInt(20, 31) }.joinToString(" ")
    }
