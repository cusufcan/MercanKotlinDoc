package b_control_flow

/**
 * Exceptions
 *
 * İstisnalar, program yürütmeyi kesintiye uğratabilecek çalışma
 * zamanı hataları meydana geldiğinde bile kodunuzun daha
 * öngörülebilir bir şekilde çalışmasına yardımcı olur. Kotlin,
 * tüm istisnaları varsayıalan olarak kontrol edilmemiş olarak
 * ele alır. Kontrol edilmemiş istisnalar, istisna işleme
 * sürecini basitleştirir: istisnaları yakalayabilirsiniz,
 * ancak bunları açıkça işlemeniz veya bildirmeniz gerekmez.
 *
 * İstisnalarla çalışma iki temel eylemden oluşur:
 *
 * - Throwing exceptions: Bir sorun oluştuğunda belirtin.
 * - Catching exceptions: Sorunu çözerek veya geliştiriciye
 * veya uygulama kullanıcısına bildirerek beklenmeyen
 * istisnayı manuel olarak işleyin.
 *
 * İstisnalar, Throwable sınıfının bir alt sınıfı olan
 * Exception sınıfının alt sınıfları tarafından temsil edilir.
 * Exception açık bir sınıf olduğundan, uygulamanızın özel
 * ihtiyaçlarına uyacak şekilde özel istisnalar oluşturabilirsiniz.
 */

/**
 * Throw Exceptions
 *
 * throw anahtar sözcüğüyle istisnaları manuel olarak atabilirsiniz.
 * Bir istisna atmak, kodda beklenmeyen bir çalışma zamanı hatası
 * oluştuğunu gösterir. İstisnalar nesnelerdir ve bir istisna
 * atmak, bir istisna sınıfının örneğini oluşturur.
 *
 * Herhangi bir parametre olmadan bir istisna atabilirsiniz:
 */

//fun main() {
//    throw IllegalArgumentException()
//}

/**
 * Sorunun kaynağını daha iyi anlamak için özel bir mesaj
 * ve orijinal neden gibi ek bilgiler ekleyin:
 */

//fun demo(userInput: Int) {
//    val cause = IllegalStateException("Original cause: illegal state")
//
//    // userInput negatifse bir IllegalArgumentException fırlatır
//    // Ek olarak, IllegalStateException nedeniyle temsil edilen orijinal nedeni gösterir
//    if (userInput < 0) {
//        throw IllegalArgumentException("Input must be non-negative", cause)
//    }
//}

/**
 * Bu örnekte, kullanıcı negatif bir değer girdiğinde bir
 * IllegalArgumentException fırlatılır. Özel hata iletileri
 * oluşturabilir ve istisnanın orijinal nedenini (cause)
 * tutabilirsiniz; bu, yığın izine dahil edilecektir.
 */

/**
 * Ön Koşul Fonksiyonlarıyla İstisnaları Fırlatın
 *
 * Kotlin, ön koşul işlevlerini kulllanarak istisnaları
 * otomatik olarak fırlatmanın ek yollarını sunar. Ön
 * koşul işlevleri şunları içerir:
 *
 * require() -> Kullanıcı girişinin geçerliliği -> IllegalArgumentException
 * check() -> Nesne veya değişken durum geçerliliği -> IllegalStateException
 * error() -> Yasadışı bir durum veya koşul -> IllegalStateException
 *
 * Bu işlevler, belirli koşullar karşılanmazsa programın
 * akışının devam edemediği durumlar için uygundur. Bu,
 * kodunuzu kolaylaştırır ve bu kontrollerin işlenmesini
 * verimli hale getirir.
 */

/**
 * require() function
 *
 * require() fonksiyonunu, fonksiyonun çalışması için
 * kritik öneme sahip olduklarında ve bu argümanlar
 * geçersizse fonksiyon devam edemediğinde giriş
 * argümanlarını doğrulamak için kullanın.
 *
 * require()'deki koşul karşılanmazsa, bir
 * IllegalArgumentException fırlatır
 */

//fun getIndices(count: Int): List<Int> {
//    require(count >= 0)
//    return List(count) { it + 1 }
//}
//
//fun main() {
//    // Bu, IllegalArgumentException ile başarısız olur
//    println(getIndices(-1))
//
//    // Çalışan bir örnek görmek için aşağıdaki satırın yorumunu kaldırın
//    // println(getIndices(3))
//    // [1, 2, 3]
//}

/**
 * NOT: require() fonksiyonu derleyicinin akıllı
 * dönüşüm gerçekleştirmesini sağlar. Başarılı bir
 * denetimden sonra değişken otomatik olarak boş
 * bırakılamaz bir türe dönüştürülür. Bu fonksiyonlar
 * genellikle değişkenin devam etmeden önce boş
 * olmadığından emin olmak için boş bırakılabilirlik
 * denetimleri için kullanılır. Örneğin:
 */

//fun printNonNullString(str: String?) {
//    // Nullability check
//    require(str != null)
//    // Bu başarılı kontrolden sonra, str'nin null olmaması garanti
//    // edilir ve otomatik olarak null edilemeyen Strin'e akıllıca dönüştürülür
//    println(str.length)
//}

/**
 * check() function
 *
 * check() fonksiyonunu bir nesnenin veya değişkenin
 * durumunu doğrulamak için kullanın. Kontrol başarısız
 * olursa, ele alınması gereken bir mantık hatası
 * olduğunu gösterir.
 *
 * check() fonksiyonunda belirtilen koşul yanlışsa,
 * bir IllegalStateException fırlatır:
 */

//fun main() {
//    var someState: String? = null
//
//    fun getStateValue(): String {
//        val state = checkNotNull(someState) { "State must be set beforehand!" }
//        check(state.isNotEmpty()) { "State must be non-empty!" }
//        return state
//    }
//    // Aşağıdaki satırın yorumun kaldırırsanız program
//    // IllegalStateException ile başarısız olur
//    // getStateValue()
//
//    someState = ""
//
//    // Aşağıdaki satırın yorumun kaldırırsanız program
//    // IllegalStateException ile başarısız olur
//    // getStateValue()
//    someState = "non-empty-state"
//
//    // "non-empty-state yazdırır
//    println(getStateValue())
//}

/**
 * NOT: check() fonksiyonu derleyicinin akıllı dönüşüm
 * gerçekleştirmesini sağlar. Başarılı bir denetimden
 * sonra değişken otomatik olarak boş bırakılamaz bir
 * türe dönüştürülür. Bu fonksiyonlar genellikle
 * değişkenin devam etmeden önce boş olmadığından
 * emin olmak için boş bırakılabilirlik denetimleri
 * için kullanılır. Örneğin:
 */

//fun printNonNullString(str: String?) {
//    // Nullability check
//    check(str != null)
//    // Bu başarılı kontrolden sonra, str'nin null olmaması garanti
//    // edilir ve otomatik olarak null edilemeyen Strin'e akıllıca dönüştürülür
//    println(str.length)
//}

/**
 * error() function
 *
 * error() fonksiyonu, mantıksal olarak gerçekleşmemesi
 * gereken yasa dışı bir durumu veya koddaki bir koşulu
 * belirtmek için kullanılır. Kodunuzda kasıtlı olarak
 * bir istisna atmak istediğiniz senaryolar için uygundur,
 * örneğin kod beklenmeyen bir durumla karşılaştığında.
 * Bu fonksiyon, özellikle when ifadelerinde kullanışlıdır
 * ve mantıksal olarak gerçekleşmemesi gereken durumları
 * ele almanın net bir yolunu sağlar.
 *
 * Aşağıdaki örnekte, error() fonksiyonu tanımsız bir
 * kullanıcı rolünü ele almak için kullanılır. Rol
 * önceden tanımlanmış olanlardan biri değilse, bir
 * IllegalStateException atılır:
 */

//class User(val name: String, val role: String)
//
//fun processUserRole(user: User) {
//    when (user.role) {
//        "admin" -> println("${user.name} is an admin.")
//        "editor" -> println("${user.name} is an editor.")
//        "viewer" -> println("${user.name} is an viewer.")
//        else -> error("Undefined role: ${user.role}")
//    }
//}
//
//fun main() {
//    // Beklendiği gibi çalışır
//    val user1 = User("Alice", "admin")
//    processUserRole(user1)
//    // Alice is an admin.
//
//    // Bu bir IllegalStateException fırlatır
//    val user2 = User("Bob", "guest")
//    processUserRole(user2)
//}

/**
 * Handle Exceptions Using try-catch Blocks
 *
 * Bir istisna atıldığında, programın normal yürütülmesini
 * kesintiye uğratır. Programınızı kararlı tutmak için try
 * ve catch anahtar sözcükleriyle istisnaları zarif bir
 * şekilde işleyebilirsiniz. Try bloğu, bir istisna
 * atabilecek kodu içerirken, catch bloğu, istisna meydana
 * gelirse onu yakalar ve işler. İstisna, belirli türüyle
 * veya istisnanın bir üst sınıfıyla eşleşen ilk catch
 * bloğu tarafından yakalanır.
 *
 * Try ve catch anahtar kelimelerini birlikte nasıl
 * kullanabileceğiniz aşağıda açıklanmıştır:
 */

//fun main() {
//    try {
//        // Bir istisna fırlatabilecek kod
//    } catch (e: Exception) {
//        // İstisnayı işlemek için kod
//    }
//}

/**
 * Try-catch'i bir ifade olarak kullanmak yaygın bir
 * yaklaşımdır, böylece try bloğundan veya catch
 * bloğundan bir değer döndürebilir:
 */

//fun main() {
//    val num: Int = try {
//        // Eğer count() başarıyla tamamlanırsa, dönüş değeri num'a atanır
//        count()
//    } catch (e: ArithmeticException) {
//        // Eğer count() bir istisna atarsa, catch bloğu -1 döndürür,
//        // bu num'a atanır
//        -1
//    }
//    println("Result: $num")
//}
//
//// ArithmeticException fırlatabilecek bir fonksiyonu simüle eder
//fun count(): Int {
//    // Bu değeri, num'dan farklı bir değer döndürecek şekilde değiştirin
//    val a = 0
//    return 10 / a
//}

/**
 * Aynı try bloğu için birden fazla catch işleyicisi
 * kullanabilirsiniz. Farklı istisnaları belirgin
 * şekilde işlemek için gerektiği kadar çok catch
 * bloğu ekleyebilirsiniz. Birden fazla catch bloğunuz
 * olduğunda, bunları en spesifik istisnadan en az
 * spesifik istisnaya doğru sıralamanız önemlidir;
 * kodunuzda yukarıdan aşağıya bir sıralama izlersiniz.
 * Bu sıralama, programın yürütme akışıyla uyumludur.
 *
 * Özel istisnalarla bu örneği ele alın:
 */

//open class WithdrawalException(message: String) : Exception(message)
//class InsufficientFundsException(message: String) : WithdrawalException(message)
//
//fun processWithdrawal(amount: Double, availableFunds: Double) {
//    if (amount > availableFunds) {
//        throw InsufficientFundsException("Insufficient funds for the withdrawal.")
//    }
//    if (amount < 1 || amount % 1 != 0.0) {
//        throw WithdrawalException("Invalid withdrawal amount.")
//    }
//    println("Withdrawal processed")
//}
//
//fun main() {
//    val availableFunds = 500.0
//
//    // Farklı senaryoları test etmek için bu değeri değiştirin
//    val withdrawalAmount = 500.5
//
//    try {
//        processWithdrawal(withdrawalAmount.toDouble(), availableFunds)
//        // Catch bloklarının sırası önemlidir!
//    } catch (e: InsufficientFundsException) {
//        println("Caught an InsufficientFundsException: ${e.message}")
//    } catch (e: WithdrawalException) {
//        println("Caught a WithdrawalException: ${e.message}")
//    }
//}

/**
 * WithdrawalException'ı işleyen genel bir yakalama bloğu,
 * InsufficientFundsException gibi belirli istisnalar da
 * dahil olmak üzere, daha belirli bir yakalama bloğu
 * tarafından daha erken yakalanmadıkları sürece, kendi
 * türündeki tüm istisnaları yakalar.
 */

/**
 * The Finally Block
 *
 * Finally bloğu, try bloğunun başarıyla tamamlanması veya
 * bir istisna oluşturması fark etmeksizin her zaman
 * yürütülen kodu içerir. Finally bloğuyla, try ve catch
 * bloklarının yürütülmesinden sonra kodu temizleyebilirsiniz.
 * Bu, özellikle dosyalar veya ağ bağlantıları gibi kaynaklarla
 * çalışırken önemlidir, çünkü finally bunların düzgün bir
 * şekilde kapatılmasını veya serbest bırakılmasını garanti eder.
 *
 * Try-catch-finally bloklarını birlikte kullanmanın tipik yolu
 * şöyledir:
 */

//fun main() {
//    try {
//        // Bir istisna fırlatabilecek kod
//    } catch (e: Exception) {
//        // İstisna işleyicisi
//    } finally {
//        // Her zaman yürütülen kod
//    }
//}

/**
 * Bir try ifadesinin döndürülen değeri, try ve catch
 * bloğundaki son yürütülen ifade tarafından belirlenir.
 * Hiçbir istisna oluşmazsa, sonuç try bloğundan gelir;
 * bir istisna işlenirse, catch bloğundan gelir. Finally
 * bloğu her zaman yürütülür, ancak try-catch bloğunun
 * sonucunu değiştirmez.
 *
 * Bunu göstermek için bir örneğe bakalım:
 */

//fun divideOrNull(a: Int): Int {
//    // Try bloğu her zaman yürütülür
//    // Burada bir istisna (sıfıra bölme) anında catch bloğuna atlamaya neden olur
//    try {
//        val b = 44 / a
//        println("try block: Executing division: $b")
//        return b
//    }
//    // ArithmeticException (a ==0 ise sıfıra bölme) nedeniyle catch bloğu yürütülür
//    catch (e: ArithmeticException) {
//        println("catch block: Encountered ArithmeticException $e")
//        return -1
//    } finally {
//        println("finally block: The finally block is always executed")
//    }
//}
//
//fun main() {
//    // Farklı bir sonuç elde etmek için bu değeri değiştirin.
//    // Bir ArithmeticException şunu döndürecektir: -1
//    divideOrNull(0)
//}

/**
 * NOT: Kotlin'de, FileInputStream veya FileOutputStream
 * gibi dosya akışları gibi AutoClosable arayüzünü uygulayan
 * kaynakları yönetmenin deyimsel yolu .use() işlevini
 * kullanmaktır.
 */

//fun main() {
//    FileWriter("test.txt").use { writer ->
//        writer.write("some text")
//        // Bu bloktan sonra, .use fonksiyonu otomatik olarak
//        // writer.close()'u çağırır, bu da finally bloğuna benzer
//    }
//}

/**
 * Eğer kodunuz istisnaları ele almadan kaynak temizliği
 * gerektiriyorsa, try'i finally bloğu ile catch blokları
 * olmadan da kullanabilirsiniz:
 */

//fun demo(resource: FileWriter) {
//    try {
//        // Kaynağı kullanma girişimleri
//        resource.use { }
//    } finally {
//        // Bir istisna oluşsa bile kaynağın her zaman kapalı olduğundan emin olur
//        resource.close()
//    }
//
//    // Bir istisna atıldığında bu satır yazdırılmaz
//    println("End of the program")
//}

/**
 * Gördüğünüz gibi, finally bloğu bir istisna oluşsa bile
 * kaynağın kapalı olmasını garanti eder.
 *
 * Kotlin'de, özel ihtiyaçlarınıza bağlı olarak yalnızca
 * bir catch bloğu, yalnızca bir finally bloğu veya her
 * ikisini kullanma esnekliğine sahipsiniz, ancak bir try
 * bloğuna her zaman en az bir catch bloğu veya bir finally
 * bloğu eşlik etmelidir.
 */

/**
 * Create Custom Exceptions
 *
 * Kotlin'de, yerleşik Exception sınıfını genişleten sınıflar
 * oluşturarak özel istisnalar tanımlayabilirsiniz. Bu,
 * uygulamanızın ihtiyaçlarına göre uyarlanmış daha belirli
 * hata türleri oluşturmanıza olanak tanır.
 *
 * Bir tane oluşturmak için, Exception'ı genişleten bir sınıf
 * tanımlayabilirsiniz:
 */

//class MyException : Exception("My message")

/**
 * Bu örnekte varsayılan bir hata mesajı olan "My message"
 * bulunmaktadır, ancak isterseniz bunu boş bırakabilirsiniz.
 */

/**
 * Özel istisnalar, ArithmeticException alt sınıfı gibi
 * önceden var olan herhangi bir istisna alt sınıfının alt
 * sınıfı da olabilir:
 */

//class NumberTooLargeException : ArithmeticException("My message")

/**
 * NOT: Özel istisnaların alt sınıflarını oluşturmak istiyorsanız,
 * ana sınıfı açık olarak bildirmelisiniz çünkü sınıflar varsayılan
 * olarak sondur ve aksi takdirde alt sınıflara ayrılamazlar.
 *
 * Örneğin:
 */

// Özel bir istisnayı açık bir sınıf olarak bildirir ve onu
// alt sınıflara ayrılabilir hale getirir
//open class MyCustomException(message: String) : Exception(message)

// Özel istisnanın bir alt sınıfını oluşturur
//class SpecificCustomException : MyCustomException("Specific error message")

/**
 * Özel istisnalar tıpkı yerleşik istisnalar gibi davranır.
 * Bunları throw anahtar sözcüğünü kullanarak fırlatabilir
 * ve try-catch-finally bloklarıyla işleyebilirsiniz. Bunu
 * göstermek için bir örneğe bakalım:
 */

//class NegativeNumberException : Exception("Parameter is less than zero.")
//class NonNegativeNumberException : Exception("Parameter is a non-negative number.")
//
//fun myFunction(number: Int) {
//    if (number < 0) throw NegativeNumberException()
//    else if (number >= 0) throw NonNegativeNumberException()
//}
//
//fun main() {
//    // Bu fonksiyondaki değeri farklı bir istisna elde edecek şekilde değiştirin
//    myFunction(1)
//}

/**
 * Çeşitli hata senaryolarına sahip uygulamalarda, istisnaların
 * bir hiyerarşisini oluşturmak kodu daha açık ve daha spesifik
 * hale getirmeye yardımcı olabilir. Bunu, ortak istisna özellikleri
 * için bir temel olarak soyut bir sınıf veya mühürlü bir sınıf
 * kullanarak ve ayrıntılı istisna türleri için belirli alt sınıflar
 * oluşturarak başarabilirsiniz. Ek olarak, isteğe bağlı parametrelere
 * sahip özel istisnalar esneklik sunarak çeşitli mesajlarla
 * başlatmaya izin verir ve bu da daha ayrıntılı hata işlemeyi
 * mümkün kılar.
 *
 * Bir istisna hiyerarşisinin temeli olarak mühürlü AccountException
 * sınıfını ve isteğe bağlı parametrelerin gelişmiş istisna
 * ayrıntıları için kullanımını gösteren bir alt sınıf olan
 * APIKeyExpiredException sınıfını kullanan bir örneğe bakalım:
 */

// Hesapla ilgili hatalar için bir istisna hiyerarşisinin temeli
// olarak soyut bir sınıf oluşturur
//sealed class AccountException(
//    message: String, cause: Throwable? = null
//) : Exception(message, cause)
//
//// AccountException'ın bir alt sınıfını oluşturur
//class InvalidAccountCredentialsException : AccountException(
//    "Invalid account credentials detected"
//)
//
//// Özel iletilerin ve nedenlerin eklenmesine izin veren bir
//// AccountException alt sınıfı oluşturur
//class APIKeyExpiredException(
//    message: String = "API key expired", cause: Throwable? = null
//) : AccountException(message, cause)
//
//// Farklı sonuçlar elde etmek için yer tutucu işlevlerin değerlerini değiştirin
//fun areCredentialsValid(): Boolean = true
//fun isAPIKeyExpired(): Boolean = true

/**
 * The Nothing Type
 *
 * Kotlin'de her ifadenin bir türü vardır. throw IllegalArgumentException()
 * ifadesinin türü Nothing'dir, diğer tüm türlerin bir alt türü olan
 * ve aynı zamanda alt tür olarak da bilinen yerleşik bir türdür. Bu, tür
 * hatalarına neden olmadan Nothing'in herhangi bir başka türün beklendiği
 * bir dönüş türü veya genel tür olarak kullanılabileceği anlamına gelir.
 *
 * Nothing, Kotlin'de hiçbir zaman başarılı bir şekilde tamamlanmayan
 * işlevleri veya ifadeleri temsil etmek için kullanılan özel bir türdür.
 * Bu işlevler ya her zaman bir istisna oluşturur ya da sonsuz bir döngü
 * gibi sonsuz bir yürütme yoluna girer. Nothing'i henüz uygulanmamış
 * veya her zaman bir istisna oluşturmak üzere tasarlanmış işlevleri
 * işaretlemek için kullanabilir ve hem derleyiciye hem de kod
 * okuyucularına niyetinizi açıkça belirtebilirsiniz. Derleyici bir
 * işlev imzasında Nothing türü çıkarırsa sizi uyarır. Nothing'i dönüş
 * türü olarak açıkça tanımlamak bu uyarıyı ortadan kaldırabilir.
 *
 * Bu Kotlin kodu, derleyicinin işlev çağrısını izleyen kodu ulaşılamaz
 * olarak işaretlediği Nothing türünün kullanımını göstermektedir:
 */

//class Person(val name: String?)
//
//fun fail(message: String): Nothing {
//    throw IllegalArgumentException(message)
//    // Bu fonksiyon asla başarılı bir şekilde geri dönmeyecektir.
//    // Her zaman bir istisna fırlatacaktır.
//}
//
//fun main() {
//    // 'name' değeri null olan bir Person örneği oluşturur
//    val person = Person(name = null)
//
//    val s: String = person.name ?: fail("Name required")
//
//    // 's'nin bu noktada başlatılması garanti edilir
//    println(s)
//}

/**
 * Kotlin'in Nothing tipini kullanan TOD\O() fonksiyonu,
 * gelecekte uygulanması gereken kod alanlarını vurgulamak
 * için bir yer tutucu görevi görür:
 */

//fun notImplementedFunction(): Int {
//    TO\DO("This function is not yet implemented")
//}
//
//fun main() {
//    val result = notImplementedFunction()
//    // Bu bir NotImplementedError hatası verir
//    println(result)
//}

/**
 * Gördüğünüz gibi TOD\O() fonksiyonu her zaman
 * NotImplementedError istisnasını fırlatır.
 */

/**
 * Exception Classes
 *
 * Kotlin'de bulunan ve RuntimeException sınıfının alt
 * sınıfları olan bazı yaygın istisna türlerini inceleyelim:
 */

/**
 * - ArithmeticException: Bu istisna, sıfıra bölme gibi
 * bir aritmetik işlemin gerçekleştirilmesinin imkansız
 * olduğu durumlarda oluşur.
 */

//fun main() {
//    val example = 2 / 0 // throws ArithmeticException
//}

/**
 * - IndexOutOfBoundsException: Bu istisna, bir dizi veya
 * dize gibi bir dizinin aralık dışında olduğunu belirtmek
 * için atılır.
 */

//fun main() {
//    val myList = mutableListOf(1, 2, 3)
//    myList.removeAt(3)  // throws IndexOutOfBoundsException
//}

/**
 * UYARI: Bu istisnayı önlemek için getOrNull() fonksiyonu
 * gibi daha güvenli bir alternatif kullanın:
 */

//fun main() {
//    val myList = listOf(1, 2, 3)
//    // Returns null, instead of IndexOutOfBoundsException
//    val element = myList.getOrNull(3)
//    println("Element at index 3: $element")
//}

/**
 * - NoSuchElementException: Bu istisna, belirli bir
 * koleksiyonda bulunmayan bir öğeye erişildiğinde oluşur.
 * first(), last() veya elementAt() gibi belirli bir öğe
 * bekleyen yöntemler kullanıldığında oluşur.
 */

//fun main() {
//    val emptyList = listOf<Int>()
//    val firstElement = emptyList.first()  // throws NoSuchElementException
//}

/**
 * UYARI: Bu istisnayı önlemek için daha güvenli bir
 * alternatif, örneğin firstOrNull() fonksiyonunu
 * kullanabilirsiniz:
 */

//fun main() {
//    val emptyList = listOf<Int>()
//    // NoSuchElementException yerine null döndürür
//    val firstElement = emptyList.firstOrNull()
//    println("First element in empty list: $firstElement")
//}

/**
 * - NumberFormatException: Bu istisna, bir dizeyi
 * sayısal bir türe dönüştürmeye çalışırken oluşur,
 * ancak dizenin uygun bir biçimi yoktur.
 */

//fun main() {
//    val string = "This is not a number"
//    val number = string.toInt() // throws NumberFormatException
//}

/**
 * UYARI: Bu istisnayı önlemek için toIntOrNull()
 * fonksiyonu gibi daha güvenli bir alternatif kullanın:
 */

//fun main() {
//    val nonNumericString = "not a number"
//    // NumberFormatException yerine null döndürür
//    val number = nonNumericString.toIntOrNull()
//    println("Converted number: $number")
//}

/**
 * - NullPointerException: Bu istisna, bir uygulama null
 * değerine sahip bir nesne referansını kullanmaya çalıştığında
 * ortaya çıkar. Kotlin'in null güvenlik özellikleri
 * NullPointerExceptions riskini önemli ölçüde azaltsa da, bunlar
 * !! operatörünün kasıtlı kullanımıyla veya Kotlin'in null
 * güvenliğinden yoksun Java ile etkileşimde bulunulduğunda
 * yine de oluşabilir.
 */

//fun main() {
//    val text: String? = null
//    println(text!!.length) // throws a NullPointerException
//}

/**
 * Kotlin'de tüm istisnalar işaretlenmemiş olsa da ve bunları
 * açıkça yakalamanız gerekmese de, isterseniz onları yakalama
 * esnekliğine sahipsiniz.
 */

/**
 * Exception Hierarchy
 *
 * Kotlin istisna hiyerarşisinin kökü Throwable sınıfıdır.
 * İki doğrudan alt sınıfı vardır, Error ve Exception:
 *
 * - Error alt sınıfı, bir uygulamanın kendi başına
 * kurtaramayacağı ciddi temel sorunları temsil eder. Bunlar,
 * OutOfMemoryError veya StackOverflowError gibi genellikle
 * ele almaya çalışmayacağınız sorunlardır.
 *
 * - Exception alt sınıfı, işlemek isteyebileceğiniz koşullar
 * için kullanılır. RuntimeException ve IOException
 * (Input/Output Exception) gibi Exception türünün alt türleri,
 * uygulamalardaki istisnai olaylarla ilgilenir.
 */

/**
 * RuntimeException genellikle program kodundaki yetersiz
 * denetimlerden kaynaklanır ve programatik olarak önlenebilir.
 * Kotlin, NullPointerException gibi yaygın RuntimeException'ları
 * önlemeye yardımcı olur ve sıfıra bölme gibi olası çalışma
 * zamanı hataları için derleme zamanı uyarıları sağlar.
 */

/**
 * Stack Trace
 *
 * Yığın izi, hata ayıklama için kullanılan, çalışma zamanı
 * ortamı tarafından oluşturulan bir rapordur. Programda
 * belirli bir noktaya, özellikle bir hata veya istisnanın
 * meydana geldiği yere giden fonksiyon çağrılarının sırasını
 * gösterir.
 *
 * JVM ortamında bir istisna nedeniyle yığın izinin otomatik
 * olarak yazdırıldığı bir örneğe bakalım:
 */

//fun main() {
//    throw ArithmeticException("This is an arithmetic exception!")
//}

/**
 * Bu kodu bir JVM ortamında çalıştırmak aşağıdaki çıktıyı
 * üretir:
 *
 * Exception in thread "main" java.lang.ArithmeticException:
 * This is an arithmetic exception!
 *     at MainKt.main(Main.kt:3)
 *     at MainKt.main(Main.kt)
 *
 * İlk satır, aşağıdakileri içeren istisna açıklamasıdır:
 * - İstisna türü: java.lang.ArithmeticException
 * - Thread: main
 * - İstisna mesajı: "This is an arithmetic exception!"
 *
 * İstisna açıklamasından sonra at ile başlayan her bir
 * satır yığın izidir. Tek bir satıra yığın izi öğesi
 * veya yığın çerçevesi denir:
 * - at MainKt.main (Main.kt:3): Bu, yöntem adını
 * (MainKt.main) ve yöntemin çağrıldığı kaynak dosyasını
 * ve satır numarasını (Main.kt:3) gösterir.
 * - at MainKt.main (Main.kt): Bu, istisnanın Main.kt
 * dosyasının main() fonksiyonunda meydana geldiğini
 * gösterir.
 */