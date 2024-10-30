package h_classes_and_objects

/**
 * Extensions
 *
 * Kotlin, bir sınıfı veya arayüzü, sınıftan
 * miras almak veya Decorator gibi tasarım
 * kalıplarını kullanmak zorunda kalmadan
 * yeni işlevsellikle genişletme olanağı
 * sağlar. Bu, uzantılar adı verilen özel
 * bildirimler aracılığıyla yapılır.
 *
 * Örneğin, değiştiremeyeceğiniz üçüncü taraf
 * bir kütüphaneden bir sınıf veya arayüz için
 * yeni işlevler yazabilirsiniz. Bu tür işlevler,
 * orijinal sınıfın yöntemleriymiş gibi her
 * zamanki şekilde çağrılabilir. Bu mekanizmaya
 * uzantı işlevi denir. Ayrıca, mevcut sınıflar
 * için yeni özellikler tanımlamanıza izin
 * veren uzantı özellikleri de vardır.
 */

/**
 * Extension Functions
 *
 * Bir uzantı işlevi bildirmek için, adının
 * önüne, genişletilen türe atıfta bulunan
 * bir alıcı türü ekleyin. Aşağıdaki,
 * MutableList<Int>'e bir takas işlevi ekler:
 */

//fun MutableList<Int>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // 'this' listeye karşılık gelir
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

/**
 * Bir uzantı fonksiyonu içindeki this anahtar
 * sözcüğü, alıcı nesneye (noktadan önce
 * geçirilen nesneye) karşılık gelir. Şimdi,
 * böyle bir fonksiyonu herhangi bir
 * MutableList<Int> üzerinde çağırabilirsiniz:
 */

//fun MutableList<Int>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // 'this' listeye karşılık gelir
//    this[index1] = this[index2]
//    this[index2] = tmp
//}
//
//fun main() {
//    val list = mutableListOf(1, 2, 3)
//    list.swap(0, 2) // 'swap()' içindeki 'this' 'list' değerini tutacak
//}

/**
 * Bu fonksiyon herhangi bir MutableList<T>
 * anlamlıdır ve bunu genel hale getirebilirsiniz:
 */

//fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // 'this' listeye karşılık gelir
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

/**
 * Alıcı tür ifadesinde kullanılabilir hale getirmek
 * için, işlev adından önce genel tür parametresini
 * bildirmeniz gerekir.
 */

/**
 * Extensions Are Resolved Statically
 *
 * Uzantılar aslında genişlettikleri sınıfları
 * değiştirmezler. Bir uzantı tanımlayarak, bir
 * sınıfa yeni üyeler eklemiyorsunuz, yalnızca
 * bu türdeki değişkenlerde nokta gösterimiyle
 * çağrılabilir yeni işlevler yapıyorsunuz.
 *
 * Uzantı işlevleri statik olarak dağıtılır.
 * Bu nedenle, hangi uzantı işlevinin
 * çağrılacağı, alıcı türüne bağlı olarak
 * derleme zamanında zaten bilinir. Örneğin:
 */

//open class Shape
//class Rectangle : Shape()
//
//fun Shape.getName() = "Shape"
//fun Rectangle.getName() = "Rectangle"
//
//fun printClassName(s: Shape) {
//    println(s.getName())
//}
//
//fun main() {
//    printClassName(Rectangle())
//}

/**
 * Bu örnek, çağrılan uzantı işlevi yalnızca
 * s parametresinin beyan edilen türüne, yani
 * Shape sınıfına bağlı olduğundan, Shape'i
 * yazdırır.
 *
 * Bir sınıfın bir üye işlevi varsa ve aynı
 * alıcı türüne, aynı ada sahip ve verilen
 * argümanlara uygulanabilir bir uzantı işlevi
 * tanımlanırsa, üye her zaman kazanır. Örneğin:
 */

//class Example {
//    fun printFunctionType() {
//        println("Class method")
//    }
//}
//
//fun Example.printFunctionType() {
//    println("Extensions function")
//}
//
//fun main() {
//    Example().printFunctionType()
//}

/**
 * Bu kod Class method yazdırır.
 *
 * Ancak, uzantı fonksiyonlarının aynı ada
 * sahip ancak farklı imzaya sahip üye
 * fonksiyonları aşırı yüklemesi tamamen
 * uygundur:
 */

//class Example {
//    fun printFunctionType() {
//        println("Class method")
//    }
//}
//
//fun Example.printFunctionType(i: Int) {
//    println("Extensions function #$i")
//}
//
//fun main() {
//    Example().printFunctionType(1)
//}

/**
 * Nullable Receiver
 *
 * Uzantıların null olabilen bir alıcı
 * türüyle tanımlanabileceğini unutmayın.
 * Bu uzantılar, değeri null olsa bile bir
 * nesne değişkeni üzerinde çağrılabilir.
 * Alıcı null ise, bu da null olur. Bu
 * nedenle, null olabilen bir alıcı türüyle
 * bir uzantı tanımlarken, derleyici
 * hatalarından kaçınmak için fonksiyon
 * gövdesi içinde this == null denetimi
 * gerçekleştirmenizi öneririz.
 *
 * Kotlin'de null olup olmadığını denetlemeden
 * toString()'i çağırabilirsiniz, çünkü
 * denetim zaten uzantı işlevi içinde
 * gerçekleşir:
 */

//fun Any?.toString(): String {
//    if (this == null) return "null"
//    // Boş denetimden sonra, 'this' otomatik olarak boş olmayan bir türe dönüştürülür,
//    // bu nedenle aşağıdaki toString() herhangi bir sınıfın üye işlevine çözümlenir
//    return toString()
//}

/**
 * Extension Properties
 *
 * Kotlin, fonksiyonları desteklediği gibi
 * uzantı özelliklerini de destekler:
 */

//val <T> List<T>.lastIndex: Int
//    get() = size - 1

/**
 * UYARI: Uzantılar sınıflara üye eklemediğinden,
 * bir uzantı özelliğinin bir destek alanına
 * sahip olması için verimli bir yol yoktur.
 * Bu nedenle, başlatıcılara uzantı özellikleri
 * için izin verilmez. Davranışları yalnızca
 * getter'lar/setter'lar açıkça sağlanarak
 * tanımlanabilir.
 */

/**
 * Örnek:
 */

//val House.number = 1 // error: uzantı özellikleri için başlatıcılara izin verilmez

/**
 * Companion Object Extensions
 *
 * Bir sınıfın tanımlanmış bir eşlik eden nesnesi
 * varsa, eşlik eden nesne için uzantı işlevleri
 * ve özellikler de tanımlayabilirsiniz. Eşlik
 * eden nesnenin normal üyeleri gibi, bunlar
 * yalnızca niteleyici olarak sınıf adı
 * kullanılarak çağrılabilir:
 */

//class MyClass {
//    companion object {} // will be called "Companion"
//}
//
//fun MyClass.Companion.printCompanion() {
//    println("companion")
//}
//
//fun main() {
//    MyClass.printCompanion()
//}

/**
 * Scope of Extensions
 *
 * Çoğu durumda, uzantıları en üst düzeyde,
 * doğrudan paketlerin altında tanımlarsınız:
 */

//package org.example.declarations
//
//fun List<String>.getLongestString() { /*...*/ }

/**
 * Bir uzantıyı bildirim paketinin dışında
 * kullanmak için onu çağrı sitesine içe
 * aktarın:
 */

//package org.example.usage
//import org.example.declarations.getLongestString
//
//fun main() {
//    val list = listOf("red", "green", "blue")
//    list.getLongestString()
//}

/**
 * Declaring Extensions as Members
 *
 * Bir sınıfın içinde başka bir sınıf için
 * uzantılar bildirebilirsiniz. Böyle bir
 * uzantının içinde birden fazla örtük
 * alıcı vardır - üyelerine bir niteleyici
 * olmadna erişilebilen nesneler. Uzantının
 * bildirildiği bir sınıfın örneğine bir
 * gönderme alıcısı denir ve uzantı
 * yönteminin alıcı türünün bir örneğine
 * bir uzantı alıcısı denir.
 */

//class Host(val hostname: String) {
//    fun printHostname() {
//        println(hostname)
//    }
//}
//
//class Connection(val host: Host, val port: Int) {
//    fun printPort() {
//        println(port)
//    }
//
//    fun Host.printConnectionString() {
//        printHostname() // calls Host.printHostname()
//        println(":")
//        printPort() // calls Connection.printPort()
//    }
//
//    fun connect() {
//        /*...*/
//        host.printConnectionString() // calls the extension function
//    }
//}
//
//fun main() {
//    Connection(Host("kotl.in"), 443).connect()
//    Host("kotl.in").printConnectionString()
//    // error, uzantı işlevi Connection dışında kullanılamaz
//}

/**
 * Bir dağıtım alıcısı ile bir uzantı alıcısı
 * üyeleri arasında bir isim çakışması olması
 * durumunda, uzantı alıcısı öncelik kazanır.
 * Dağıtım alıcısının üyesine atıfta bulunmak
 * için nitelikli this sözdizimini
 * kullanabilirsiniz.
 */

//class Host
//
//class Connection {
//    fun Host.getConnectionString() {
//        toString() // calls Host.toString()
//        this@Connection.toString() // calls Connection.toString()
//    }
//}

/**
 * Üye olarak bildirilen uzantılar alt sınıflarda
 * açık ve geçersiz kılınmış olarak bildirilebilir.
 * Bu, bu tür işlevlerin dağıtımının dağıtım
 * alıcısı türüne göre sanal, ancak uzantı alıcısı
 * türüne göre statik olduğu anlamına gelir.
 */

//open class Base
//
//class Derived : Base()
//
//open class BaseCaller {
//    open fun Base.printFunctionInfo() {
//        println("Base extension function in BaseCaller")
//    }
//
//    open fun Derived.printFunctionInfo() {
//        println("Derived extension function in BaseCaller")
//    }
//
//    fun call(b: Base) {
//        b.printFunctionInfo() // call the extension function
//    }
//}
//
//class DerivedCaller : BaseCaller() {
//    override fun Base.printFunctionInfo() {
//        println("Base extension function in DerivedCaller")
//    }
//
//    override fun Derived.printFunctionInfo() {
//        println("Derived extension function in DerivedCaller")
//    }
//}
//
//fun main() {
//    BaseCaller().call(Base())
//    // "Base extension function in BaseCaller"
//    DerivedCaller().call(Base())
//    // "Base extension function in DerivedCaller"
//    // - dispatch receiver is resolved virtually
//    DerivedCaller().call(Derived())
//    // "Base extension function in DerivedCaller"
//    // - extension receiver is resolved statically
//}

/**
 * Note on Visibility
 *
 * Uzantılar, aynı kapsamda bildirilen normal
 * işlevlerle aynı görünürlük değiştiricilerini
 * kullanır. Örneğin:
 *
 * - Bir dosyanın en üst düzeyinde bildirilen bir
 * uzantı, aynı dosyadaki diğer özel en üst düzey
 * bildirimlere erişebilir.
 *
 * - Bir uzantı, alıcı türünün dışında bildirilirse,
 * alıcının özel veya korumalı üyelerine erişemez.
 */