package munaylab.data

/** Representa a un proyecto dentro de una {@link Planificacion}. */
class Proyecto extends Plan {

    /** Programa al cual pertenece. */
    Programa programa
    /** Lista de actividades que puede contener éste proyecto. */
    Collection actividades

    /** Pertenece a un {@link Programa}. */
    static belongsTo = [programa: Programa]

    /** Puede tener varias {@link Actividad actividades}. */
    static hasMany = [actividades: Actividad]

}
