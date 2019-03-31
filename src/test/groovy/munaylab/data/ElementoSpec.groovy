package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ElementoSpec extends SpecificationTestBuilder implements DomainUnitTest<Elemento> {

    void "validacion de campos obligatorios"() {
        expect: elementoValido.validate() == true
    }

    void "validacion de nombres validos"() {
        expect: nuevoElementoCon('nombre', nombre).validate()
        where: nombre << NOMBRES_DE_ELEMENTO_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevoElementoCon('nombre', nombre).validate()
        where: nombre << NOMBRES_DE_ELEMENTO_INVALIDOS
    }

    void "validacion de un servicio"() {
        given: elementoServicioValido.validate() == true
    }
}
