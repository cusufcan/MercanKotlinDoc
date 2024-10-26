package a_types.a_basic_types

/**
 * Arrays
 *
 * Dizi, aynı türdeki veya alt türlerindeki sabit sayıda değeri
 * tutan bir veri yapısıdır. Kotlin'deki en yaygnı dizi türü,
 * Array sınfıı tarafından temsil edilen nesne türü dizisidir.
 *
 * NOT: Nesne türü dizisinde primitive öğeler kullanırsanız, bu,
 * primitive öğelerinizin nesnelere boxed yapılması nedeniyle
 * bir performans etkisine neden olur. Boxed yükünü önlemek için,
 * bunun yerine ilkel tür dizileri kullanın.
 *
 * Diziler ne zaman kullanılır?
 *
 * Kotlinde karşılamanız gerken özel düşük seviyesi gereksinimleriniz
 * olduğunda dizileri kullanın. Örneğin, normal uygulamalar için
 * gerekenin ötesinde performans gereksinimleriniz varsa veya özel
 * veri yapıları oluşturmanız gerekiyorsa. Bu türk kısıtlamalarınız
 * yoksa bunun yerine koleksiyonları kullanın.
 *
 * Koleksiyonların dizilere kıyasla şu avantajları vardır:
 *
 * Koleksiyonlar salt okunur olabilir; bu da size daha fazla kontrol
 * sağlar ve net bir amacı olan sağlam kod yazmanıza olanak tanır.
 *
 * Koleksiyonlara eleman eklemek ve çıkarmak kolaydır. Buna karşılık,
 * dizilerin boyutu sabittir. Bir diziye eleman eklemenin veya çıkarmanın
 * tek yolu her seferinde yeni bir dizi oluşturmaktır ki bu çok verimsizdir:
 */

//fun main() {
//    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
//
//    // += atama işlemini kullanarak yeni bir riversArray oluşturulur,
//    // orijinal öğeleri kopyalar ve "Mississippi" ekler
//    riversArray += "Mississippi"
//    println(riversArray.joinToString())
//    // Nile, Amazon, Yangtze, Mississippi
//}

/**
 * Koleksiyonların yapısal olarak eşit olup olmadığını kontrol etmek için
 * eşitlik operatörünü (==) kullanabilirsiniz. Bu operatörü diziler için
 * kullanamazsınız.
 */

/**
 * Dizi Oluşturma
 *
 * Kotlin'de diziler olutşurmak için şunları kullanabilirsiniz:
 *
 * arrayOf(), arrayOfNulls() veya emptyArray() gibi işlevler.
 * Array constructor.
 */

/**
 * Bu örnek arrayOf() işlevini kullanır ve öğe değerlerini ona geçirir:
 */

//fun main() {
//    val simpleArray = arrayOf(1, 2, 3)
//    println(simpleArray.joinToString())
//    // 1, 2, 3
//}

/**
 * Bu örnekte, belirtilen boyutta boş öğelerler dolu bir dizi
 * oluşturmak için arrayOfNulls() fonksiyonu kullanılmaktadır:
 */

//fun main() {
//    val nullArray: Array<Int?> = arrayOfNulls(3)
//    println(nullArray.joinToString())
//    // null, null, null
//}

/**
 * Bu örnekte boş bir dizi oluşturmak için emptyArray()
 * fonksiyonu kullanılmaktadır:
 */

//fun main() {
//    var exampleArray = emptyArray<String>()
//}

/**
 * Kotlin'in type inference nedeniyle atamanın sol veya
 * sağ tarafındaki boş dizinin türünü belirtebilirsiniz.
 *
 * Örneğin:
 */

//fun main() {
//    var exampleArray = emptyArray<String>()
//
////    var exampleArray: Array<String> = emptyArray()
//}

/**
 * Dizi oluşturucusu, dizi boyutunu ve dizi elemanları için
 * dizi indeksi verildiğinde değerler döndüren bir fonksiyonu
 * alır:
 */

//fun main() {
//    // Sıfırlarla başlatılan bir Array<Int> oluşturur
//    val initArray = Array<Int>(3) { 0 }
//    println(initArray.joinToString())
//    // 0, 0, 0
//
//    // 0, 1, 4, 9, 16 değerlerine sahip bir Array<String> oluşturur
//    val asc = Array(5) { i -> (i * i).toString() }
//    asc.forEach { println(it) }
//    // 014916
//}

/**
 * Nested Arrays
 *
 * Çok boyutlu diziler oluşturmak için diziler birbirinin içine
 * yerleştirilebilir:
 */

//fun main() {
//    // İki-boyutlu bir dizi oluşturur
//    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
//    println(twoDArray.contentDeepToString())
//    // [[0, 0], [0, 0]]
//
//    // Üç-boyutlu bir dizi oluşturur
//    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
//    println(threeDArray.contentDeepToString())
//    // [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
//}

/**
 * Öğelere Erişme ve Değiştirme
 *
 * Diziler her zaman değiştirilebilir. Bir dizideki öğelere
 * erişmek ve bunları değiştirmek için dizinli erişim
 * operatörünü [] kullanın:
 */

//fun main() {
//    val simpleArray = arrayOf(1, 2, 3)
//    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
//
//    // Öğeye erişir ve onu değiştirir
//    simpleArray[0] = 10
//    twoDArray[0][0] = 2
//
//    // Değiştirilen öğeyi yazdırır
//    println(simpleArray[0].toString()) // 10
//    println(twoDArray[0][0].toString()) // 2
//}

/**
 * Kotlin'deki diziler değişmezdir. Bu, Kotlin'in olası bir
 * çalışma zamanı hatasını önlemek için bir Array<String> öğesini
 * bir Array<Any> öğesine atamanıza izin vermediği anlamına gelir.
 * Bunun yerine, Array<out Any> öğesini kullanabilirsiniz.
 * (Type Projections, Generics)
 */

/**
 * Dizilerle Genel İşlemler
 *
 * Kotlin'de, dizileri kullanarak bir fonksiyona değişken sayıda
 * argüman geçirebilir veya dizilerin kendisinde işlemler
 * gerçekleştirebilirsiniz. Örneğin, dizileri karşılaştırmak,
 * içeriklerini dönüştürmek veya bunları koleksiyonlara
 * dönüştürmek.
 */

/**
 * Bir Fonksiyona Değişken Sayıda Argüman Geçirin
 *
 * Kotlin'de vararg parametresi aracılığıyla bir fonksiyona
 * değişken sayıda argüman geçirebilirsiniz. Bu, bir mesajı
 * biçimlendirirken veya bir SQL sorgusu oluştururken olduğu
 * gibi, argüman sayısını önceden bilmediğinizde yararlıdır.
 *
 * Değişken sayıda argüman içeren bir diziyi bir fonksiyona
 * geçirmek için, spread operatörünü (*) kullanın. Spread
 * operatörü, dizinin her bir öğesini seçtiğiniz fonksiyona
 * ayrı argümanlar olarak geçirir:
 */

//fun main() {
//    val lettersArray = arrayOf("c", "d")
//    printAllStrings("a", "b", *lettersArray)
//    // abcd
//}
//
//fun printAllStrings(vararg strings: String) {
//    for (string in strings) {
//        println(string)
//    }
//}

/**
 * Dizileri Karşılaştır
 *
 * İki dizinin aynı elemanlara aynı sırada sahip olup olmadığını
 * karşılaştırmak için .contentEquals() ve .contentDeepEquals()
 * fonksiyonlarını kullanın:
 */

//fun main() {
//    val simpleArray = arrayOf(1, 2, 3)
//    val anotherArray = arrayOf(1, 2, 3)
//
//    // Dizilerin içeriklerini karşılaştırır
//    println(simpleArray.contentEquals(anotherArray))
//    // true
//
//    // infix gösterimini kullanarak, bir öğe değiştirildikten
//    // sonra dizilerin içeriklerini karşılaştırır
//    simpleArray[0] = 10
//    println(simpleArray contentEquals anotherArray)
//    // false
//}

/**
 * UYARI: Dizilerin içeriklerini karşılaştırmak için eşitlik (==)
 * ve eşitsizlik (!=) operatörülerini kullanmayın. Bu operatörler,
 * atanan değişkenlerin aynı nesneye işaret edip etmediğini kontrol
 * eder.
 */

/**
 * Dizileri Dönüştür
 *
 * Kotlin dizileri dönüştürmek için birçok yararlı fonksiyona sahiptir.
 */

/**
 * Sum
 *
 * Bir dizideki tüm elemanların toplamını döndürmek için .sum()
 * fonksiyonunu kullanın:
 */

//fun main() {
//    val sumArray = arrayOf(1, 2, 3)
//
//    // Dizi öğelerini toplar
//    println(sumArray.sum())
//    // 6
//
//    // .sum() fonksiyonu yalnızca Int gibi sayısal veri türlerinden
//    // oluşan dizilerle kullanılabilir.
//}

/**
 * Shuffle
 *
 * Bir dizideki elemanları rastgele karıştırmak için .shuffle()
 * fonksiyonunu kullanın:
 */

//fun main() {
//    val simpleArray = arrayOf(1, 2, 3)
//
//    // Öğeleri karıştırır [3, 2, 1]
//    simpleArray.shuffle()
//    println(simpleArray.joinToString())
//
//    // Öğeleri tekrar karıştırır [2, 3, 1]
//    simpleArray.shuffle()
//    println(simpleArray.joinToString())
//}

/**
 * Dizileri Koleksiyonlara Dönüştürün
 *
 * Eğer bazılarının dizileir, bazılarının da koleksiyonları
 * kullandığı farklı API'lerle çalışıyorsanız, dizilerinizi
 * koleksiyonlara dönüştürebilir ve tam tersini yapabilirsiniz.
 */

/**
 * List veya Set'e Dönüştürün
 *
 * Bir diziyi List veya Set'e dönüştürmek için .toList() ve
 * .toSet() fonksiyonlarını kullanın.
 */

//fun main() {
//    val simpleArray = arrayOf("a", "b", "c", "c")
//
//    // Set'e dönüştürür
//    println(simpleArray.toSet())
//    // [a, b, c]
//
//    // List'e dönüştürür
//    println(simpleArray.toList())
//    // [a, b, c, c]
//}

/**
 * Map' Dönüştürün
 *
 * Bir diziyi Map'e dönüştürmek için .toMap() fonksiyonunu
 * kullanın.
 *
 * Yalnızca Pair<K,V> dizisi bir Map'e dönüştürülebilir.
 * Bir Pair örneğinin ilk değeri bir anahtar olur ve ikincisi
 * bir değer olur. Bu örnek, Pair'in tuple'larını oluşturmak
 * için to işlevini çağırmak için infix gösterimini kullanır:
 */

//fun main() {
//    val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
//
//    // Map'e dönüştürür
//    // Anahtarlar meyvelerdir ve değerleri ise kalori sayılarıdır
//    // Anahtarların benzersiz olması gerektiğine dikkat edin, bu
//    // nedenle "apple"ın son değeri ilkini geçersiz kılar
//    println(pairArray.toMap())
//    // {apple=140, banana=150, cherry=90}
//}

/**
 * Primitive-type Arrays
 *
 * Array sınıfını primitive değerlerle kullanırsanız, bu
 * değerler nesnelerle boxed yapılır. Alternatif olarak,
 * boxed ek yükünün yan etkisi olmadan primitive'leri bir
 * dizide depolamanıza izin veren primitive tür dizileri
 * kullanabilirsiniz:
 *
 * BooleanArray -> boolean[]
 * ByteArray -> byte[]
 * CharArray -> char[]
 * DoubleArray -> double[]
 * FloatArray -> float[]
 * IntArray -> int[]
 * LongArray -> long[]
 * ShortArray -> short[]
 *
 * Bu sınıfların Array sınıfıyla kalıtım ilişkisi yoktur,
 * ancak aynı fonksiyon ve özellik kümesine sahiptirler.
 *
 * Bu örnek, IntArray sınıfının bir örneğini oluşturur:
 */

//fun main() {
//    // Değerleri sıfır, 5 boyutlu bir Int dizisi oluşturur
//    val exampleArray = IntArray(5)
//    println(exampleArray.joinToString())
//    // 0, 0, 0, 0, 0
//}

/**
 * Primitive türdeki dizileri nesne türü dizilere dönüştürmek
 * için .toTypedArray() fonksiyonunu kullanın.
 *
 * Nesne türü dizileri primitive türdeki dizilere dönüştürmek
 * için .toBooleanArray(), .toByteArray(), .toCharArray() vb.
 * kullanın.
 */