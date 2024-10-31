package h_classes_and_objects

/**
 * Sealed Classes and Interfaces
 *
 * Mühürlü sınıflar ve arayüzler, sınıf hiyerarşilerinizin
 * kontrollü kalıtımını sağlar. Mühürlü bir sınıfın tüm
 * doğrudan alt sınıfları derleme zamanında bilinir.
 * Mühürlü sınıfın tanımlandığı modül ve paketin dışında
 * başka hiçbir alt sınıf görünemez. Aynı mantık mühürlü
 * arayüzler ve uygulamaları için de geçerlidir: mühürlü
 * bir arayüze sahip bir modül derlendiğinde, yeni
 * uygulamalar oluşturulamaz.
 */

/**
 * UYARI: Doğrudan alt sınıflar, üst sınıflardan hemen
 * miras alan sınıflardır.
 *
 * Dolaylı alt sınıflar, üst sınıflardan birden fazla
 * seviyeden miras alan sınıflarddır.
 */

/**
 * Mühürlü sınıfları ve arayüzleri when ifadesiyle
 * birleştirdiğinizde, tüm olası alt sınıfların
 * davranışını kapsayabilir ve kodunuzu olumsuz
 * yönde etkileyecek yeni alt sınıfların
 * oluşturulmamasını sağlayabilirsiniz.
 *
 * Mühür sınıflar, şu durumlarda en iyi şekilde
 * kullanılır:
 *
 * - Sınırlı sınıf kalıtımı isteniyorsa: Bir sınıfı
 * genişleten ve derleme zamanında bilinen, önceden
 * tanımlanmış, sonlu bir alt sınıf kümeniz varsa.
 * - Tür güvenli tasarım gereklidir: Projenizde
 * güvenlik ve desen eşleştirmesi çok önemlidir.
 * Özellikle durum yönetimi veya karmaşık koşullu
 * mantığın işlenmesi için.
 * - Kapalı API'lerle çalışma: Üçüncü taraf
 * istemcilerin API'leri amaçlandığı şekilde
 * kullanmasını sağlayan kütüphaneler için sağlam
 * ve sürdürülebilir genel API'ler istersiniz.
 */

/**
 * Declare A Sealed Class Or Interface
 *
 * Mühürlü bir sınıf veya arayüz bildirmek için,
 * sealed anahtar kelimesini kullanın:
 */

// Create a sealed interface
//sealed interface Error

// Create a sealed class that implements sealed interface Error
//sealed class IOError() : Error

// Define subclasses that extend sealed class 'IOError'
//class FileReadError(val file: File) : IOError()
//class DatabaseError(val source: DataSource) : IOError()

// Create a singleton object implementing the 'Error' sealed interface
//object RuntimeError : Error

/**
 * Bu örnek, kütüphane kullanıcılarının fırlatabileceği
 * hataları ele almasına izin veren hata sınıfları içeren
 * bir kütüphanenin API'sini temsil edebilir. Bu tür hata
 * sınıflarının hiyerarşisi, genel API'de görünen
 * arayüzleri veya soyut sınıfları içeriyorsa, diğer
 * geliştiricilerin bunları istemci kodunda uygulamasını
 * veya genişletmesini hiçbir şey engelleyemez. Kütüphane,
 * dışında bildirilen hataları bilmediğinden, bunları kendi
 * sınıflarıyla tutarlı bir şekilde ele alamaz. Ancak,
 * mühürlenmiş bir hata sınıfları hiyerarşisiyle, kütüphane
 * yazarları tüm olası hata türlerini bildiklerinden ve
 * diğer hata türlerinin daha sonra ortaya çıkamayacağından
 * emin olabilirler.
 */

/**
 * Constructors
 *
 * Mühürlenmiş bir sınıfın kendisi her zaman soyut bir
 * sınıftır ve sonuç olarak doğrudan örnekleştirilemez.
 * Ancak, oluşturucuları içerebilir veya miras alabilir.
 * Bu oluşturucular mühürlenmiş sınıfın kendisinin
 * örneklerini oluşturmak için değil, alt sınıfları
 * içindir. Error adlı mühürlenmiş bir sınıf ve
 * örnekleştirdiğimiz birkaç alt sınıfı olan aşağıdaki
 * örneği ele alalım:
 */

//sealed class Error(val message: String) {
//    class NetworkError : Error("Network failure")
//    class DatabaseError : Error("Database cannot be reached")
//    class UnknownError : Error("An unknown error has occured")
//}
//
//fun main() {
//    val errors = listOf(
//        Error.NetworkError(),
//        Error.DatabaseError(),
//        Error.UnknownError(),
//    )
//    errors.forEach { println(it.message) }
//}
// Network failure
// Database cannot be reached
// An unknown error has occurred

/**
 * Enum sabitlerini durumları temsil etmek ve ek
 * ayrıntılar sağlamak için kullanmak üzere mühürlü
 * sınıflarınız içinde enum sınıflarını kullanabilirsiniz.
 * Her enum sabiti yalnızca tek bir örnek olarak bulunurken,
 * mühürlü bir sınıfın alt sınıfları birden fazla örneğe
 * sahip olabilir. Örnekte, mühürlü sınıf Error ve birkaç
 * alt sınıfı, hata ciddiyetini belirtmek için bir enum
 * kullanır. Her alt sınıf oluşturucusu ciddiyeti başlatır
 * ve durumunu değiştirebilir:
 */

//enum class ErrorSeverity { MINOR, MAJOR, CRITICAL }
//
//sealed class Error(val severity: ErrorSeverity) {
//    class FileReadError(val file: File) : Error(ErrorSeverity.MAJOR)
//    class DatabaseError(val source: DataSource) : Error(ErrorSeverity.CRITICAL)
//    object RuntimeError : Error(ErrorSeverity.CRITICAL)
//    // Ek hata tipleri buraya eklenebilir
//}

/**
 * Mühürlü sınıfların oluşturucuları iki görünürlükten
 * birine sahip olabilir: protected (varsayılan olarak)
 * veya private:
 */

//sealed class IOError {
//    // Varsayılan olarak protected constructor. Burada ve alt sınıflarında görünür.
//    constructor() { /*...*/ }
//
//    // Sadece burada görünür.
//    private constructor(description: String) : this() { /*...*/ }
//}

/**
 * Inheritance
 *
 * Mühürlü sınıfların ve arayüzlerin doğrudan alt sınıfları
 * aynı pakette bildirilmelidir. Bunlar en üst düzeyde olabilir
 * veya herhangi sayıda başka adlandırılmış sınıf, adlandırılmış
 * arayüz veya adlandırılmış nesnenin içine yerleştirilebilir.
 * Alt sınıflar, Kotlin'deki normal miras kurallarıyla uyumlu
 * oldukları sürece herhangi bir görünürlüğe sahip olabilir.
 *
 * Mühürlü sınıfların alt sınıfları düzgün bir şekilde
 * nitelendirilmiş bir ada sahip olmalıdır. Yerel veya
 * anonim nesneler olamazlar.
 */

/**
 * UYARI: enum sınıfları mühürlü bir sınıfı veya başka bir
 * sınıfı genişletemez. Ancak mühürlü arayüzleri
 * uygulayabilirler:
 */

//sealed interface Error
//
//enum class ErrorType : Error {
//    FILE_ERROR, DATABASE_ERROR
//}

/**
 * Bu kısıtlamalar dolaylı alt sınıflar için geçerli
 * değildir. Mühürlü bir sınıfın doğrudan bir alt sınıfı
 * mühürlü olarak işaretlenmemişse, değiştiricilerinin
 * izin verdiği herhangi bir şekilde genişletilebilir:
 */

// Mühürlü arayüz 'Hata' yalnızca aynı paket ve modülde uygulamalara sahiptir
//sealed interface Error

// Mühürlü sınıf 'IOError' 'Error'ı genişletir ve sadece aynı pakette genişletilebilir
//sealed class IOError() : Error

// 'CustomError' sınıfı 'Error'ı genişletir ve görünür olduğu her yere genişletilebilir
//open class CustomError() : Error

/**
 * Use Sealed Classes With When Expression
 *
 * Mühürlü sınıfları kullanmanın en önemli faydası,
 * bunları bir when ifadesinde kullandığınızda ortaya
 * çıkar. Mühürlü bir sınıfla kullanılan when ifadesi,
 * Kotlin derleyicisinin tüm olası durumların
 * kapsandığını ayrıntılı bir şekilde kontrol etmesini
 * sağlar. Bu gibi durumlarda, else ifadesi eklemenize
 * gerek yoktur:
 */

//sealed class Error() {
//    class FileReadError() : Error()
//    class DatabaseError() : Error()
//    object RuntimeError : Error()
//}
//
//fun log(e: Error) = when (e) {
//    is Error.FileReadError -> println("Error while reading file")
//    is Error.DatabaseError -> println("Error while reading from database")
//    Error.RuntimeError -> println("Runtime error")
//    // Tüm durumlar kapsandığı için `else ifadesi gerekli değildir`
//}

/**
 * Use Case Scenarios
 *
 * Mühürlü sınıfların ve arayüzlerin özellikle yararlı
 * olabileceği bazı pratik senaryoları inceleyelim.
 */

/**
 * State Management In UI Applications
 *
 * Bir uygulamada farklı kullanıcı arayüzü durumlarını
 * temsil etmek için mühürlü sınıflar kullanabilirsiniz.
 * Bu yaklaşım, kullanıcı arayüzü değişikliklerinin
 * yapılandırılmış ve güvenli bir şekilde işlenmesini
 * sağlar. Bu örnek, çeşitli kullanıcı arayüzü durumlarının
 * nasıl yönetileceğini gösterir:
 */

//sealed class UIState {
//    data object Loading : UIState()
//    data class Success(val data: String) : UIState()
//    data class Error(val exception: Exception) : UIState()
//}
//
//fun updateUI(state: UIState) {
//    when (state) {
//        is UIState.Loading -> showLoadingIndicator()
//        is UIState.Success -> showData(state.data)
//        is UIState.Error -> showError(state.exception)
//    }
//}

/**
 * Payment Method Handling
 *
 * Pratik iş uygulamalarında, çeşitli ödeme yöntemlerini
 * verimli bir şekilde yönetmek yaygın bir gerekliliktir.
 * Bu tür iş mantığını uygulamak için when ifadeleriyle
 * mühürlenmiş sınıfları kullanabilirsiniz. Farklı ödeme
 * yöntemlerini mühürlenmiş bir sınıfın alt sınıfları
 * olarak temsil ederek, işlemleri işlemek için net ve
 * yönetilebilir bir yapı oluşturur:
 */

//sealed class Payment {
//    data class CreditCard(val number: String, val expiryDate: String) : Payment()
//    data class PayPal(val email: String) : Payment()
//    data object Cash : Payment()
//}
//
//fun processPayment(payment: Payment) {
//    when (payment) {
//        is Payment.CreditCard -> processCreditCardPaym(payment.number, payment.expiryDate)
//        is Payment.PayPal -> processPayPalPayment(payment.email)
//        is Payment.Cash -> processCashPayment()
//    }
//}

/**
 * Payment, bir e-ticaret sistemindeki farklı ödeme yöntemlerini
 * temsil eden mühürlü bir sınıftır: CreditCard, PayPal ve Cash.
 * Her alt sınıfın, CreditCard için sayı ve son kullanma tarihi
 * ve PayPal için e-posta gibi kendine özgü özellikleri olabilir.
 *
 * processPayment() işlevi, farklı ödeme yöntemlerinin nasıl
 * işleneceğini gösterir. Bu yaklaşım, tüm olası ödeme türlerinin
 * dikkate alınmasını ve sistemin gelecekte eklenecek yeni
 * ödeme yöntemleri için esnek kalmasını sağlar.
 */

/**
 * API Request-Response Handling
 *
 * API isteklerini ve yanıtlarını işleyen bir kullanıcı kimlik
 * doğrulama sistemi uygulamak için mühürlü sınıflar ve mühürlü
 * arayüzler kullanabilirsiniz. Kullanıcı kimlik doğrulama
 * sistemi oturum açma ve oturum kapatma işlevlerine sahiptir.
 * ApiRequest mühürlü arayüzü belirli istek türlerini tanımlar:
 * Oturum açma için LoginRequest ve oturum kapatma işlemleri için
 * LogoutRequest. Mühürlü sınıf ApiResponse farklı yanıt
 * senaryolarını kapsüller: Kullanıcı verileriyle UserSuccess,
 * yok kullanıcılar için UserNotFound ve herhangi bir başarısızlık
 * için Error. handleRequest işlevi bu istekleri bir when ifadesi
 * kullanarak tür güvenli bir şekilde işlerken getUserById
 * kullanıcı alımını simüle eder:
 */

//@Resource("api")
//sealed interface ApiRequest
//
//@Serializable
//@Resource("login")
//data class LoginRequest(val username: String, val password: String) : ApiRequest
//
//@Serializable
//@Resource("logout")
//object LogoutRequest : ApiRequest
//
//sealed class ApiResponse {
//    data class UserSuccess(val user: UserData) : ApiResponse()
//    data object UserNotFound : ApiResponse()
//    data class Error(val message: String) : ApiResponse()
//}
//
//data class UserData(
//    val userId: String,
//    val name: String,
//    val email: String,
//)
//
//fun isValidUser(username: String, password: String): Boolean {
//    return username == "validUser" && password == "validPass"
//}
//
//fun handleRequest(request: ApiRequest): ApiResponse {
//    return when (request) {
//        is LoginRequest -> {
//            if (isValidUser(request.username, request.password)) {
//                ApiResponse.UserSuccess(UserData("userId", "userName", "userEmail"))
//            } else {
//                ApiResponse.Error("Invalid username or password")
//            }
//        }
//
//        is LogoutRequest -> {
//            ApiResponse.UserSuccess(UserData("userId", "userName", "userEmail"))
//        }
//    }
//}
//
//fun getUserById(userId: String): ApiResponse {
//    return if (userId == "validUserId") {
//        ApiResponse.UserSuccess(UserData("validUserId", "John Doe", "john@example.com"))
//    } else {
//        ApiResponse.UserNotFound
//    }
//}
//
//fun main() {
//    val loginResponse = handleRequest(LoginRequest("user", "pass"))
//    println(loginResponse)
//
//    val logoutResponse = handleRequest(LogoutRequest)
//    println(logoutResponse)
//
//    val userResponse = getUserById("validUserId")
//    println(userResponse)
//
//    val userNotFoundResponse = getUserById("invalidId")
//    println(userNotFoundResponse)
//}