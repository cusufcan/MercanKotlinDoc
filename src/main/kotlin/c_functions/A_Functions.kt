package c_functions

/**
 * Functions
 *
 * Kotlin fonksiyonları fun anahtar sözcüğü kullanılarak
 * tanımlanır:
 */

//fun double(x: Int): Int {
//    return 2 * x
//}

/**
 * Function Kullanımı
 *
 * Fonksiyonlar standart yaklaşım kullanılarak çağrılır:
 */

//fun double(x: Int): Int {
//    return 2 * x
//}
//
//val result = double(2)

/**
 * Üye fonksiyonlarını çağırmak nokta gösterimini
 * kullanır:
 */

//class Stream {
//    fun read() {}
//}
//
//fun main() {
//    Stream().read() // Stream sınıfının örneğini oluştur ve read()'i çağır
//}

/**
 * Parametreler
 *
 * Fonksiyon parametreleri Pascal gösterimi kullanılarak
 * tanımlanır (name: type). Parametreler virgülle ayrılır
 * ve her parametrenin açıkça yazılması gerekir:
 */

//fun powerOf(number: Int, exponent: Int): Int { /*...*/ }

/**
 * Fonksiyon parametrelerini bildirirken son virgül
 * kullanabilirsiniz:
 */

//fun powerOf(
//    number: Int,
//    exponent: Int, // son virgül
//) { /*...*/ }

/**
 * Varsayılan Argümanlar
 *
 * İşlev parametreleri, karşılık gelen argümanı
 * atladığınızda kullanılan varsayılan değerlere
 * sahip olabilir. Bu, aşırı yükleme sayısını
 * azaltır:
 */

//fun read(
//    b: ByteArray,
//    off: Int = 0,
//    len: Int = b.size,
//) { /*...*/ }

/**
 * Türe = eklenerek varsayılan bir değer ayarlanır.
 *
 * Geçersiz kılma yöntemleri her zaman temel yöntemin
 * varsayılan parametre değerlerini kullanır.
 * Varsayılan parametre değerlerine sahip bir yöntemi
 * geçersiz kılarken, varsayılan parametre değerleri
 * imzadan çıkarılmalıdır:
 */

//open class A {
//    open fun foo(i: Int = 10) { /*...*/ }
//}
//
//class B : A() {
//    override fun foo(i: Int) { /*...*/ } // Varsayılan değere izin verilmez.
//}

/**
 * Varsayılan bir parametre, varsayılan değeri olmayan
 * bir parametreden önce geliyorsa, varsayılan değer
 * yalnızca adlandırılmış argümanlarla fonksiyonu çağırarak
 * kullanılabilir:
 */

//fun foo(
//    bar: Int = 0,
//    baz: Int,
//) { /*...*/ }
//
//fun main() {
//    foo(baz = 1) // Varsayılan değer bar = 0 kullanılır
//}

/**
 * Varsayılan parametrelerden sonraki son argüman bir
 * lambda ise, bunu adlandırılmış bir argüman olarak
 * veya parantez dışında geçirebilirsiniz:
 */

//fun foo(
//    bar: Int = 0,
//    baz: Int = 1,
//    qux: () -> Unit,
//) { /*...*/ }
//
//fun main() {
//    foo(1) { println("hello") } // Varsayılan değer baz = 1'i kullanır
//    foo(qux = { println("hello") }) // bar = 0, baz = 1 varsayılan değerlerini kullanır
//    foo { println("hello") } // bar = 0, baz = 1 varsayılan değerlerini kullanır
//}

/**
 * Named Arguments
 *
 * Bir fonksiyonu çağırırken bir veya daha fazla
 * argümanını adlandırabilirsiniz. Bu, bir fonksiyonun
 * çok sayıda argümanı olduğunda ve bir argümanla
 * bir değer ilişkilendirmek zor olduğunda, özellikle
 * de bir boolean veya null değeriyse, yardımcı
 * olabilir.
 *
 * Bir fonksiyon çağrısında adlandırılmış argümanlar
 * kullandığınızda, listelendikleri sırayı özgürce
 * değiştirebilirsiniz. Varsayılan değerlerini
 * kullanmak istiyorsanız, bu argümanları tamamen
 * dışarıda bırakabilirsiniz.
 *
 * Varsayılan değerlere sahip 4 argümanı olan reformat()
 * fonksiyonunu düşünün.
 */

//fun reformat(
//    str: String,
//    normalizeCase: Boolean = true,
//    upperCaseFirstLetter: Boolean = true,
//    divideByCamelHumps: Boolean = false,
//    wordSeperator: Char = ' ',
//) { /*...*/ }

/**
 * Bu fonksiyonu çağırırken tüm argümanlarını isimlendirimeniz
 * gerekmez:
 */

//fun reformat(
//    str: String,
//    normalizeCase: Boolean = true,
//    upperCaseFirstLetter: Boolean = true,
//    divideByCamelHumps: Boolean = false,
//    wordSeperator: Char = ' ',
//) { /*...*/
//}
//
//fun main() {
//    reformat(
//        "String!",
//        false,
//        upperCaseFirstLetter = false,
//        divideByCamelHumps = true,
//        '_'
//    )
//}

/**
 * Varsayılan değerlere sahip olanların hepsini
 * atlayabilirsiniz:
 */

//fun reformat(
//    str: String,
//    normalizeCase: Boolean = true,
//    upperCaseFirstLetter: Boolean = true,
//    divideByCamelHumps: Boolean = false,
//    wordSeperator: Char = ' ',
//) { /*...*/ }
//
//fun main() {
//    reformat("This is a long String!")
//}

/**
 * Ayrıca, tümünü atlamak yerine, varsayılan değerlere
 * sahip belirli argümanları atlayabilirsiniz. Ancak,
 * atlanan ilk argümandan sonra, sondaki tüm argümanları
 * adlandırmalısınız:
 */

//fun reformat(
//    str: String,
//    normalizeCase: Boolean = true,
//    upperCaseFirstLetter: Boolean = true,
//    divideByCamelHumps: Boolean = false,
//    wordSeperator: Char = ' ',
//) { /*...*/ }
//
//fun main() {
//    reformat(
//        "This is a short String!",
//        upperCaseFirstLetter = false,
//        wordSeperator = '_',
//    )
//}

/**
 * Spread operatörünü kullanarak değişken sayıda
 * argümanı (vararg) isimlerle geçirebilirsiniz:
 */

//fun foo(vararg strings: String) { /*...*/ }
//
//fun main() {
//    foo(strings = *arrayOf("a", "b", "c"))
//}

/**
 * UYARI: JVM'de Java fonksiyonlarını çağırırken
 * adlandırılmış argüman sözdizimini kullanamazsınız
 * çünkü Java bayt kodu her zaman fonksiyon
 * parametrelerinin adlarını korumaz.
 */

/**
 * Unit-Returning Functions
 *
 * Bir fonksiyon yararlı bir değer döndürmezse,
 * dönüş tipi Unit'tir. Unit, yalnızca bir değere
 * sahip bir tiptir (Unit). Bu değerin açıkça
 * döndürülmesi gerekmez:
 */

//fun printHello(name: String?): Unit {
//    if (name != null)
//        println("Hello $name")
//    else
//        println("Hit there!")
//    // `return Unit` veya `return` isteğe bağlıdır
//}

/**
 * Birim dönüş tipi bildirimi de isteğe bağlıdır.
 * Yukarıdaki kod şuna eşdeğerdir:
 */

//fun printHello(name: String?) { /*...*/ }

/**
 * Single-Expression Functions
 *
 * Fonksyion gövdesi tek bir ifadeden oluşuyorsa,
 * süslü parantezler atlanabilir ve gövde =
 * simgesinden sonra beirtilebilir:
 */

//fun double(x: Int): Int = x * 2

/**
 * Derleyici tarafından çıkarılabildiğinde dönüş
 * türünü açıkça belirtmek isteğe bağlıdır:
 */

//fun double(x: Int) = x * 2

/**
 * Explicit Return Types
 *
 * Blok gövdeli işlevler, Unit döndürmeleri
 * amaçlanmadığı sürece her zaman dönüş tiplerini
 * açıkça belirtmelidir; bu durumda dönüş tipini
 * belirtmek isteğe bağlıdır.
 *
 * Kotlin, blok gövdeli işlevler için dönüş tiplerini
 * çıkarsamaz çünkü bu tür işlevlerin gövdesinde
 * karmaşık bir kontorl akışı olabilir ve dönüş tipi
 * okuyucu (ve bazen derleyici) için açık olmayacktır.
 */

/**
 * Değişken Sayıda Argüman (varargs)
 *
 * Bir fonksiyonun parametresini (genellikle sonuncusunu)
 * vararg değiştiricisi ile işaretleyebilirsiniz:
 */

//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) // ts is an Array
//        result.add(t)
//    return result
//}

/**
 * Bu durumda fonksiyona değişken sayıda argüman
 * geçirebilirsiniz:
 */

//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) // ts is an Array
//        result.add(t)
//    return result
//}
//
//fun main() {
//    val list = asList(1, 2, 3)
//}

/**
 * Bir fonksiyonun içinde, T türünde bir vararg
 * parametresi yukarıdaki örnekte olduğu gibi, ts
 * değişkeninin Array<out T> türünde olduğu gibi,
 * T dizisi olarak görünür.
 *
 * Yalnızca bir parametre vararg olarak işaretleneebilir.
 * Bir vararg parametresi listedeki son parametre
 * değilse, sonraki parametreler için değerler
 * adlandırılmış argüman sözdizimii kullanılarak
 * veya parametre bir fonksiyon türüne sahipse,
 * parantezlerin dışında bir lambda geçirilerek
 * geçirilebilir.
 *
 * Bir vararg fonksiyonunu çağırdığınızda, argümanları
 * tek tek geçirebilirsiniz, örneğin asList(1, 2, 3).
 * Zaten bir diziniz varsa ve içeriğini fonksiyona
 * geçirmek istiyorsanız, spread operatörünü kullanın
 * (dizinin önüne * ekleyin):
 */

//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) // ts is an Array
//        result.add(t)
//    return result
//}
//
//fun main() {
//    val a = arrayOf(1, 2, 3)
//    val list = asList(-1, 0, *a, 4)
//}

/**
 * Yalnızca bir parametre vararg olarak işaretlenebilir.
 * Bir vararg parametresi listesinde son parametre yoksa,
 * sonraki etki için değerler olarak adlandırılan
 * parametreler sözdizimi yöntemi veya parametre bir
 * fonksiyon tipine sahipse, parantezlerin hedefi bir
 * lambda geçirilerek geçirilebilir.
 */

//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) // ts is an Array
//        result.add(t)
//    return result
//}
//
//fun main() {
//    val a = intArrayOf(1, 2, 3) // IntArray is a primitive type array
//    val list = asList(-1, 0, *a.toTypedArray(), 4)
//}

/**
 * Infix Notation
 *
 * Infix anahtar sözüğüyle işaretlenen işlevler, infix
 * gösterimi kullanılarak da çağrılabilir (çağrı için
 * nokta ve parantezleri atlayarak). Infix işlevleri
 * aşağıdaki gereksinimleri karşılamalıdır:
 *
 * - Üye işlevleri veya uzantı işlevleri olmalıdır.
 * - Tek bir parametreye sahip olmalıdır.
 * - Parametre değişken sayıda argüman kabul etmemeli
 * ve varsayılan değere sahip olmamalıdır.
 */

//infix fun Int.shl(x: Int): Int { /*...*/ }
//
//fun main() {
//    // fonksiyonu infix gösterimini kullanarak çağırma
//    1 shl 2
//
//    // aynıdır
//    1.shl(2)
//}

/**
 * UYARI: Infix fonksiyn çağrıları aritmetik
 * operatörlerden, tür dönüştürmelerinden ve
 * rangeTo operatöründen daha düşük önceliğe
 * sahiptir. Aşağıdaki ifadeler eşdeğerdir:
 *
 * - 1 shl 2 + 3, 1 shl (2 + 3)'e eşdeğerdir
 * - 0 until n * 2, 0 until (n * 2)'ye eşdeğerdir
 * - xs union ys as Set<*>, xs union (ys as Set<*>)'ne eşdeğerdir
 *
 * Öte yandan, bir infix fonksiyon çağrısının
 * önceliği, && ve ||, is (ve in-checks) ve
 * diğer bazı operatörlerden daha yüksektir.
 * Bu ifadeler de eşdeğerdir:
 *
 * - a && b xor c, a && (b xor c)'ye eşdeğerdir
 * - a xor b in c, (a xor b) in c'ye eşdeğerdir
 */

/**
 * Infix fonksiyonlarının her zaman hem alıcının
 * hem de parametrenin belirtilmesi gerektirdiğini
 * unutmayın. Infix gösterimini kullanarak geçerli
 * alıcıda bir yöntemi çağırdığınızda, bunu açıkça
 * kullanın. Bu, belirsiz olmayan ayrıştırmayı
 * sağlamak için gereklidir.
 */

//class MyStringCollection {
//    infix fun add(s: String) { /*...*/ }
//
//    fun build() {
//        this add "abc" // Correct
//        add("abc") // Correct
//        //add "abc" // Incorrect: alıcı belirtilmelidir
//    }
//}

/**
 * Function Scope
 *
 * Kotlin fonksiyonları bir dosyada en üst düzeyde
 * bildirilebilir, yani bir fonksiyonu tutmak için
 * bir sınıf oluşturmanız gerekmez, Java, C# ve Scala
 * (en üst düzey tanımlama Scala 3'ten beri mevcuttur)
 * gibi dillerde bunu yapmanız gerekir. En üst düzey
 * fonksiyonlara ek olarak, Kotlin fonksiyonları yerel
 * olarak üye fonksiyonlar ve uzantı fonksiyonları
 * olarak da bildirilebilir.
 */

/**
 * Local Functions
 *
 * Kotlin, diğer fonksiyonların içindeki diğer
 * fonksiyonlar olan yerel fonksiyonları destekler:
 */

//data class Graph(val vertices: List<Vertex>)
//data class Vertex(val neighbors: List<Vertex>)
//
//fun dfs(graph: Graph) {
//    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
//        if (!visited.add(current)) return
//        for (v in current.neighbors)
//            dfs(v, visited)
//    }
//
//    dfs(graph.vertices[0], HashSet())
//}

/**
 * Yerel bir fonksiyon dış fonksiyonların yerel
 * değişkenlerine erişebilir (kapanış). Yukarıdaki
 * durumda, visited yerel bir değişken olabilir:
 */

//data class Graph(val vertices: List<Vertex>)
//data class Vertex(val neighbors: List<Vertex>)
//
//fun dfs(graph: Graph) {
//    val visited = HashSet<Vertex>()
//    fun dfs(current: Vertex) {
//        if (!visited.add(current)) return
//        for (v in current.neighbors)
//            dfs(v)
//    }
//
//    dfs(graph.vertices[0])
//}

/**
 * Member Functions
 *
 * Üye fonksiyon, bir sınıf veya nesnenin içinde
 * tanımlanmış bir fonksiyondur:
 */

//class Sample {
//    fun foo() {
//        println("Foo")
//    }
//}

/**
 * Üye fonksiyonları nokta gösterimi ile çağrılır:
 */

//class Sample {
//    fun foo() {
//        println("Foo")
//    }
//}
//
//fun main() {
//    Sample().foo() // Sample sınıfının örneğini oluşturur ve foo'yu çağırır
//}

/**
 * Generic Functions
 *
 * Fonksiyonlar, fonksiyon adından önce açılı
 * parantezler kullanılarak belirtilen genel
 * parametrelere sahip olabilir:
 */

//fun<T> singletonList(item: T): List<T> { /*...*/ }

/**
 * Tail Recursive Functions
 *
 * Kotlin, tail recursiiion olarak bilinen bir
 * fonksiyonel programlama stilini destekler.
 * Normalde döngüler kullanacak bazı algoritmalar
 * için, yığın taşması riski olmadan bunun yerine
 * recursive bir fonksiyon kullanabilirsiniz.
 * Bir fonksiyon tailrec değiştiricisi ile
 * işaretlendiğinde ve gerekli resmi koşulları
 * karşıladığında, derleyici recursion'ı optimize
 * eder ve bunun yerine hızlı ve verimli bir döngü
 * tabanlı sürüm bırakır:
 */

//fun main() {
//    val eps = 1E-10 // "good enough", could be 10^-15
//
//    tailrec fun findFixPoint(x: Double = 1.0): Double =
//        if (abs(x - cos(x)) < eps) x else findFixPoint(cos(x))
//}

/**
 * Bu kod, matematiksel bir sabit olan kosinüsün
 * sabit noktasını hesaplar. Sonuç artık değişmeyene
 * kadar 1.0'dan başlayarak Math.cos'u tekrar tekrar
 * çağırır ve belirtilen eps hassasiyeti için
 * 0.7390851332151611 sonucunu berir. Ortaya çıkan
 * kod, bu daha geleneksel stile eşdeğerdir:
 */

//fun main() {
//    val eps = 1E-10 // "good enough", could be 10^-15
//
//    private fun findFixPoint(): Double {
//        var x = 1.0
//        while (true) {
//            val y = cos(x)
//            if (abs(x - y) < eps) return x
//            x = cos(x)
//        }
//    }
//}

/**
 * tailrec değiştiricisi için uygun olabilmek için,
 * bir fonksiyon gerçekleştirdiği son işlem olarak
 * kendisini çağırmalıdır. Tekrarlı çağrıdan sonra,
 * try/catch/finally blokları içinde veya açık
 * fonksiyonlarda daha fazla kod olduğunda tail
 * tekrarını kullanamazsınız. Şu anda, tail tekrarı
 * Kotlin tarafından JVM ve Kotlin/Native için
 * desteklenmektedir.
 */