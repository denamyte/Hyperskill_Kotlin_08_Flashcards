fun makeMyWishList(wishList: Map<String, Int>, limit: Int) =
    wishList.filterValues { it <= limit }.toMutableMap()