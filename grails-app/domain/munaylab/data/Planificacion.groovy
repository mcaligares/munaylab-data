package munaylab.data

import groovy.transform.ToString

@ToString(
    includeNames=true,
    includeFields=false,
    excludes='organizacion'
)
class Planificacion {

    Articulo mision
    Articulo vision
    Articulo valores
    Collection programas
    Organizacion organizacion

    static hasOne = [
        mision: Articulo,
        vision: Articulo,
        valores: Articulo
    ]
    static hasMany = [programas: Programa]
    static belongsTo = [organizacion: Organizacion]

    static constraints = {
        mision nullable: true
        vision nullable: true
        valores nullable: true
    }

}
