package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class ProgramaSpec extends SpecificationTestBuilder implements DomainUnitTest<Programa> {

    void "validacion de campos"() {
        expect: programaValido.validate() == true
    }

    void "guardar un programa"() {
        when:
        programaValido.save(flush: true)
        then:
        Programa.count() == 1
    }

    void "validacion de nombres validos"() {
        expect: nuevoProgramaCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PROGRAMA_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevoProgramaCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_PROGRAMA_INVALIDOS
    }

    void "validacion de descripcion validos"() {
        expect: nuevoProgramaCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PROGRAMA_VALIDOS
    }

    void "validacion de descripcion invalidos"() {
        expect: !nuevoProgramaCon('descripcion', valor).validate()
        where:  valor << DESCRIPCION_DE_PROGRAMA_INVALIDOS
    }

    void "validacion de contenido validos"() {
        expect: nuevoProgramaCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PROGRAMA_VALIDOS
    }

    void "validacion de contenido invalidos"() {
        expect: !nuevoProgramaCon('contenido', valor).validate()
        where:  valor << CONTENIDO_DE_PROGRAMA_INVALIDOS
    }

    void "validacion de fechas"() {
        given:
        def programa = programaValido
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
