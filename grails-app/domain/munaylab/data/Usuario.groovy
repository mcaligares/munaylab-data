package munaylab.data

import munaylab.data.utils.DateUtil

/**
 * Representa un usuario de la plataforma.
 */
class Usuario {

    /** DNI del usuario, es un campo obligatorio con un tamaño de 7 a 10 caracteres. */
    String dni
    /** Nombre del usuario, es un campo obligatorio con un tamaño de 5 a 50 caracteres. */
    String nombre
    /** Apellido del usuario, es un campo obligatorio con un tamaño de 5 a 30 caracteres. */
    String apellido
    /** Username del usuario, es un campo único y obligatorio con un tamaño de 3 a 20 caracteres. */
    String username
    /** Email del usuario, es un campo único y obligatorio con una validación de email. */
    String email
    /** Celular del usuario, es un campo opcional con un tamaño de 9 a 15 caracteres, no tiene ningún formato en especial. */
    String celular
    /** Teléfono del usuario, es un campo opcional con un tamaño de 9 a 15 caracteres, no tiene ningún formato en especial. */
    String telefono
    /** Fecha de Nacimiento del usuario, es un campo opcional (admite edades de 16 - 90 años). */
    Date fechaDeNacimiento
    /** Direccion del usuario, es un campo opcional. */
    Direccion direccion
    /** Configuracion de privacidad del usuario. Valor por defecto: {@link Privacidad#getPorDefecto() porDefecto}. */
    Privacidad privacidad = Privacidad.porDefecto
    /** Datos del usuario como voluntario, es un campo único. */
    Voluntario voluntario = Voluntario.porDefecto

    /**
     * Contiene una {@link Direccion},
     * una configuracion de {@link Privacidad}
     * y unos datos de {@link Voluntario}
     */
    static hasOne = [
        direccion: Direccion,
        privacidad: Privacidad,
        voluntario: Voluntario
    ]

    static constraints = {
        dni nullable: true, size: 7..10
        nombre nullable: false, blank: false, size: 3..50
        apellido nullable: false, blank: false, size: 3..30
        username nullable: false, blank: false, unique: true, size: 3..20
        email nullable: false, blank: false, email: true, unique: true
        celular nullable: true, size: 9..15
        telefono nullable: true, size: 9..15
        fechaDeNacimiento nullable: true, range: DateUtil.rangoDeFechas(90, 16)
        direccion nullable: true
        privacidad nullable: false
        voluntario nullable: false, unique: true
    }

}
