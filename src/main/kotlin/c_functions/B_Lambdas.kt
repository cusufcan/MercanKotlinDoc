package c_functions

/**
 * Higher-Order Functions and Lambdas
 *
 * Kotlin fonksiyonları birinci sınıftır, yani değişkenlerde
 * ve veri yapılarında saklanabilir ve diğer üst düzey
 * fonksiyonlara argüman olarak geçirilebilir ve onlardan
 * döndürülebilir. Fonksiyonlar üzerinde, diğer fonksiyon
 * dışı değerler için mümkün olan tüm işlemleri
 * gerçekleştirebilirsiniz.
 *
 * Bunu kolaylaştırmak için, statik olarak yazılmış bir
 * programlama dili olan Kotlin, fonksiyonları temsil etmek
 * için bir fonksiyon tipleri ailesi kullanır ve lambda
 * lambda ifadeleri gibi bir özel dil yapısı sağlar.
 */

/**
 * High-Order Functions
 *
 * Daha yüksek dereceli bir fonksiyon, fonksiyonlar
 * parametre olarak alan veya bir fonksiyon döndüren
 * bir fonksiyondur.
 *
 * Daha yüksek dereceli bir fonksiyonun iyi bir örneği,
 * koleksiyonlar için fonksiyonel programlama deyimi fold'dur.
 * Bir başlangıç biriktirici değeri ve bir birleştirme
 * fonksiyonu alır ve her seferinde birikirici değerini
 * değiştirerek geçerli biriktirici değerini her koleksiyon
 * öğesiyle art arda birleştirerek dönüş değerini oluşturur:
 */

//fun <T, R> Collection<T>.fold(
//    initial: R,
//    combine: (acc: R, nextElement: T) -> R
//): R {
//    var accumulator: R = initial
//    for (element: T in this) {
//        accumulator = combine(accumulator, element)
//    }
//    return accumulator
//}

/**
 * Yukarıdaki kodda, birleştirme parametresi (R, T) -> R
 * fonksiyon tipine sahiptir, bu nedenle R ve T tiplerinde
 * iki argüman alan ve R tipinde bir değer döndüren bir
 * fonksiyonu kabul eder. For döngüsü içinde çağrılır ve
 * dönüş değeri daha sonra accumulator'e atanır.
 *
 * Fold'u çağırmak için, fonksiyon tipinin bir örneğini
 * argüman olarak ona geçirmeniz gerekir ve lambda
 * ifadeleri (aşağıda daha ayrıntılı olarak açıklanmıştır)
 * bu amaçla daha yüksek dereceli fonksiyon çağrı sitelerinde
 * yayın olarak kullanır:
 */

//fun <T, R> Collection<T>.fold(
//    initial: R,
//    combine: (acc: R, nextElement: T) -> R
//): R {
//    var accumulator: R = initial
//    for (element: T in this) {
//        accumulator = combine(accumulator, element)
//    }
//    return accumulator
//}
//
//fun main() {
//    val items = listOf(1, 2, 3, 4, 5)
//
//    // Lambdalar süslü parantezlerle çevrelenmiş kod bloklarıdır
//    items.fold(0, {
//        // Bir lambda'nın parametreleri varsa, bunlar önce gelir,
//        // ardından '->' gelir
//            acc: Int, i: Int ->
//        println("acc = $acc, i = $i, ")
//        val result = acc + i
//        println("result = $result")
//        // Bir lambda'daki son ifade, geri dönüş değeri olarak kabul edilir:
//        result
//    })
//
//    // Bir lambda'daki parametre türleri, çıkarılabiliyorsa isteğe bağlıdır:
//    val joinedToString = items.fold("Elements", { acc, i ->
//        acc + " " + i
//    })
//
//    // Fonksiyon referansları daha yüksek düzeyli fonksiyon çağrıları
//    // için de kullanılabilir:
//    val product = items.fold(1, Int::times)
//}

/**
 * Function Types
 *
 * Kotlin fonksiyonlarla ilgili bildirimler için
 * (Int) -> String gibi fonksiyon tiplerini kullanır:
 * val onClick(): () -> Unit = ...
 *
 * Bu tiplerin, fonksiyonların imzalarına karşılık
 * gelen özel bir gösterimi vardır (parametreleri
 * ve dönüş değerleri):
 * - Tüm fonksiyon tiplerinin parantez içinde parametre
 * tipleri listesi ve bir dönüş tipi vardır:
 * (A, B) -> C, A ve B tiplerinde iki argüman alan ve
 * C tipinde bir değer döndüren fonksiyonları temsil
 * edeln bir tipi belirtir. Parametre tipleri listesi,
 * () -> A'da olduğu gibi boş olabilir. Unit dönüş tipi
 * atlanamaz.
 * - Fonksiyon tipleri, isteğe bağlı olarak gösterimdeki
 * noktadan önce belirtilen ek bir alıcı tipine sahip
 * olabilir. A.(B) -> C tipi, B parametresine sahip bir
 * alıcı nesnesi A üzerinde çağrılabilen ve C değeri
 * döndüren fonksiyonları temsil eder. Alıcıya sahip
 * fonksiyon değişmezleri genellikle bu tipleri birlikte
 * kulllanılır.
 * - Askıya alma işlevleri, gösterimlerinde askıya alma
 * değiştiricisi bulunan özel bir işlev türü türüne
 * aittir, örneğin suspend () -> Unit veya
 * suspend A.(B) -> C
 *
 * İşlev türü gösterimi isteğe bağlı olarak işlev
 * parametreleri için adları içerebilir:
 * (x: Int, y: Int) -> Point. Bu adlar, parametrelerin
 * anlamını belgelemek için kullanılabilir.
 *
 * Bir işlev türünün nullable olduğunu belirtmek için
 * parantezleri şu şekilde kullanın ((Int, Int) -> Int)?
 *
 * İşlev türleri ayrıca parantez kullanılarak
 * birleştirilebilir: (Int) -> ((Int) -> Unit)
 */

/**
 * UYARI: Ok gösterimi sağ-ilişkiseldir,
 * (Int) -> (Int) -> (Unit) önceki örneğe eşdeğerdir,
 * ancak ((Int) -> (Int)) -> Unit ile eşdeğer değildir.
 */

/**
 * Bir fonksiyon türünde, bir tür takma adı kullanarak
 * alternatif bir ad da verebilirsiniz:
 */

//class Button
//class ClickEvent
//
//typealias ClickHandler = (Button, ClickEvent) -> Unit

/**
 * Bir Fonksiyon Tipini Örneklendirme
 *
 * Bir fonksiyon tipinin örneğini elde etmenin birkaç
 * yolu vardır:
 *
 * - Aşağıdaki biçimlerden birinde, bir fonksiyon
 * sabiti içinde bir kod bloğu kullanın:
 *  - bir lambda ifadesi: { a, b -> a + b }
 *  - anonim bir fonksiyon: fun(s: Stirng): Int {
 *  return s.toIntOrNull ?: 0 }
 *  Alıcısı olan fonksiyon sabitleri, alıcısı olan
 *  fonksiyon tiplerinin değerleri olarak kullanılabilir.
 *
 * - Mevcut bir bildirimde çağrılabilir bir referans
 * kullanın:
 *  - üst düzey, üye veya uzantı fonksiyonu:
 *  ::isOdd, String::toInt,
 *  - üst düzey, üye veya uzantı özelliği:
 *  List<Int>::size,
 *  - bir constructor: ::Regex
 *  Bunlar belirli bir örneğin bir üyesine işaret
 *  eden bağlı çağrılabilir referansları içerir:
 *  foo::toString
 *
 * - Bir fonksiyon tipini arayüz olarak uygulayan özel
 * bir sınıfın örneklerini kullanın:
 */

//class IntTransformer : (Int) -> Int {
//    override operator fun invoke(x: Int): Int = TO\DO()
//}
//
//fun main() {
//    val intFunction: (Int) -> Int = IntTransformer()
//}

/**
 * Derleyici, yeterli bilgi varsa değişkenler için
 * fonksiyon türlerini çıkarabilir:
 */

//fun main() {
//    val a = { i: Int -> i + 1 } // Çıkarılan tür (Int) -> Int'tir
//}

/**
 * Alıcısı olan ve olmayan fonksiyon tiplerinin
 * gerçek olmayan değerleri birbirinin yerine
 * kullanılabilir, bu nedenle alcı ilk parametrenin
 * yerine geçebilir ve tam tersi de geçerlidir.
 * Örneğin, (A, B) -> C tipinde bir değer, A.(B) -> C
 * tipinde bir değer beklendiğinde geçirilebilir
 * veya atanabilir ve bunun tersi de geçerlidir:
 */

//fun main() {
//    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
//    val twoParameters: (String, Int) -> String = repeatFun // OK
//
//    fun runTransformation(f: (String, Int) -> String): String {
//        return f("hello", 3)
//    }
//
//    val result = runTransformation(repeatFun) // OK
//}

/**
 * Bir değişken bir uzantı işlevine referansla
 * başlatılsa bile, alıcısı olmayan bir işlev türü
 * varsayılan olarak çıkarılır. Bunu değiştirmek
 * için değişken türünü açıkça belirtin.
 */

/**
 * Bir Fonksiyon Türü Örneğini Çağırma
 *
 * Bir fonksiyon tipinin değeri, invoke(...)
 * operatörü kullanılarak çağrılabilir:
 * f.invoke(x) veya sadece f(x).
 *
 * Değerin bir alıcı tipi varsa, alıcı nesnesi
 * ilk argüman olarak geçirilmelidir. Bir
 * fonksiyon tipinin değerini alıcı ile
 * çağırmanın bir başka yolu, değer bir
 * uzantı fonksiyonuymuş gibi, ona alıcı
 * nesnesini eklemektir: 1.foo(2)
 *
 * Örnek:
 */

//fun main() {
//    val stringPlus: (String, String) -> String = String::plus
//    val intPlus: Int.(Int) -> Int = Int::plus
//
//    println(intPlus.invoke(1, 1))
//    println(intPlus(1, 2))
//    println(2.intPlus(3)) // extension-like call
//}

/**
 * Inline Functions
 *
 * Bazen daha yüksek düzeyli fonksiyonlar için
 * esnek kontrol akışı sağlayan inline fonksiyonları
 * kullanmak faydalı olabilir.
 */

/**
 * Lambda Expressions and Anonymous Functions
 *
 * Lambda ifadeleri ve anonim işlevler işlev
 * değişmezleridir. İşlev değişmezleri,
 * bildirilmeyen ancak hemen bir ifade olarak
 * geçirilen işlevlerdir. Aşağıdaki örneği ele
 * alalım:
 */

//fun max(strings: List<String>, hof: (String, String) -> Boolean) {}
//
//fun main() {
//    val strings = listOf<String>()
//    max(strings, { a, b -> a.length < b.length })
//}

/**
 * max fonksiyonu, ikinci argümanı olarak bir
 * fonksiyon değeri aldığı için daha yüksek
 * dereceli bir fonksiyondur. Bu ikinci argüman,
 * kendisi bir fonksiyon olan ve aşağıdaki
 * adlandırılmış fonksiyona eşdeğer olan bir
 * fonksiyon sabiti adı verilen bir ifadedir:
 */

//fun compare(a: String, b: String): Boolean = a.length < b.length

/**
 * Lambda Expression Syntax
 *
 * Lambda ifadelerinin tam sözdizimsel biçimi
 * aşağıdaki gibidir:
 */

//fun main() {
//    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
//}

/**
 * - Bir lambda ifadesi her zaman süslü
 * parantezlerle çevrilidir.
 * - Tam sözdizimsel formdaki parametre
 * bildirimleri süslü parantezlerin içine
 * girer ve isteğe bağlı tür açıklamalarına
 * sahiptir.
 * - Gövde -> işaretinden sonra gelir.
 * - Lambda'nın çıkarılan dönüş türü Unit
 * değilse, lambda gövdesi içindeki son
 * (veya muhtemelen tek) ifade dönüş değeri
 * olarak ele alınır:
 *
 * Tüm isteğe bağlı açıklamaları çıkarırsanız
 * geriye şu şekilde bir şey kalır:
 */

//fun main() {
//    val sum = { x: Int, y: Int -> x + y }
//}

/**
 * Passing Trailing Lambdas
 *
 * Kotlin kuralına göre, bir fonksiyonun
 * son parametresi bir fonksiyon ise, ilgili
 * argüman olarak geçirilen bir lambda
 * ifadesi parantez dışına yerleştirilebilir:
 */

//fun main() {
//    val items = listOf<Int>()
//    val product = items.fold(1) { acc, e -> acc * e }
//}

/**
 * Bu tür sözdizimi, ardışık lambda olarak
 * da bilinir.
 *
 * Eğer lambda bu çağrıdaki tek arümansa,
 * parantezler tamamen atlanabilir:
 */

//fun main() {
//    run { println("...") }
//}

/**
 * it: Tek Bir Parametrenin Örtük Adı
 *
 * Bir lambda ifadesinin yalnızca bir parametresi
 * olması çok yaygındır.
 *
 * Derleyici imzayı herhangi bir parametre olmadan
 * ayrıştırabiliyorsa, parametrenin bildirilmesine
 * gerek yoktur ve -> atlanabilir. Parametre, it
 * adı altında örtük olarak bildirilecektir:
 */

//fun main() {
//    val ints = listOf<Int>()
//    ints.filter { it > 0 } // bu literal '(it: Int) -> Boolean' türündedir
//}

/**
 * Bir Lambda İfadesinden Bir Değer Döndürme
 *
 * Nitelikli dönüş sözdizimini kullanarak lambda'dan
 * açıkça bir değer döndürebilirsiniz. Aksi takdirde,
 * son ifadenin değeri örtük olarak döndürülür.
 *
 * Bu nedenle, aşağıdaki iki kod parçaçığı eşdeğerdir:
 */

//fun main() {
//    val ints = listOf<Int>()
//
//    ints.filter {
//        val shouldFilter = it > 0
//        shouldFilter
//    }
//
//    ints.filter {
//        val shouldFilter = it > 0
//        return@filter shouldFilter
//    }
//}

/**
 * Bu kural, parantez dışında bir lambda ifadesi
 * geçirmenin yanı sıra LINQ tarzı koda da olanak
 * tanır:
 */

//fun main() {
//    val strings = listOf<String>()
//    strings.filter { it.length == 5 }
//        .sortedBy { it }
//        .map { it.uppercase() }
//}

/**
 * Underscore For Unused Variables
 *
 * Eğer lambda parametresi kullanılmıyorsa,
 * isminin yerine alt çizgi koyabilirsiniz:
 */

//fun main() {
//    val map = mapOf<String, String>()
//    map.forEach { (_, value) -> println("$value!") }
//}

/**
 * Destructuring In Lambdas
 *
 * Lambdalarda destructuring, destructuring
 * bildirimlerinin bir parçası olarak
 * açıklanmaktadır.
 */

/**
 * Anonymous Functions
 *
 * Yukarıdaki lambda ifadesi sözdiziminde bir
 * şey eksiktir: fonksiyonun dönüş türünü
 * belirtme yeteneği. Çoğu durumda, dönüş
 * türü otomatik olarak çıkarılabildiği için
 * bu gereksizdir. Ancak, bunu açıkça belirtmeniz
 * gerekiyorsa, alternatif bir sözdizimi
 * kullanabilirsiniz: anonim bir fonksiyon.
 */

//fun main() {
//    fun(x: Int, y: Int): Int = x + y
//}

/**
 * Anonim bir fonksiyon, normal bir fonksiyon
 * bildirimine çok benzer, ancak adı atlanmıştır.
 * Gövdesi bir ifade (yukarıda gösterildiği gibi)
 * veya bir blok olabilir:
 */

//fun main() {
//    fun(x: Int, y: Int): Int {
//        return x + y
//    }
//}

/**
 * Parametreler ve dönüş türü, normal
 * fonksiyonlarda olduğu gibi aynı şekilde
 * belirtilir; ancak parametre türleri,
 * bağlamdan çıkarılabiliyorsa atlanabilir:
 */

//fun main() {
//    val ints = listOf<Int>()
//    ints.filter(fun(item) = item > 0)
//}

/**
 * Anonim fonksiyonlar için dönüş tipi
 * çıkarımı, normal fonksiyonlardaki gibi
 * çalışır: İfade gövdesine sahip anonim
 * fonksiyonlar için dönüş tipi otomatik
 * olarak çıkarılır, ancak blok gövdesine
 * sahip anonim fonksiyonlar için açıkça
 * belirtilmesi gerekir (veya Unit olduğu
 * varsayılır).
 */

/**
 * UYARI: Anonim fonksiyonları parametre
 * olarak geçirirken, bunları parantezlerin
 * içine yerleştirin Fonksiyonu parantezlerin
 * dışında bırakmanıza izin veren kısa
 * sözdizimi yalnızca lambda ifadeleri için
 * çalışır.
 */

/**
 * Lambda ifadeleri ile anonim işlevler
 * arasındaki bir diğer fark, yerel olmayan
 * dönüşlerin davranışıdır. Etiketi olmayan
 * bir return ifadesi her zaman fun anahtar
 * sözcüğüyle bildirilen işlevden döner.
 * Bu, bir lambda ifadesinin içindeki bir
 * dönüşün çevreleyen işlevden döneceği,
 * anaonim bir işlevin içindeki bir dönüşün
 * ise anonim işlevin kendisinden döneceği
 * anlamına gelir.
 */

/**
 * Closures
 *
 * Bir lambda ifadesi veya anonim fonksiyon
 * (yerel bir fonksiyon ve bir nesne
 * ifadesinin yanı sıra) dış kapsamda
 * bildirilen değişkenleri içeren kapanışına
 * erişebilir. Kapanışta yakalanan değişkenler
 * lambdada değiştirilebilir:
 */

//fun main() {
//    val ints = listOf<Int>()
//
//    var sum = 0
//    ints.filter { it > 0 }.forEach {
//        sum += it
//    }
//    println(sum)
//}

/**
 * Function Literals With Receiver
 *
 * Alıcısı olan fonksiyon tipleri, örneğin
 * A.(B) -> C, fonksiyon sabitlerinin özel
 * bir biçimiyle örneklendirilebilir -alıcısı
 * olan fonksiyon sabitleri.
 *
 * Yukarıda belirtildiği gibi, Kotlin alıcı
 * nesnesini sağlarken alıcısı olan bir
 * fonksiyon tipinin örneğini çağırma olanağı
 * sağlar.
 *
 * Fonksiyon sabitinin gövdesinin içinde, bir
 * çağrıya geçirilen alıcı nesnesi örtük bir
 * this olur, böylece herhangi bir ek niteleyici
 * olmadan o alıcı nesnenin üyelerine erişebilir
 * veya alıcı nesnesine this ifadesini kullanarak
 * erişebilirsiniz.
 *
 * Bu davranış, fonksiyon gövdesinin içinde alıcı
 * nesnenin üyelerine erişmenize de izin veren
 * uzantı fonksiyonlarının davranışına benzerdir.
 *
 * İşte alıcısı ve tipi olan bir fonksiyon sabitinin
 * bir örneği, burada alıcı nesnesinde artı çağrılır:
 */

//fun main() {
//    val sum: Int.(Int) -> Int = { other -> plus(other) }
//}

/**
 * Anonim fonksiyon sözdizimi, bir fonksiyon
 * literalinin alıcı türünü doğrudan belirtmenize
 * olanak tanır. Bu, bir fonksiyon türünün bir
 * değişkenini alıcıyla bildirmeniz ve daha sonra
 * kullanmanız gerektiğinde yararlı olabilir.
 */

//fun main() {
//    val sum = fun Int.(other: Int): Int = this + other
//}

/**
 * Lambda ifadeleri, alıcı türü bağlamdan
 * çıkarılabildiğinde alıcıyla işlev sabitleri
 * olarak kullanılabilir. Kullanımlarının en
 * önemli örneklerinden biri tür güvenli
 * oluşturuculardır:
 */

//class HTML {
//    fun body() { /*...*/
//    }
//}
//
//fun html(init: HTML.() -> Unit): HTML {
//    val html = HTML() // alıcı nesneyi oluştur
//    html.init() // alıcı nesneyi lambda'ya geçir
//    return html
//}
//
//fun main() {
//    html { // alıcı lambda burada başlıyor
//        body() // alıcı nesnede bir yöntemi çağırma
//    }
//}