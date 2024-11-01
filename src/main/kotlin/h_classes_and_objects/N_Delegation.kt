package h_classes_and_objects

/**
 * Delegation
 *
 * Delegation örüntüsünün uygulama kalıtımına
 * iyi bir alternatif olduğu kanıtlanmıştır
 * ve Kotlin bunu sıfır kalıp kod gerektirerek
 * doğal olarak destekler.
 *
 * Bir Derived sınıfı, tüm genel üyelerini
 * belirtilen bir nesneye devrederek bir Base
 * arayüzünü uygulayabilir.
 */

//interface Base {
//    fun print()
//}
//
//class BaseImpl(val x: Int) : Base {
//    override fun print() {
//        println(x)
//    }
//}
//
//class Derived(b: Base) : Base by b
//
//fun main() {
//    val base = BaseImpl(10)
//    Derived(base).print()
//}

/**
 * Derived için üst tip listesindeki by
 * cümlesi, b'nin Derived nesnelerinde
 * dahili olarak saklanacağını ve
 * derleyicinin b'ye ileten tüm Base
 * metotlarını üreteceğini belirtir.
 */

/**
 * Overriding a Member Of an Interface Implemented By Delegation
 *
 * Geçersiz kılmalar beklediğiniz gibi
 * çalışır: derleyici, temsilci nesnesindekiler
 * yerine geçersiz kılma uygulamalarınızı
 * kullanacaktır. Eğer Derived'a override
 * fun printMessage() { print("abc") }
 * eklemek isterseniz, program printMessage
 * çağrıldığında 10 yerine abc yazdıracaktır:
 */

//interface Base {
//    fun printMessage()
//    fun printMessageLine()
//}
//
//class BaseImpl(val x: Int) : Base {
//    override fun printMessage() {
//        println(x)
//    }
//
//    override fun printMessageLine() {
//        println(x)
//    }
//}
//
//class Derived(b: Base) : Base by b {
//    override fun printMessage() {
//        println("abc")
//    }
//}
//
//fun main() {
//    val base = BaseImpl(10)
//    Derived(base).printMessage()
//    Derived(base).printMessageLine()
//}

/**
 * Ancak, bu şekilde geçersiz kılınan
 * üyelerin, yalnızca arayüz üyelerinin
 * kendi uygulamalarına erişebilen
 * temsilci nesnesinin üyelerinden
 * çağrılmadığına dikkat edin:
 */

//interface Base {
//    val message: String
//    fun print()
//}
//
//class BaseImpl(x: Int) : Base {
//    override val message = "BaseImpl: x = $x"
//
//    override fun print() {
//        println(message)
//    }
//}
//
//class Derived(b: Base) : Base by b {
//    // Bu özelliğe b'nin `print` uygulamasından erişilemez
//    override val message = "Message of Derived"
//}
//
//fun main() {
//    val b = BaseImpl(10)
//    val derived = Derived(b)
//    derived.print()
//    println(derived.message)
//}