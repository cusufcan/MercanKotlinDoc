package b_control_flow

/**
 * If Expression
 *
 * Kotlin'de if bir ifadedir: bir değer döndürür. Bu nedenle,
 * ternary operator yoktur (koşul ? then : else) çünkü sıradan
 * if bu rolde iyi çalışır.
 */

//fun demo(a: Int, b: Int) {
//    var max = a
//    if (a < b) max = b
//
//    // With else
//    if (a > b) {
//        max = a
//    } else {
//        max = b
//    }
//
//    // As expression
//    max = if (a > b) a else b
//
//    // else if ifadesini ifadelerde de kullanabilirsiniz:
//    val maxLimit = 1
//    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b
//}

/**
 * Bir if ifadesinin dalları blok olabilir. Bu durumda, son ifade
 * bir bloğun değeridir:
 */

//fun demo(a: Int, b: Int) {
//    val max = if (a > b) {
//        println("Choose a")
//    } else {
//        println("Choose b")
//    }
//}

/**
 * Örneğin, if'i bir ifade olarak, değerini döndürmek veya bir
 * değişkene atamak için kullanıyorsanız, else dalı zorunludur.
 */

/**
 * When Expression
 *
 * when, birden fazla dalı olan koşullu bir ifade tanımlar. C
 * benzeri dillerdeki switch ifadesine benzer. Basit biçimi
 * şu şekildedir.
 */

//fun demo(x: Int) {
//    when (x) {
//        1 -> println("x == 1")
//        2 -> println("x == 2")
//        else -> {
//            println("x is neither 1 nor 2")
//        }
//    }
//}

/**
 * when, bazı dal koşulları karşılanana kadar argümanını tüm
 * dallara karşı sırayla eşleştirir.
 *
 * when hem bir expression hem de bir statement olarak
 * kullanılabilir. Bir expression olarak kullanılırsa, ilk
 * eşleşen dalın değeri genel ifadenin değeri olur. Bir
 * statement olarak kullanılırsa, bireysel dalların değerleri
 * göz ardı edilir. if'de olduğu gibi, her dal bir blok
 * olabilir ve değeri bloktaki son ifadenin değeridir.
 *
 * Diğer dallanma koşullarının hiçbiri sağlanmıyorsa else
 * dalı değerlendirilir.
 *
 * Eğer when bir expression olarak kullanılıyorsa, derleyici
 * tüm olası durumların dal koşullarıyla (örneğin enum sınıf
 * girişleri ve sealed sınıf alt türleri) kapsandığını
 * kanıtlayamadığı sürece else dalı zorunludur.
 */

//enum class Bit {
//    ZERO, ONE
//}
//
//val numericValue = when (getRandomBit()) {
//    Bit.ZERO -> 0
//    Bit.ONE -> 1
//}
//
//fun getRandomBit(): Bit {
//    val randomBit = (0..1).random()
//    return if (randomBit == 0) Bit.ZERO else Bit.ONE
//}

/**
 * When ifadelerinde else dalının kullanılması aşağıdaki
 * durumlarda zorunludur:
 *
 * when bir Boolean, enum veya sealed türünden bir
 * özneye veya bunların null olabilen karşılıklarına
 * sahipse.
 *
 * When'in dalları bu konu için tüm olası durumları
 * kapsamamaktaysa.
 */

//enum class Color {
//    RED, GREEN, BLUE
//}
//
//fun main() {
//    when (getColor()) {
//        Color.RED -> println("red")
//        Color.GREEN -> println("green")
//        Color.BLUE -> println("blue")
//        // 'else' gerekli değildir çünkü tüm durumlar kapsanmaktadır
//    }
//
//    when (getColor()) {
//        Color.RED -> println("red") // GREEN ve MAVI için kontrol yok
//        else -> println("not red") // 'else' gereklidir
//    }
//}
//
//fun getColor(): Color = Color.RED

/**
 * Birden fazla durum için ortak bir davranış tanımlamak
 * için, koşullarını virgül kullanarak tek bir satırda
 * birleştirin:
 */

//fun demo(x: Int) {
//    when (x) {
//        0, 1 -> println("x == 0 or x == 1")
//        else -> println("otherwise")
//    }
//}

/**
 * Dallanma koşulları olarak keyfi ifadeleri (sadece
 * sabitleri değil) kullanabilirsiniz
 */

//fun demo(x: Int, s: String) {
//    when (x) {
//        s.toInt() -> println("s encodes x")
//        else -> println("s does not encode x")
//    }
//}

/**
 * Ayrıca bir değerin bir aralıkta veya koleksiyonda olup
 * olmadığını da kontrol edebilirsiniz:
 */

//fun demo(x: Int, validNumbers: IntArray) {
//    when (x) {
//        in 1..10 -> println("x is in the range")
//        in validNumbers -> println("x is valid")
//        !in 10..20 -> println("x is outside the range")
//        else -> println("none of the above")
//    }
//}

/**
 * Başka bir seçenek de bir değerin belirli bir türde
 * olup olmadığını (is) veya (!is) olduğunu kontrol etmektir.
 * Akıllı tür dönüşümleri sayesinde, türün yöntemlerine
 * ve özelliklerine herhangi bir ek kontrol yapmadan
 * erişebileceğinizi unutmayın.
 */

//fun hasPrefix(x: Any) = when (x) {
//    is String -> x.startsWith("prefix")
//    else -> false
//}

/**
 * When, bir if-else if zincirinin yerine de kullanılabilir.
 * Eğer bir argüman sağlanmazsa, dallanma koşulları basitçe
 * boolean ifadeleridir ve bir dallanma, koşulu doğru
 * olduğunda yürütülür:
 */

//fun demo(x: Int, y: Int) {
//    when {
//        x.isOdd() -> println("x is odd")
//        y.isEven() -> println("y is even")
//        else -> println("x+y is odd")
//    }
//}
//
//// Sadece dökümantasyondaki örnekle uysun diye yazdım. BAKMA!
//fun Int.isOdd() = this % 2 != 0
//fun Int.isEven() = this % 2 == 0

/**
 * Aşağıdaki sözdizimini kullanarak bir değişkendeki özneyi
 * yakalayabilirsiniz:
 */

//interface Request
//class Success : Request {
//    fun getBody() = "body"
//}
//
//class HttpError(val status: String) : Request
//class HttpException(val status: String) : Throwable()
//
//fun executeRequest() = Success()
//
//fun Request.getBody() =
//    when (val response = executeRequest()) {
//        is Success -> response.getBody()
//        is HttpError -> throw HttpException(response.status)
//    }

/**
 * For Loops
 *
 * For döngüsü, bir yineleyici sağlayan her şeyi yineler.
 * Bu, C# gibi dillerdeki foreach döngüsüne eşdeğerdir.
 * For'un sözdizimi aşağıdaki gibidir:
 */

//fun demo(collection: List<Int>) {
//    for (item in collection) println(item)
//}

/**
 * for'un gövdesi bir blok olabilir.
 */

//fun demo(ints: List<Int>) {
//    for (item: Int in ints) {
//        // ...
//    }
//}

/**
 * Daha önce de belirtildiği gibi, for yineleyici sağlayan
 * her şeyin içinden geçer. Bu şu anlama gelir:
 *
 * Iterator<> döndüren bir üye veya uzantı işlevi iterator()'a
 * sahiptir, bu da:
 *      - bir üye veya uzantı işlevi next()'e sahiptir.
 *      - Boolean döndüren bir üye veya uzantı işlevi hasNext()'e
 *      sahiptir.
 *
 * Bu üç fonksiyonun hepsinin operatör olarak işaretlenmesi
 * gerekiyor.
 */

//fun main() {
//    for (i in 1..3) {
//        println(i)
//    }
//
//    for (i in 6 downTo 0 step 2) {
//        println(i)
//    }
//}

/**
 * Bir aralık veya dizi üzerindeki for döngüsü, yineleyici
 * nesnesi oluşturmayan indeks tabanlı bir döngüye derlenir.
 *
 * Bir dizi veya indeksli bir liste üzerinde yineleme yapmak
 * istiyorsanız bunu şu şekilde yapabilirsiniz:
 */

//fun demo(array: IntArray) {
//    for (i in array.indices) {
//        println(array[i])
//    }
//}

/**
 * Alternatif olarak withIndex kütüphane fonksiyonunu
 * kullanabilirsiniz:
 */

//fun demo(array: IntArray) {
//    for ((index, value) in array.withIndex()) {
//        println("the element at $index is $value")
//    }
//}

/**
 * While Loops
 *
 * while ve do-while döngüleri, koşulları sağlandığı sürece
 * gövdelerini sürekli olarak yürütürler. Aralarındaki fark,
 * koşul kontrol süresidir:
 *
 * while koşulu kontrol eder ve eğer koşul sağlanıyorsa
 * gövdeyi yürütür ve ardından koşul kontrolüne geri döner.
 *
 * do-while gövdeyi yürütür ve ardından koşulu kontrol eder.
 * Eğer karşılanırsa, döngü tekrar eder. Yani, do-while'ın
 * gövdesi koşuldan bağımsız olarak en az bir kere yürütülür.
 */

//fun demo() {
//    var x = 1
//    while (x > 0) {
//        x--
//    }
//
//    do {
//        val y = retrieveData()
//    } while (y != null) // Burada y görünüyor
//}
//
//fun retrieveData(): Unit? = null

/**
 * Break and Continue In Loops
 *
 * Kotlin döngülerde geleneksel break ve continue
 * operatörlerini destekler.
 */