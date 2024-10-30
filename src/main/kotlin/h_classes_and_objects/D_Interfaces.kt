package h_classes_and_objects

/**
 * Interfaces
 *
 * Kotlin'deki arayüzler, soyut yöntemlerin
 * bildirimlerini ve yöntem uygulamalarını
 * içerebilir. Bunları souyt sınıflardan
 * farklı kılan şey, arayüzlerin durumu
 * depolayamamasıdır. Özelliklere sahip
 * olabilirler, ancak bunların soyut olması
 * veya erişim uygulamaları sağlaması gerekir.
 *
 * Bir arayüz, interface anahtar sözcüğü
 * kullanılarak tanımlanır:
 */

//interface MyInterface {
//    fun bar()
//    fun foo() {
//        // optional body
//    }
//}

/**
 * Implementing Interfaces
 *
 * Bir sınıf veya nesne bir veya daha fazla
 * arayüzü uygulayabilir:
 */

//interface MyInterface {
//    fun bar()
//    fun foo() {
//
//    }
//}
//
//class Child : MyInterface {
//    override fun bar() {
//        // body
//    }
//}

/**
 * Properties In Interfaces
 *
 * Arayüzlerde özellikler bildirebilirsiniz. Bir
 * arayüzde bildirilen bir özellik soyut olabilir
 * veya erişim araçları için uygulamalar
 * sağlayabilir. Arayüzlerde bildirilen özellikler
 * destek alanlarına sahip olamaz ve bu nedenle
 * arayüzlerde bildirilen erişim araçları bunlara
 * başvuramaz:
 */

//interface MyInterface {
//    val prop: Int // abstract
//
//    val propertyWithImplementation: String
//        get() = "foo"
//
//    fun foo() {
//        println(prop)
//    }
//}
//
//class Child : MyInterface {
//    override val prop: Int = 29
//}

/**
 * Interfaces Inheritance
 *
 * Bir arayüz diğer arayüzlerden türetilebilir,
 * yani hem üyeleri için uygulamalar sağlayabilir
 * hem de yeni işlevler ve özellikler bildirebilir.
 * Oldukça doğal olarak, böyle bir arayüzü
 * uygulayan sınıfların yalnızca eksik uygulamaları
 * tanımlamaları gerekir:
 */

//interface Named {
//    val name: String
//}
//
//interface Person : Named {
//    val firstName: String
//    val lastName: String
//
//    override val name: String get() = "$firstName $lastName"
//}
//
//data class Employee(
//    // implementing 'name' is not required
//    override val firstName: String,
//    override val lastName: String,
//    val position: Position
//) : Person

/**
 * Resolving Overriding Conflicts
 *
 * Üst tür listenizde birden fazla tür bildirdiğinizde,
 * aynı yöntemin birden fazla uygulamasını miras
 * alabilirsiniz:
 */

//interface A {
//    fun foo() {
//        println("A")
//    }
//
//    fun bar()
//}
//
//interface B {
//    fun foo() {
//        println("B")
//    }
//
//    fun bar() {
//        println("bar")
//    }
//}
//
//class C : A {
//    override fun bar() {
//        println("bar")
//    }
//}
//
//class D : A, B {
//    override fun foo() {
//        super<A>.foo()
//        super<B>.foo()
//    }
//
//    override fun bar() {
//        super<B>.bar()
//    }
//}

/**
 * Arayüzler A ve B, foo() ve bar() fonksiyonlarını bildirir.
 * Her ikisi de foo()'yu uygular, ancak yalnızca B bar()'ı
 * uygular (bar(), A'da soyut olarak işaretlenmez, çünkü
 * bu, fonksiyonun gövdesi yoksa arayüzler için varsayılan
 * değerdir). Şimdi, A'dan somut bir C sınıfı türetirseniz,
 * bar()'ı geçersiz kılmalı ve bir uygulama sağlamalısınız.
 *
 * Ancak, D'yi A ve B'den türetirseniz, birden fazla
 * arayüzden miras aldığınız tüm yöntemleri uygulamanız
 * ve D'nin bunları tam olarak nasıl uygulayacağını
 * belirtmeniz gerekir. Bu kural, hem tek bir uygulamayı
 * miras aldığınız yöntemler (bar() hem de birden fazla
 * uygulamayı miras aldığınız yöntemler (foo()) için
 * geçerlidir.
 */