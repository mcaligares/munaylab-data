package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ActividadSpec extends SpecificationTestBuilder implements DomainUnitTest<Actividad> {

    void "guardar una actividad"() {
        when:
        actividadValida.save(flush: true)
        then:
        Actividad.count() == 1
    }

    void "guardar toda una planificacion"() {
        when:
        def planning = planificacionValida.save(flush: true)
        def programa = programaValido
        and:
        planning.addToProgramas(programa)
        planning.save(flush: true)
        and:
        def proyecto = proyectoValido
        programa.addToProyectos(proyecto)
        programa.save(flush: true)
        and:
        proyecto.addToActividades(actividadValida)
        proyecto.save(flush: true)
        then:
        comprobarLasActividadesDeUnaOrganizacion(planning.organizacion)
    }

}
