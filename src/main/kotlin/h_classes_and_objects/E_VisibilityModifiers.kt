package h_classes_and_objects

/**
 * Visibility Modifiers
 *
 * Sınıflar, nesneler, arayüzler, oluşturucular ve
 * işlevler, özellikler ve ayarlayıcıları gibi
 * görünürlük değiştiricilerine sahip olabilir.
 * Getter'lar her zaman özellikleriyle aynı
 * görünürlüğe sahiptir.
 *
 * Kotlin'de dört görünürlük değiştiricisi vardır:
 * private, protected, internal ve public. Varsayılan
 * görünürlük public'tir.
 *
 * Bu sayfada, değiştiricilerin farklı türdeki
 * bildirme kapsamlarına nasıl uygulandığını
 * öğreneceksiniz.
 */

/**
 * Packages
 *
 * Fonksiyonlar, özellikler, sınıflar, nesneler
 * ve arayüzler bir paketin içinde doğrudan
 * "en üst düzeyde" bildirilebilir:
 */

// file name: example.kt
//package foo
//
//fun baz() { /*...*/ }
//class Bar { /*...*/ }

/**
 * - Görünürlük değiştiricisi kullanmazsanız,
 * varsayılan olarak public kullanılır, bu da
 * bildirimlerinizin her yerde görünür olacağı
 * anlamına gelir.
 *
 * - Bir bildirimi private olarak işaretlerseniz,
 * yalnızca bildirimi içeren dosyanın içinde
 * görünür olur.
 *
 * - Dahili olarak işaretlerseniz, aynı modüldeki
 * her yerde görünür olur.
 *
 * - Korunan değiştirici, en üst düzey bildirimler
 * için kullanılamaz.
 */

/**
 * UYARI: Başka bir paketten görünür bir üst
 * düzey bildirimi kullanmak için onu içe
 * aktarmalısınız.
 */

/**
 * Örnekler:
 */

// file name: example.kt
//package foo
//
//private fun foo() { /*...*/ } // visible inside example.kt
//
//public var bar: Int = 5 // property is visible everywhere
//    private set         // setter is visible only in example.kt
//
//internal val baz = 6    // visible inside the same module

/**
 * Class Members
 *
 * Bir sınıfın içinde bildirilen üyeler için:
 *
 * - private, üyenin yalnızca bu sınıfın içinde
 * (tüm üyeler dahil) görünür olduğu anlamına
 * gelir.
 *
 * - protected, üyenin private olarak işaretlenen
 * bir üyeyle aynı görnürlüğe sahip olduğu, ancak
 * alt sınıflarda da görünür olduğu anlamına gelir.
 *
 * - internal, bu modül içindeki bildiren sınıfı
 * gören herhangi bir istemcinin onun dahili
 * üyelerini gördüğü anlamına gelir.
 *
 * - public, bildiren sınıfı gören herhangi bir
 * istemcinin onun public üyelerini gördüğü
 * anlamına gelir.
 */

/**
 * UYARI: Kotlin'de dış sınıf, iç sınıflarının
 * private üyelerini görmez.
 */

/**
 * Korunan veya dahiili bir üyeyi geçersiz
 * kılarsanız ve görünürlüğü açıkça belirtmezseniz,
 * geçersiz kılan üye de orijinal üyeyle aynı
 * görünürlüğe sahip olacaktır.
 *
 * Örnekler:
 */

//open class Outer {
//    private val a = 1
//    protected open val b = 2
//    internal open val c = 3
//    val d = 4 // public by default
//
//    protected class Nested {
//        public val e: Int = 5
//    }
//}
//
//class Subclass : Outer() {
//    // a is not visible
//    // b,c and d are visible
//    // Nested and e are visible
//
//    override val b = 5 // 'b' is protected
//    override val c = 7 // 'c' is internal
//}
//
//class Unrelated(o: Outer) {
//    // o.a, o.b are not visible
//    // o.c and o.d are visible (same module)
//    // Outer.Nested is not visible, and Nested::e is not visible either
//}

/**
 * Constructors
 *
 * Bir sınıfın birincil oluşturucusunun
 * görünürlüğünü belirtmek için aşağıdaki
 * sözdizimini kullanın:
 */

/**
 * UYARI: Açık bir oluşturucu anahtar sözcüğü
 * eklemeniz gerekir
 */

//class C private constructor(a: Int) { /*...*/ }

/**
 * Burada oluşturucu özeldir. Varsayılan
 * olarak, tüm oluşturucular herkese açıktır,
 * bu da sınıfın görünür olduğu her yerde
 * görünür olmaları anlamına gelir (bu, dahili
 * bir sınıfın oluşturucusunun yalnızca aynı
 * modül içinde görünür olduğu anlamına gelir).
 *
 * Mühürlü sınıflar için, oluşturucular
 * varsayılan olarak korunur.
 */

/**
 * Local Declarations
 *
 * Yerel değişkenler, fonksiyonlar ve sınıflar
 * görünürlük değiştiricilerine sahip olamazlar.
 */

/**
 * Modules
 *
 * Dahili görünürlük değiştiricisi, üyenin
 * aynı modül içinde görünür olduğu anlamına
 * gelir. Daha spesifik olarak, bir modül,
 * birlikte derlenen bir Kotlin dosyaları
 * kümesidir, örneğin:
 *
 * - Bir Intellij IDEA modülü.
 * - Bir Maven projesi.
 * - Bir Gradle kaynak kümesi (test kaynak
 * kümesinin main'in dahili bildirimlerine
 * erişebilmesi istisnasıyla).
 * - <kotlinc> Ant görevinin bir çağrısıyla
 * derlenen bir dosya kümesi.
 */