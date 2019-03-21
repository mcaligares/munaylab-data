package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class CategoriaSpec extends SpecificationTestBuilder implements DomainUnitTest<Categoria> {

    void "validacion de campos"() {
        expect:
        categoriaValida.validate() == true
    }

    void "validacion de nombres validos"() {
        expect: nuevaCategoriaCon('nombre', valor).validate()
        where: valor << NOMBRE_CATEGORIA_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevaCategoriaCon('nombre', valor).validate()
        where: valor << NOMBRE_CATEGORIA_INVALIDOS
    }

    void "validacion de nombres unicos"() {
        given:
        def categoria = categoriaValida
        categoriaValida.save(flush: true)
        when:
        categoria.save()
        then:
        Categoria.count() == 1
        categoria.hasErrors()
        categoria.errors.hasFieldErrors('nombre')
    }

    void "creacion de subcategorias"() {
        given:
        def categoria = categoriaValida
        5.times { categoria.addToSubcategorias(nuevaCategoriaCon('nombre', "categoria ${it}")) }
        when:
        categoria.save(flush: true, failOnError: true)
        then:
        Categoria.count() == 6
    }

}
