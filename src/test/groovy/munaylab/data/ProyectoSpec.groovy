package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ProyectoSpec extends SpecificationTestBuilder implements DomainUnitTest<Proyecto> {

    void "validacion de campos"() {
        when:
        proyectoValido.save(flush: true, failOnError: true)
        then:
        Proyecto.count() == 1
    }
}
