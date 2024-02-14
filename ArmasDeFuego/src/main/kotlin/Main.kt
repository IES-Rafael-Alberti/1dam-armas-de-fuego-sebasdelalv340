import ArmasDeFuego.Companion.cantidadMunicionExtra
import ArmasDeFuego.Companion.municionExtra


fun main() {
    val pistola: ArmasDeFuego = Pistola("Pistola", 8, 1, "9mm", 5, TipoRadio.CORTO)
    val rifle: ArmasDeFuego = Rifle("Rifle", 10, 2, "7.62mm", 9, TipoRadio.INTERMEDIO )
    val bazooka: ArmasDeFuego = Bazooka("Bazooka", 12, 3, "RPG", 20, TipoRadio.AMPLIO)

    val armas: MutableList<ArmasDeFuego> = mutableListOf(pistola, rifle, bazooka)

    municionExtra()
    println("\nMunición extra = $cantidadMunicionExtra... para todas las armas de fuego.\n")

    val disparos = (1..12).map { armas.random() to (1..3).random() }

    disparos.forEach { println(it) }
}