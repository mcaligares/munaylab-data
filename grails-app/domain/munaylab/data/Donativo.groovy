package munaylab.data

class Donativo {

    Tipo tipo
    String nombre
    Estado estado

    static constraints = {
        tipo nullable: false
        nombre nullable: false, blank: false, size: 3..50
        estado validator: { val, obj ->
            (obj.tipo == Tipo.SERVICIO) || (obj.tipo == Tipo.BIEN && val)
        }
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
