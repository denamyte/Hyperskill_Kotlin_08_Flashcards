fun addUser(userMap: Map<String, String>, login: String, password: String) =
    userMap.toMutableMap().also {
        if (login in it) println("User with this login is already registered!")
        else it[login] = password
    }
