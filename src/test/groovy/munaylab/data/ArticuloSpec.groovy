package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ArticuloSpec extends SpecificationTestBuilder implements DomainUnitTest<Articulo> {

    void "validacion campos obligatorios"() {
        expect:
        articuloConOrganizacionValido.validate() == true
    }

    void "validacion de autores validos"() {
        expect: nuevoArticuloCon('autor', valor).validate()
        where:  valor << AUTORES_VALIDOS
    }

    void "validacion de autores invalidos"() {
        expect: !nuevoArticuloCon('autor', valor).validate()
        where:  valor << AUTORES_INVALIDOS
    }

    void "validacion de titulos validos"() {
        expect: nuevoArticuloCon('titulo', valor).validate()
        where:  valor << TITULOS_VALIDOS
    }

    void "validacion de titulos invalidos"() {
        expect: !nuevoArticuloCon('titulo', valor).validate()
        where:  valor << TITULOS_INVALIDOS
    }

    void "validacion de urls validas"() {
        expect: nuevoArticuloCon('url', valor).validate()
        where:  valor << URLS_VALIDAS
    }

    void "validacion de urls invalidas"() {
        expect: !nuevoArticuloCon('url', valor).validate()
        where:  valor << URLS_INVALIDAS
    }

    void "validacion de resumenes validos"() {
        expect: nuevoArticuloCon('resumen', valor).validate()
        where:  valor << RESUMENES_VALIDOS
    }

    void "validacion de resumenes invalidos"() {
        expect: !nuevoArticuloCon('resumen', valor).validate()
        where:  valor << RESUMENES_INVALIDOS
    }

    void "validacion de contenidos validos"() {
        expect: nuevoArticuloCon('contenido', valor).validate()
        where:  valor << CONTENIDOS_VALIDOS
    }

    void "validacion de contenidos invalidos"() {
        expect: !nuevoArticuloCon('contenido', valor).validate()
        where:  valor << CONTENIDOS_INVALIDOS
    }

    void "validacion de imagenes validas"() {
        expect: nuevoArticuloCon('imagen', valor).validate()
        where:  valor << IMAGENES_VALIDAS
    }
    void "validacion de imagenes invalidas"() {
        expect: !nuevoArticuloCon('imagen', valor).validate()
        where:  valor << IMAGENES_INVALIDAS
    }

    void "validacion de palabras claves validas"() {
        expect: nuevoArticuloCon('palabrasClaves', valor).validate()
        where:  valor << PALABRAS_CLAVES_VALIDAS
    }

    void "validacion de palabras claves invalidas"() {
        expect: !nuevoArticuloCon('palabrasClaves', valor).validate()
        where:  valor << PALABRAS_CLAVES_INVALIDAS
    }

    void "guardar articulo"() {
        when:
        articuloConOrganizacionValido.save(flush: true)
        then:
        Articulo.count() == 1
    }

    void "validacion de integridad de titulo y url"() {
        given:
        def articulo = articuloConOrganizacionValido.save(flush: true)
        def otroArticulo = articuloValido
        otroArticulo.organizacion = articulo.organizacion
        when:
        otroArticulo.save(flush: true, failOnError: true)
        then:
        Articulo.count() == 1
        def err = thrown Exception
        err.message.contains('unique.url') == true
        err.message.contains('unique.titulo') == true
    }

}
