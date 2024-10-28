package c_functions

/**
 * Operator Overloading
 *
 * Kotlin, türlerdeki önceden tanımlanmış operatör
 * kümesi için özel uygulamalar sağlamanıza olanak
 * tanır. Bu operatörlerin önceden tanımlanmış
 * sembolik gösterimi (+ veya * gibi) ve önceliği
 * vardır. Bir operatörü uygulamak için, karşılık
 * gelen tür için belirli bir adı olan bir üye
 * işlevi veya uzantı işlevi sağlayın. Bu tür,
 * ikili işlemler için sol taraf türü ve tekli
 * işlemler için argüman türü olur.
 *
 * Bir operatörü aşırı yüklemek için, karşılık
 * gelen işlevi operatör değiştiricisiyle
 * işaretleyin:
 */

//interface IndexedContainer {
//    operator fun get(index: Int)
//}

/**
 * Operatör aşırı yüklemelerini geçersiz kılarken,
 * operatörü atlayabilirsiniz:
 */

//interface IndexedContainer {
//    operator fun get(index: Int)
//}
//
//class OrdersList: IndexedContainer {
//    override fun get(index: Int) { /*...*/ }
//}

/**
 * Unary Operations
 */

/** Unary Prefix Operations
 * +a -> a.unaryPlus()
 * -a -> a.UnaryMinus()
 * !a -> a.not()
 *
 * Bu tablo, derleyicinin örneğin +a ifadesini
 * işlediğinde aşağıdaki adımları gerçekleştirdiğini
 * söyler:
 *
 * - a'nın türünü belirler, T olsun.
 * - T alıcısı için operatör değiştiricisi ve
 * parametresi olmayan unaryPlus() fonksiyonunu
 * arar, bu bir üye fonksiyonu veya uzantı fonksiyonu
 * anlamına gelir.
 * - Fonksiyon yoksa veya belirsizse, bu bir derleme
 * hatasıdır.
 * - Fonksiyon mevvcutsa ve dönüş tipi R ise, +a
 * ifadesinin tipi R'dir.
 */

/**
 * UYARI: Bu işlemler ve diğerleri temel tipler
 * için optimize edilmiştir ve bu işlemler için
 * fonksiyon çağrılarında ek yük oluşturmaz.
 */

/**
 * Örnek olarak, tekli eksi operatörünü nasıl
 * aşırı yükleyebileceğiniz gösterelim:
 */

//data class Point(val x: Int, val y: Int)
//
//operator fun Point.unaryMinus() = Point(-x, -y)
//
//val point = Point(10, 20)
//
//fun main() {
//    println(-point) // prints "Point(x=-10, y=-20)"
//}

/**
 * Incerements and Decrements
 *
 * a++ -> a.inc()
 * a-- -> a.dec()
 *
 * inc() ve dec() fonksiyonları, ++ veya -- işleminin
 * kullanıldığı değişkene atanacak bir değer
 * döndürmelidir. inc veya dec'in çağrıldığı nesneyi
 * değiştirmemelidirler.
 *
 * Derleyici, örneğin a++ gibi postfix formundaki bir
 * operatörün çözümlenmesi için aşağıdaki adımları
 * gerçekleştirir:
 *
 * - a'nın türünü belirtler, T olsun.
 * - İşlemci değiştiricisi ve parametresi olmayan, T
 * türündeki alıcıya uygulanabilen bir inc()
 * fonksiyonunu arar.
 * - Fonksiyonun dönüş türünün T'nin bir alt türü
 * olup olmadığını kontrol eder.
 *
 * İfadenin hesaplanmasının etkisi şudur:
 *
 * - a'nın başlangıç değerini geçiçi bir depolama
 * alanı olan a0'a kaydedin.
 * - a0.inc()'in sonucunu a'ya atayın.
 * - İfadenin sonucu olarak a0'ı döndürün.
 *
 * a-- için adımlar tamamen benzerdir.
 *
 * ++a ve --a önek formları için çözüm aynı şekilde
 * çalışır ve etkisi şöyledir:
 *
 * - a.inc() sonucunu a'ya atayın.
 * - İfadenin sonucu olarak a'nın yeni değerini
 * döndürün.
 */

/**
 * Binary Operations
 */

/**
 * Arithmetic Operators
 *
 * a + b -> a.plus(b)
 * a - b -> a.minus(b)
 * a * b -> a.times(b)
 * a / b -> a.div(b)
 * a % b -> a.rem(b)
 * a..b -> a.rangeTo(b)
 * a..<b -> a.rangeUntil(b)
 *
 * Bu tabloda yer alan işlemler için derleyici
 * yalnızca Translated to sütunundaki ifadeyi
 * çözer.
 *
 * Aşağıda, belirli bir değerden başlayan ve
 * aşırı yüklenmiş + operatörü kullanılarak
 * arttırılabilen bir Counter sınıfı örneği
 * verilmiştir:
 */

//data class Counter(val dayIndex: Int) {
//    operator fun plus(increment: Int): Counter {
//        return Counter(dayIndex + increment)
//    }
//}

/**
 * in Operator
 *
 * a in b -> b.contains(a)
 * a !in b -> !b.contains(a)
 *
 * Çünkü in ve !in için prosedür aynıdır,
 * sadece argümanların sırası terstir.
 */

/**
 * Indexed Access Operator
 *
 * a[i] -> a.get(i)
 * a[i, j] -> a.get(i, j)
 * a[i_1, ..., i_n] -> a.get(i_1, ..., i_n)
 * a[i] = b -> a.set(i, b)
 * a[i, j] = b -> a.set(i, j, b)
 * a[i_1, ..., i_n] = b -> a.set(i_1, ..., i_n, b)
 *
 * Köşeli parantezler, uygun sayıda argümanla get
 * ve set çağrılarına çevrilir.
 */

/**
 * invoke Operator
 *
 * a() -> a.invoke()
 * a(i) -> a.invoke(i)
 * a(i, j) -> a.invoke(i, j)
 * a(i_1, ..., i_n) -> a.invoke(i_1, ..., i_n)
 *
 * Parantezler, uygun sayıda argümanla invoke
 * çağrılarına çevrilir.
 */

/**
 * Augmented Assignments
 *
 * a += b -> a.plusAssign(b)
 * a -= b -> a.minusAssign(b)
 * a *= b -> a.timesAssign(b)
 * a /= b -> a.divAssign(b)
 * a %= b -> a.remAssign(b)
 *
 * Atama işlemleri için, örneğin a += b için,
 * derleyici aşağıdaki adımları gerçekleştirir:
 *
 * - Sağ sütundaki fonksiyon mevcutsa:
 *  - Eğer karşılık eglen ikili fonksiyon
 *  (yani plusAssign()) için plus() da mevcutsa,
 *  a değişken bir değişkense ve plus'ın dönüş
 *  tipi a'nın tipinin bir alt tipiyse, bir
 *  hata bildirin (belirsizlik).
 *  - Dönüş tipinin Unit olduğundan emin olun
 *  ve aksi takdirde bir hata bildirin.
 *  - a.plusAssign(b) için kod oluşturun.
 * - Aksi takdirde, a = a + b için kod üretmeyi
 * deneyin (bu bir tür denetimi içerir: a + b'ninn
 * türü, a'nınn bir alt türü olmalıdır).
 */

/**
 * UYARI: Kotlin'de atamalar ifade DEĞİLDİR.
 */

/**
 * Equality and Inequality Operators
 *
 * a == b -> a?.equals(b) ?: (b === null)
 * a != b -> !(a?.equals(b) ?: (b === null))
 *
 * Bu operatörler yalnızca equals(other: Any?): Boolean
 * fonksiyonuyla çalışır ve bu fonksiyon özel eşitlik
 * kontrolü uygulaması sağlamak için geçersiz
 * kılınabilir. Aynı adı taşıyan diğer fonksiyonlar
 * (örneğin equals(other: Foo)) çağrılmayacaktır.
 *
 * UYARI: === ve !== (kimlik kontrolleri) aşırı
 * yüklenemez, bu yüzden onlar için herhangi
 * bir kural yoktur.
 */

/**
 * == işlemi özeldir: null'ları tarayan karmaşık
 * bir ifadeye çevrilir. null == null her zaman
 * doğrudur ve null olmayan x için x = null her
 * zaman yanlıştır ve x.equals()'ı çağırmaz.
 */

/**
 * Comparison Operators
 *
 * a > b -> a.compareTo(b) > 0
 * a < b -> a.compareTo(b) < 0
 * a >= b -> a.compareTo(b) >= 0
 * a <= b -> a.compareTo(b) <= 0
 *
 * Tüm karşılaştırmalar, Int döndürmek için
 * gerekli olan compareTo çağrılarına çevrilir.
 */

/**
 * Property Delegation Operators
 *
 * provideDelegate, getValue ve setValue operatör
 * fonksiyonları Delege edilmiş özellikler bölümünde
 * açıklanmıştır.
 */

/**
 * Infix Calls For Named Functions
 *
 * Infix fonksiyon çağrılarını kullanarak özel
 * infix işlemlerini simüle edebilirsiniz.
 */