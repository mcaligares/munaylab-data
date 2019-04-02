package munaylab.data

/**
 * Configuración de privacidad de un usuario.
 */
class Privacidad {

    /** Configuración para compartir el campo DNI. Default <code>true</code>. */
    Boolean compartirDni = true
    /** Configuración para compartir el campo Nombre y Apellido. Default <code>true</code>. */
    Boolean compartirNombre = true
    /** Configuración para compartir el campo Email. Default <code>true</code> */
    Boolean compartirEmail = true
    /** Configuración para compartir el campo Celular. Default <code>true</code> */
    Boolean compartirCelular = true
    /** Configuración para compartir el campo Telefono. Default <code>true</code> */
    Boolean compartirTelefono = true
    /** Configuración para compartir el campo Fecha de Nacimiento. Default <code>true</code> */
    Boolean compartirFechaDeNacimiento = true
    /** Configuración para compartir el campo Direccion. Default <code>true</code> */
    Boolean compartirDireccion = true
    /** Configuración para recibir SMS. Default <code>true</code> */
    Boolean recibirSms = true
    /** Configuración para recibir Email. Default <code>true</code> */
    Boolean recibirEmail = true

    /** Pertenece a un {@link Usuario}. */
    static belongsTo = [usuario: Usuario]

    /**
     * Devuelve una configuración de privacidad por defecto.
     * @return configuración por defecto.
     */
    public static Privacidad getPorDefecto() {
        return new Privacidad()
    }

}
