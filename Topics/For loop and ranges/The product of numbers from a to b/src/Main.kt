fun main() = (readln().toLong() until readln().toLong())
    .reduce(Long::times)
    .run(::print)
