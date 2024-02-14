import kotlin.random.Random

abstract class ArmasDeFuego(val nombre: String, var municion: Int, municionARestar: Int, var tipoDeMunicion: String) {

    abstract val danio: Int
    abstract val radio: TipoRadio

    init {
        require(nombre.isNotBlank()) {"El nombre no puede estar vacío."}

    }

    companion object {
        var cantidadMunicionExtra: Int = 0
        fun municionExtra() {
            cantidadMunicionExtra = Random.nextInt(5, 15)
        }
    }

    abstract fun dispara()

    abstract fun recargar()

    override fun toString() = "Nombre: $nombre, Munición: $municion, Tipo de Munición: $tipoDeMunicion, Daño: $danio, Radio: $radio)."
}

enum class TipoRadio(radio: String) {
    REDUCIDO("Reducido"),
    CORTO("Corto"),
    INTERMEDIO("Intermedio"),
    AMPLIO("Amplio"),
    ENORME("Enorme")
}



