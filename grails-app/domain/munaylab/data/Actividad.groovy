package munaylab.data

import groovy.transform.ToString

@ToString(
    includeNames=true,
    includeFields=true,
    includeSuper=true,
    excludes='proyecto'
)
class Actividad extends Plan {

    Proyecto proyecto
    Articulo articulo
    Collection horarios
    Collection elementos

    static belongsTo = [proyecto: Proyecto]

    static hasMany = [horarios: Horario, elementos: Elemento]

}
