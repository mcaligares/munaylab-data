package munaylab.data

import groovy.transform.ToString

/** Planificación de una organización. */
@ToString(
    includeNames=true,
    includeFields=false,
    excludes='organizacion'
)
class Planificacion {

    /** Misión de una Organización. */
    Articulo mision
    /** Visión de una Organización. */
    Articulo vision
    /** Valores de una Organización. */
    Articulo valores
    /** Lista de Programas de una Organización. */
    Collection programas
    /** Organización */
    Organizacion organizacion

    /** Tiene una misión, visión y valores como {@link Articulo}. */
    static hasOne = [
        mision: Articulo,
        vision: Articulo,
        valores: Articulo
    ]
    /** Puede tener varios {@link Programa Programas}. */
    static hasMany = [programas: Programa]
    /** Pertenece a una {@link Organizacion}. */
    static belongsTo = [organizacion: Organizacion]

    static constraints = {
        mision nullable: true
        vision nullable: true
        valores nullable: true
    }

}
