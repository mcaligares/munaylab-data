package munaylab

import munaylab.data.Elemento
import munaylab.data.Evento
import munaylab.data.Horario

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

    static final HORARIO_VALIDO = [
        dia: Horario.Dia.LUNES,
        desdeHora: 10,
        desdeMinuto: 0,
        hastaHora: 13,
        hastaMinuto: 0,
        todoElDia: false,
        matutino: false,
        vespertino: false
    ]

    static final CONTRATO_VALIDO = [
        dedicacion: 80,
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

    static final CADENA_DE_10_CARACTERES = '1234567890'
    static final CADENA_DE_20_CARACTERES = (1..2).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_30_CARACTERES = (1..3).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_50_CARACTERES = (1..5).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_100_CARACTERES = (1..10).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_200_CARACTERES = (1..20).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_300_CARACTERES = (1..30).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_500_CARACTERES = (1..50).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_1000_CARACTERES = (1..100).collect{CADENA_DE_10_CARACTERES}.join()
    static final CADENA_DE_5000_CARACTERES = (1..500).collect{CADENA_DE_10_CARACTERES}.join()

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

    static final PLAN_VALIDO = [
        nombre: 'planing',
        descripcion: 'descripcion de planing',
        contenido: 'contenido de la planing',
        fechaDeInicio: new Date() +10,
        fechaDeFin: new Date() +50,
        publicado: true
    ]

    static final NOMBRES_DE_PLAN_VALIDOS = ['abcde', 'Lorem ipsum dolor sit amet', (CADENA_DE_500_CARACTERES)]
    static final NOMBRES_DE_PLAN_INVALIDOS = [null, '', ' ', 'abcd', CADENA_DE_500_CARACTERES +'1']
    static final DESCRIPCION_DE_PLAN_VALIDOS = ['abcde', 'Lorem ipsum dolor sit amet', (CADENA_DE_1000_CARACTERES)]
    static final DESCRIPCION_DE_PLAN_INVALIDOS = [null, '', ' ', 'abcd', CADENA_DE_1000_CARACTERES +'1']
    static final CONTENIDO_DE_PLAN_VALIDOS = [CADENA_DE_10_CARACTERES, 'Lorem ipsum dolor sit amet', (CADENA_DE_5000_CARACTERES)]
    static final CONTENIDO_DE_PLAN_INVALIDOS = [null, '', ' ', CADENA_DE_10_CARACTERES -'1', CADENA_DE_5000_CARACTERES +'1']

    static final CATEGORIA_VALIDA = [ nombre: 'categoria padre' ]
    static final SUBCATEGORIA_VALIDA = [ nombre: 'subcategoria' ]

    static final NOMBRE_CATEGORIA_VALIDOS = [ 'cat', 'categoria', CADENA_DE_50_CARACTERES ]
    static final NOMBRE_CATEGORIA_INVALIDOS = [ null, '', ' ', '12', CADENA_DE_50_CARACTERES + '1' ]

    static final ELEMENTO_VALIDO = [
        nombre: 'elemento',
        tipo: Elemento.Tipo.BIEN,
        estado: Elemento.Estado.NUEVO
    ]
    static final NOMBRES_DE_ELEMENTO_VALIDOS = ['123', 'elementos', CADENA_DE_50_CARACTERES]
    static final NOMBRES_DE_ELEMENTO_INVALIDOS = [null, '', ' ', '12', CADENA_DE_50_CARACTERES + '1']

    static final EVENTO_VALIDO = [
        tipo: Evento.Tipo.CONVOCATORIA,
        nombre: 'evento',
        objetivo: 'objetivo del evento'
    ]
    static final NOMBRES_EVENTOS_VALIDOS = ['nom', 'nombre', CADENA_DE_50_CARACTERES]
    static final NOMBRES_EVENTOS_INVALIDOS = [null, '', ' ', '12', CADENA_DE_50_CARACTERES + '1']
    static final OBJETIVOS_DE_EVENTOS_VALIDOS = ['12345', 'objetivos', CADENA_DE_300_CARACTERES]
    static final OBJETIVOS_DE_EVENTOS_INVALIDOS = [null, '', ' ', '1234', CADENA_DE_300_CARACTERES + '1']
}
