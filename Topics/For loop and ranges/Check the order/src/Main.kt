fun main() = List(readln().toInt()) { readln().toInt() }
    .run { this == this.sorted() }
    .run { if (this) "YES" else "NO" }
    .run(::println)