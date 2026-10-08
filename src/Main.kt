fun main() {
    val player = Player()
    val enemy = Player()

    player.name = "Ваше поле"
    enemy.name = "Поле противника"

    player.shots = 10
    player.hits = 7

    player.field[3][2] = '#'
    player.field[3][3] = '#'
    player.field[3][4] = '#'
    player.field[3][5] = '#'

    enemy.field[5][7] = '#'
    enemy.field[6][7] = '#'
    enemy.field[7][7] = '#'
    enemy.field[5][5] = 'x'
    enemy.field[5][6] = 'o'

    player.printField()
    player.printStats()
    enemy.printField(false)
    printBothFields(player, enemy)
    printBothFields(player, enemy, true)
    player.printField(debug = true)

    // === Проверка задания ===

    println()
    println("=== Два игрока: статус и isAlive ===")
    val p1 = Player()
    p1.name = "Вы"
    p1.shots = 12
    p1.hits = 7
    p1.shipsLeft = 15

    val p2 = Player()
    p2.name = "Противник"
    p2.shots = 20
    p2.hits = 4

    p1.printStats()
    p2.printStats()
    println("${p1.name}: isAlive = ${p1.isAlive()}")
    println("${p2.name}: isAlive = ${p2.isAlive()}")

    println()
    println("=== Сценарий из задания ===")
    val player2 = Player()
    player2.name = "Вы"

    player2.registerShot(true)    // попал
    player2.registerShot(false)   // промах
    player2.registerShot(true)    // попал

    println(player2.status())

    player2.takeDamage()
    player2.takeDamage()
    println(player2.shipsLeft)    // 18
    println(player2.isAlive())    // true

    player2.reset()
    println(player2.status())
}

fun printBothFields(player: Player, enemy: Player, showEnemyShips: Boolean = false) {
    if (player.field.size != enemy.field.size || player.field[0].size != enemy.field[0].size) {
        println("Ошибка: размеры полей должны совпадать!")
    }
    else {
        println("====== Ваше поле ======       === Поле противника ===")
        print("   ")
        for (c in player.field.indices) print("$c ")
        print("      ")
        print("    ")
        for (c in enemy.field.indices) print("$c ")
        println()
        for (r in enemy.field.indices) {
            print("$r  ")
            for (c in player.field.indices) print("${player.field[r][c]} ")
            print("       ")
            print("$r  ")
            for (c in enemy.field.indices) {
                if (showEnemyShips) {
                    print("${enemy.field[r][c]} ")
                } else {
                    if (enemy.field[r][c] == '#') print(". ")
                    else print("${enemy.field[r][c]} ")
                }
            }
            println()
        }
    }
}