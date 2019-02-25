package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ProgramaSpec extends SpecificationTestBuilder implements DomainUnitTest<Programa> {

    void "guardar un programa"() {
        when:
        programaValido.save(flush: true, failOnError: true)
        then:
        Programa.count() == 1
    }
}
