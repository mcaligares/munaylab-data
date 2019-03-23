package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class EventoSpec extends SpecificationTestBuilder implements DomainUnitTest<Evento> {

    void "validacion de campos"() {
        expect: eventoValido.validate() == true
    }

    void "validacion de nombres validos"() {
        expect: nuevoEventoCon('nombre', valor).validate()
        where: valor << NOMBRES_EVENTOS_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevoEventoCon('nombre', valor).validate()
        where: valor << NOMBRES_EVENTOS_INVALIDOS
    }

    void "validacion de objetivos validos"() {
        expect: nuevoEventoCon('objetivo', valor).validate()
        where: valor << OBJETIVOS_DE_EVENTOS_VALIDOS
    }

    void "validacion de objetivos invalidos"() {
        expect: !nuevoEventoCon('objetivo', valor).validate()
        where: valor << OBJETIVOS_DE_EVENTOS_INVALIDOS
    }

    void "validacion de horario de evento"() {
        expect: !nuevoEventoCon('horario', null).validate()
    }

    void "validacion de articulo de evento"() {
        expect: !nuevoEventoCon('articulo', null).validate()
    }

    void "validacion de direccion de evento"() {
        expect: !nuevoEventoCon('direccion', null).validate()
    }

    void "validacion de destinatarios de evento"() {
        expect: !nuevoEventoCon('destinatarios', null).validate()
    }

    void "validacion de tipo de evento"() {
        expect:
        nuevoEventoCon('tipo', tipo).validate() == resultado
        where:
        resultado | tipo
        false     | Evento.Tipo.OTRO
        true      | Evento.Tipo.RECAUDACION
        true      | Evento.Tipo.CONVOCATORIA
    }

    void "validacion de plantilla de evento"() {
        given:
        def evento = nuevoEventoCon('tipo', Evento.Tipo.OTRO)
        evento.plantilla = 'una plantilla de evento'
        expect:
        evento.validate()
    }
}
