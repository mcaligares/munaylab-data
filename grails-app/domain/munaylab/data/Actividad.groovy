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

    static belongsTo = [proyecto: Proyecto]

    static hasMany = [horarios: Horario]

}
