package h_classes_and_objects

/**
 * Enum Classes
 *
 * Enum sınıfları için en temel kullanım örneği,
 * tür güvenli enumların uygulanmasıdır:
 */

//enum class Direction {
//    NORTH, SOUTH, WEST, EAST
//}

/**
 * Her enum sabiti bir nesnedir. Enum sabitleri
 * virgülle ayrılır.
 *
 * Her enum, enum sınıfının bir örneği olduğundan,
 * şu şekilde başlatılabilir:
 */

//enum class Color(val rgb: Int) {
//    RED(0xFF0000),
//    GREEN(0x00FF00),
//    BLUE(0x0000FF)
//}

/**
 * Anonymous Classes
 *
 * Enum sabitleri, kendi anonim sınıflarını,
 * ilgili metotlarıyla birlikte, ayrıca temel
 * metotları geçersiz kılarak bildirebilirler.
 */

//enum class ProtocolState {
//    WAITING {
//        override fun signal() = TALKING
//    },
//
//    TALKING {
//        override fun signal() = WAITING
//    };
//
//    abstract fun signal(): ProtocolState
//}

/**
 * Eğer enum sınıf herhangi bir üye tanımlıyorsa,
 * sabit tanımlarını üye tanımlarından noktalı
 * virgülle ayırın.
 */

/**
 * Implementing Interfaces In Enum Classes
 *
 * Bir enum sınıfı bir arayüzü uygulayabilir
 * (ancak bir sınıftan türetilemez), tüm girdiler
 * için arayüz üyelerinin ortak bir uygulamasını
 * veya anonim sınıfındaki her girdi için ayrı
 * uygulamaları sağlayabilir. Bu, uygulamak
 * istediğiniz arayüzleri enum sınıf bildirimine
 * aşağıdaki şekilde ekleyerek yapılır:
 */

//enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
//    PLUS {
//        override fun apply(t: Int, u: Int): Int = t + u
//    },
//    TIMES {
//        override fun apply(t: Int, u: Int): Int = t + u
//    };
//
//    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
//}

/**
 * Tüm enum sınıfları varsayılan olarak Comparable
 * arayüzünü uygular. Enum sınıfındaki sabitler
 * doğal sırayla tanımlanır.
 */

/**
 * Working With Enum Constants
 *
 * Kotlin'deki enum sınıfları, tanımlanmış enum
 * sabitlerini listelemek ve bir enum sabitini
 * adına göre almak için sentetik özelliklere
 * ve yöntemlere sahiptir. Bu yöntemlerin imzaları
 * aşağıdaki gibidir (enum sınıfının adının
 * EnumClass olduğu varsayılarak):
 */

//EnumClass.valueOf(value: String): EnumClass
//EnumClass.entries: EnumEntries<EnumClass> // specialized List<EnumClass>

/**
 * Aşağıda bunların eyleme halinde bir örneği
 * yer almaktadır:
 */

//enum class RGB { RED, GREEN, BLUE }
//
//fun main() {
//    for (color in RGB.entries) println(color.toString()) // RED, GREEN, BLUE
//    println("The first color is: ${RGB.valueOf("RED")}") // The first color is: RED
//}

/**
 * valueOf() yöntemi, belirtilen ad sınıfta
 * tanımlanan enum sabitlerinden hiçbiriyle
 * eşleşmezse bir IllegalArgumentException
 * fırlatır.
 *
 * Kotlin 1.9.0'da girdilerin tanıtılmasından
 * önce, values() işlevi bir enum sabitleri
 * dizisini almak için kullanılıyordu.
 *
 * Her enum sabitinin ayrıca şu özellikleri
 * vardır: name ve ordinal enum sınıf bildiriminde
 * adını ve konumunu (0'dan başlayarak) elde
 * etmek için:
 */

//println(RGB.RED.name) // prints RED
//println(RGB.RED.ordinal) // prints 0

/**
 * Erişim sınıfındaki sabitlere enumValues<T>()
 * ve enumValueOf<T>() işlevlerini kullanarak
 * genel bir şekilde erişebilirsiniz. Kotlin
 * 2.0.0'da enumEntries<T>() işlevi enumValues<T>()
 * işlevi için bir yedek olarak tanıtılmıştır.
 * enumEntries<T>() işlevi, verilen enum türü T
 * için tüm enum girişlerinin bir listesini
 * döndürür.
 *
 * enumValues<T>() işlevi hala desteklenmektedir,
 * ancak daha az performans etkisi olduğu için
 * bunun yerine enumEntries<T>() işlevini
 * kullanmanızı öneririz. enumValues<T>()
 * işlevini her çağırdığınızda yeni bir dizi
 * oluşturulurken, enumEntries<T>() işlevini
 * her çağırdığınızda aynı liste döndürülür
 * ve bu çok daha verimlidir.
 *
 * Örneğin:
 */

//enum class RGB { RED, GREEN, BLUE }
//
//inline fun <reified T : Enum<T>> printAllValues() {
//    println(enumEntries<T>().joinToString { it.name })
//}
//
//fun main() {
//    printAllValues<RGB>()
//    // RED, GREEN, BLUE
//}