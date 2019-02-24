package munaylab.data

class Privacidad {

    Boolean compartirDni = true
    Boolean compartirNombre = true
    Boolean compartirEmail = true
    Boolean compartirCelular = true
    Boolean compartirTelefono = true
    Boolean compartirFechaDeNacimiento = true
    Boolean compartirDireccion = true
    Boolean recibirSms = true
    Boolean recibirEmail = true

    static belongsTo = [usuario: Usuario]

    static constraints = {
    }

    public static Privacidad getPorDefecto() {
        return new Privacidad()
    }

}
