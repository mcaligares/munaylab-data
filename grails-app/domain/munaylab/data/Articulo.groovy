package munaylab.data

import groovy.transform.ToString

/** Representa un articulo de la plataforma. */
@ToString(
    includeNames=true,
    includeFields=true,
    excludes='organizacion'
)
class Articulo {

    /** Autor del articulo, es un campo obligatorio con un tamaño de 3 a 20 caracteres. */
    String autor
    /** Titulo del articulo, es un campo obligatorio, único por organización con un tamaño de 5 a 1000 caracteres. */
    String titulo
    /** URL del articulo, es un campo obligatorio, único por organización con un tamaño de 5 a 500 caracteres. */
    String url
    /** Resumen del articulo, es un campo opcional con un tamaño de 10 a 1000 caracteres. */
    String resumen
    /** Contenido del articulo, es un campo obligatorio con un tamaño de 10 a 5000 caracteres. */
    String contenido
    /*Imagen del articulo, es un campo opcional. */
    String imagen
    /* Palabras claves del articulo, es un campo opcionalcon un máximo de 1000 caracteres. */
    String palabrasClaves
    /* Representa si el articulo está publicado o no. Default: <code>false</code>. */
    Boolean publicado = false
    /** Organizacion del articulo. */
    Organizacion organizacion
    /** Fecha de creación del registro. */
    Date dateCreated
    /** Fecha de última actualización del registro. */
    Date lastUpdated

    /** Pertenece a una {@link Organizacion}. */
    static belongsTo = [organizacion: Organizacion]

    static constraints = {
        autor nullable: false, blank: false, size: 3..20
        titulo nullable: false, blank: false, size: 5..100, unique: 'organizacion'
        url nullable: false, blank: false, size: 5..500, unique: 'organizacion'
        resumen nullable: true, blank: false, size: 10..1000
        contenido nullable: false, blank: false, size: 10..5000
        imagen nullable: true, blank: false, size: 3..1000
        palabrasClaves nullable: true, maxSize: 1000
        publicado nullable: false
    }

}
