package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class DonativoSpec extends SpecificationTestBuilder implements DomainUnitTest<Donativo> {

    void "validacion de campos obligatorios"() {
        expect: donativoValido.validate() == true
    }

    void "validacion de campo nombre"() {
        expect:
        new Donativo(DONATIVO_VALIDO + [nombre: dato]).validate() == resultado
        where:
        resultado | dato
        false     | ''
        false     | ' '
        false     | '12'
        true      | 'algo'
        true      | CADENA_DE_50_CARACTERES
        false     | CADENA_DE_50_CARACTERES + '1'
    }
}
