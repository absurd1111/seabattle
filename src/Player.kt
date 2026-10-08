class Player(size: Int = 10) {
    var name: String = ""
    var field: Array<CharArray> = Array(size) { CharArray(size){'.'} }

    var shots: Int = 0
    var hits: Int = 0
    var shipsLeft: Int = 20

    fun isAlive(): Boolean {
        return shipsLeft > 0
    }

    fun accuracy(): Double {
        if (shots == 0) {
            return 0.0
        }
        return hits * 100.0 / shots
    }

    fun status(): String {
        val percent = (accuracy() * 10).toInt() / 10.0
        return "Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попаданий $hits, точность $percent%"
    }

    fun takeDamage(): Boolean {
        shipsLeft--
        return isAlive()
    }

    fun registerShot(hit: Boolean) {
        shots++
        if (hit) {
            hits++
        }
    }

    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20
        for (r in field.indices) {
            for (c in field[r].indices) {
                field[r][c] = '.'
            }
        }
    }

    fun printStats() {
        println(status())
    }

    fun printField(showShips: Boolean = true, debug: Boolean = false){
        if (debug) {
            println("=== $name (debug) ===")
            print("     ")
            for (c in field.indices) {
                print("$c   ")
            }
            println()
            print("   +")
            print("---+".repeat(field.size))
            println()
            for (r in field.indices) {
                print("$r  |")
                for (c in field.indices) {
                    if (showShips) {
                        print(" ${field[r][c]} |")
                    } else {
                        if (field[r][c] == '#') print(" . |")
                        else print(" ${field[r][c]} |")
                    }
                }
                println()
                print("   +")
                print("---+".repeat(field.size))
                println()
            }
        }
        else {
            println("==== $name ====")
            print("  ")
            for (c in field.indices) print("$c ")
            println()
            for (r in field.indices) {
                print("$r ")
                for (c in field.indices) {
                    if (showShips) print("${field[r][c]} ")
                    else {
                        if (field[r][c] == '#') print(". ")
                        else print("${field[r][c]} ")
                    }
                }
                println()
            }
        }
    }
}