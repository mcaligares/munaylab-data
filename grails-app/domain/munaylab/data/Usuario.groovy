package munaylab.data

import munaylab.data.utils.DateUtil

class Usuario {

    String dni
    String nombre
    String apellido
    String username
    String email
    String celular
    String telefono
    Date fechaDeNacimiento
    Direccion direccion
    Privacidad privacidad = Privacidad.porDefecto
    Voluntario voluntario = Voluntario.porDefecto

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
