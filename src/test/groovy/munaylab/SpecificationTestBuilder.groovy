package munaylab

import munaylab.data.Articulo
import munaylab.data.Contrato
import munaylab.data.Direccion
import munaylab.data.Disponibilidad
import munaylab.data.Privacidad
import munaylab.data.Organizacion
import munaylab.data.Planificacion
import munaylab.data.Programa
import munaylab.data.Usuario
import munaylab.data.Voluntario
import spock.lang.Specification

class SpecificationTestBuilder extends Specification implements DataSample {

    protected Usuario getUsuarioValido() {
        return new Usuario(USUARIO_VALIDO)
    }

    protected void comprobarValoresPorDefectoDePrivacidad(Privacidad privacidad) {
        assert privacidad != null
        assert privacidad.compartirDni == true
        assert privacidad.compartirEmail == true
        assert privacidad.compartirNombre == true
        assert privacidad.compartirCelular == true
        assert privacidad.compartirTelefono == true
        assert privacidad.compartirFechaDeNacimiento == true
        assert privacidad.compartirDireccion == true
        assert privacidad.recibirSms == true
        assert privacidad.recibirEmail == true
    }

    protected void comprobarValorPorDefectoDeVoluntario(Voluntario voluntario) {
        assert voluntario != null
        assert voluntario.estado == Voluntario.Estado.INACTIVO
    }

    protected void comprobarVoluntario() {
        assert Usuario.count() == 1
        assert Voluntario.count() == 1
    }

    protected Direccion getDireccionValida() {
        return new Direccion(DIRECCION_VALIDA)
    }

    protected Disponibilidad getDisponibilidadValida() {
        return new Disponibilidad(DISPONIBILIDAD_VALIDA)
    }

    protected void comprobarDisponibilidadDelVoluntario(int cantidad) {
        comprobarVoluntario()
        assert Disponibilidad.count() == cantidad
    }

    protected Contrato getContratoValido() {
        return new Contrato(CONTRATO_VALIDO + [voluntario: usuarioValido.voluntario])
    }

    protected void comprobarContratoDeVoluntario() {
        comprobarVoluntario()
        assert Contrato.count() == 1
        assert Voluntario.get(1) == Contrato.get(1).voluntario
    }

    protected Articulo getArticuloValido() {
        return new Articulo(ARTICULO_VALIDO)
    }

    protected Articulo getArticuloConOrganizacionValido() {
        Articulo articulo = articuloValido
        articulo.organizacion = organizacionValida
        return articulo
    }

    protected Articulo nuevoArticuloCon(String campo, def valor) {
        Articulo articulo = articuloConOrganizacionValido
        articulo[campo] = valor
        return articulo
    }

    protected Organizacion getOrganizacionValida() {
        Organizacion org = new Organizacion(ORGANIZACION_VALIDA)
        org.direccion = direccionValida
        return org
    }

    protected Organizacion nuevaOrganizacionCon(String campo, def valor) {
        Organizacion org = organizacionValida
        org[campo] = valor
        return org
    }

    protected Articulo nuevoArticulo(String contenido) {
        return new Articulo(ARTICULO_VALIDO + [url: contenido, titulo: contenido])
    }

    protected Planificacion getPlanificacionValida() {
        return new Planificacion([organizacion: organizacionValida])
    }

    protected Programa getProgramaValido() {
        return new Programa(PROGRAMA_VALIDO + [planificacion: planificacionValida])
    }

    protected Programa nuevoProgramaCon(String campo, def valor) {
        Programa programa = programaValido
        programa[campo] = valor
        return programa
    }

}
