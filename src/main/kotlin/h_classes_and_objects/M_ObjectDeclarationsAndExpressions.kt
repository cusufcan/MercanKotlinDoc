package h_classes_and_objects

/**
 * Object Declarations and Expressions
 *
 * Kotlin'de nesneler, bir sınıfı tanımlamanıza
 * ve tek bir adımda onun bir örneğini oluşturmanıza
 * olanak tanır. Bu, yeniden kullanılabilir bir
 * tekil örnek veya tek seferlik bir nesneye
 * ihtiyacınız olduğunda faydalıdır. Bu senaryoları
 * ele almak için Kotlin iki temel yaklaşım sunar:
 * tekil nesneler oluşturmak için nesne bildirimleri
 * ve anonim, tek seferlik nesneler oluşturmak için
 * nesne ifadeleri.
 */

/**
 * NOT: Singleton, bir sınıfın yalnızca bir örneğinin
 * olmasını sağlar ve ona küresel bir erişim noktası
 * sağlar.
 */

/**
 * Nesne bildirimleri ve nesne ifadeleri şu durumlarda
 * en iyi şekilde kullanılır:
 *
 * - Paylaşılan kaynaklar için tekil öğelerin
 * kullanılması: Uygulama boyunca bir sınıfın yalnızca
 * bir örneğinin mevcut olduğundan emin olmanız gerekir.
 * Örneğin, bir veritabanına bağlantı havuzunun
 * yönetilmesi.
 *
 * - Fabrika yöntemlerinin oluşturulması: Örnekleri
 * verimli bir şekilde oluşturmak için kullanışlı
 * bir yola ihtiyacınız vardır. Eşlik eden nesneler,
 * bir sınıfa bağlı sınıf düzeyindeki işlevleri ve
 * özellikleri tanımlamanıza olanak tanır ve bu
 * örneklerin oluşturulmasını ve yönetilmesini
 * basitleştirir.
 *
 * - Mevcut sınıf davranışını geçici olarak
 * değiştirme: Yeni bir alt sınıf oluşturmaya
 * gerek kalmadan mevcut bir sınıfın davranışını
 * değiştirmek isterseniz. Örneğin, belirli bir
 * işlem için bir nesneye geçici işlevsellik
 * ekleme.
 *
 * - Tür güvenli tasarım gereklidir: Nesne
 * ifadelerini kullanarak arayüzlerin veya
 * soyut sınıfların tek seferlik uygulamalarına
 * ihtiyacınız vardır. Bu, bir butona tıklama
 * işleyicisi gibi senaryolar için yararlı
 * olabilir.
 */

/**
 * Object Declarations
 *
 * Kotlin'de nesne bildirimlerini kullanarak
 * nesnelerin tek örneklerini oluşturabilirsiniz,
 * bu bildirimler her zaman nesne anahtar
 * sözcüğünden sonra bir ada sahiptir. Bu, tek
 * bir adımda bir sınıf tanımlamanıza ve onun
 * bir örneğini oluşturmanıza olanak tanır,
 * bu da tekil öğeleri uygulamak için faydalıdır:
 */

//class DataProvider
//
//// Veri sağlayıcılarını yönetmek için bir Singleton nesnesi bildirir
//object DataProviderManager {
//    private val providers = mutableListOf<DataProvider>()
//
//    // Yeni bir veri sağlayıcısını kaydeder
//    fun registerDataProvider(provider: DataProvider) {
//        providers.add(provider)
//    }
//
//    // Kayıtlı tüm veri sağlayıcılarını alır
//    val allDataProviders: Collection<DataProvider>
//        get() = providers
//}

/**
 * NOT: Bir nesne bildiriminin başlatılması
 * iş parçacığı açısından güvenlidir ve ilk
 * erişimde yapılır.
 */

/**
 * Nesneye atıfta bulunmak için doğrudan adını
 * kullanın:
 */

//DataProviderManager.registerDataProvider(exampleProvider)

/**
 * Nesne bildirimlerinin de, anonim nesnelerin
 * mevcut sınıflardan miras alabilmesi veya
 * arayüzleri uygulayabilmesi gibi, üst tipleri
 * olabilir:
 */

//object DefaultLister: MouseAdapter() {
//    override fun mouseClicked(e: MouseEvent) { /*...*/ }
//    override fun mouseEntered(e: MouseEvent) { /*...*/ }
//}

/**
 * Değişken bildirimleri gibi nesne bildirimleri
 * de ifade değildir, bu yüzden atama ifadesinin
 * sağ tarafında kullanılamazlar:
 */

// Syntax error: Bir nesne ifadesi bir ismi bağlayamaz.
//val myObject = object MySingleton {
//    val name = "Singleton"
//}

/**
 * Nesne bildirimleri yerel olamaz, yani doğrudan
 * bir fonksiyonun içine yerleştirilemezler.
 * Ancak, diğer nesne bildirimleri veya iç
 * olmayan sınıflar içine yerleştirilebilirler.
 */

/**
 * Data Objects
 *
 * Kotlin'de düz bir nesne bildirimi yazdırıldığında,
 * dize gösterimi hem nesnenin adını hem de nesnenin
 * karma değerini içerir:
 */

//object MyObject
//
//fun main() {
//    println(MyObject)
//    // MyObject@hashcode
//}

/**
 * Ancak, bir nesne bildirimini veri tanımlayıcısıyla
 * işaretleyerek, derleyiciye toString()'i çağırırken
 * nesnenin gerçek adını döndürmesini söyleyebilirsiniz;
 * bu, veri sınıfları için de aynı şekilde çalışır:
 */

//data object MyDataObject {
//    val number: Int = 3
//}
//
//fun main() {
//    println(MyDataObject)
//    // MyDataObject
//}

/**
 * Ek olarak, derleyici veri nesneniz için birkaç
 * işlev üretir:
 *
 * - toString() veri nesnesinin adını döndürür
 * - equals()/hashcode() eşitlik kontrollerini
 * ve karma tabanlı koleksiyonları etkinleştirir
 */

/**
 * UYARI: Bir veri nesnesi için özel bir eşittir
 * veya hashCode uygulaması sağlayamazsınız.
 */

/**
 * Bir veri nesnesi için equals() işlevi, veri
 * nesnenizin türüne sahip tüm nesnelerin eşit
 * kabul edilmesini sağlar. Çoğu durumda, bir
 * veri nesnesi bir singleton bildirdiğinden,
 * çalışma zamanında veri nesnenizin yalnızca
 * tek bir örneğine sahip olursunuz. Ancak,
 * aynı türde başka bir nesnenin çalışma
 * zamanında üretildiği uç durumda (örneğin,
 * java.lang.reflect ile platform yansıması
 * veya bu API'yi arka planda kullanan bir
 * JVM serileştirme kitaplığı kullanılarak),
 * bu, nesnelerin eşit olarak ele alınmasını
 * sağlar.
 */

/**
 * UYARI: Veri nesnelerini yalnızca yapısal
 * olarak (== operatörünü kullanarak) ve asla
 * referansla (=== operatörünü kullanarak)
 * karşılaştırmadığınızdan emin olun. Bu,
 * çalışma zamanında bir veri nesnesinin
 * birden fazla örneği mevcut olduğunda
 * tuzaklardan kaçınmanıza yardımcı olur.
 */

//data object MySingleton
//
//fun main() {
//    val evilTwin = createInstanceViaReflection()
//
//    println(MySingleton)
//    // MySingleton
//
//    println(evilTwin)
//    // MySingleton
//
//    // Bir kütüphane zorla ikinci bir MySingleton örneği oluşturduğunda bile,
//    // equals() fonksiyonu true döndürür:
//    println(MySingleton == evilTwin)
//    // true
//
//    // Veri nesnelerini === kullanarak karşılaştırmayın
//    println(MySingleton === evilTwin)
//    // false
//}
//
//fun createInstanceViaReflection(): MySingleton {
//    // Kotlin yansıması veri nesnelerinin örneklenmesine izin vermez.
//    // Bu, "zorla" yeni bir MySingleton örneği oluşturur (Java
//    platform yansımasını kullanarak)
//    // Bunu kendiniz yapmayın!
//    return (MySingleton.javaClass.declaredConstructors[0].apply {
//        isAccessible = true
//    } as Constructor<MySingleton>).newInstance()
//}

/**
 * Üretilen hashCode() fonksiyonu, equals()
 * fonksiyonuyla tutarlı bir davranışa sahiptir,
 * böylece bir veri nesnesinin tüm çalışma zamanı
 * örnekleri aynı karma koduna sahip olur.
 */

/**
 * Differences Between Data Objects and Data Classes
 *
 * Veri nesnesi ve veri sınıfı bildirimleri
 * sıklıkla birlikte kullanılır ve bazı
 * benzerliklere sahip olsa da, bir veri
 * nesnesi için üretilmeyen bazı işlevler
 * vardır:
 *
 * - copy() işlevi yok. Bir veri nesnesinin
 * bildiriminin tekil öğeler kullanılması
 * amaçlandığından, copy() işlevi üretilmez.
 * Tekil öğreler bir sınıfın örneklenmesini
 * tek bir örnekle sınırlar ve bu, örneğin
 * kopyalarının oluşturulmasına izin
 * verilerek ihlal edilir.
 *
 * - componentN() işlevi yok. Bir veri
 * sınıfının aksine, bir veri nesnesinin
 * herhangi bir veri özelliği yoktur.
 * Veri özellikleri olmadan böyle bir
 * nesneyi yapıbozuma uğratmaya çalışmak
 * mantıklı olmayacağından, componentN()
 * işlevi üretilmez.
 */

/**
 * Use Data Objects With Sealed Hierarchies
 *
 * Veri nesnesi bildirimleri, mühürlü sınıflar
 * veya mühürlü arayüzler gibi mühürlü
 * hiyerarşiler için özellikle yararlıdır.
 * Nesnenin yanında tanımlamış olabileceğiniz
 * herhangi bir veri sınıfıyla simetriyi
 * korumanıza olanak tanırlar.
 *
 * Bu örnekte, EndOfFile'ı düz bir nesne
 * yerine bir veri nesnesi olarak bildirmek,
 * toString() işlevini manuel olarak geçersiz
 * kılmaya gerek kalmadan alacağı anlamına
 * gelir:
 */

//sealed interface ReadResult
//data class Number(val number: Int) : ReadResult
//data class Text(val tex: String) : ReadResult
//data object EndOfFile : ReadResult
//
//fun main() {
//    println(Number(7))
//    // Number(number=7)
//    println(EndOfFile)
//    // EndOfFile
//}

/**
 * Companion Objects
 *
 * Eşlik eden nesneler, sınıf düzeyindeki
 * işlevleri ve özellikleri tanımlamanıza
 * olanak tanır. Bu, fabrika yöntemleri
 * oluşturmayı, sabitleri tutmayı ve
 * paylaşılan yardımcı programlara
 * erişmeyi kolaylaştırır.
 *
 * Bir sınıfın içindeki bir nesne bildirimi,
 * eşlik eden anahtar sözcükle işaretlenebilir:
 */

//class MyClass {
//    companion object Factory {
//        fun create(): MyClass = MyClass()
//    }
//}

/**
 * Eşlik eden nesnenin üyeleri, sınıf adını
 * niteleyici olarak kullanarak kolayca
 * çağrılabilir:
 */

//class User(val name: String) {
//    // Kullanıcı örnekleri oluşturmak için bir fabrika görevi
//    // gören bir yardımcı nesne tanımlar
//    companion object Factory {
//        fun create(name: String): User = User(name)
//    }
//}
//
//fun main() {
//    // Sınıf adını niteleyici olarak kullanarak eşlik eden
//    // nesnenin fabrika yöntemini çağırır.
//    // Yeni bir Kullanıcı örneği oluşturur
//    val userInstance = User.create("John Doe")
//    println(userInstance.name)
//    // John Doe
//}

/**
 * Eşlik eden nesnenin adı atlanabilir, bu
 * durumda Companion adı kullanılır:
 */

//class User(val name: String) {
//    // Adı olmayan bir eşlik eden nesneyi tanımlar
//    companion object {}
//}
//
//// Eşlik eden nesneye erişir
//val companionUser = User.Companion

/**
 * Sınıf üyeleri, kendilerine karşılık gelen
 * eşlik eden nesnelerin özel üyelerine
 * erişebilirler:
 */

//class User(val name: String) {
//    companion object {
//        private val defaultGreeting = "Hello"
//    }
//
//    fun sayHi() {
//        println(defaultGreeting)
//    }
//}
//
//fun main() {
//    User("Nick").sayHi()
//    // Hello
//}

/**
 * Bir sınıf adı tek başına kullanıldığında,
 * eşlik eden nesnenin adlandırılmış olup
 * olmamasına bakılmaksızın, sınıfın eşlik
 * eden nesnesine bir referans görevi görür:
 */

//class User1 {
//    // Adlandırılmış bir eşlik eden nesneyi tanımlar
//    companion object Named {
//        fun show(): String = "User1's Named Companion Object"
//    }
//}
//
//// User1'in eşlik eden nesnesine sınıf adını kullanarak başvurur
//val reference1 = User1
//
//class User2 {
//    // Adlandırılmamış bir eşlik eden nesneyi tanımlar
//    companion object {
//        fun show(): String = "User2's Companion Object"
//    }
//}
//
//// User2'nin eşlik eden nesnesine sınıf adını kullanarak başvurur
//val reference2 = User2

/**
 * Kotlin'deki eşlik eden nesnelerin üyeleri
 * diğer dillerden gelen statik üyeler gibi
 * görünse de, aslında eşlik eden nesnenin
 * örnek üyeleridir, yani nesnenin kendisine
 * aittirler. Bu, eşlik eden nesnelerin
 * arayüzleri uygulamasına izin verir:
 */

//interface Factory<T> {
//    fun create(name: String): T
//}
//
//class User(val name: String) {
//    // Factory arayüzünü uygulayan bir yardımcı nesne tanımlar
//    companion object : Factory<User> {
//        override fun create(name: String): User = User(name)
//    }
//}
//
//fun main() {
//    // Arkadaş nesnesini bir Fabrika olarak kullanır
//    val userFactory: Factory<User> = User
//    val newUser = userFactory.create("Example User")
//    println(newUser.name)
//    // Example User
//}

/**
 * Ancak, JVM'de @JvmStatic açıklamasını
 * kullanırsanız, eşlik eden nesnelerin
 * üyelerinin gerçek statik yöntemler ve
 * alanlar olarak oluşturulmasını
 * sağlayabilirsiniz.
 */

/**
 * Object Expressions
 *
 * Nesne ifadeleri bir sınıfı bildirir
 * ve bu sınıfın bir örneğini oluşturur,
 * ancak ikisini de adlandırmadan. Bu
 * sınıflar tek seferlik kullanım için
 * yararlıdır. Sıfırdan oluşturulabilir,
 * mevcut sınıflardan miras alınabilir
 * veya arayüzler uygulanabilir. Bu
 * sınıfların örneklerine ayrıca anonim
 * nesneler denir çünkü bir adla değil,
 * bir ifadeyle tanımlanırlar.
 */

/**
 * Create Anonymous Objects From Scratch
 *
 * Nesne ifadeleri object anahtar sözcüğüyle
 * başlar.
 *
 * Nesne herhangi bir sınıfı genişletmiyorsa
 * veya arayüz uygulamıyorsa, nesnenin üyelerini
 * doğrudan object anahtar sözcüğünden sonra
 * süslü parantezlerin içinde tanımlayabilirsiniz:
 */

//fun main() {
//    val helloWorld = object {
//        val hello = "Hello"
//        val world = "World"
//
//        // Nesne ifadeleri, halihazırda bir toString() fonksiyonuna
//        // sahip olan Any sınıfını genişletir, bu nedenle geçersiz kılınmalıdır
//        override fun toString(): String = "$hello $world"
//    }
//
//    println(helloWorld)
//    // Hello World
//}

/**
 * Inherit Anonymous Objects From Supertypes
 *
 * Bazı tipten (veya tiplerden) miras alan
 * anonim bir nesne oluşturmak için, bu tipi
 * object'ten sonra ve iki nokta üst üste (:)
 * olarak belirtin. Daha sonra bu sınıfın
 * üyelerini sanki ondan miras alıyormuşsunuz
 * gibi uygulayın ve geçersiz kılın:
 */

//fun main() {
//    window.addMouseListener(object : MouseAdapter() {
//        override fun mouseClicked(e: MouseEvent?) { /*...*/ }
//
//        override fun mouseEntered(e: MouseEvent?) { /*...*/ }
//    })
//}

/**
 * Bir üst tipin bir kurucusu varsa, ona
 * uygun kurucu parametrelerini geçirin.
 * İki noktadan sonra virgülle ayrılmış
 * birden fazla üst tip belirtilebilir:
 */

//// Bakiye özelliğine sahip açık bir BankAccount sınıfı oluşturur
//open class BankAccount(initialBalance: Int) {
//    open val balance: Int = initialBalance
//}
//
//// Bir execute() fonksiyonu ile bir arayüz Transaction'ı tanımlar
//interface Transaction {
//    fun execute()
//}
//
//// Bir Banka Hesabında özel bir işlem gerçekleştirmek için bir fonksiyon
//fun specialTransaction(account: BankAccount) {
//    // BankAccount sınıfından miras alan ve Transaction arayüzünü
//    // uygulayan anonim bir nesne oluşturur
//    // Sağlanan hesabın bakiyesi BankAccount üst sınıf oluşturucusuna geçirilir
//    val temporaryAccount = object : BankAccount(account.balance), Transaction {
//        override val balance = account.balance + 500 // Geçici bonus
//
//        // Transaction arayüzünden execute() fonksiyonunu uygular
//        override fun execute() {
//            println("Executing special transaction. New balance is $balance.")
//        }
//    }
//    // İşlemi yürütür
//    temporaryAccount.execute()
//}

/**
 * Use Anonymous Objects as Return and Value Types
 *
 * Yerel veya özel bir fonksiyondan veya
 * özellikten (ancak satır içi bir
 * fonksiyondan değil) anonim bir nesne
 * döndürdüğünüzde, bu anonim nesnenin
 * tüm üyelerine bu fonksiyon veya
 * özellik aracılığıyla erişilebilir:
 */

//class UserPreferences {
//    private fun getPreferences() = object {
//        val theme: String = "Dark"
//        val fontSize: Int = 14
//    }
//
//    fun printPreferences() {
//        val preferences = getPreferences()
//        println("Theme: ${preferences.theme}, Font Size: ${preferences.fontSize}")
//    }
//}

/**
 * Bu, belirli özelliklere sahip anonim
 * bir nesne döndürmenize olanak tanır
 * ve ayrı bir sınıf oluşturmadan verileri
 * veya davranışı kapsüllemenin basit bir
 * yolunu sunar.
 *
 * Anonim bir nesne döndüren bir işlev veya
 * özellik genel veya özel ise, gerçek
 * türü şudur:
 *
 * - Anonim nesnenin beyan edilmiş bir üst
 * türü yoksa Any.
 * - Anonim nesnenin beyan edilmiş üst türü,
 * tam olarak bir tür varsa.
 * - Birden fazla beyan edilmiş üst tür
 * varsa, açıkça beyan edilmiş tür.
 *
 * Bu durumların hepsinde, anonim nesneye
 * eklenen üyelere erişilemez. Geçersiz
 * kılınan üyelere, işlev veya özelliğin
 * gerçek türünde beyan edilirlerse
 * erişilebilir. Örneğin:
 */

//interface Notification {
//    // Notification arayüzünde notifyUser()'ı bildirir
//    fun notifyUser()
//}
//
//interface DetailedNotification
//
//class NotificationManager {
//    // Dönüş türü Any'dir. Mesaj özelliği erişilebilir değildir.
//    // Dönüş türü Any olduğunda, yalnızca Any sınıfının üyelerine erişilebilir.
//    fun getNotification() = object {
//        val message: String = "General notification"
//    }
//
//    // Dönüş türü Bildirim'dir çünkü anonim nesne yalnızca bir arayüz uygular
//    // NotifyUser() fonksiyonu erişilebilirdir çünkü Bildirim arayüzünün bir parçasıdır
//    // Mesaj özelliği erişilebilir değildir çünkü Bildirim arayüzünde bildirilmemiştir
//    fun getEmailNotification() = object : Notification {
//        override fun notifyUser() {
//            println("Sending email notification")
//        }
//
//        val message: String = "You've got mail!"
//    }
//
//    // Dönüş türü DetailedNotification'dır. notifyUser() fonksiyonu
//    // ve message özelliği erişilebilir değildir
//    // Yalnızca DetailedNotification arayüzünde bildirilen üyelere erişilebilir
//    fun getDetailedNotification(): DetailedNotification = object
//        : Notification, DetailedNotification {
//        override fun notifyUser() {
//            println("Sending detailed notification")
//        }
//
//        val message: String = "Detailed message content"
//    }
//}

/**
 * Access Variables From Anonymous Objects
 *
 * Nesne ifadelerinin gövdesindeki kod,
 * çevreleyen kapsamdaki değişkenlere
 * erişebilir:
 */

//fun countClicks(window: JComponent) {
//    var clickCount = 0
//    var enterCount = 0
//
//    // MouseAdapter, fare olayı işlevleri için varsayılan uygulamaları sağlar
//    // MouseAdapter'ın fare olaylarını işlemesini simüle eder
//    window.addMouseListener(object : MouseAdapter() {
//        override fun mouseClicked(e: MouseEvent?) {
//            clickCount++
//        }
//
//        override fun mouseEntered(e: MouseEvent?) {
//            enterCount++
//        }
//    })
//    // clickCount ve enterCount değişkenlerine nesne ifadesi içinde erişilebilir
//}

/**
 * Behavior Difference Between Object Declarations and Expressions
 *
 * Nesne bildirimleri ve nesne ifadeleri
 * arasında başlatma davranışında farklılıklar
 * vardır:
 *
 * - Nesne ifadeleri kullanıldıkları yerde
 * hemen yürütülür (ve başlatılır).
 * - Nesne bildirimleri ilk kez erişildiğinde
 * tembel bir şekilde başlatılır.
 * - Bir Java statik başlatıcısının semantiğiyle
 * eşleşen karşılık gelen sınıf yüklendiğinde
 * (çözümlendiğinde) bir eşlik eden nesne
 * başlatılır.
 */