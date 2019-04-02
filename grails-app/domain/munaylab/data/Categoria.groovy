package munaylab.data

/** Representa una categoría. */
class Categoria {

    /** Nombre de la categoría, es un campo obligatorio, único con un tamaño de 3 a 50 caracteres. */
    String nombre
    /** Lista de subcategorías. */
    Collection subcategorias
    /** Categoría padre. */
    Categoria categoriaPadre

    /** Puede tener varias subcategorias. */
    static hasMany = [subcategorias: Categoria]

    /** Pertenece a una categoría padre. */
    static belongsTo = [categoriaPadre: Categoria]

    static constraints = {
        categoriaPadre nullable: true
        nombre nullable: false, blank: false, unique: true, size: 3..50
    }

}
