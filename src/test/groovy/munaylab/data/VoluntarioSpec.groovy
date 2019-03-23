package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class VoluntarioSpec extends SpecificationTestBuilder implements DomainUnitTest<Voluntario> {

    void "crear usuario con estado de voluntario por defecto"() {
        given:
        def usuario = usuarioValido.save(flush: true)
        expect:
        comprobarValorPorDefectoDeVoluntario(usuario.voluntario)
    }

    void "crear usuario voluntario con disponibilidad"() {
        given:
        def usuario = usuarioValido
        5.times { usuario.voluntario.addToDisponibilidad(horarioValido) }
        when:
        usuario.save(flush: true)
        then:
        comprobarDisponibilidadDelVoluntario(5)
    }

    void "crear usuario voluntario con contrato"() {
        given:
        def usuario = usuarioValido
        when:
        usuario.voluntario.addToContratos(contratoValido)
        usuario.save(flush: true)
        then:
        comprobarContratoDeVoluntario()
    }
}
