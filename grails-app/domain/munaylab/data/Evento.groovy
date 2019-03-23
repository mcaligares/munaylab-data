package munaylab.data

class Evento {

    Tipo tipo
    String nombre
    String objetivo
    String plantilla
    Horario horario
    Articulo articulo
    Direccion direccion
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

    enum Tipo {
        OTRO,
        RECAUDACION,
        CONVOCATORIA
    }

}
