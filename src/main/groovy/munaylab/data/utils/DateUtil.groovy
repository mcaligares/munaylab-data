package munaylab.data.utils

class DateUtil {

    public static Date menosAnios(int value) {
        return new Date().parse('yyy/MM/dd', "${Calendar.instance[Calendar.YEAR] - value}/1/1")
    }

    public static Range rangoDeFechas(int desde, int hasta) {
        return DateUtil.menosAnios(desde)..DateUtil.menosAnios(hasta)
    }
}
