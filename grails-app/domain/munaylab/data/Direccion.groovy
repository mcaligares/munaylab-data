package munaylab.data

class Direccion {

    String latitud
    String longitud
    String domicilio
    String departamento
    String provincia
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
