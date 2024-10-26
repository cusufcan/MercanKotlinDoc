package a_types.a_basic_types

/**
 * Characters
 *
 * Karakterler Char türüyle temsil edilir. Karakter sabitleri tek
 * tırnak içine alınır: '1'.
 *
 * NOT: JVM'de, primitive tür olan char olarak saklanan bir karakter,
 * 16 bitlik bir Unicode karakterini temsil eder.
 *
 * Özel karakterler kaçış ters eğik çizgisinden (\) başlar. Aşağıdaki
 * kaçış dizileri desteklenir:
 *
 * \t - tab
 * \b - geri al
 * \n - yeni satır
 * \r - satır başı
 * \' - tek tırnak işareti
 * \" - çift tırnak işareti
 * \\ - ters eğik çizgi
 * \$ - dolar işareti
 *
 * Başka herhangi bir karakteri kodlamak için Unicode kaçış dizisi
 * sözdizimini kullanın: '\uFF00'.
 */

//fun main() {
//    val aChar: Char = 'a'
//
//    println(aChar)
//    println('\n') // Ekstra bir yeni satır karakteri yazdırır
//    println('\uFF00')
//}

/**
 * NOT: Karakter değişkeninin değeri bir rakamsa, digitToInt()
 * fonksiyonunu kullanarak bunu açıkça bir Int sayısına
 * dönüştürebilirsiniz.
 *
 * NOT: JVM'de sayılarda olduğu gibi, nullable bir referans,
 * gerektiğinde karakterler Java sınıflarında boxed olur.
 */