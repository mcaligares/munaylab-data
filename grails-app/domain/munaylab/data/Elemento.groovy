package munaylab.data

/** Representa a un elemento que puede ser utilizado como un {@link Donativo} o un elemento de una {@link Actividad}. */
class Elemento {

    /** Tipo de elemento que representa. */
    Tipo tipo
    /** Nombre del elemento, campo obligatorio y con un tamaño de 3 a 50 caracteres. */
    String nombre
    /** Si es necesario para una actividad de una organización. */
    Boolean esNecesario
    /**
     * Estado del elemento.
     * Es obligatorio si el elemento es un <code>Tipo.BIEN</code>,
     * de otro, si es un <code>Tipo.SERVICIO</code> este campo es opcional.
     */
    Estado estado

    static constraints = {
        tipo nullable: false
        nombre nullable: false, blank: false, size: 3..50
        estado validator: { val, obj ->
            (obj.tipo == Tipo.SERVICIO) || (obj.tipo == Tipo.BIEN && val)
        }
        esNecesario nullable: true
    }

    /** Representa el tipo de {@link Elemento}. */
    enum Tipo {
        /** Es un elemento tangible que puede ser entregado. */
        BIEN,
        /** Es un elemento intangible que puede ser brindado. */
        SERVICIO
    }

    /** Representa el estado de un {@link Elemento}. */
    enum Estado {
        /** Es un elemento nuevo, sin uso. */
        NUEVO,
        /** Es un elemento usado, con algún tipo de uso. */
        USADO
    }
}
