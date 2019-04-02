package munaylab.data

import groovy.transform.ToString

/** Representa a una actividad dentro de una {@link Planificacion}. */
@ToString(
    includeNames=true,
    includeFields=true,
    includeSuper=true,
    excludes='proyecto'
)
class Actividad extends Plan {

    /** Proyecto al cual pertenece. */
    Proyecto proyecto
    /** Articulo que define la actividad. */
    Articulo articulo
    /** Lista de horarios en el que se realiza la actividad. */
    Collection horarios
    /** Lista de elementos necesarios para realizar la actividad. */
    Collection elementos

    /** Pertenece a un {@link Proyecto Proyecto}. */
    static belongsTo = [proyecto: Proyecto]

    /** Puede tener varios {@link Horario Horarios} y {@link Elemento Elementos}. */
    static hasMany = [horarios: Horario, elementos: Elemento]

}
