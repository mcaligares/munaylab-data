package munaylab.data

import groovy.transform.ToString

/** Representa a un elemento dentro de una {@link Planificacion}. */
@ToString(
    includeNames=true,
    includeFields=true,
    excludes='planificacion'
)
class Plan {

    /** Nombre del elemento, dato obligatorio con un tamaño de 5 a 500 caracteres. */
    String nombre
    /** Descripcion del elemento, dato obligarorio con un tamaño de 5 a 1000 caracteres. */
    String descripcion
    /** Contenido del elemento, dato obligatorio con un tamaõ de 10 a 5000 caracteres. */
    String contenido
    /** Fecha de inicio de la planificación, dato opcional. Si se agrega una fechaDeFin éste campo es obligatorio. */
    Date fechaDeInicio
    /** Fecha de finalización de la planificación, dato opcional. Si se agregar un valor no puede superar el campo fechaDeInicio. */
    Date fechaDeFin
    /** Fecha de creación del registro. */
    Date dateCreated
    /** Fecha de última modificación del registro. */
    Date lastUpdated
    /** Representa si el elemento está publicado, dato obligatorio. */
    Boolean publicado = false

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
