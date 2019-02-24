package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class DireccionSpec extends SpecificationTestBuilder implements DomainUnitTest<Direccion> {

    void "validacion de campos obligatorios"() {
        expect: direccionValida.validate() == true
    }

    void "validacion de domicilio"() {
        expect:
        new Direccion(DIRECCION_VALIDA + [domicilio: valor]).validate() == resultado
        where:
        resultado | valor
        false     | ''
        false     | ' '
        false     | 'un'
        true      | 'una'
        true      | 'un domicilio'
        true      | 'un domicilio no tan largo'
        false     | 'un domicilio realmente largo en un lugar muy lejano'
    }

    void "validacion de departamento"() {
        expect:
        new Direccion(DIRECCION_VALIDA + [departamento: valor]).validate() == resultado
        where:
        resultado | valor
        false     | ''
        false     | ' '
        false     | 'un'
        true      | 'una'
        true      | 'un departamento'
        true      | 'un departamento no tan largo'
        false     | 'un departamento realmente largo en un lugar muy lejano'
    }

    void "validacion de provincia"() {
        expect:
        new Direccion(DIRECCION_VALIDA + [provincia: valor]).validate() == resultado
        where:
        resultado | valor
        false     | ''
        false     | ' '
        false     | 'un'
        true      | 'una'
        true      | 'un provincia'
        true      | 'un provincia no tan largo'
        false     | 'un provincia realmente largo en un lugar muy lejano'
    }

    void "validacion de pais"() {
        expect:
        new Direccion(DIRECCION_VALIDA + [pais: valor]).validate() == resultado
        where:
        resultado | valor
        false     | ''
        false     | ' '
        false     | 'un'
        true      | 'una'
        true      | 'un pais'
        true      | 'un pais no tan largo'
        false     | 'un pais realmente largo en un planeta muy muy lejano'
    }
}
