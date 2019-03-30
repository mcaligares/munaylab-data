package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ActividadSpec extends SpecificationTestBuilder implements DomainUnitTest<Actividad> {

    void "validacion de campos"() {
        expect: actividadValida.validate()
    }

    void "guardar una actividad"() {
        when:
        actividadValida.save(flush: true)
        then:
        Articulo.count() == 1
        Actividad.count() == 1
    }

    void "guardar una actividad con horarios"() {
        given:
        def actividad = actividadValida
        actividad.addToHorarios(horarioValido)
        when:
        actividad.save(flush: true)
        then:
        Horario.count() == 1
        Articulo.count() == 1
        Actividad.count() == 1
        actividad.horarios.size() == 1
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
