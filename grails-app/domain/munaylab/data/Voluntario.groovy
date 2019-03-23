package munaylab.data

class Voluntario {

    Usuario usuario
    Estado estado = Estado.INACTIVO
    Collection contratos
    Collection disponibilidad

    static belongsTo = [usuario: Usuario]
    static hasMany = [
        contratos: Contrato,
        disponibilidad: Horario
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
