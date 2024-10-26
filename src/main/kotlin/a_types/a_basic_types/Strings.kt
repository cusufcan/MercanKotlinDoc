package a_types.a_basic_types

/**
 * Strings
 *
 * Kotlin'de dizeler String türüyle temsil edilir.
 *
 * NOT: JVM'de, UTF-16 kodlamasındaki String türündeki bir nesne
 * karakter başına yaklaşık 2 bayt kullanır.
 *
 * Genel olarak, bir dize değeri çift tırnak işareti (") içindeki
 * bir karakter dizisidir:
 */

//fun main() {
//    val str = "abcd 123"
//}

/**
 * Bir dizenin elemanları, dzinleme işlemiyle erişebileceğiniz
 * karakterlerdir: s[i]. Bu karakterler üzerinde for dönügüsüyle
 * yineleme yapabilirsiniz:
 */

//fun main() {
//    val str = "abcd 123"
//
//    for (c in str) {
//        println(c)
//    }
//}

/**
 * Dizeler değişmezdir (immutable). Bir dizeyi başlattığınızda,
 * değerini değiştiremez veya ona yeni bir değer atayamazsınız.
 * Dizeleri dönüştüren tüm işlemler, orijinal dizeyi değiştirmeden
 * bırakarak sonuçlarını yeni bir String nesnesinde döndürür:
 */

//fun main() {
//    val str = "abcd"
//
//    // Yeni bir String nesnesi oluşturur ve yazdırır
//    println(str.uppercase())
//    // ABCD
//
//    // Orijinal dize aynı kalır
//    println(str)
//    // abcd
//}

/**
 * Dizeleri birleştirmek için + operatörünü kullanın. Bu,
 * ifadedeki ilk öğe bir dize olduğu sürece dizeleri diğer
 * türlerdeki değerlerle birleştirmek için de işe yarar:
 */

//fun main() {
//    val s = "abc" + 1
//    println(s + "def")
//    // abc1def
//}

/**
 * String Literals
 * Kotlin'de iki tür string literal vardır:
 */

/**
 * Escaped Strings
 * Escaped Strings kaçan karakterler içerebilir.
 * İşte kaçan dizenin bir örneği:
 */

//fun main() {
//    val s = "Hello, world!\n"
//}

/**
 * Multiline Strings
 * Çok satırlı dizeler yeni satırlar ve keyfi metinler içerebilir.
 * Üçlü tırnak işaretiyle (""") sınırlandırılır, kaçış içermez ve
 * yeni satırlar ve diğer karakterleri içerebilir:
 */

//fun main() {
//    val text = """
//        for(c in "foo")
//            print(c)
//    """
//}

/**
 * Çok satırlı dizelerden öndeki boşlukları kaldırmak için
 * trimMargin() fonksiyonunu kullanın:
 */

//fun main() {
//    val text = """
//        |Tell me and I forget.
//        |Teach me and I remember.
//        |Involve me and I learn.
//        |(Benjamin Franklin)
//        """.trimMargin()
//}

/**
 * Varsayılan olarak, kenar boşluğu öneki olarak bir boru sembolü
 * | kullanılır, ancak başka bir karakter seçip bunu trimMargin(">")
 * gibi bir parametre olarak geçirebilirsiniz.
 */

/**
 * String Templates
 *
 * Dize değişkenleri şablon ifadeleri içerebilir - değerlendirilen
 * ve sonuçları bir dizeye birleştirilen kod parçaları. Bir şablon
 * ifadesi işlendiğinde, Kotlin ifadenin sonucunu ir dizeye
 * dönüştürmek için otomatik olarak .toString() işlevini çağırır.
 * Bir şablon ifadesi dolar işaretiyle ($) başlar ve bir değişken
 * adından oluşur:
 */

//fun main() {
//    val i = 10
//    println("i = $i")
//    // i = 10
//
//    val letters = listOf("a", "b", "c", "d", "e")
//    println("Letters: $letters")
//    // Letters: [a, b, c, d, e]
//
//    // veya süslü parantez içindeki bir ifadeden:
//
//    val s = "abc"
//    println("$s.length is ${s.length}")
//    // abc.length is 3
//}

/**
 * Şablonları hem çok satırlı hem de kaçışlı dizelerde kullanabilirsiniz.
 * Çok satırlı bir dizede (ters eğik çizgi kaçışını desteklemeyen)
 * herhangi bir sembolden önce dolar işareti $ eklemek için, bir
 * tanımlayıcının başlangıcı olarak izin verilen, aşağıdaki sözdizimini
 * kullanın:
 */

//fun main() {
//    val price = """
//    ${'$'}_9.99
//    """
//}

/**
 * String Formatting
 *
 * NOT: String.format() fonksiyonu ile dize biçimlendirme sadece
 * Kotlin/JVM'de mevcuttur.
 *
 * Bir dizeyi özel gereksinimlerinize göre biçimlendirmek için
 * String.format() fonksiyonunu kullanın.
 *
 * String.format() fonksiyonu bir biçim dizesi ve bir veya daha fazla
 * argüman kabul eder. Biçim dizesi, belirli bir argüman için bir yer
 * tutucu (%) ile gösterilir, ardından biçim belirteçleri gelir.
 * Biçim belirteçleri, flags, genişlik, hassasiyet ve dönüştürme
 * türünden oluşan ilgili argüman için biçimlendirme talimatlarıdır.
 * Biçim belirteçleri toplu olarak çıktının biçimlendirmesini
 * şekillendirir. Yaygın biçim belirteçleri arasında tamsayılar için
 * %d, kesirli sayılar için %f ve dizeler için %s bulunur. Ayrıca,
 * biçim dizesinde aynı argümana farklı biçimlerde birden çok kez
 * başvurmak için (argument_index$) sözdizimini de kullanabilirsiniz.
 *
 * Bir örneğe bakalım:
 */

fun main() {
    // Yedi karakter için başa sıfırlar ekleyerek bir tam sayıyı biçimlendirir
    val integerNumber = String.format("%07d", 31416)
    println(integerNumber)
    // 0031416

    // Kesirli sayıyı + işareti ve dört basamak şeklinde biçimlendirir
    val floatNumber = String.format("%+.4f", 3.141592)
    println(floatNumber)
    // +3.1416

    // İki dizeyi büyük harfe dönüştürürür.
    val helloString = String.format("%S %S", "hello", "world")
    println(helloString)
    // HELLO WORLD

    // Negatif bir sayıyı parantez içine alınacak şekilde biçimlendirir
    // Ardından aynı sayıyı argument_index$ kullanarak parantez olmadan biçimlendirir.
    val negativeNumberInParantheses = String.format("%(d means %1\$d", -31416)
    println(negativeNumberInParantheses)
    // (31416) means -31416
}

/**
 * Ek olarak, biçim dizesini bir değişkene atayabilirsiniz. Bu, biçim
 * dizesi değiştiğinde, örneğin kullanıcı yerel ayarına bağlı yerelleştirme
 * durumlarında yararlı olabilir.
 *
 * UYARI: String.format() fonksiyonunu kullanırken dikkatli olun çünkü
 * argümanların sayısı veya konumu ile bunlara karşılık gelen yer
 * tutucuların uyuşmaması kolay olabilir.
 */