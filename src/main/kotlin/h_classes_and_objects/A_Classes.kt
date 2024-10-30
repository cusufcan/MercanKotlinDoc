package h_classes_and_objects

/**
 * Classes
 *
 * Kotlin'de sınıflar class anahtar sözcüğü
 * kullanılarak tanımlanır:
 */

//class Person { /*...*/ }

/**
 * Sınıf bildirimi, sınıf adından, sınıf
 * başlığından (tür parametrelerini, birincil
 * oluşturucuyu ve diğer bazı şeyleri
 * belirterek) ve süslü parantezlerle çevrili
 * sınıf gövdesinden oluşur. Hem başlık hem
 * de gövde isteğe bağlıdır; sınıfın gövdesi
 * yoksa süslü parantezler atlanabilir.
 */

//class Empty

/**
 * Constructors
 *
 * Kotlin'de bir sınıfın birincil bir kurucusu
 * ve muhtemelen bir veya daha fazla ikincil
 * kurucusu vardır. Birincil kurucu sınıf
 * başlığında bildirilir ve sınıf adından
 * ve isteğe bağlı tür parametrelerinden
 * sonra gelir.
 */

//class  Person constructor(firstName: String) { /*...*/ }

/**
 * Birincil oluşturucunun herhangi bir ek
 * açıklaması veya görünürlük değiştiricisi
 * yoksa, oluşturucu anahtar sözcüğü
 * atlanabilir:
 */

//class Person(firstName: String) { /*...*/ }

/**
 * Birincil oluşturucu, sınıf başlığında bir
 * sınıf örneğini ve özelliklerini başlatır.
 * Sınıf başlığı herhangi bir çalıştırılabilir
 * kod içeremez. Nesne oluşturma sırasında biraz
 * kod çalıştırmak istiiyorsanız, sınıf gövdesinin
 * içindeki başlatıcı blokları kullanın. Başlatıcı
 * blokları, init anahtar sözcüğü ve ardından
 * gelen süslü parantezlerle bildirilir. Çalıştırmak
 * istediğiniz herhangi bir kodu süslü parantezlerin
 * içine yazın.
 *
 * Bir örneğin başlatılması sırasında, başlatıcı
 * blokları, sınıf gövdesinde göründükleri sırayla,
 * özellik başlatıcılarıyla iç içe geçirilerek
 * yürütülür:
 */

//class InitOrderDemo(name: String) {
//    val firstProperty = "First property: $name".also(::println)
//
//    init {
//        println("First initializer block that prints $name")
//    }
//
//    val secondProperty = "Second property: ${name.length}".also(::println)
//
//    init {
//        println("Second initializer block that prints ${name.length}")
//    }
//}

/**
 * Birincil oluşturucu parametreleri başlatıcı
 * bloklarında kullanılabilir. Ayrıca sınıf
 * gövesinde bildirilen özellik başlatıcılarında
 * da kullanılabilirler:
 */

//class Customer(name: String) {
//    val customerKey = name.uppercase()
//}

/**
 * Kotlin, özellikleri bildirmek ve bunları birincil
 * oluşturucudan başlatmak için özlü bir sözdizimine
 * sahiptir:
 */

//class Person(val firstName: String, val lastName: String, var age: Int)

/**
 * Bu tür bildirimler sınıf özelliklerinin varsayılan
 * değerlerini de içerebilir:
 */

//class Person(
//    val firstName: String, val lastName: String, var isEmployed: Boolean = true
//)

/**
 * Sınıf özelliklerini bildirirken son virgül
 * kullanabilirsiniz:
 */

//class Person(
//    val firstName: String,
//    val lastName: String,
//    var age: Int, // trailing comma
//) { /*...*/ }

/**
 * Tıpkı normal özellikler gibi, birincil oluşturucuda
 * bildirilen özellikler değiştirilebilir (var) veya
 * salt okunur (val) olabilir.
 *
 * Oluşturucunun açıklamaları veya görünürlük
 * değiştiricileri varsa, oluşturucu anahtar sözcüğü
 * gereklidir ve değiştiriciler ondan önce gelir:
 */

//class Customer public @Inject constructor(name: String) { /*...*/ }

/**
 * Secondary Constructors
 *
 * Bir sınıf ayrıca constructor ön ekine sahip
 * ikincil kurucuları da bildirebilir:
 */

//class Person(val pets: MutableList<Pet> = mutableListOf())
//
//class Pet {
//    constructor(owner: Person) {
//        owner.pets.add(this) // bu evcil hayvanı sahibinin evcil hayvanlarına ekler
//    }
//}

/**
 * Sınıfnı birincil bir kurucusu varsa, her
 * ikincil kurucunun birincil kurucuya doğrudan
 * veya dolaylı olarak başka ikincil kurucular
 * aracılığıyla yetki devretmesi gerekir. Aynı
 * sınıfın başka bir kurucusuna yetki devretme
 * işlemi this anahtar sözcüğü kullanılarak
 * yapılır:
 */

//class Person(val name: String) {
//    val children: MutableList<Person> = mutableListOf()
//
//    constructor(name: String, parent: Person) : this(name) {
//        parent.children.add(this)
//    }
//}

/**
 * Başlatıcı bloklarındaki kod, birincil
 * oluşturucunun etkili bir parçası haline
 * gelir. Birincil oluşturucuya delete etme,
 * ikincil bir oluşturucunun ilk ifadesine
 * erişim anında gerçekleşir, bu nednele
 * tüm başlatıcı bloklarındaki ve özellik
 * başlatıcılarındaki kod, ikincil
 * oluşturucunun gövdesinden önce yürütülür.
 *
 * Sınıfın birincil oluşturucusu olmasa bile,
 * delege etme yine de örtük olarak gerçekleşir
 * ve başlatıcı blokları yine de yürütülür:
 */

//class Constructors {
//    init {
//        println("Init block")
//    }
//
//    constructor(i: Int) {
//        println("Constructor $i")
//    }
//}

/**
 * Soyut olmayan bir sınıf herhangi bir
 * oluşturucu (birincil veya ikincil)
 * bildirmezse, argümanı olmayan bir
 * birincil oluşturucusu olacaktır.
 * Oluşturucunun görünürlüğü herkese
 * açık olacaktır.
 *
 * Sınıfınızın herkese açık bir
 * oluşturucusu olmasını istemiyorsanız,
 * varsayılan olmayan görünürlüğe sahip
 * boş bir birincil oluşturucu bildirin:
 */

//class DontCreateMe private constructor() { /*...*/ }

/**
 * UYARI: JVM'de, tüm birincil oluşturucu
 * parametrelerinin varsayılan değerleri
 * varsa, derleyici varsayılan değerleri
 * kullanacak ek bir parametresiz
 * oluşturucu üretecektir. Bu, Kotlin'i
 * Jackson veya JPA gibi parametresiz
 * oluşturucular aracılığıyla sınıf
 * örnekleri oluşturan kütüphanelerle
 * kullanmayı kolaylaştırır.
 */

//class Customer(val customerName: String = "")

/**
 * Creating Instances Of Classes
 *
 * Bir sınıfın örneğini oluşturmak için,
 * oluşturucuyu normal bir fonksiyonmuş
 * gibi çağırın. Oluşturulan örneği bir
 * değişkene atayabilirsiniz:
 */

//class Invoice()
//class Customer(val name: String)
//
//fun main() {
//    val invoice = Invoice()
//    val customer = Customer("Yusuf Can")
//}

/**
 * UYARI: Kotlin'de new anahtar kelimesi
 * yoktur.
 */

/**
 * Class Members
 *
 * Sınıflar şunları içerebilir:
 *
 * - Yapıcılar ve başlatıcı bloklar
 * - Fonksiyonlar
 * - Property'ler
 * - Nested ve inner sınıflar
 * - Object declaration'lar
 */

/**
 * Inheritance
 *
 * Sınıflar birbirlerinden türetilebilir ve
 * miras hiyerarşileri oluşturabilir.
 */

/**
 * Abstract Classes
 *
 * Bir sınıf, bazı veya tüm üyeleriyle birlikte
 * soyut olarak bildirilebilir. Soyut bir
 * üyenin sınıfında bir uygulaması yoktur.
 * Soyut sınıfları veya işlevleri open ile
 * açıklamanız gerekmez.
 */

//abstract class Polygon {
//    abstract fun draw()
//}
//
//class Rectangle : Polygon() {
//    override fun draw() {
//        // draw the rectangle
//    }
//}

/**
 * Soyut olmayan bir open üyeyi soyut bir
 * üyeyle geçersiz kılabilirsiniz.
 */

//open class Polygon {
//    open fun draw() {
//        // some default polygon drawing method
//    }
//}
//
//abstract class WildShape : Polygon() {
//    // WildShape'i miras alan sınıfların, Polygon'daki varsayılanı
//    // kullanmak yerine kendi çizim yöntemlerini sağlamaları gerekir
//    abstract override fun draw()
//}

/**
 * Companion Objects
 *
 * Bir sınıf örneğine sahip olmadan çağrılabilen
 * ancak bir sınıfın iç yapısına erişim gerektiren
 * (örneğin bir factory method) bir fonksiyon
 * yazmanız gerekiyorsa, bunu o sınıfın içindeki
 * bir nesne bildiriminin bir üyesi olarak
 * yazabilirsiniz.
 *
 * Daha da spesifik olarak, sınıfınızın içinde
 * bir eşlik eden nesne bildirirseniz, üyelerine
 * yalnızca sınıf adını niteleyici olarak
 * kullanarak erişebilirsiniz.
 */