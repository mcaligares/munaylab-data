package munaylab.data

import groovy.transform.ToString

/** Representa una organización de la plataforma, representa una organización de la sociedad civíl. */
@ToString(
    includeNames=true,
    includeFields=true,
    excludes='editores,administradores,voluntarios')
class Organizacion {

    /** Nombre de la organización, es un campo obligatorio, único y con un tamaño de 3 a 200 caracteres. */
    String nombre
    /** Subdominio de la organización, es un campo obligatorio, único y con un tamaño de 3 a 200 caracteres. */
    String dominio
    /** Resumen de la organización, es un campo obligatorio con un tamaño de 10 a 300 caracteres. */
    String resumen
    /** {@link Direccion} de la organización. */
    Direccion direccion
    /** Fecha de constitución de la organización. */
    Date fechaDeConstitucion
    /** Datos de planificación de la organización, campo obligatorio. */
    Planificacion planificacion
    /** Lista de usuario con el rol de editores de la organización. */
    Collection editores
    /** Lista de voluntarios de la organización. */
    Collection voluntarios
    /** Lista de usuario con el rol de adminitradores de la organización. */
    Collection administradores

    /** Fecha de creación del registro */
    Date dateCreated
    /** Fecha de última modificación del registro */
    Date lastUpdated

    /** Tiene una {@link Planificacion}. */
    static hasOne = [planificacion: Planificacion]

    /** Puede tener varios editores, voluntarios y administradores. */
    static hasMany = [
        editores: Usuario,
        voluntarios: Voluntario,
        administradores: Usuario
    ]

    static constraints = {
        nombre nullable: false, blank: false, unique: true, size: 3..200
        dominio nullable: false, blank: false, unique: true, size: 3..200
        resumen nullable: false, blank: false, size: 10..300
        direccion nullable: false
        fechaDeConstitucion nullable: false, max: new Date() +1
        planificacion nullable: false
    }
}
