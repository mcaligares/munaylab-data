package munaylab.data

import groovy.transform.ToString

@ToString(
    includeNames=true, 
    includeFields=true, 
    excludes='editores,administradores,voluntarios')
class Organizacion {

    String nombre
    String url
    String resumen
    Direccion direccion
    Date fechaDeConstitucion
    Articulo mision
    Articulo vision
    Articulo valores

    Date dateCreated
    Date lastUpdated

    static hasOne = [
        mision: Articulo,
        vision: Articulo,
        valores: Articulo
    ]

    static hasMany = [
        editores: Usuario,
        administradores: Usuario,
        voluntarios: Voluntario
    ]

    static constraints = {
        nombre nullable: false, blank: false, unique: true, size: 3..200
        url nullable: false, blank: false, unique: true, size: 3..200
        resumen nullable: false, blank: false, size: 10..300
        direccion nullable: false
        fechaDeConstitucion nullable: false, max: new Date() +1
        mision nullable: true
        vision nullable: true
        valores nullable: true
    }
}
