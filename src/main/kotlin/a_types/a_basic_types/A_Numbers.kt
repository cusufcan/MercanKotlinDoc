package a_types.a_basic_types

/**
 * Integer Types
 *
 * Kotlin, sayıları temsil eden bir dizi yerleşik tür sağlar.
 * Tam sayılar için, farklı boyutlara ve değer aralıklarına sahip dört tür vardır:
 *
 * Byte -> 8 bit -> [-128, 127]
 * Short -> 16 bit -> [-32768, 32767]
 * Int -> 32 bit -> [-2,147,483,648, 2,147,483,647]
 * Long -> 64 bit -> [-9,223,372,036,854,775,808, 9,223,372,036,854,775,807]
 */

/**
 * Type Specification
 *
 * Açık bir tür belirtimi olmadan bir değişkeni başlattığınızda,
 * derleyici otomatik olarak Int'den başlayarak temsil etmek için
 * yeterli en küçük aralığa sahip türü çıkarır.
 * Int aralığını aşmıyorsa, tür Int'tir. Aşarsa, tür Long'dur.
 *
 * Explicit Type Specification
 *
 * Long değerini açıkça belirtmek için, değere L son ekini ekleyin.
 * Açık tür belirtimi, derleyicinin değerin belirtilen tür aralığını
 * aşmadığını kontrol etmesini tetikler.
 */

//fun main() {
//    val one = 1 // Int
//    val threeBillion = 3000000000 // Long
//    val oneLong = 1L // Long
//    val oneByte: Byte = 1 // Byte
//}

/**
 * Floating-point Types
 *
 * Gerçek sayılar için Kotlin, IEEE 754 standardına uyan Float ve
 * Double kayan nokta türleri sağlar. Float, IEEE 754 tek hassasiyeti
 * yansıtırken, Double çift hassasiyeti yansıtır.
 *
 * Bu türler boyutlarına göre farklılık gösterir ve farklı hasssiyetteki
 * kayan nokta sayıları için depolama sağlar:
 *
 * Float -> 32 bit -> 6-7 basamak
 * Double -> 64 bit -> 15-16 basamak
 *
 * Double ve Float değişkenlerini kesirli bir kısmı olan sayılarla
 * başlatabilirsiniz. Tamsayı kısmından bir nokta (.) ile ayrılır.
 * Kesirli sayılarla başlatılan değişkenler için derleyici Double
 * türünü çıkarır:
 */

//fun main() {
//    val pi = 3.14 // Double
//    val one: Double = 1 // Error: type mismatch
//    val oneDouble = 1.0 // Double
//}

/**
 * Bir değer için Float türünü açıkça belirtmek için f veya F son ekini
 * ekleyin. Böyle bir değer 6-7'den fazla ondalık basamak içeriyorsa yuvarlanır:
 */

//fun main() {
//    val e = 2.7182818284 // Double
////    val eFloat = 2.7182818284f // Float, actual value is 2.7182817
//}

/**
 * Diğer bazı dillerin aksine, Kotlin'de sayılar için örtük genişletme
 * (implicit conversions) dönüşümleri yoktur. Örneğin, Double parametresi
 * olan bir fonksiyon yalnızca Double değerleri üzerinde çağrılabilir,
 * ancak Float, Int veya diğer sayısal değerler üzerinde çağrılamaz:
 */

//fun main() {
//    fun printDouble(d: Double) {
//        print(d)
//    }
//
//    val i = 1
//    val d = 1.0
//    val f = 1.0f
//
//    printDouble(d)
////   printDouble(i) // Error: Type mismatch
////   printDouble(f) // Error: Type mismatch
//}

/**
 * Tam sayılar için aşağıdaki türde saabit değerler vardır:
 *
 * Decimals: 123
 * Longs: 123L
 * Hexadecimals: 0x0F
 * Binaries: 0b00001011
 *
 * Not: Kotlin'de sekizli sayı sistemleri desteklenmez.
 *
 * Sayı sabitlerini daha okunabilir hale getirmek için alt çizgileri
 * kullanabilirsiniz:
 */

//fun main() {
//    val oneMillion = 1_000_000
//    val creditCardNumber = 1234_5678_9012_3456L
//    val socialSecurityNumber = 999_99_9999L
//    val hexBytes = 0xFF_EC_DE_5E
//    val bytes = 0b11010010_01101001_10010100_10010010
//}

/**
 * Boxed vs Unboxed
 *
 * JVM platformunda sayılar ilkel (primitive) türler olarak saklanır:
 * int, double, vb.
 * İstisnalar, Int? gibi null olabilen bir sayı
 * referansı oluşturduğunuz veya generic'leri kullandığınız durumlardır.
 * Bu durumlarda sayılar Java sınıflarında kutulanır (boxed). Integer,
 * Double, vb.
 */

//fun main() {
//    val a: Int = 100
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a
//
//    val b: Int = 10000
//    val boxedB: Int? = b
//    val anotherBoxedB: Int? = b
//
//    println(boxedA === anotherBoxedA) // true
//    println(boxedB === anotherBoxedB) // false
//}

/**
 * a'ya ait tüm nullable referanslar aslında aynı nesnedir çünkü JVM,
 * -128 ile 127 arasındaki tam sayılara bellek optimizasyonu uygular.
 * Bu, b referanslarına uygulanmaz, dolayısıyla bunlar farklı nesnelerdir.
 *
 * Öte yandan, hala eşitler:
 */

//fun main() {
//    val b: Int = 10000
//    println(b == b) // Prints 'true'
//    val boxedB: Int? = b
//    val anotherBoxedB: Int? = b
//    println(boxedB == anotherBoxedB) // Prints 'true'
//}

/**
 * Explicit Number Conversions (Açık Sayı Dönüşümleri)
 *
 * Farklı temsiller nedeniyle, daha küçük tipler daha büyük olanların
 * alt tipleri değildir. Eğer öyle olsalardı, aşağıdaki türden sorunlar
 * yaşardık:
 */

//fun main() {
//    // Sözde kod, aslında derlenmez.
//    val a: Int? = 1 // A boxed Int (java.lang.Integer)
//    val b: Long? = a // Kapalı dönüşüm boxed bir Long üretir (java.lang.Long)
//    println(b == a) // Surprise! Long == Int. Prints 'false'
//}

/**
 * Sonuç olarak, daha küçük tipler örtük (implicit) olarak daha büyük
 * tiplere dönüştürülemez.
 * Bu, bir Int değişkenine Byte türünde bir değer atamanın açık (explicit)
 * bir dönüştürme gerektirdiği anlamına gelir:
 */

//fun main() {
//    val b: Byte = 1 // OK
////    val i: Int = b // ERROR
//    val i1: Int = b.toInt()
//}

/**
 * Tüm sayı türleri diğer türlere dönüşümleri destekler:
 *
 * toByte(): Byte
 * toShort(): Short
 * toInt(): Int
 * toLong(): Long
 * toFloat(): Float
 * toDouble(): Double
 *
 * Çoğu durumda, tür bağlamdan çıkarıldığı ve uygun dönüşümleri için
 * aritmetik işlemler aşırı yüklendiği için açık dönüşümlere gerek
 * yoktur, örneğin:
 */

//fun main() {
//    val l = 1L + 3 // Long + Int => Long
//}

/**
 * Sayılar Üzerinde İşlemler
 *
 * Kotlin sayılar üzerinde aritmetik işlemlerin standart kümesini
 * destekler: +, -, *, /, %. Bunlar uygun sınıfların üyeleri olarak
 * bildirilir:
 */

//fun main() {
//    println(1 + 2)
//    println(2_500_000_000L - 1L)
//    println(3.14 * 2.71)
//    println(10.0 / 3)
//}

/**
 * Tam Sayıların Bölünmesi
 *
 * Tam sayılar arasındaki bölme her zaman bir tam sayı döndürür.
 * Herhangi bir kesirli kısım atılır.
 */

//fun main() {
//    val x = 5 / 2
////    println(x == 2.5) // ERROR: Int == Double yapılamaz
//    println(x == 2)
//}

/**
 * Bu, herhangi bir iki tam sayı türü arasındaki bölme için
 * geçerlidir:
 */

//fun main() {
//    val x = 5L / 2
//    println(x == 2L)
//}

/**
 * Kesirli sayı türünü döndürmek için, argümanlardan birini
 * explicit (açıkça) kesirli sayı türüne dönüştürün:
 */

//fun main() {
//    val x = 5 / 2.toDouble()
//    println(x == 2.5)
//}