package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ContratoSpec extends SpecificationTestBuilder implements DomainUnitTest<Contrato> {

    void "validacion de campos obligatorios"() {
        expect: contratoValido.validate() == true
    }

    void "validacion de fecha de inicio"() {
        given:
        def contrato = contratoValido
        contrato.fechaDeInicio = fecha
        expect:
        contrato.validate() == resultado
        where:
        resultado | fecha
        true      | new Date()
        true      | new Date() +1
        true      | new Date() +99
        false     | new Date() -1
        false     | new Date() -99
    }

    void "validacion de fecha de firma"() {
        given:
        def contrato = contratoValido
        contrato.fechaDeFirma = fecha
        expect:
        contrato.validate() == resultado
        where:
        resultado | fecha
        true      | new Date()
        true      | new Date() +1
        true      | new Date() +99
        false     | new Date() -1
        false     | new Date() -99
    }

    void "validacion de firma digital"() {
        given:
        def contrato = contratoValido
        contrato.firmaDigital = firma
        expect:
        contrato.validate() == resultado
        where:
        resultado | firma
        false     | null
        false     | ''
        false     | ' '
        false     | '12345678901234567890123456789012345'
        false     | '1234567890123456789012345678901234567'
        true      | UUID.randomUUID().toString()
    }

}
