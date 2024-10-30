package g_destructuring_declarations

/**
 * Destructuring Declarations
 *
 * Bazen bir nesneyi birden fazla değişkene ayırmak
 * kullanışlı olabilir, örneğin:
 */

//data class Person(val name: Int, val age: Int)
//
//fun main() {
//    val person = Person("Yusuf", 21)
//    val (name, age) = person
//}

/**
 * Bu yapı bozma bildirimi aşağıdaki koda derlenir:
 */

//data class Person(val name: String, val age: Int)
//
//fun main() {
//    val person = Person("Yusuf", 21)
//    val name = person.component1()
//    val age = person.component2()
//}

/**
 * component1() ve component2() fonksiyonları,
 * Kotlin'de yaygın olarak kullanılan sözleşmeler
 * ilkesinin bir başka örneğidir (örnek olarak +
 * ve * gibi operatörlere, for döngülerine bakın).
 * Gerekli sayıda bileşen fonksiyonu çağrılabildiği
 * sürece, bir yapı bozma bildiriminin sağ tarafında
 * her şey olabilir. Ve tabii ki, component3() ve
 * component4() vb. olabilir.
 */

/**
 * UYARI: componentN() fonksiyonlarının, yapıbozum
 * bildiriminde kullanılabilmeleri için operatör
 * anahtar sözcüğüyle işaretlenmeleri gerekir.
 */

/**
 * Yapıbozum bildirimleri for döngülerinde de
 * çalışır:
 */

//for ((a, b) in collection) { /*...*/ }

/**
 * Değişkenler a ve b, koleksiyonun elemanları
 * üzerinde çağrılan component1() ve component2()
 * tarafından döndürülen değerleri alır.
 */

/**
 * Örnek: Returnin Two Values From A Function
 *
 * Bir fonksiyondan iki şey döndürmeniz gerektiğini
 * varsayalım -örneğin, bir sonuç nesnesi ve bir tür
 * durum. Bunu Kotlin'de yapmanın kompakt bir yolu,
 * bir veri sınıfı bildirmek ve örneğini döndürmektir:
 */

//data class Result(val result: Int, val status: ParseStatus)
//fun function(...): Result {
//    // hesaplamalar
//
//    return Result(result, status)
//}
//
//// Now, to use this function:
//val (result, status) = function(...)

/**
 * Veri sınıfları componentN() fonksiyonlarını
 * otomatik olarak bildirdiğinden, yapı bozma
 * bildirimleri burada işe yarar.
 */

/**
 * UYARI: Standart sınıf Pair'i de kullanabilirsiniz
 * ve function()'ın Pair<Int, Status> döndürmesini
 * sağlayabilirsiniz, ancak verilerinizin düzgün
 * şekilde adlandırılması genellikle daha iyidir.
 */

/**
 * Örnek: Destructuring Declarations and Maps
 *
 * Bir haritada gezinmenin en güzel yolu muhtemelen
 * şudur:
 */

//for ((key, value) in map) {
//    // do something with the key and the value
//}

/**
 * Bunu çalıştırmak için şunları yapmalısınız:
 *
 * - Haritayı bir iterator() fonksiyonu sağlayarak
 * bir değerler dizisi olarak sunun.
 * - Her bir öğeyi component1() ve component2()
 * fonksiyonlarını sağlayarak bir çift olarak
 * sunun.
 *
 * Ve aslında, standart kütüphane şu uzantıları
 * sağlar:
 */

//operator fun <K, V> Map<K, V>.iterator(): Iterator<Map.Entry<K, V>> = entries.iterator()
//operator fun <K, V> Map.Entry<K, V>.component1() = key
//operator fun <K, V> Map.Entry<K, V>.component2() = value

/**
 * Bu sayede for döngülerinde (veya veri sınıfı
 * örneklerinin koleksiyonlarında veya benzerlerinde)
 * yapıbozum bildirimlerini özgürce kullanabilirsiniz.
 */

/**
 * Underscore For Unused Variables
 *
 * Yapıbozum bildiriminde bir değişkene
 * ihtiyacınız yoksa, değilkenin adı yerine
 * alt çizgi koyabilirsiniz:
 */

//val (_, status) = getResult()

/**
 * Bu şekilde atlanan bileşenler için componentN()
 * operatör fonksiyonları çağrılmaz.
 */

/**
 * Destructuring In Lambdas
 *
 * Lambda parametreleri için yapıbozum bildirimleri
 * sözdizimini kullanabilirsiniz. Bir lambda'nın
 * Pair türünde (veya Map.Entry veya uygun
 * componentN işlevlerine sahip herhangi bir tür)
 * bir parametresi varsa, parantez içine koyarak
 * bir yerine birkaç yeni parametre ekleyebilirsiniz:
 */

//fun main() {
//    val map = mapOf<String, String>()
//    map.mapValues { entry -> "${entry.value}!" }
//    map.mapValues { (key, value) -> "$value!" }
//}

/**
 * İki parametre bildirmek ile bir parametre yerine
 * yapı bozma çifti bildirmek arasındaki farkı not
 * edin:
 */

//{ a -> ... } // one parameter
//{ a, b -> ... } // two parameter
//{ (a, b) -> ... } // a destructured pair
//{ (a, b), c -> ... } // a destructured pair and another parameter

/**
 * Yapısı bozulmuş parametrenin bir bileşeni
 * kullanılmıyorsa, adını uydurmaktan kaçınmak
 * için onu alt çizgiyle değiştirebilirsiniz:
 */

//fun main() {
//    val map = mapOf<String, String>()
//    map.mapValues { (_, value) -> "$value!" }
//}

/**
 * Tüm destructured parametre için veya belirli
 * bir bileşen için ayrı ayrı türü belirtebilirsiniz:
 */

//fun main() {
//    val map = mapOf<Int, String>()
//    map.mapValues { (_, value): Map.Entry<Int, String> -> "$value!" }
//    map.mapValues { (_, value: String) -> "$value!" }
//}