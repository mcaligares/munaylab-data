package munaylab.data

class Disponibilidad {

    Dia dia
    Integer desdeHora
    Integer desdeMinuto
    Integer hastaHora
    Integer hastaMinuto
    Boolean todoElDia = false
    Boolean matutino = false
    Boolean vespertino = false

    static constraints = {
        dia nullable: false
        desdeHora nullable: true, min: 0, max: 23
        desdeMinuto nullable: true, min: 0, max: 59
        hastaHora nullable: true, min: 0, max: 23
        hastaMinuto nullable: true, min: 0, max: 59
        todoElDia nullable: false
        matutino nullable: false
        vespertino nullable: false
    }

    enum Dia {
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO
    }
}
