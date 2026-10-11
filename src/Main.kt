fun main() {
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    printBothFields(player, enemy)
    println()

    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    println(player.status())

    println("Выстрелов: ${player.shots}")
    println("Попаданий: ${player.hits}")

    player.reset()
    println(player.status())
}