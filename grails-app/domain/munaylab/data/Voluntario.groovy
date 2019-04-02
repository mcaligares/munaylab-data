package munaylab.data

/** Datos de un voluntario */
class Voluntario {

    /** Único usuario al cual pertenecen los datos del voluntario. */
    Usuario usuario
    /** Estado actual del voluntario, dato obligatorio. Default <code>Estado.INACTIVO</code>*/
    Estado estado = Estado.INACTIVO
    /** Contratos del voluntario */
    Collection contratos
    /** Disponibilidad del Voluntario */
    Collection disponibilidad

    /** Pertenece a un {@link Usuario}. */
    static belongsTo = [usuario: Usuario]

    /**
     * Puede tener varios {@link Contrato Contratos}
     * y tambien establecer su {@link Horario Disponibilidad}.
     */
    static hasMany = [
        contratos: Contrato,
        disponibilidad: Horario
    ]

    static constraints = {
        usuario unique: true
        estado nullable: false
    }

    /** Estado de un voluntario. */
    enum Estado {
        /** El voluntario se encuentra actualmente ejerciendo al menos un trabajo con alguna organización. */
        ACTIVO,
        /** El voluntario no se encuentra ejerciendo trabajos y tampoco está en búsqueda de uno.*/
        INACTIVO,
        /** El voluntario se encuentra en búsqueda de un trabajo. */
        BUSQUEDA
    }

    /**
     * Devuelve datos de un voluntario con valores por defecto.
     * @return Datos de voluntario por defecto.
     */
    public static Voluntario getPorDefecto() {
        return new Voluntario()
    }

}
