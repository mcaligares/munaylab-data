package munaylab.data

/** Representa un programa dentro de una {@link Planificacion}. */
class Programa extends Plan {

    /** Planificación a la cual pertenece. */
    Planificacion planificacion
    /** Lista de proyecto que puede contener éste programa. */
    Collection proyectos

    /** Pertenece a una {@link Planificacion}. */
    static belongsTo = [planificacion: Planificacion]

    /** Puede tener varios {@link Proyecto Proyectos}. */
    static hasMany = [proyecto: Proyecto]

}
