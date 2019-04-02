package munaylab.data

/** Representa un evento de una {@link Organizacion}. */
class Evento {

    /** Tipo de evento, dato obligatorio. */
    Tipo tipo
    /** Nombre del evento, dato obligatorio con un tamaño de 3 a 50 caracteres. */
    String nombre
    /** Objetivo del evento, dato obligatorio con un tamaño de 5 a 300 caracteres. */
    String objetivo
    /** Nombre de la plantilla que se utilizará para generar la gacetilla de prensa. */
    String plantilla
    /** Horario del evento, dato obligatorio. */
    Horario horario
    /** Articulo del evento, dato obligatorio. */
    Articulo articulo
    /** Direccion de un evento. */
    Direccion direccion
    /** Destinatarios del evento. */
    String destinatarios = 'el público en general'

    static constraints = {
        nombre nullable: false, blank: false, size: 3..50
        objetivo nullable: false, blank: false, size: 5..300
        horario nullable: false
        articulo nullable: false
        direccion nullable: false
        destinatarios nullable: false
        plantilla nullable: true, validator: { val, obj, errors ->
            if (Tipo.OTRO == obj.tipo && !val) errors.rejectValue('plantilla', 'noTemplate')
        }
    }

    /** Tipo de {@link Evento} */
    enum Tipo {
        /** Otro tipos de eventos. */
        OTRO,
        /** Evento de recaudación. */
        RECAUDACION,
        /** Evento de convocatoria. */
        CONVOCATORIA
    }

}
