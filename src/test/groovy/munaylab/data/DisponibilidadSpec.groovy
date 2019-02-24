package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class DisponibilidadSpec extends SpecificationTestBuilder implements DomainUnitTest<Disponibilidad> {

    void "validacion de campos obligatorios"() {
        expect: disponibilidadValida.validate() == true
    }

    void "validacion de dia"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [dia: dia]).validate() == resultado
        where:
        resultado | dia
        false     | null
        true      | Disponibilidad.Dia.LUNES
    }

    void "validacion de fecha desde"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [desdeHora: hora, desdeMinuto: min]).validate() == resultado
        where:
        resultado | hora | min
        false     | 24   | 0
        false     | -1   | 0
        false     | 0    | -1
        false     | 0    | 60
        true      | 0    | 0
        true      | 10   | 10
    }

    void "validacion de fecha hasta"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [hastaHora: hora, hastaMinuto: min]).validate() == resultado
        where:
        resultado | hora | min
        false     | 24   | 0
        false     | -1   | 0
        false     | 0    | -1
        false     | 0    | 60
        true      | 0    | 0
        true      | 10   | 10
    }

    void "validacion de disponibilidad (todo el dia)"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [todoElDia: valor]).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

    void "validacion de disponibilidad (turno matutino)"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [matutino: valor]).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

    void "validacion de disponibilidad (turno vespertino)"() {
        expect:
        new Disponibilidad(DISPONIBILIDAD_VALIDA + [vespertino: valor]).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

}
