package munaylab.data

/** Representa la dirección física de un {@link Usuario} o una {@link Organizacion}. */
class Direccion {

    /** Coordenada de Latitud, campo opcional. */
    String latitud
    /** Coordenada de Longitud, campo opcional. */
    String longitud
    /** Domicilio campo obligatorio con un tamaño de 3 a 50 caracteres */
    String domicilio
    /** Departamento campo obligatorio con un tamaño de 3 a 50 caracteres */
    String departamento
    /** Provincia campo obligatorio con un tamaño de 3 a 50 caracteres */
    String provincia
    /** Pais campo obligatorio con un tamaño de 3 a 50 caracteres */
    String pais

    static constraints = {
        latitud nullable: true
        longitud nullable: true
        domicilio nullable: false, blank: false, size: 3..50
        departamento nullable: false, blank: false, size: 3..50
        provincia nullable: false, blank: false, size: 3..50
        pais nullable: false, size: 3..50
    }

}
