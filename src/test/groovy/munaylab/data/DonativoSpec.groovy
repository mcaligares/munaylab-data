package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class DonativoSpec extends SpecificationTestBuilder implements DomainUnitTest<Donativo> {

    void "validacion de campos obligatorios"() {
        expect: donativoValido.validate() == true
    }

    void "validacion de nombres validos"() {
        expect: nuevoDonativoCon('nombre', nombre).validate()
        where: nombre << NOMBRES_DE_ELEMENTO_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !(nuevoDonativoCon('nombre', nombre)).validate()
        where: nombre << NOMBRES_DE_ELEMENTO_INVALIDOS
    }

    void "validacion de un servicio"() {
        given: donativoServicioValido.validate() == true
    }
}
