package munaylab.data

class Contrato {

    Boolean firmado = false
    String firmaDigital
    Date fechaDeFirma
    Date fechaDeInicio
    Voluntario voluntario

    static belongsTo = [voluntario: Voluntario]

    static constraints = {
        firmado nullable: false
        voluntario nullable: false
        fechaDeFirma nullable: true, min: new Date()
        fechaDeInicio nullable: false, min: new Date()
        firmaDigital nullable: false, blank: false, unique: true, minSize: 36, maxSize: 36
    }

}
