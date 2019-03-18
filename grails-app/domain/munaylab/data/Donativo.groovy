package munaylab.data

class Donativo {

    Tipo tipo
    String nombre

    static constraints = {
        tipo nullable: false
        nombre nullable: false, blank: false, size: 3..50
    }

    enum Tipo {
        BIEN,
        SERVICIO
    }
}
