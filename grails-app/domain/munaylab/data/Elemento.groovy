package munaylab.data

class Elemento {

    Tipo tipo
    String nombre
    Estado estado
    Boolean esNecesario

    static constraints = {
        tipo nullable: false
        nombre nullable: false, blank: false, size: 3..50
        estado validator: { val, obj ->
            (obj.tipo == Tipo.SERVICIO) || (obj.tipo == Tipo.BIEN && val)
        }
        esNecesario nullable: true
    }

    enum Tipo {
        BIEN,
        SERVICIO
    }

    enum Estado {
        NUEVO,
        USADO
    }
}
