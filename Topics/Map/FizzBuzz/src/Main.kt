fun iterator(map: Map<String, Int>) =
    map.values.forEach {
        println(
            when {
                it % 3 == 0 -> "Fizz"
                it % 5 == 0 -> "Buzz"
                else -> "FizzBuzz"
            }
        )
}