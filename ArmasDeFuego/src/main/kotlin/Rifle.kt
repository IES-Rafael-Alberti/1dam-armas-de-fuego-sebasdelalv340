class Rifle(nombre: String, municion: Int, val municionARestar: Int = 2, tipoDeMunicion: String, override val danio: Int, override val radio: TipoRadio): ArmasDeFuego(nombre, municion, municionARestar, tipoDeMunicion) {

    init {
        require(danio in 5..10) {"El daño debe ser entre 5 y 10"}
        require(radio == TipoRadio.CORTO || radio == TipoRadio.INTERMEDIO) {"El radio debe ser corto o intermedio"}
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