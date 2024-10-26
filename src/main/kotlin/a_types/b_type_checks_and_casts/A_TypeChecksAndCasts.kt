package a_types.b_type_checks_and_casts

/**
 * Type Checks and Casts
 *
 * Kotlin'de çalışma zamanında bir nesnenin türünü kontrol
 * etmek için tür denetimleri gerçekleştirebilirsiniz. Tür
 * dönüştürmeleri, nesneleri farklı bir türe dönüştürmenizi
 * sağlar.
 */

/**
 * is and !is Operatörleri
 *
 * Bir nesnenin belirli bir türe uyup uymadığını belirleyen
 * bir çalışma zamanı denetimi gerçekleştirmek için is
 * operatörünü veya onun olumsuzlanmış biçimi !is'i
 * kullanın:
 */

//fun main() {
//    val obj: Any? = null
//
//    if (obj is String) {
//        println(obj.length)
//    }
//
//    if (obj !is String) { // Same as !(obj is String)
//        println("Not a String")
//    } else {
//        println(obj.length)
//    }
//}

/**
 * Smart Casts
 *
 * Çoğu durumda, derleyici sizin için nesneleri otomatik olarak
 * dönüştürdüğü için açık dönüştürme operatörlerini kullanmanıza
 * gerek yoktur. Buna akıllı dönüştürme denir. Derleyici, değişmez
 * değerler için tür kontrollerini ve açık dönüştürmeleri izler
 * ve gerektiğinde örtük (güvenli) dönüştürmeleri otomatik olarak
 * ekler:
 */

//fun demo(x: Any) {
//    if (x is String) {
//        println(x.length) // x otomatik olarak String'e dönüştürülür
//    }
//}

/**
 * Derleyici, olumsuz bir kontrolün bir return'e yol açması
 * durumunda ir dönüşümün güvenli olduğunu bilecek kadar
 * akıllıdır:
 */

//fun demo(x: Any) {
//    if (x !is String) return
//
//    println(x.length) // x otomatik olarak String'e dönüştürülür
//}

/**
 * Control Flow
 *
 * Akıllı dönüşümler yalnızca if koşullu ifadeler için değil, aynı
 * zamanda when ifadeleri ve while döngüleri için de işe yarar:
 */

//fun demo(x: Any) {
//    when (x) {
//        is Int -> println(x + 1)
//        is String -> println(x.length + 1)
//        is IntArray -> println(x.sum())
//    }
//}

/**
 * Eğer if, when veya while koşulunda kullanmadan önce Boolean
 * türünde bir değişken bildirirseniz, derleyici tarafından
 * değişken hakkında toplanan tüm bilgiler akıllı dönüştürme
 * için ilgili blokta erişilebilir olacaktır.
 *
 * Bu, değişkenlere boolean koşullarını çıkarmak gibi şeyler
 * yapmak istediğinizde yararlı olabilir. Daha sonra, değişkene
 * anlamlı bir ad verebilirsiniz, bu kodunuzun okunabilirliğini
 * artıracak ve değişkeni daha sonra kodunuzda yeniden kullanmanızı
 * mümkün kılacaktır. Örneğin:
 */

//class Cat {
//    fun purr() {
//        println("Purr purr")
//    }
//}
//
//fun petAnimal(animal: Any) {
//    val isCat = animal is Cat
//    if (isCat) {
//        // Derleyici, isCat hakkında bilgilere erişebilir,
//        // böylece animal'ın akıllıca Cat türüne dönüştürüldüğünü
//        // bilir. Bu nedenle purr() fonksiyonu çağrılabilir.
//        animal.purr()
//    }
//}
//
//fun main() {
//    val kitty = Cat()
//    petAnimal(kitty)
//    // Purr purr
//}

/**
 * Logical Operators
 *
 * Derleyici, && veya || operatörlerinin sol tarafında bir
 * tip kontrolü (normal veya negatif) varsa, sağ tarafta
 * akıllı dönüşümler gerçekleştirebilir:
 */

//fun demo(x: Any) {
//    // x otomatik olarak sağ tarafta String'e dönüştürülür
//    if (x !is String || x.length == 0) return
//
//    // x otomatik olarak sağ tarafta String'e dönüştürülür
//    if (x is String && x.length > 0) {
//        println(x.length) // x otomatik olarak String'e dönüştürülür
//    }
//}

/**
 * Nesneler için tip kontrollerini bir veya operatörü (||)
 * ile birleştirirseniz, en yakın ortak üst tiplerine akıllı
 * bir dönüştürme yapılır:
 */

//interface Status {
//    fun signal() {}
//}
//
//interface Ok : Status
//interface Postponed : Status
//interface Declined : Status
//
//fun signalCheck(signalStatus: Any) {
//    if (signalStatus is Postponed || signalStatus is Declined) {
//        // signalStatus, ortak bir üst tip olan Status'a dönüştürülür
//        signalStatus.signal()
//    }
//}

/**
 * "Unsafe" Cast Operator
 *
 * bir nesneyi açıkça null olmayan bir türe dönüştürmek için
 * güvenli olmayan dönüştürme operatörünü şu şekilde kullanın:
 */

//fun demo(y: Any) {
//    val x: String = y as String
//}

/**
 * Eğer dönüşüm mümkün değilse, derleyici bir istisna fırlatır.
 * Bu yüzden buna unsafe denir.
 *
 * Önceki örnekte, y null ise, yukarıdaki kod da bir istisna atar.
 * Bunun nedeni, null'ın String'e dönüştürülememesidir, çünkü
 * String nullable değildir. Örneği olası null değerleri için
 * çalıştırmak için, dönüştürmenin sağ tarafında nullable bir
 * tür kullanın:
 */

//fun demo(y: Any?) {
//    val x: String? = y as String?
//}

/**
 * "Safe" (nullable) Cast Operator
 *
 * İstisnalardan kaçınmak için, başarısızlık durumunda null
 * döndüren güvenli dönüştürme operatörünü (?) olarak kullanın.
 */

//fun demo(y: Any?) {
//    val x: String? = y as? String
//}

/**
 * NOT: as? ifadesinin sağ tarafınnın null yapıda olmayan
 * bir String türü olmasına rağmen, dönüşüm sonucunun null
 * olabileceğine dikkat edin.
 */