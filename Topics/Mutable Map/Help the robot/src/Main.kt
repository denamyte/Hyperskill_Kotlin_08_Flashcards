fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) =
    purchases.toMutableMap().apply {
        addition.forEach { (k, v) -> merge(k, v, Int::plus) }
    }
