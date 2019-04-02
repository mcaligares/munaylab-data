package munaylab.data.utils

/** Clase de utilidad para realizar operaciones con fechas. */
class DateUtil {

    /**
     * Realiza la substracción de una cantidad de años a la fecha actual.
     * @param value Cantidad de años a reducir.
     * @return 1 de Enero del año resultante.
     */
    public static Date menosAnios(int value) {
        return new Date().parse('yyy/MM/dd', "${Calendar.instance[Calendar.YEAR] - value}/1/1")
    }

    /**
     * Genera un rango de fechas.
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de finalización del rango.
     * @return rango de fechas.
     */
    public static Range rangoDeFechas(int desde, int hasta) {
        return DateUtil.menosAnios(desde)..DateUtil.menosAnios(hasta)
    }
}
