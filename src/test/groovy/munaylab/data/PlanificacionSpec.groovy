package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class PlanificacionSpec extends SpecificationTestBuilder implements DomainUnitTest<Planificacion> {

    void "validacion de campos"() {
        expect: planificacionValida.validate() == true
    }

    void "guardar una planificacion"() {
        when:
        planificacionValida.save(flush: true)
        then:
        Organizacion.count() == 1
        Planificacion.count() == 1
    }

    void "validacion de nombres validos"() {
        expect: nuevaPlanificacionCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PLANIFICACION_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevaPlanificacionCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PLANIFICACION_INVALIDOS
    }

    void "validacion de descripcion validos"() {
        expect: nuevaPlanificacionCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PLANIFICACION_VALIDOS
    }

    void "validacion de descripcion invalidos"() {
        expect: !nuevaPlanificacionCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PLANIFICACION_INVALIDOS
    }

    void "validacion de contenido validos"() {
        expect: nuevaPlanificacionCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PLANIFICACION_VALIDOS
    }

    void "validacion de contenido invalidos"() {
        expect: !nuevaPlanificacionCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PLANIFICACION_INVALIDOS
    }

    void "validacion de fechas"() {
        given:
        def planing = planificacionValida
        planing.fechaDeInicio = fechaDeInicio
        planing.fechaDeFin = fechaDeFin
        expect:
        planing.validate() == resultado
        where:
        resultado | fechaDeInicio | fechaDeFin
        true      | null          | null
        true      | new Date()    | new Date() +1
        true      | new Date() -9 | new Date()
        true      | new Date()    | new Date()
        true      | new Date()    | null
        false     | null          | new Date()
        false     | new Date() +2 | new Date() +1
    }
}
