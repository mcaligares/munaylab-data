package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class PrivacidadSpec extends SpecificationTestBuilder implements DomainUnitTest<Privacidad> {

    void "crear usuario con configuracion de privacidad por defecto"() {
        given:
        def usuario = usuarioValido.save(flush: true)
        expect:
        comprobarValoresPorDefectoDePrivacidad(usuario.privacidad)
    }

}
