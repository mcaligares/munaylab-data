package munaylab.data

import groovy.transform.ToString

@ToString(
    includeNames=true,
    includeFields=true,
    excludes='organizacion'
)
class Articulo {

    String autor
    String titulo
    String url
    String resumen
    String contenido
    String imagen
    String palabrasClaves
    Boolean publicado = false
    Organizacion organizacion
    Date dateCreated
    Date lastUpdated

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
