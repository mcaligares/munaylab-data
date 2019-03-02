package munaylab.data

import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class OrganizacionSpec extends SpecificationTestBuilder implements DomainUnitTest<Organizacion> {

    void "validacion de campos obligatorios"() {
        expect: organizacionValida.validate() == true
    }

    void "guardar una organizacion"() {
        when: organizacionValida.save(flush: true)
        then: Organizacion.count() == 1
    }

    void "validacion de nombres validos"() {
        expect: nuevaOrganizacionCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_ORGANIZACION_VALIDOS
    }

    void "validacion de nombres invalidos"() {
        expect: !nuevaOrganizacionCon('nombre', valor).validate()
        where:  valor << NOMBRES_DE_ORGANIZACION_INVALIDOS
    }

    void "validacion de urls validas"() {
        expect: nuevaOrganizacionCon('url', valor).validate()
        where:  valor << URLS_DE_ORGANIZACION_VALIDOS
    }

    void "validacion de urls invalidos"() {
        expect: !nuevaOrganizacionCon('url', valor).validate()
        where:  valor << URLS_DE_ORGANIZACION_INVALIDOS
    }

    void "validacion de resumenes validos"() {
        expect: nuevaOrganizacionCon('resumen', valor).validate()
        where:  valor << RESUMENES_DE_ORGANIZACION_VALIDOS
    }

    void "validacion de resumenes invalidos"() {
        expect: !nuevaOrganizacionCon('resumen', valor).validate()
        where:  valor << RESUMENES_DE_ORGANIZACION_INVALIDOS
    }

    void "validacion de fecha de constitucion validas"() {
        expect: nuevaOrganizacionCon('fechaDeConstitucion', valor).validate()
        where:  valor << [new Date(), new Date() -1, new Date() -1000]
    }

    void "validacion de fecha de constitucion invalidas"() {
        expect: !nuevaOrganizacionCon('fechaDeConstitucion', valor).validate()
        where:  valor << [new Date() +1, new Date() +1000]
    }

    void "validacion de integridad de nombre y url"() {
        given:
        def org = organizacionValida.save(flush: true)
        def otraOrg = organizacionValida
        when:
        otraOrg.save(flush: true, failOnError: true)
        then:
        Organizacion.count() == 1
        def err = thrown Exception
        err.message.contains('unique.url') == true
        err.message.contains('unique.nombre') == true
    }

}
