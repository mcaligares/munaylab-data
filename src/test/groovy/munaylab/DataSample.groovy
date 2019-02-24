package munaylab

import munaylab.data.Disponibilidad

interface DataSample {

    static final USUARIO_VALIDO = [
        nombre:     'Miguel Augusto',
        apellido:   'Caligares',
        username:   'mcaligares',
        email:      'mcaligares@munaylab.org'
    ]

    static final DIRECCION_VALIDA = [
        domicilio:      'Peat. 32 N° 570 B° San Pedrito',
        departamento:   'San Salvador de Jujuy',
        provincia:      'Jujuy',
        pais:           'Argentina'
    ]

    static final DISPONIBILIDAD_VALIDA = [
        dia: Disponibilidad.Dia.LUNES,
        desdeHora: 10,
        desdeMinuto: 0,
        hastaHora: 13,
        hastaMinuto: 0,
        todoElDia: false,
        matutino: false,
        vespertino: false
    ]

    static final CONTRATO_VALIDO = [
        fechaDeInicio: new Date() +1,
        firmaDigital: UUID.randomUUID().toString()
    ]

    static final ARTICULO_VALIDO = [
        autor: 'mcaligares',
        titulo: 'articulo',
        url: 'articulo',
        contenido: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit'
    ]

    static final ORGANIZACION_VALIDA = [
        nombre: 'MunayLab',
        url: 'munaylab',
        resumen: 'Lorem ipsum dolor sit amet...',
        fechaDeConstitucion: new Date() -1
    ]

    static final CADENA_DE_20_CARACTERES = '12345678901234567890'
    static final CADENA_DE_100_CARACTERES = (1..100).join().toString()
    static final CADENA_DE_200_CARACTERES = (1..200).join().toString()
    static final CADENA_DE_300_CARACTERES = (1..300).join().toString()
    static final CADENA_DE_500_CARACTERES = (1..500).join().toString()
    static final CADENA_DE_1000_CARACTERES = (1..1000).join().toString()
    static final CADENA_DE_5000_CARACTERES = (1..5000).join().toString()

    static final AUTORES_VALIDOS = ['abc', 'mcaligares', CADENA_DE_20_CARACTERES]
    static final AUTORES_INVALIDOS = [null, '', ' ', '  ', CADENA_DE_20_CARACTERES + '1']

    static final TITULOS_VALIDOS = ['titulo']
    static final TITULOS_INVALIDOS = [null, '', '1234', CADENA_DE_100_CARACTERES + '1']

    static final URLS_VALIDAS = ['una_url']
    static final URLS_INVALIDAS = [null, '', '1234', CADENA_DE_500_CARACTERES + '1']

    static final RESUMENES_VALIDOS = [null, 'un resumen']
    static final RESUMENES_INVALIDOS = ['', '123456789', CADENA_DE_1000_CARACTERES + '1']

    static final CONTENIDOS_VALIDOS = ['Lorem ipsum dolor sit amet']
    static final CONTENIDOS_INVALIDOS = [null, '', '123456789', CADENA_DE_5000_CARACTERES + '1']

    static final IMAGENES_VALIDAS = [null, 'https://munaylab.org/imagen.jpg']
    static final IMAGENES_INVALIDAS = ['', '12', CADENA_DE_1000_CARACTERES + '1']

    static final PALABRAS_CLAVES_VALIDAS = [null, '', ' ', 'palabras, claves']
    static final PALABRAS_CLAVES_INVALIDAS = [CADENA_DE_1000_CARACTERES + '1']

    static final NOMBRES_DE_ORGANIZACION_VALIDOS = ['abc', 'MunayLab']
    static final NOMBRES_DE_ORGANIZACION_INVALIDOS = [null, '', ' ', '  ', CADENA_DE_200_CARACTERES + '1']

    static final URLS_DE_ORGANIZACION_VALIDOS = ['abc', 'MunayLab']
    static final URLS_DE_ORGANIZACION_INVALIDOS = [null, '', ' ', '  ', CADENA_DE_200_CARACTERES + '1']

    static final RESUMENES_DE_ORGANIZACION_VALIDOS = ['Lorem ipsum dolor sit amet']
    static final RESUMENES_DE_ORGANIZACION_INVALIDOS = [null, '', '123456789', CADENA_DE_300_CARACTERES + '1']
}
