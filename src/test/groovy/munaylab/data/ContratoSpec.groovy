package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ContratoSpec extends SpecificationTestBuilder implements DomainUnitTest<Contrato> {

    void "validacion de campos obligatorios"() {
        expect: contratoValido.validate() == true
    }

    void "validacion de fecha de inicio"() {
        expect:
        nuevoContratoCon('fechaDeInicio', fecha).validate() == resultado
        where:
        resultado | fecha
        true      | new Date()
        true      | new Date() +1
        true      | new Date() +99
        false     | new Date() -1
        false     | new Date() -99
    }

    void "validacion de fecha de firma"() {
        expect:
        nuevoContratoCon('fechaDeFirma', fecha).validate() == resultado
        where:
        resultado | fecha
        true      | new Date()
        true      | new Date() +1
        true      | new Date() +99
        false     | new Date() -1
        false     | new Date() -99
    }

    void "validacion de firma digital"() {
        expect:
        nuevoContratoCon('firmaDigital', firma).validate() == resultado
        where:
        resultado | firma
        false     | null
        false     | ''
        false     | ' '
        false     | CADENA_DE_30_CARACTERES + '12345'
        false     | CADENA_DE_30_CARACTERES + '1234567'
        true      | UUID.randomUUID().toString()
    }

    void "validacion de dedicacion"() {
        expect:
        nuevoContratoCon('dedicacion', horas).validate() == resultado
        where:
        resultado | horas
        true      | 1
        true      | 160
        false     | 0
        false     | -1
        false     | 161
    }

    void "guardar un contrato"() {
        when:
        contratoValido.save(flush: true)
        then:
        Contrato.count() == 1
        Actividad.count() == 1
    }
}
