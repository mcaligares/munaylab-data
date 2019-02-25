package munaylab.data

class Proyecto extends Plan {

    Programa programa
    Collection actividades

    static belongsTo = [programa: Programa]

    static hasMany = [actividades: Actividad]

}
