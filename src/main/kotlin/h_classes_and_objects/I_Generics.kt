package h_classes_and_objects

/**
 * Generics: in, out, where
 *
 * Kotlin'deki sınıflar, tıpkı Java'daki gibi
 * tip parametrelerine sahip olabilir:
 */

//class Box<T>(t: T) {
//    var value = t
//}

/**
 * Böyle bir sınıfın örneğini oluşturmak için
 * yalnızca tür argümanlarını sağlamanız yeterlidir:
 */

//class Box<T>(t: T) {
//    var value = t
//}
//
//val box: Box<Int> = Box<Int>(1)

/**
 * Ancak parametreler örneğin oluşturucu argümanlarından
 * çıkarılabilyorsa, tür argümanlarını atlayabilirsiniz:
 */

//class Box<T>(t: T) {
//    var value = t
//}
//
//val box = Box(1)

/**
 * Variance
 *
 * Java'nın tür sisteminin en zor yönlerinden biri
 * wildcard'lardır. Kotlin'de bunlar yoktur. Bunun yerine
 * Kotlin'de bildirim-site varyansı ve tür projeksiyonları
 * vardır.
 */

/**
 * Variance and Wildcards In Java
 *
 * Java'nın bu gizemli wildcard'a neden ihtiyaç duyduğunu
 * Öncelikle, Java'daki genel tipler değişmezdir, yani
 * List<String>, List<Object>'in bir alt tipi değildir.
 * List değişmez olmasaydı, Java'nın dizilerinden
 * daha iyi olmazdı, çünkü aşağdaki kod derlenirdi ancak
 * çalışma zamanında bir istisnaya neden olurdu:
 */

// Java
//List<String> strs = new ArrayList<String>();

// Java derleme zamanında bir tür uyuşmazlığı bildiriyor.
//List<Object> objs = strs;

// Ya olmasaydı?
// Bir Integer'ı bir String listesine koyabilirdik.
//objs.add(1);

// Ve sonra çalışma zamanında, Java
// bir ClassCastException fırlatırdı: Tam sayı Dizeye dönüştürülemez
//String s = strs.get(0);

/**
 * Java, çalışma zamanı güvenliğini garanti altına
 * almak için bu tür şeyleri yasaklar. Ancak bunun
 * bazı sonuçları vardır. Örneğin, Collection
 * arayüzünden addAll() metodunu ele alalım. Bu
 * metodun imzası nedir? Sezgisel olarak, bunu şu
 * şekilde yazardınız:
 */

// Java
//interface Collection<E> ... {
//    void addAll(Collection<E> items);
//}

/**
 * Ama o zaman aşağıdakileri yapamazsınız (ki
 * bu da tamamen güvenlidir):
 */

// Java

// Aşağıdakiler addAll'ın saf bildirimiyle derlenmeyecektir:
// Collection<String>, Collection<Object>'in bir alt türü değildir
//void copyAll(Collection<Object> to, Collection<String> from) {
//    to.addAll(from);
//}

/**
 * İşte bu yüzden addAll()'un gerçek imzası aşağıdaki
 * gibidir:
 */

// Java
//interface Collection<E> ... {
//    void addAll(Collection<? extends E> items);
//}

/**
 * Wildcard ? extends E, bu yöntemin yalnızca E'nin
 * kendisinin değil, E'nin nesnelerinden oluşan bir
 * koleksiyonu veya E'nin bir alt tipini kabul
 * ettiğini belirtir. Bu, öğelerden E'leri güvenli
 * bir şekilde okuyabileceğiniz (bu koleksiyonun
 * öğeleri, E'nin bir al sınıfının örnekleridir)
 * ancak E'nin bilinmeyen alt ipine uyan nesneleri
 * bilmediğiniz için bunlara yazamayacağınız anlamına
 * gelir. Bu sınırlama karşılığında, istenen davranışı
 * elde edersiniz: Collection<String>,
 * Collection<? extends Object>'in bir alt tipidir.
 * Başka bir deyişle, extends sınırına (üst sınır)
 * sahip wildcard, türü covariant hale getirir.
 *
 * Bunun neden işe yaradığını anlamanın anahtarı
 * oldukça basittir: yalnızca bir koleksiyondan
 * öğeler alabiliyorsanız, o zaman bir String
 * koleksiyonu kullanmak ve ondan Object'leri
 * okumak sorun değildir. Tersine, yalnızca
 * öğeleri koleksiyona koyabiliyorsanız, bir
 * Object koleksiyonu alıp içine String'ler
 * koymak sorun değildir: Java'da String veya
 * onun üst tiplerinden herhangi birini kabul
 * eden List<? super String> vardır.
 *
 * İkincisine contravariance denir ve
 * List<? super String> üzerinde yalnızca
 * String'i argüman olarak alan yöntemleri
 * çağırabilirsiniz (örneğin, add(String) veya
 * set(int, String) çağırabilirsiniz). List<T>'de
 * T döndüren bir şeyi çağırırsanız, bir String
 * değil, bir Object elde edersiniz.
 */

/**
 * UYARI: Üretici nesnesi kullanıyorsanız, örneğin
 * List<? extends Foo>, bu nesne üzerinde add()
 * veya set() çağırmanıza izin verilmez, ancak bu
 * onun değişmez olduğu anlamına gelmez: örneğin,
 * clear()'ı çağırarak listeden tüm öğeleri
 * kaldırmanızı engelleyen hiçbir şey yoktur,
 * çünkü clear() hiçbir parametre almaz.
 *
 * Wildcard'lar (veya diğer değişkenlik türleri)
 * tarafından garnati edilen tek şey tür güvenliğidir.
 * Değişmezlik tamamen farklı bir hikaye.
 */

/**
 * Declaration-Site Variance
 *
 * T'yi parametre olarak alan hiçbir metodu olmayan,
 * sadece T'yi döndüren metodları olan genel bir
 * Source<T> arayüzü olduğunu varsayalım:
 */

// Java
//interface Source<T> {
//    T next();
//}

/**
 * O zaman, Source<String> örneğine bir referansı
 * Source<Object> türündeki bir değişkende saklamak
 * tamamen güvenli olurdu - çağrılacak tüketici
 * yöntemleri yoktur. Ancak Java bunu bilmez ve
 * yine de bunu yasaklar:
 */

// Java
//void demo(Source<String> strs) {
//    Source<Object> objects = strs; // !!! Not allowed in Java
//    // ...
//}

/**
 * Bunu düzeltmek için Source<? extends Object>
 * türünde nesneler bildirmelisiniz. Bunu yapmak
 * anlamsızdır, çünkü daha önce olduğu gibi bu
 * tür bir değişkende aynı yöntemlerin hepsini
 * çağırabilirsiniz, bu nedenle daha karmaşık
 * tür tarafından eklenen bir değer yoktur.
 * Ancak derleyici bunu bilmez.
 *
 * Kotlin'de, bu tür şeyleri derleyiciye
 * açıklamanın bir yolu vardır. Buna
 * declaration-site variance denir:
 * Source'un T tür parametresini, yalnızca
 * Source<T> üyelerinden döndürüldüğünden
 * (üretildiğinden) ve asla tüketilmediğinden
 * emin olmak için açıklayabilirsiniz. Bunu
 * yapmak için out değiştiricisini kullanın:
 */

//interface Source<out T> {
//    fun next(): T
//}
//
//fun demo(strs: Source<String>) {
//    val objects: Source<Any> = strs // This is OK, çünkü T bir dış parametredir
//}

/**
 * Genel kural şudur: C sınıfının T tip parametresi
 * out olarak bildirildiğinde, yalnızca C üyelerinin
 * out-pozisyonunda bulunabilir, ancak karşılığında
 * C<Base> güvenli bir şekilde C<Derived>'in bir üst
 * tipi olabilir.
 *
 * Başka bir deyişle, C sınıfının T parametresinde
 * covariant olduğunu veya T'nin covariant tip
 * parametresi olduğunu söyleyebilirsiniz. C'yi
 * T'lerin bir üreticisi olarak düşünebilirsiniz,
 * T'lerin bir tüketicisi DEĞİL.
 *
 * Out değiştiricisi variance annotation olarak
 * adlandırılır ve tip parametresi bildirim sitesinde
 * sağlandığından, bildirim sitesi variance'ı sağlar.
 * Bu, tür kullanımlarındaki wildcard karakterlerin
 * türleri covariant yaptığı Java'nın kullanım sitesi
 * variance'ının tersidir.
 *
 * Kotlin, out'a ek olarak tamamlayıcı bir variance
 * annotation'u sağlar: in. Bir tip parametresini
 * contravariant yapar, yani yalnızca tüketilebilir
 * ve asla üretilemez. Contravariant tipin iyi bir
 * örneği Comparable'dır:
 */

//interface Comparable<in T> {
//    operator fun compareTo(other: T): Int
//}
//
//fun demo(x: Comparable<Number>) {
//    x.compareTo(1.0) // 1.0, Number'ın bir alt türü olan Double türüne sahiptir
//    // Bu nedenle, x'i Comparable<Double> türünde bir değişkene atayabilirsiniz
//    val y: Comparable<Double> = x // OK!
//}

/**
 * In ve out kelimeleri kendini açıklıyor gibi
 * görünüyor ve bu yüzden yukarıda bahsedilen
 * ezber tekniğine gerçekten gerek yok. Aslında
 * daha yüksek bir soyutlama seviyesinde yeniden
 * ifade edilebilir:
 */

/**
 * Type Projections
 */

/**
 * Use-Site Variance: Type Projections
 *
 * Bir tip parametresi T'yi out olarak bildirmek
 * ve use sitesinde alt tiplemeyle ilgili sorunlardan
 * kaçınmak çok kolaydır, ancak bazı sınıflar aslında
 * yalnızca T'leri döndürmekle sınırlandırılamaz!
 * Bunun iyi bir örneği Array'dir:
 */

//class Array<T>(val size: Int) {
//    operator fun get(index: Int): T { /*...*/ }
//    operator fun set(index: Int, value: T) { /*...*/ }
//}

/**
 * Bu sınıf T'de ne eşdeğişken ne de karşıtdeğişken
 * olabilir. Ve bu da belirli esnekliksizlikler
 * getirir. Aşağıdaki fonksiyonu düşünün:
 */

//fun copy(from: Array<Any>, to: Array<Any>) {
//    assert(from.size == to.size)
//    for (i in from.indices)
//        to[i] = from[i]
//}

/**
 * Bu fonksiyonun öğeleri bir diziden diğerine
 * kopyalaması gerekiyor. Bunu pratikte uygulamaya
 * çalışalım:
 */

//fun copy(from: Array<Any>, to: Array<Any>) {
//    assert(from.size == to.size)
//    for (i in from.indices)
//        to[i] = from[i]
//}
//
//fun main() {
//    val ints: Array<Int> = arrayOf(1, 2, 3)
//    val any = Array<Any>(3) { "" }
//    copy(ints, any)
//    //    ^ türü Array<Int> ama Array<Any> bekleniyordu
//}

/**
 * Burada aynı bilindik sorunla karşılaşırsınız:
 * Array<T> T'de değişmezdir ve bu nedenle ne
 * Array<Int> ne de Array<Any> diğerinin alt tipidir.
 * Neden olmasın? Tekrar ediyorum, bunun nedeni
 * copy'nin beklenmeyen bir davranışa sahip
 * olabilmesidir, örneğin from'a bir String yazmaya
 * çalışabilir ve oraya gerçekten bir Int dizisi
 * geçirirseniz, daha sonra bir ClassCastException
 * atılır.
 *
 * Copy işlevini from'a yazmasını engellemek için
 * şunları yapabilirsiniz:
 */

//fun copy(from: Array<out Any>, to: Array<Any>) { /*...*/ }

/**
 * Bu, tip projeksiyonudur, yani from basit bir
 * dizi değil, daha ziyade kısıtlı (projekte edilmiş)
 * bir dizidir. Yalnızca T tip parametresini döndüren
 * yöntemleri çağırabilirsiniz, bu durumda yalnızca
 * get()'i çağırabileceğiniz anlamına gelir. Bu,
 * kullanım yeri varyansına yaklaşımımızdır ve biraz
 * daha basit olmasına rağmen Java'nın
 * Array<? extends Object>'ine karşılık gelir.
 *
 * Ayrica in ile bir tip projeksiyonu yapabilirsiniz:
 */

//fun fill(dest: Array<in String>, value: String) { /*...*/ }

/**
 * Array<in String>, Java'nın Array<? super String>'ine
 * karşılık gelir. Bu, fill() fonksiyonuna bir
 * CharSequence dizisi veya bir Object dizisi
 * geçirebileceğiniz anlamına gelir.
 */

/**
 * Star-Projections
 *
 * Bazen tip argümanı hakkında hiçbir şey bilmediğinizi
 * söylemek istersiniz, ancak yine de onu güvenli bir
 * şekilde kullanmak istersiniz. Buradaki güvenli yol,
 * genel tipin böyle bir izdüşümünü tanımlamaktır,
 * böylece bu genel tipin her somut örneklemesi bu
 * izdüşümün bir alt tipi olacaktır.
 *
 * Kotlin bunun için sözde yıldız izdüşüm sözdizimi
 * sağlar:
 *
 * - T'nin üst sınırı TUpper olan covariant bir tip
 * parametresi olduğu Foo<out T: TUpper> için Foo<*>,
 * Foo<out TUpper> ile eşdeğerdir. Bu, T bilinmediğinde
 * TUpper değerlerini Foo<*>'dan güvenli bir şekilde
 * okuyabileceğiniz anlamına gelir.
 *
 * - T'nin karşıt değişken bir tip parametresi olduğu
 * Foo<in T> için Foo<*>, Foo<in Nothing> ile eşdeğerdir.
 * Bu, T bilinmediğinde Foo<*>'ya güvenli bir şekilde
 * yazabileceğiniz hiçbir şey olmadığı anlamına gelir.
 *
 * - T'nin üst sınırı TUpper olan değişmez bir tür
 * parametresi olduğu Foo<T: TUpper> için, Foo<*>,
 * değerleri okumak için Foo<out TUpper> ve değerleri
 * yazmak için Foo<in Nothing> ile eşdeğerdir.
 *
 * Genel bir tipin birden fazla tip parametresi varsa,
 * bunların her biri bağımsız olarak yansıtılabilir.
 * Örneğin, tip Function<in T, out U> arayüzü olarak
 * bildirilirse, aşağıdaki yıldız yansıtmalarını
 * kullanabilirsiniz:
 *
 * - Function<*, String> -> Function<in Nothing, String>
 * - Function<Int, *> -> Function<Int, out Any?>
 * - Function<*, *> -> Function<in Nothing, out Any?>
 *
 * Yıldız projeksiyonları Java'nın ham tiplerine çok
 * benzer, ancak güvenlidir.
 */

/**
 * Generic Functions
 *
 * Sınıflar, tip parametrelerine sahip olabilen tek
 * bildirimler değildir. Fonksiyonlar da olabilir.
 * Tip parametreleri, fonksiyon adından önce
 * yerleştirilir:
 */

//fun <T> singletonList(item: T): List<T> {
//    // ...
//}
//
//fun <T> T.basicToString(): String { // extension function
//    // ...
//}

/**
 * Genel bir fonksiyonu çağırmak için, fonksiyonun
 * adından sonra çağrı yerinde tür argümanlarını
 * belirtin:
 */

//val l = singletonList<Int>(1)

/**
 * Tür argümanları, bağlamdan çıkarılabiliyorsa
 * atlanabilir, bu nedenle aşağıdaki örnek de işe
 * yarar:
 */

//val l = singletonList(1)

/**
 * Generic Constraints
 *
 * Belirli bir tip parametresinin yerine geçebilecek
 * tüm olası tiplerin kümesi genel kısıtlamalarla
 * sınırlandırılabilir.
 */

/**
 * Upper Bounds
 *
 * En yaygın kısıtlama türü, Java'nın extends
 * anahtar sözcüğüne gelen üst sınırdır:
 */

//fun <T : Comparable<T>> sort(list: List<T>) { /*...*/ }

/**
 * İki noktadan sonra belirtilen tür, üst sınırdır
 * ve bu da T yerine yalnızca Comparable<T> alt
 * türünün ikame edilebileceğini gösterir. Örneğin:
 */

//fun <T : Comparable<T>> sort(list: List<T>) { /*...*/ }
//
//fun main() {
//    sort(listOf(1, 2, 3)) // OK.
//    sort(listOf(HashMap<Int, String>())) // Error
//}

/**
 * Varsayılan üst sınır (eğer belirtilmemişse) Any?'dir.
 * Açılı parantezlerin içinde yalnızca bir üst sınır
 * belirtilebilir. Aynı tür parametresinin birden
 * fazla üst sınıra ihtiyacı varsa, ayrı bir where
 * cümlesine ihtiyacınız vardır:
 */

//fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
//        where T : CharSequence,
//              T : Comparable<T> {
//    return list.filter { it > threshold }.map { it.toString() }
//}

/**
 * Geçilen tür, where ifadesinin tüm koşullarını aynı
 * anda karşılamalıdır. Yukarıdaki örnekte, T türü
 * hem CharSequence hem de Comparable'ı uygulamalıdır.
 */

/**
 * Definitely Non-Nullable Types
 *
 * Genel Java sınıfları ve arayüzleriyle birlikte
 * çalışabilirliği kolaylaştırmak için Kotlin, genel
 * bir tür parametresini kesinlikle boş bırakılamaz
 * olarak bildirmeyi destekler.
 *
 * Genel bir tür T'yi kesinlikle boş bırakılamaz
 * olarak bildirmek için, türü & Any ile bildirin.
 * Örneğin: T & Any.
 *
 * Kesinlikle boş bırakılamaz bir türün boş
 * bırakılabilir bir üst sınırı olmalıdır.
 *
 * Kesinlikle boş bırakılamaz türleri bildirmek
 * için en yaygın kullanım durumu, argüman olarak
 * @NotNull içeren bir Java yöntemini geçersiz
 * kılmak istediğiniz zamandır. Örneğin, load()
 * yöntemini ele alalım:
 */

//public interface Game<T> {
//    public T save(T x) {}
//    @NotNull
//    public T load(@NotNull T x) {}
//}

/**
 * Kotlin'de load() metodunu başarılı bir
 * şekilde geçersiz kılmak için T1'in kesinlikle
 * null yapılamayacak şekilde tanımlanması
 * gerekir:
 */

//interface ArcadeGame<T1> : Game<T1> {
//    override fun save(x: T1): T1
//
//    // T1 kesinlikle non-nullable'dır
//    override fun load(x: T1 & Any): T1 & Any
//}

/**
 * Sadece Kotlin ile çalıştığınızda, kesinlikle
 * null yapılamayan türleri açıkça bildirmeniz
 * pek olası değildir çünkü Kotlin'in tür çıkarımı
 * bunu sizin için halleder.
 */

/**
 * Type Erasure
 *
 * Kotlin'in genel bildirim kullanımları için
 * gerçekleştirdiği tür güvenliği kontrolleri
 * derleme zamanında yapılır. Çalışma zamanında,
 * genel türlerin örnekleri gerçek tür argümanları
 * hakkında hiçbir bilgi tutmaz. Tür bilgisinin
 * silindiği söylenir. Örneğin, Foo<Bar> ve
 * Foo<Baz?> örnekleri yalnızca Foo<*> olarak
 * silinir.
 */

/**
 * Generics Type Checks and Casts
 *
 * Tür silme nedeniyle, genel bir tür örneğinin
 * çalışma zamanında belirli tür argümanlarıyla
 * oluşturulup oluşturulmadığını kontrol etmenin
 * genel bir yolu yoktur ve derleyici,
 * ints is List<Int> veya list is T (tür parametresi)
 * gibi bu tür kontrolleri yasaklar. Ancak, bir
 * örneği yıldız projeksiyonlu bir türe karşı
 * kontrol edebilirsiniz:
 */

//if(something is List<*>) {
//    something.forEach { println(it) } // Elemanlar Any? tipindedir
//}

/**
 * Benzer şekilde, bir örneğin tür argümanları
 * zaten statik olarak (derleme zamanında) kontrol
 * edildiğinde, türün genel olmayan kısmını içeren
 * bir is-check veya bir dönüşüm yapabilirsiniz.
 * Bu durumda açılı parantezlerin atlandığını
 * unutmayın:
 */

//fun handleStrings(list: MutableList<String>) {
//    if (list is ArrayList) {
//        // list, ArrayList<String>'e smart cast'lendi
//    }
//}

/**
 * Aynı sözdimi, ancak tür argümanları atlanarak,
 * tür argümanlarını hesaba katmayan dönüşümler
 * için kullanılabilir: list as ArrayList.
 *
 * Genel fonksiyon çağrılarının tür argümanları da
 * yalnızca derleme zamanında kontrol edilir.
 * Fonksiyon gövdelerinin içinde, tür parametreleri
 * tür kontrolleri için kullanılamaz ve tür
 * parametrelerine (foo as T) tür dönüşümleri
 * kontrol edilmez. Tek istisna, gerçek tür
 * argümanları her çağrı yerinde satır içine
 * alınmış olan somutlaştırılmış tür parametrelerine
 * sahip satır içi işlevlerdir. Bu, tür parametreleri
 * için tür kontrollerini ve dönüşümlerini
 * etkinleştirir. Ancak, yukarıda açıklanan kısıtlamalar,
 * kontroller veya dönüşümler içinde kullanılan genel
 * tür örnekleri için hala geçerlidir. Örneğin, tür
 * kontrolünde arg T ise, arg genel bir türün örneğiyse,
 * tür argümanları hala silinir.
 */

//inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
//    if (first !is A || second !is B) return null
//    return first as A to second as B
//}
//
//val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)
//
//val stringToSomething = somePair.asPairOf<String, Any>()
//val stringToInt = somePair.asPairOf<String, Int>()
//val stringToList = somePair.asPairOf<String, List<*>>()
//
//// Derlenir ancak tür güvenliğini bozar!
//val stringToStringList = somePair.asPairOf<String, List<String>>()

/**
 * Unchecked Casts
 *
 * Foo gibi somut tip argümanları olan genel tiplere
 * yapılan tip dönüşümleri List<String> çalışma
 * zamanında kontrol edilemez.
 * Bu kontrol edilmemiş dönüşümler, tip güvenliğinin
 * üst düzey program mantığı tarafından ima edildiği
 * ancak derleyici tarafından doğrudan çıkarılamadığı
 * durumlarda kullanılabilir. Aşağıdaki örneğe bakın.
 */

//fun readDictionary(file: File): Map<String, *> = file.inputStream().use {
//    TO\DO("Read a mapping of strings to arbitrary elements.")
//}
//
//// Bu dosyaya `Int`li bir harita kaydettik
//val intsFile = File("ints.dictionary")
//
//// Uyarı: Denetlenmeyen dönüştürme: `Map<String, *>` to `Map<String, Int>`
//val intsDictionary: Map<String, Int> = readDictionary(intsFile) as Map<String, Int>

/**
 * Son satırdaki dönüşüm için bir uyarı görünür.
 * Derleyici bunu çalışma zamanında tam olarak
 * kontrol edemez ve haritadaki değerlerin Int
 * olduğuna dair hiçbir garanti vermez.
 *
 * Denetlenmemiş dönüşümlerden kaçınmak için
 * program yapısını yeniden tasarlayabilirsiniz.
 * Yukarıdaki örnekte, farklı türler için tür
 * güvenli uygulamalarla DictionaryReader<T> ve
 * DictionaryWriter<T> arayüzlerini kullanabilirsiniz.
 * Denetlenmemiş dönüşümleri çağrı sitesinden
 * uygulama ayrıntılarına taşımak için makul
 * soyutlamalar sunabilirsiniz. Genel variance'ın
 * doğru kullanımı da yardımcı olabilir.
 *
 * Genel işlevler için, somutlaştırılmış tür
 * parametrelerini kullanmak, arg gibi dönüşümleri
 * T denetlenmiş hale getirir, arg'ın türünün
 * silinen kendi tür argümanları olmadığı sürece.
 *
 * Denetlenmemiş dönüşüm uyarısı,
 * @Suppress("UNCHECKED_CAST") ile oluştuğu yerdeki
 * ifadeyi veya bildirimi açıklayarak bastırılabilir:
 */

//inline fun <reified T> List<*>.asListOfType(): List<T>? =
//    if (all { it is T })
//        @Suppress("UNCHECKED_CAST")
//        this as List<T> else
//        null

/**
 * UYARI: JVM'de: dizi tipleri (Array<Foo>) öğelerinin
 * silinen tipi hakkında bilgi tutar ve dizi tipine
 * yapılan tip dönüşümleri kısmen kontrol edilir: öğe
 * tipinin geçersizliği ve gerçke tip argümanları hala
 * silinir. Örneğin, foo'nun herhangi bir List<*> tutan
 * bir dizi olması durumunda, geçersiz olsun veya olmasın,
 * foo'nun Array<List<String>?> olarak dönüştürülmesi
 * başarılı olur.
 */

/**
 * Underscore Operator For Type Arguments
 *
 * Alt çizgi operatörü (_) tip argümanları için
 * kullanılabilir. Diğer tipler açıkça belirtildiğinde
 * argümanın tipini otomatik olarak çıkarmak için
 * kullanın:
 */

//abstract class SomeClass<T> {
//    abstract fun execute(): T
//}
//
//class SomeImplementation : SomeClass<String>() {
//    override fun execute(): String = "Test"
//}
//
//class OtherImplementation : SomeClass<Int>() {
//    override fun execute(): Int = 42
//}
//
//object Runner {
//    inline fun <reified S : SomeClass<T>, T> run(): T {
//        return S::class.java.getDeclaredConstructor().newInstance().execute()
//    }
//}
//
//fun main() {
//    // T, SomeImplementation'ın SomeClass<String>'den
//    // türetilmesi nedeniyle String olarak çıkarılır
//    val s = Runner.run<SomeImplementation, _>()
//    assert(s == "Test")
//
//    // T, Int olarak çıkarılır çünkü OtherImplementation,
//    // SomeClass<Int>'den türetilir
//    val n = Runner.run<OtherImplementation, _>()
//    assert(n == 42)
//}