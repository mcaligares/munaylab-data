package munaylab.data

class Programa extends Plan {

    Planificacion planificacion
    Collection proyectos

    static belongsTo = [planificacion: Planificacion]

    static hasMany = [proyecto: Proyecto]

}
