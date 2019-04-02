package munaylab.data

/** Representa un acuerdo entre un {@link Voluntario} y una {@link Organizacion}. */
class Contrato {

    /** Confirmación de firma del voluntario, campo obligatorio. Default: <code>true</code>*/
    Boolean firmado = false
    /** Firma digital del voluntario. Es un campo único, obligatorio con un tamaño de 36 caracteres. */
    String firmaDigital
    /** Fecha en la cual el voluntario firma el contrato. */
    Date fechaDeFirma
    /** Fecha de inicio de actividades por parte del voluntario. No puede ser anterior a la fecha actual. */
    Date fechaDeInicio
    /** Cantidad de horas mensuales dedicadas como voluntario. No puede ser anterior a la fecha actual. */
    Integer dedicacion
    /** Actividad de una Organización por la cual se está realizando el contrato. */
    Actividad actividad
    /** Voluntario que firmará el contrato. */
    Voluntario voluntario

    /** Pertenece a los datos del Voluntario. */
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
