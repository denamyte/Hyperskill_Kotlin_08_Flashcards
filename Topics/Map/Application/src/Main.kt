fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>) =
    priceList.filterKeys { it in shoppingList }.values.sum()