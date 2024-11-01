package h_classes_and_objects

/**
 * Inline Value Classes
 *
 * Bazen daha etki alanına özgü bir tür
 * oluşturmak için bir değeri bir sınıfa
 * sarmak yararlıdır. Ancak, ek yığın
 * tahsisleri nedeniyle çalışma zamanı ek
 * yükü getirir. Dahası, sarmalanmış tür
 * ilkelse, performans düşüşü önemlidir
 * çünkü ilkel türler genellikle çalışma
 * zamanı tarafından yoğun bir şekilde
 * optimize edilirken, sarmalıyıcıları
 * herhangi bir özel işlem görmez.
 *
 * Bu tür sorunları çözmek için Kotlin,
 * satır içi sınıf adı verilen özel bir
 * sınıf türü sunar. Satır içi sınıflar,
 * değer tabanlı sınıfların bir alt
 * kümesidir. Bir kimliğe sahip değildirler
 * ve yalnızca değerleri tutabilirler.
 *
 * Satır içi bir sınıf bildirmek için,
 * adından önce value değiştiricisini
 * kullanın:
 */

//value class Password(private val s: String)

/**
 * JVM arka ucu içi bir sınıf bildirmek
 * için, sınıf bildiriminden önce @JvmInline
 * açıklamasıyla birlikte değer değiştiricisini
 * kullanın:
 */

// For JVM backends
//@JvmInline
//value class Password(private val s: String)

/**
 * Satır içi bir sınıfın birincil oluşturucuda
 * başlatılmış tek bir özelliği olmalıdır.
 * Çalışma zamanında, satır içi sınıfın örnekleri
 * bu tek özellik kullanılarak temsil edilecektir
 * (aşağıda çalışma zamanı temsili hakkında
 * ayrıntılara bakın):
 */

//@JvmInline
//value class Password(private val s: String)

// 'Password' sınıfının gerçek bir öneklemesi gerçekleşmez
// Çalışma zamanında 'securePassword' yalnızca 'String' içerir
//val securePassword = Password("Don't try this in production")

/**
 * Bu, inline ismine ilham veren satır içi sınıfların
 * temel özelliğidir: sınıfın verileri kullanımlarına
 * satır içi olarak eklenir (satır içi işlevlerin
 * içeriğinin siteleri çağırmak için satır içi olarak
 * eklenmesine benzer).
 */

/**
 * Members
 *
 * Satır içi sınıflar, normal sınıfların bazı işlevlerini
 * destekler. Özellikle, özellik ve işlevleri bildirmelerine,
 * bir init bloğuna ve ikincil oluşturuculara sahip olmalarına
 * izin verilir:
 */

//@JvmInline
//value class Person(private val fullName: String) {
//    init {
//        require(fullName.isNotEmpty()) {
//            "Full name shouldn't be empty"
//        }
//    }
//
//    constructor(firstName: String, lastName: String) : this("$firstName $lastName") {
//        require(lastName.isNotBlank()) {
//            "Last name shouldn't be empty"
//        }
//    }
//
//    val length: Int
//        get() = fullName.length
//
//    fun greet() {
//        println("Hello, $fullName")
//    }
//}
//
//fun main() {
//    val name1 = Person("Kotlin", "Mascot")
//    val name2 = Person("Kodee")
//    name1.greet() // `greet()` fonksiyonu statik bir yöntem olarak çağrılır
//    println(name2.length) // özellik alıcısı statik bir yöntem olarak çağrılır
//}

/**
 * Satır içi sınıf özellikleri destek alanlarına
 * sahip olamaz. Sadece basit hesaplanabilir
 * özelliklere sahip olabilirler (lateinit/delege
 * edilmiş özellikler yok).
 */

/**
 * Inheritance
 *
 * Satır içi sınıfların arayüzlerden miras
 * almasına izin verilir:
 */

//interface Printable {
//    fun prettyPrint(): String
//}
//
//@JvmInline
//value class Name(val s: String) : Printable {
//    override fun prettyPrint(): String = "Let's $s!"
//}
//
//fun main() {
//    val name = Name("Kotlin")
//    println(name.prettyPrint()) // Hala statik bir yöntem olarak çağrılıyor
//}

/**
 * Satır içi sınıfların bir sınıf hiyerarşisine
 * katılması yasaktır. Bu, satır içi sınıfların
 * diğer sınıfları genişletemeyeceği ve her
 * zaman son olduğu anlamına gelir.
 */

/**
 * Representation
 *
 * Üretilen kodda, Kotlin derleyicisi her satır
 * içi sınıf için bir sarmalıyıcı tutar. Satır
 * içi sınıf örnekleri, çalışma zamanında
 * sarmalayıcılar veya temel tür olarak temsil
 * edilebilir. Bu, Int'in ilkel bir int veya
 * sarmalayıcı Integer olarak temsil edilebilmesine
 * benzerdir.
 *
 * Kotlin derleyicisi, en performanslı ve optimize
 * edilmiş kodu üretmek için sarmalayıcılar yerine
 * temel türleri kullanmayı tercih edecektir. Ancak,
 * bazen sarmalayıcıları tutmak gerekir. Genel bir
 * kural olarak, satır içi sınıflar başka bir tür
 * olarak kullanıldıklarında kutulanır.
 */

//interface I
//
//@JvmInline
//value class Foo(val i: Int) : I
//
//fun asInline(f: Foo) {}
//fun <T> asGeneric(x: T) {}
//fun asInterface(i: I) {}
//fun asNullable(i: Foo?) {}
//
//fun <T> id(x: T): T = x
//
//fun main() {
//    val f = Foo(42)
//
//    asInline(f)     // unboxed: Foo'nun kendisi olarak kullanılır
//    asGeneric(f)    // boxed: genel tür T olarak kullanılır
//    asInterface(f)  // boxed: tür I olarak kullanılır
//    asNullable(f)   // boxed: Foo'dan farklı olan Foo? olarak kullanılır
//
//    // aşağıda, 'f' önce kutulanır ('id'ye geçirilirken) ve sonra kutudan çıkarılır
//    // ('id'den döndürüldüğünde)
//    // Sonunda, 'c' kutudan çıkarılmış temsili içerir (sadece '42'), çünkü 'f'
//    val c = id(f)
//}

/**
 * Satır içi sınıflar hem altta yatan değer
 * hem de bir sarmalayıcı olarak temsil
 * edilebildiğinden, referans eşitliği onlar
 * için anlamsızdır ve bu nedenle yasaktır.
 *
 * Satır içi sınıflar ayrıca altta yatan tür
 * olarak genel bir tür parametresine sahip
 * olabilir. Bu durumda, derleyici bunu Any?
 * veya genellikle tür parametresinin üst
 * sınırına eşler.
 */

//@JvmInline
//value class UserId<T>(val value: T)

//fun compute(s: UserId<String>) {} // derleyici fun compute-<hashcode>(s: Any?) üretir

/**
 * Mangling
 *
 * Satır içi sınıflar, altta yatan türlerine
 * derlendiğinden, beklenmeyen platform imzası
 * çakışmaları gibi çeşitli belirsiz hatalara
 * yol açabilir:
 */

//@JvmInline
//value class UInt(val x: Int)

// JVM'de 'public final void compute(int x)' olarak temsil edilir
//fun compute(x: Int) {}

// Ayrıca JVM'de 'public final void compute(int x)' olarak da temsil edilir!
//fun compute(x: UInt) {}

/**
 * Bu tür sorunları hafifletmek için, satır
 * içi sınıflar kullanan işlevler, işlev
 * adına bazı kararlı karma kodları eklenerek
 * bozulur. Bu nedenle, fun compute(x: UInt),
 * çakışma sorununu çözen public final void
 * compute-<hashcode>(int x) olarak temsil
 * edilecektir.
 */

//@JvmInline
//value class UInt(val x: Int)
//
//fun compute(x: Int) {}
//
//@JvmName("computeUInt")
//fun compute(x: UInt) {}

/**
 * Inline Classes vs Type Aliases
 *
 * İlk bakışta, satır içi sınıflar tür takma
 * adlarına çok benzer görünüyor. Aslında, her
 * ikisi de yeni bir tür sunuyor gibi görünüyor
 * ve her ikisi de çalışma zamanında altta yatan
 * tür olarak temsil edilecek.
 *
 * Ancak, önemli fark, tür takma adlarının altta
 * yatan türleriyle (ve aynı altta yatan türe
 * sahip diğer tür takma adlarıyla) atama uyumlu
 * olması, satır içi sınıfların ise uyumlu
 * olmamasıdır.
 *
 * Başka bir deyişle, satır içi sınıflar, yalnızca
 * var olan bir tür için alternatif bir ad (takma
 * ad) sunan tür takma adlarının aksine, gerçekten
 * yeni bir tür sunar:
 */

//typealias NameTypeAlias = String
//
//@JvmInline
//value class NameInlineClass(val s: String)
//
//fun acceptString(s: String) {}
//fun acceptNameTypeAlias(n: NameTypeAlias) {}
//fun acceptNameInlineClass(p: NameInlineClass) {}
//
//fun main() {
//    val nameAlias: NameTypeAlias = ""
//    val nameInlineClass: NameInlineClass = NameInlineClass("")
//    val string: String = ""
//
//    acceptString(nameAlias)         // OK: altta yatan tür yerine takma ad geçir
//    acceptString(nameInlineClass)   // NOT OK: altta yatan tür yerine satır içi sınıf geçirilemez
//
//    acceptNameTypeAlias(string)     // OK: takma ad yerine temel türü geçir
//    acceptNameInlineClass(string)   // NOT OK: satır içi sınıf yerine temel türü geçiremezsiniz
//}

/**
 * Inline Class and Delegation
 *
 * Aşağıdaki arayüzlerle, satır içi sınıfın satır
 * içi değerine yetki yoluyla uygulamaya izin
 * verilir:
 */

//interface MyInterface {
//    fun bar()
//    fun foo() = "foo"
//}
//
//@JvmInline
//value class MyInterfaceWrapper(val myInterface: MyInterface) : MyInterface by myInterface
//
//fun main() {
//    val my = MyInterfaceWrapper(object : MyInterface {
//        override fun bar() {
//            // body
//        }
//    })
//    println(my.foo()) // prints "foo"
//}