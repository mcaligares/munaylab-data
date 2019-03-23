package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class HorarioSpec extends SpecificationTestBuilder implements DomainUnitTest<Horario> {

    void "validacion de campos obligatorios"() {
        expect: horarioValido.validate() == true
    }

    void "validacion de dia"() {
        expect:
        nuevoHorarioCon('dia', valor).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | Horario.Dia.LUNES
    }

    void "validacion de fecha desde"() {
        expect:
        nuevoHorarioCon('desdeHora', hora, 'desdeMinuto', min).validate() == resultado
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
        nuevoHorarioCon('hastaHora', hora, 'hastaMinuto', min).validate() == resultado
        where:
        resultado | hora | min
        false     | 24   | 0
        false     | -1   | 0
        false     | 0    | -1
        false     | 0    | 60
        true      | 0    | 0
        true      | 10   | 10
    }

    void "validacion de campo todo el dia"() {
        expect:
        nuevoHorarioCon('todoElDia', valor).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

    void "validacion de campo turno matutino"() {
        expect:
        nuevoHorarioCon('matutino', valor).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

    void "validacion de campo turno vespertino"() {
        expect:
        nuevoHorarioCon('vespertino', valor).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

    void "validacion de campo turno nocturno"() {
        expect:
        nuevoHorarioCon('nocturno', valor).validate() == resultado
        where:
        resultado | valor
        false     | null
        true      | true
        true      | false
    }

}
