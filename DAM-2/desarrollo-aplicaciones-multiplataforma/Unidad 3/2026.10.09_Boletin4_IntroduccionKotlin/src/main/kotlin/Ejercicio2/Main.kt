package Ejercicio2

fun main() {
    // Para acelerar la creacion de los alumnos les doy unas asignaturas posibles aleatorias a cada uno y una calificacion aleatoria.
    var asignaturasAlumno1 = AsignaturasDAM.entries.shuffled().iterator()
    val alumno1 = Alumno(
        "Daniel",
        26,
        asignaturasMatriculadas = MutableList<Asignatura>(
            5
        ) {
            Asignatura(
                asignaturasAlumno1.next(),
                (1..10).random()
            )
        }
    )
    var asignaturasAlumno2 = AsignaturasDAM.entries.shuffled().iterator()
    val alumno2 = Alumno(
        "Mario",
        28,
        asignaturasMatriculadas = MutableList<Asignatura>(
            4
        ) {
            Asignatura(
                asignaturasAlumno2.next(),
                (1..10).random()
            )
        }
    )
    var asignaturasAlumno3 = AsignaturasDAM.entries.shuffled().iterator()
    val alumno3 = Alumno(
        "Francisco",
        19,
        asignaturasMatriculadas = MutableList<Asignatura>(
            2
        ) {
            Asignatura(
                asignaturasAlumno3.next(),
                (1..10).random()
            )
        }
    )

    var alumnos = listOf<Alumno>(alumno1, alumno2, alumno3)
    println("\n/// Media total del alumno  ///")
    alumnos.forEach { alumno ->
        val media = alumno.asignaturasMatriculadas.map { it.calificacion }.average()
        println("La nota media del alumno ${alumno.nombre} es: $media")
    }

    val mediaPorModulo = alumnos
        .flatMap { it.asignaturasMatriculadas }
        .groupBy ({ it.nombre }, {it.calificacion})

    mediaPorModulo.forEach { (asignatura, notas) ->
        println("Media total de $asignatura: %.2f".format(notas.average()))
    }
}