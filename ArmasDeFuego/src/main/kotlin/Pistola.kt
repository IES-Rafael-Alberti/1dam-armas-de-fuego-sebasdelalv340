class Pistola(nombre: String, municion: Int, val municionARestar: Int = 1, tipoDeMunicion: String, override val danio: Int, override val radio: TipoRadio): ArmasDeFuego(nombre, municion, municionARestar, tipoDeMunicion) {

    init {
        require(danio in 1..5) {"El daño debe ser entre 1 y 5"}
        require(radio == TipoRadio.REDUCIDO || radio == TipoRadio.CORTO) {"El radio debe ser reducido o corto"}
    }

    override fun dispara() {
        if (municion - municionARestar < 0) {
            recargar()
            if (municion - municionARestar < 0) {
                println("No hay suficiente munición para disparar")
            } else {
                municion -= municionARestar
                println("$nombre dispara. Munición restante: $municion")
            }
        } else {
            municion -= municionARestar
            println("$nombre dispara. Munición restante: $municion")
        }
    }

    override fun recargar() {
        if (cantidadMunicionExtra >= (municionARestar * 2)) {
            municion += municionARestar * 2
        } else if (cantidadMunicionExtra == municionARestar) {
            municion += municionARestar
        } else {
            println("No hay suficiente munición para disparar")
        }
    }
}