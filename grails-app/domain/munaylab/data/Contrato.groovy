package munaylab.data

class Contrato {

    Boolean firmado = false
    String firmaDigital
    Date fechaDeFirma
    Date fechaDeInicio
    Integer dedicacion
    Actividad actividad
    Voluntario voluntario

    static belongsTo = [voluntario: Voluntario]

    static constraints = {
        firmado nullable: false
        actividad nullable: false
        voluntario nullable: false
        dedicacion nullable: false, min: 1, max: 160
        fechaDeFirma nullable: true, min: new Date()
        fechaDeInicio nullable: false, min: new Date()
        firmaDigital nullable: false, blank: false, unique: true, minSize: 36, maxSize: 36
    }

}
