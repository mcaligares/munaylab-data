package munaylab.data

import munaylab.data.utils.DateUtil
import munaylab.SpecificationTestBuilder

import grails.testing.gorm.DomainUnitTest

class UsuarioSpec extends SpecificationTestBuilder implements DomainUnitTest<Usuario> {

    void "validacion de campos obligatorios"() {
        expect: usuarioValido.validate() == true
    }

    void "validacion de dni"() {
        expect:
        new Usuario(USUARIO_VALIDO + [dni: dato]).validate() == resultado
        where:
        resultado | dato
        false     | '914256'
        true      | '34914256'
        true      | '34.914.256'
        false     | '034.914.256'
        false     | '0.034.914.256'
    }

    void "validacion de nombre"() {
        expect:
        new Usuario(USUARIO_VALIDO + [nombre: dato]).validate() == resultado
        where:
        resultado | dato
        false     | ''
        false     | ' '
        false     | 'ma'
        true      | 'Miguel Augusto'
        false     | 'Un nombre para validar muy pero muy largo que no existe'
    }

    void "validacion de apellido"() {
        expect:
        new Usuario(USUARIO_VALIDO + [apellido: dato]).validate() == resultado
        where:
        resultado | dato
        false     | ''
        false     | ' '
        false     | 'mc'
        true      | 'Caligares'
        false     | 'Un apellido para validar muy largo que no existe'
    }

    void "validacion de username"() {
        expect:
        new Usuario(USUARIO_VALIDO + [username: dato]).validate() == resultado
        where:
        resultado | dato
        false     | ''
        false     | ' '
        false     | 'mc'
        true      | 'mcaligares'
        true      | 'mcaligares_prueba'
        false     | 'username_para_validar_muy_muy_largo'
    }

    void "validacion de integridad de username"() {
        given:
        usuarioValido.save(flush: true)
        when:
        def otroUsuarioValido = usuarioValido
        otroUsuarioValido.username = usuarioValido.username
        otroUsuarioValido.save(flush: true, failOnError: true)
        then:
        thrown Exception
        Usuario.count() == 1
    }

    void "validacion de email"() {
        expect:
        new Usuario(USUARIO_VALIDO + [email: dato]).validate() == resultado
        where:
        resultado | dato
        false     | ''
        false     | ' '
        false     | 'email'
        false     | 'email@'
        false     | 'email@org'
        true      | 'email@munaylab.org'
    }

    void "validacion de integridad de email"() {
        given:
        usuarioValido.save(flush: true)
        when:
        def otroUsuarioValido = usuarioValido
        otroUsuarioValido.email = usuarioValido.email
        otroUsuarioValido.save(flush: true, failOnError: true)
        then:
        thrown Exception
        Usuario.count() == 1
    }

    void "validacion de celular"() {
        expect:
        new Usuario(USUARIO_VALIDO + [celular: dato]).validate() == resultado
        where:
        resultado | dato
        false     | '1'
        false     | '12345678'
        true      | '123456789'
        true      | '123456789012345'
        false     | '1234567890123456'
    }

    void "validacion de telefono"() {
        expect:
        new Usuario(USUARIO_VALIDO + [telefono: dato]).validate() == resultado
        where:
        resultado | dato
        false     | '1'
        false     | '12345678'
        true      | '123456789'
        true      | '123456789012345'
        false     | '1234567890123456'
    }

    void "validacion de fecha de nacimiento"() {
        expect:
        new Usuario(USUARIO_VALIDO + [fechaDeNacimiento: dato]).validate() == resultado
        where:
        resultado | dato
        false     | new Date()
        false     | DateUtil.menosAnios(15)
        true      | DateUtil.menosAnios(16)
        true      | DateUtil.menosAnios(26)
        true      | DateUtil.menosAnios(70)
        true      | DateUtil.menosAnios(90)
        false     | DateUtil.menosAnios(99)
    }

    void "guardar un usuario"() {
        when:
        usuarioValido.save(flush: true)
        then:
        Usuario.count() == 1
    }

    void "guardar un usuario con direccion"() {
        given:
        def usuario = usuarioValido
        usuario.direccion = direccionValida
        when:
        usuario.save(flush: true)
        then:
        Usuario.count() == 1 && Direccion.count() == 1
    }
}
