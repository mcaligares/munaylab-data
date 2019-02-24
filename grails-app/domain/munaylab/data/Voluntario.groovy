package munaylab.data

class Voluntario {

    Usuario usuario
    Estado estado = Estado.INACTIVO

    static belongsTo = [usuario: Usuario]
    static hasMany = [
        contratos: Contrato,
        disponibilidad: Disponibilidad
    ]

    static constraints = {
        usuario unique: true
        estado nullable: false
    }

    enum Estado {
        ACTIVO,
        INACTIVO,
        BUSQUEDA
    }

    public static Voluntario getPorDefecto() {
        return new Voluntario()
    }

}
