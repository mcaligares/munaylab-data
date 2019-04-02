package munaylab.data

/** Representa un horario. Constituido por un dia y un rango de horas. */
class Horario {

    /** Dia del horario, campo obligatorio. */
    Dia dia
    /** Inicio del rango de horas (0 - 23). */
    Integer desdeHora
    /** Inicio del rango de minutos (0 - 59). */
    Integer desdeMinuto
    /** Fin del rango de horas (0 - 23). */
    Integer hastaHora
    /** Fin del rango de minutos (0 - 59). */
    Integer hastaMinuto
    /** Opción para marcar disponibilidad de todo el día. */
    Boolean todoElDia = false
    /** Opción para marcar disponibilidad matutina. */
    Boolean matutino = false
    /** Opción para marcar disponibilidad vespertina. */
    Boolean vespertino = false
    /** Opción para marcar disponibilidad nocturna. */
    Boolean nocturno = false

    static constraints = {
        dia nullable: false
        desdeHora nullable: true, min: 0, max: 23
        desdeMinuto nullable: true, min: 0, max: 59
        hastaHora nullable: true, min: 0, max: 23
        hastaMinuto nullable: true, min: 0, max: 59
        todoElDia nullable: false
        matutino nullable: false
        vespertino nullable: false
        nocturno nullable: false
    }

    /** Dias de un horario. */
    enum Dia {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO
    }
}
