fun main() {
    val playerField1 = createEmptyField()
    playerField1[3][2] = '#'
    playerField1[3][3] = '#'
    playerField1[3][4] = '#'
    playerField1[3][5] = '#'

    val enemyField1 = createEmptyField()
    enemyField1[5][7] = '#'
    enemyField1[6][7] = '#'
    enemyField1[7][7] = '#'
    enemyField1[5][5] = 'X'
    enemyField1[5][6] = 'O'

    printField(playerField1, "Ваше поле")
    println()
    printField(enemyField1, "Поле противника", showShips = false)
    println()

    val smallField = createEmptyField(8)
    printField(smallField, "Маленькое поле 8×8")
    println()

    val bigField = createEmptyField(12)
    printField(bigField, "Большое поле 12×12")
    println()

    val defaultField = createEmptyField()
    printField(defaultField, "Поле по умолчанию 10×10")
    println()

    val playerField3 = createEmptyField(10)
    playerField3[3][2] = '#'
    playerField3[3][3] = '#'

    val enemyField3 = createEmptyField(10)
    enemyField3[5][7] = '#'
    enemyField3[5][5] = 'X'

    printBothFields(playerField3, enemyField3)
    println()

    val mismatched = createEmptyField(8)
    printBothFields(playerField3, mismatched)
    println()

    val debugField = createEmptyField(10)
    debugField[3][2] = '#'
    debugField[3][3] = '#'
    debugField[3][4] = '#'
    debugField[3][5] = '#'
    printField(debugField, "Ваше поле", debug = true)
}
fun createEmptyField(size: Int = 10): Array<CharArray> {
    return Array(size) { CharArray(size) { '.' } }
}
fun printField(
    field: Array<CharArray>,
    title: String,
    showShips: Boolean = true,
    debug: Boolean = false
) {
    val size = field.size
    if (debug) {
        println("=== $title (debug) ===")
        val border = "+---".repeat(size) + "+"
        println("   $border")
        for (r in field.indices) {
            print("$r |")
            for (c in field.indices) {
                val ch = if (!showShips && field[r][c] == '#') '.' else field[r][c]
                print(" $ch |")
            }
            println()
            println("   $border")
        }
        return
    }
    println("=== $title ===")
    print("   ")
    for (c in field.indices) print("$c ")
    println()
    for (r in field.indices) {
        print("$r ")
        for (c in field.indices) {
            val ch = if (!showShips && field[r][c] == '#') '.' else field[r][c]
            print("$ch ")
        }
        println()
    }
}
fun printBothFields(
    player: Array<CharArray>,
    enemy: Array<CharArray>,
    showEnemyShips: Boolean = false
) {
    if (player.size != enemy.size) {
        println("Ошибка: размеры полей не совпадают (${player.size} и ${enemy.size}).")
        return
    }

    val size = player.size
    println("=== Ваше поле ===      === Поле противника ===")
    print("   ")
    for (c in 0 until size) print("$c ")
    print("    ")
    print("   ")
    for (c in 0 until size) print("$c ")
    println()

    for (r in 0 until size) {
        // Левое поле
        print("$r ")
        for (c in 0 until size) print("${player[r][c]}")

        print("    ")
        print("$r ")
        for (c in 0 until size) {
            val ch = if (!showEnemyShips && enemy[r][c] == '#') '.' else enemy[r][c]
            print("$ch")
        }
        println()
    }
}
