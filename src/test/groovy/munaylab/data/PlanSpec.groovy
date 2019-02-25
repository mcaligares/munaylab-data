package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class PlanSpec extends SpecificationTestBuilder implements DomainUnitTest<Plan> {

    void "validacion de campos"() {
        expect: planValido.validate() == true
    }

    void "guardar un programa"() {
        when:
        planValido.save(flush: true)
        then:
        Plan.count() == 1
    }

    void "validacion de nombres validos"() {
        expect: nuevoPlanCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PLAN_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevoPlanCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PLAN_INVALIDOS
    }

    void "validacion de descripcion validos"() {
        expect: nuevoPlanCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PLAN_VALIDOS
    }

    void "validacion de descripcion invalidos"() {
        expect: !nuevoPlanCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PLAN_INVALIDOS
    }

    void "validacion de contenido validos"() {
        expect: nuevoPlanCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PLAN_VALIDOS
    }

    void "validacion de contenido invalidos"() {
        expect: !nuevoPlanCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PLAN_INVALIDOS
    }

    void "validacion de fechas"() {
        given:
        def programa = planValido
        programa.fechaDeInicio = fechaDeInicio
        programa.fechaDeFin = fechaDeFin
        expect:
        programa.validate() == resultado
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
