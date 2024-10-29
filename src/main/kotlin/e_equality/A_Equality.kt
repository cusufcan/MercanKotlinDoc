package e_equality

/**
 * Equality
 *
 * Kotlin'de iki tür eşitlik vardır:
 *
 * - Yapısal eşitlik (==) equals() fonksiyonu
 * için bir kontrol
 * - Referanssal eşitlik (===) aynı nesneye
 * işaret eden iki referans için bir kontrol
 */

/**
 * Structural Equality
 *
 * Yapısal eşitlik, iki nesnenin aynı içeriğe
 * veya yapıya sahip olup olmadığını doğrular.
 * Yapısal eşitlik, == işlemi ve onun
 * olumsuzlanmış karşılığı != tarafından kontrol
 * edilir. Sözleşmeye göre, a == b gibi bir ifade
 * şu şekilde çevrilir:
 */

//a?.equals(b) ?: (b === null)

/**
 * Eğer a null değilse, equals(Any?) fonksiyonunu
 * çağırır. Aksi takdirde (a null ise), b'nin
 * referans olarak null'a eşit olup olmadığını
 * kontrol eder:
 */

//fun main() {
//    var a = "hello"
//    var b = "hello"
//    var c = null
//    var d = null
//    var e = d
//
//    println(a == b)
//    // true
//    println(a == c)
//    // false
//    println(c == e)
//    // true
//}

/**
 * Kodunuzu null ile açıkça karşılaştırırken
 * optimize etmenin bir anlamı olmadığını
 * unutmayın: == null otomatik olarak ===
 * null'a çevrilir.
 *
 * Kotlin'de equals() fonksiyonu tüm sınıflar
 * tarafından Any sınıfından devralınır.
 * Varsayılan olarak, equals() fonksiyonu
 * referans eşitliğini uygular. Ancak, Kotlin'deki
 * sınıflar, özel bir eşitlik mantığı sağlamak
 * ve bu şekilde yapısal eşitliği uygulamak
 * için equals() fonksiyonunu geçersiz kılabilir.
 *
 * Değer sınıfları ve veri sınıfları equals()
 * fonksiyonunu otomatik olarak geçersiz kılan
 * iki özel Kotlin türüdür. Bu nedenle varsayılan
 * olarak yapısal eşitliği uygularlar.
 *
 * Ancak, veri sınıfları durumunda, equals()
 * fonksiyonu üst sınıfta final olarak işaretlenirse,
 * davranışı değişmeden kalır.
 *
 * Açıkça, veri olmayan sınıflar (veri değiştiricisi
 * ile bildirilmeyenler) varsayılan olarak equals()
 * fonksiyonunu geçersiz kılmaz. Bunun yerine,
 * veri olmayan sınıflar Any sınıfından devralınan
 * referans eşitlik davranışını uygular. Yapısal
 * eşitliği uygulamak için, veri olmayan sınıflar
 * equals() fonksiyonunu geçersiz kılmak için özel
 * bir eşitlik mantığı gerektirir.
 *
 * Özel bir equals kontrol uygulaması sağlamak
 * için equals(other: Any?): Boolean fonksiyonunu
 * geçersiz kılın:
 */

//class Point(val x: Int, val y: Int) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is Point) return false
//
//        // Yapısal eşitlik için özellikleri karşılaştırır
//        return this.x == other.x && this.y == other.y
//    }
//}

/**
 * UYARI: equals() fonksiyonunu geçersiz kıldığınızda,
 * eşitlik ve karma arasındaki tutarlılığı korumak
 * ve bu fonksiyonların düzgün bir şekilde davrandığından
 * emin olmak için hashCode() fonksiyonunu da geçersiz
 * kılmalısınız.
 */

/**
 * Aynı adı ve diğer imzaları (örneğin equals(other: Foo))
 * olan işlevler == ve != operatörleriyle eşitlik
 * kontrollerini etkilemez.
 *
 * Yapısal eşitliğinn Comparable<...> arayüzü tarafından
 * tanımlanan karşılaştırmayla hiçbir ilgisi yoktur,
 * bu nedenle yalnızca özel bir equals(Any?) uygulaması
 * operatörün davranışını etkileyebilir.
 */

/**
 * Referential Equality
 *
 * Referans eşitliği, aynı örnek olup olmadıklarını
 * belirlemek için iki nesnenin bellek adreslerini
 * doğrular.
 *
 * Referans eşitliği === işlemi ve onun olumsuzlanmış
 * karşılığı !== tarafından kontrol edilir. a === b,
 * yalnızca a ve b aynı nesneyi işaret ediyorsa doğru
 * olarak değerlendirilir:
 */

//fun main() {
//    var a = "Hello"
//    var b = a
//    var c = "world"
//    var d = "world"
//
//    println(a === b)
//    // true
//    println(a === c)
//    // false
//    println(c === d)
//    // true
//}

/**
 * Çalışma zamanında ilkel tiplerle temsil edilen
 * değerler için (örneğin, Int), === eşitlik denetimi
 * == denetimine eşdeğerdir.
 */

/**
 * Floating-Point Numbers Equality
 *
 * Eşitlik denetiminin işlenenlerinin statik olarak
 * Float veya Double (boş bırakılabilir veya değil)
 * olduğu biliniyorsa, denetim IEEE 754 Kesirli Sayı
 * Aritmetiği Standartını takip eder.
 *
 * Davranış, kesirli sayılar olarak statik olarak
 * yazılmamış işleneneler için farklıdır. Bu durumlarda
 * yapısal eşitlik uygulanır. Sonuç olarak, kesirli
 * sayılar olarak statik olarak yazılmamış işlenenlere
 * sahip denetimler IEEE standardından farklıdır. Bu
 * senaryoda:
 *
 * - NaN kendisine eşittir
 * - NaN diğer tüm elemanlardan (POSITIVE_INFINITIY
 * dahil) büyüktür
 * - -0.0, 0.0'a eşit değildir
 */

/**
 * Array Equality
 *
 * İki dizinin aynı elemanlara aynı sırada sahip
 * olup olmadığını karşılaştırmak için contentEquals()
 * kullanılır.
 */