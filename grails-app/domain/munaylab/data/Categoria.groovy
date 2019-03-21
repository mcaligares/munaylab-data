package munaylab.data

class Categoria {

    String nombre
    Collection subcategorias
    Categoria categoriaPadre

    static hasMany = [subcategorias: Categoria]

    static belongsTo = [categoriaPadre: Categoria]

    static constraints = {
        categoriaPadre nullable: true
        nombre nullable: false, blank: false, unique: true, size: 3..50
    }

}
