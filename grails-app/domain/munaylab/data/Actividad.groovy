package munaylab.data

import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true, includeSuper=true, excludes='proyecto')
class Actividad extends Plan {

    Proyecto proyecto

    static belongsTo = [proyecto: Proyecto]

}
