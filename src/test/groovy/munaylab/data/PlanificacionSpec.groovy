package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class PlanificacionSpec extends SpecificationTestBuilder implements DomainUnitTest<Planificacion> {

    void "guardar una planificacion"() {
        when:
        planificacionValida.save(flush: true)
        then:
        Planificacion.count() == 1
    }

    void "agregar contenido a una planificacion"() {
        given:
        def planing = planificacionValida
        when:
        planing.mision = nuevoArticulo('mision')
        planing.vision = nuevoArticulo('vision')
        planing.valores = nuevoArticulo('valores')
        planing.save(flush: true, failOnError: true)
        then:
        Articulo.count() == 3
        Organizacion.count() == 1
        Planificacion.count() == 1
    }

}
