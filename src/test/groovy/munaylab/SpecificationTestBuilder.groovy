package munaylab

import munaylab.data.Actividad
import munaylab.data.Articulo
import munaylab.data.Contrato
import munaylab.data.Categoria
import munaylab.data.Direccion
import munaylab.data.Evento
import munaylab.data.Horario
import munaylab.data.Donativo
import munaylab.data.Privacidad
import munaylab.data.Organizacion
import munaylab.data.Plan
import munaylab.data.Planificacion
import munaylab.data.Programa
import munaylab.data.Proyecto
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

    protected Horario getHorarioValido() {
        return new Horario(HORARIO_VALIDO)
    }
    protected Horario nuevoHorarioCon(String nombre1, def valor1, String nombre2 = null, def valor2 = null) {
        def horario = new Horario(HORARIO_VALIDO)
        horario[nombre1] = valor1
        if (nombre2) horario[nombre2] = valor2
        return horario
    }

    protected void comprobarDisponibilidadDelVoluntario(int cantidad) {
        comprobarVoluntario()
        assert Horario.count() == cantidad
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
        org.planificacion = new Planificacion()
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

    protected Plan getPlanValido() {
        return new Plan(PLAN_VALIDO + [planificacion: planificacionValida])
    }

    protected Plan nuevoPlanCon(String campo, def valor) {
        Plan plan = planValido
        plan[campo] = valor
        return plan
    }

    protected Programa getProgramaValido() {
        return new Programa(PLAN_VALIDO + [planificacion: planificacionValida])
    }

    protected Proyecto getProyectoValido() {
        return new Proyecto(PLAN_VALIDO + [programa: programaValido])
    }

    protected Actividad getActividadValida() {
        return new Actividad(PLAN_VALIDO + [proyecto: proyectoValido])
    }

    protected void comprobarLaPlanificacionDeUnaOrganizacion(Organizacion org) {
        assert Organizacion.count() == 1
        assert Planificacion.count() == 1
        assert org.planificacion != null
        def id = org.planificacion.id
        assert org.planificacion == Planificacion.get(id)
    }

    protected void comprobarLosProgramasDeUnaOrganizacion(Organizacion org) {
        comprobarLaPlanificacionDeUnaOrganizacion(org)
        assert Programa.count() == 1
        def id = org.planificacion.programas.first().id
        assert org.planificacion.programas.first() == Programa.get(id)
    }

    protected void comprobarLosProyectosDeUnaOrganizacion(Organizacion org) {
        comprobarLosProgramasDeUnaOrganizacion(org)
        assert Proyecto.count() == 1
        def id = org.planificacion.programas.first().proyectos.first().id
        assert org.planificacion.programas.first().proyectos.first() == Proyecto.get(id)
    }

    protected void comprobarLasActividadesDeUnaOrganizacion(Organizacion org) {
        comprobarLosProyectosDeUnaOrganizacion(org)
        assert Actividad.count() == 1
        assert org.planificacion.programas.first().proyectos.first().actividades.first()
        // TODO comparar actividad del obj con la de base de datos
    }

    protected Categoria getCategoriaValida() {
        return new Categoria(CATEGORIA_VALIDA)
    }

    protected Categoria nuevaCategoriaCon(String campo, def valor) {
        Categoria categoria = categoriaValida
        categoria[campo] = valor
        return categoria
    }

    protected void comprobarNombreUnicoDeCategoria(Categoria categoria) {
        assert Categoria.count() == 1
        assert categoria.hasErrors()
        assert categoria.errors.hasFieldErrors('nombre')
    }

    protected void comprobarSubcategorias(Categoria categoria, int cantidad) {
        assert !categoria.hasErrors()
        assert categoria.subcategorias.size() == cantidad
        assert Categoria.count() == (cantidad + 1)
    }

    protected Donativo getDonativoValido() {
        return new Donativo(DONATIVO_VALIDO)
    }

    protected Donativo getDonativoServicioValido() {
        return new Donativo(tipo: Donativo.Tipo.SERVICIO, nombre: 'servicio')
    }

    protected Donativo nuevoDonativoCon(String nombre, def valor) {
        Donativo donativo = donativoValido
        donativo[nombre] = valor
        return donativo
    }

    protected Evento getEventoValido() {
        def evento = new Evento(EVENTO_VALIDO)
        evento.horario = horarioValido
        evento.articulo = articuloValido
        evento.direccion = direccionValida
        return evento
    }

    protected Evento nuevoEventoCon(String nombre, def valor) {
        def evento = eventoValido
        evento[nombre] = valor
        return evento
    }
}
