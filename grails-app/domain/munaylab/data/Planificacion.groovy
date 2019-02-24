package munaylab.data
import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true, excludes='organizacion')
class Planificacion {

    String nombre
    String descripcion
    String contenido
    Date fechaDeInicio
    Date fechaDeFin
    Date dateCreated
    Date lastUpdated
    Organizacion organizacion
    Boolean publicado = false

    static belongsTo = [organizacion: Organizacion]

    static constraints = {
        nombre nullable: false, blank: false, size: 5..500
        descripcion nullable: false, blank: false, size: 5..1000
        contenido nullable: false, blank: false, size: 10..5000
        fechaDeInicio nullable: true
        fechaDeFin nullable: true, validator: { val, obj ->
            if (val) {
                if (!obj.fechaDeInicio) return 'faltaFechaInicio'
                if (obj.fechaDeInicio && obj.fechaDeInicio > val) return 'fechaIniDespuesDeFechaFin'
            }
        }
        publicado nullable: false
    }
}
