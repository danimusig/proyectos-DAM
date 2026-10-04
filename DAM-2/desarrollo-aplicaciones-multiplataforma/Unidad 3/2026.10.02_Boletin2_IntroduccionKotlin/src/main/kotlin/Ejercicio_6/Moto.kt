package Ejercicio_6

class Moto(matriculaMoto: String, velocidadMoto: Int = 0): Vehiculo {

    private var matricula = matriculaMoto
        get() {
            return field
        }
        set(value) {
            field = value
        }
    private var velocidad = velocidadMoto
        get() {
            return field
        }
        set(value) {
            if (value < 0) {
                println("ERROR: La velocidad no puede ser menor a 0")
            } else {
                field = value
            }
        }

    override fun acelear(velocidadAcelera: Int) {
        if (velocidadAcelera < 0) {
            println("La aceleracion debe ser mayor que 0")
        } else {
            this.velocidad += velocidadAcelera
        }
    }

    override fun frenar(velocidadFrenado: Int) {
        if (velocidadFrenado < 0) {
            println("El valor del freno debe ser mayor que 0")
        } else {
            this.velocidad -= velocidadFrenado
        }
    }

    override fun toString(): String {
        return "- Informacion del vehiculo $matricula: \nVelocidad actual: $velocidad"
    }
}