package h_classes_and_objects

/**
 * Properties
 */

/**
 * Declaring Properties
 *
 * Kotlin sınıflarındaki özellikler, var
 * anahtar sözcüğü kullanılarak
 * değiştriilebilir olarak veya val anahtar
 * sözcüğü kullanılarak salt okunur olarak
 * bildirilebilir.
 */

//class Address {
//    var name: String = "Holmes, Sherlock"
//    var street: String = "Baker"
//    var city: String = "London"
//    var state: String? = null
//    var zip: String = "123456"
//}

/**
 * Bir özelliği kullanmak için, ona
 * sadece adıyla atıfta bulunmanız
 * yeterlidir:
 */

//class Address {
//    var name: String = "Holmes, Sherlock"
//    var street: String = "Baker"
//    var city: String = "London"
//    var state: String? = null
//    var zip: String = "123456"
//}
//
//fun copyAddress(address: Address): Address {
//    val result = Address()
//    result.name = address.name
//    result.street = address.street
//    // ...
//    return result
//}

/**
 * Getters and Setters
 *
 * Bir özelliği bildirmenin tam sözdizimi
 * aşağıdaki gibidir:
 */

//var <propertyName>[: <PropertyType>] [= <property_initializer>]
//        [<getter>]
//        [<setter>]

/**
 * Başlatıcı, alıcı ve ayarlayıcı isteğe
 * bağlıdır. Özellik türü, aşağıda
 * gösterildiği gibi başlatıcıdan veya
 * alıcının dönüş türünden çıkarılabiliyorsa
 * isteğe bağlıdır:
 */

//var initialized = 1 // Int tipinde, varsayılan getter ve setter'a sahiptir
//var allByDefault // ERROR: açık başlatıcı gerekli, getter ve setter ima edildi

/**
 * Salt okunur bir özellik bildiriminin tam
 * sözdizimi, değiştirilebilir bir özellik
 * bildiriminden iki şekilde farklıdır: var
 * yerine val ile başlar ve bir ayarlayıcıya
 * izin vermez:
 */

//val simple: Int? // Int türüne sahip, varsayılan getter, oluşturucuda başlatılmalıdır
//val inferredType = 1 // Int türüne ve varsayılan getter'a sahip

/**
 * Bir özellik için özel erişim araçları
 * tanımlayabilirsiniz. Özel bir getter
 * tanımlarsanız, özelliğe her eriştiğinizde
 * çağrılır (bu şekilde hesaplanmış bir
 * özellik uygulayabilirsiniz). İşte özel
 * bir getter örneği:
 */

//class Rectangle(val width: Int, val height: Int) {
//    val area: Int // özellik türü, isteğe bağlıdır
//        get() = this.width * this.height
//}

/**
 * Eğer getter'dan çıkarılabiliyosa, özellik
 * türünü atlayabilirsiniz:
 */

//class Rectangle(val width: Int, val height: Int) {
//    val area get() = this.width * this.height
//}

/**
 * Özel bir ayarlayıcı tanımlarsanız, başlatma
 * işlemi hariç, özelliğe bir değer atadığınız
 * her seferinde çağrılacaktır. Özel bir
 * ayarlayıcı şu şekilde görünür:
 */

//var stringRepresentation: String
//    get() = this.toString()
//    set(value) {
//        setDataFromString(value)
//    }

/**
 * Sözleşmeye göre, setter parametresinin adı
 * value'dur, ancak isterseniz farklı bi ad
 * seçebilirsiniz.
 *
 * Bir erişimciyi açıklamanız veya görünürlüğünü
 * değiştirmeniz gerekiyorsa, ancak varsayılan
 * uygulamayı değiştirmek istemiyorsanız,
 * erişimciyi gövdesini tanımlamadan
 * tanımlayabilirsiniz:
 */

//var setterVisibility: String = "abc"
//    private set // setter private'dır ve varsayılan uygulamaya sahiptir
//
//var setterWithAnnotation: Any? = null
//    @Inject set // setter Inject ile anotasyon yapılmıştır

/**
 * Backing Fields
 *
 * Kotlin'de bir alan, değerini bellekte tutmak
 * için yalnızca bir özelliğin parçası olarak
 * kullanılır. Alanlar doğrudan bildirilemez.
 * Ancak, bir özelliğin bir destek alanına
 * ihtiyacı olduğunda, Kotlin bunu otomatik
 * olarak sağlar. Bu destek alanı, alan
 * tanımlayıcısı kullanılarak erişimcilerde
 * referans alınabilir:
 */

//var counter = 0 // başlatıcı, backing field'a doğrudan atar
//    set(value) {
//        if (value >= 0)
//            field = value
//        //  counter = value // ERROR StackOverflow: recursive olur
//    }

/**
 * Alan tanımlayıcısı yalnızca özelliğin
 * erişimcilerinde kullanılabilir.
 *
 * Bir özellik için, erişimcilerden en az
 * birinin varsayılan uygulamasını kullanıyorsa
 * veya özel bir erişimci alan tanımlayıcısı
 * aracılığıyla ona başvuryorsa bir destek
 * alanı oluşturulur.
 *
 * Örneğin aşağıdaki durumda destek alanı
 * olmazdı:
 */

//val isEmpty: Boolean
//    get() = this.size == 0

/**
 * Backing Properties
 *
 * Bir örtük destek alanı şemasına uymayan bir
 * şey yapmak istiyorsanız, her zaman bir
 * destek özelliğine sahip olmaya geri
 * dönebilirsiniz:
 */

//private var _table: Map<String, Int>? = null
//public val table: Map<String, Int>
//    get() {
//        if (_table == null) {
//            _table = HashMap()
//        }
//        return _table ?: throw AssertionError("Set to null by another thread")
//    }

/**
 * UYARI: JVM'de: Fonksiyon çağrısı yükünü
 * önlemek için varsayılan getter ve setter'larla
 * özel özelliklere erişim optimize edildi.
 */

/**
 * Compile-Time Constants
 *
 * Salt okunur bir özelliğin değeri derleme
 * zamanında biliniyorsa, const değiştiricisini
 * kullanarak derleme zamanı sabiti olarak
 * işaretleyin. Böyle bir özelliğin aşağıdaki
 * gereksinimleri karşılaması gerekir:
 *
 * - En üst düzey bir özellik veya bir nesne
 * bildiriminin veya bir eşlik eden nesnenin
 * üyesi olmalıdır.
 * - Dize türünde veya ilkel bir türde bir
 * değerle başlatılmalıdır.
 * - Özel bir getter olamaz
 *
 * Derleyici sabitin kullanımlarını satır içi
 * hale getirecek ve sabite olan referansı
 * gerçek değeriyle değiştirecektir. Ancak,
 * alan kaldırılmayacak ve bu nedenle yansıma
 * kullanılarak etkileşime girilebilecektir.
 *
 * Bu tür özellikler açıklamalarda da
 * kullanılabilir:
 */

//const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
//
//@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { /*...*/ }

/**
 * Late-Initialized Properties and Variables
 *
 * Normalde, null olmayan bir türe sahip
 * olarak bildirilen özellikler, oluşturucuda
 * başlatılmalıdır. Ancak, bunu yapmanın uygun
 * olmadığı durumlar sıklıkla görülür. Örneğin,
 * özellikler bağımlılık enjeksiyonu veya bir
 * birim testinin kurulum yöntemiyle başlatılabilir.
 * Bu durumlarda, oluşturucuda null olmayan bir
 * başlatıcı sağlayamazsınız, ancak yine de bir
 * sınıfın gövdesi içinde özelliğe başvururken
 * null kontrollerinden kaçınmak istersiniz.
 *
 * Bu tür durumlarla başa çıkmak için, özelliği
 * lateinit değiştiricisiyle işaretleyebilirsiniz:
 */

//class TestSubject {
//    fun method() {}
//}
//
//public class MyTest {
//    lateinit var subject: TestSubject
//
//    @SetUp
//    fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test
//    fun test() {
//        subject.method() // doğrudan başvuruyu kaldır
//    }
//}

/**
 * Bu değiştirici, bir sınıfın gövdesinde bildirilen
 * var özelliklerinde (birincil oluşturucuda değil
 * ve yalnızca özelliğin özel bir alıcısı veya
 * ayarlayıcısı olmadığında) ve ayrıca üst düzey
 * özellikler ve yerel değişkenlerde kullanılabilir.
 * Özelliğin veya değişkenin türü boş bırakılamaz
 * olmalı ve ilkel bir tür olmamalıdır.
 *
 * Başlatılmadan önce bir lateinit özelliğine erişmek,
 * erişilen özelliği ve başlatılmamış olduğu gerçeğini
 * açıkça tanımlayan özel bir istisna oluşturur.
 */

/**
 * Checking Whether A Lateinit Var Is Initialized
 *
 * Bir lateinit değişkeninin daha önce başlatılıp
 * başlatılmadığını kontrol etmek için, o özelliğe
 * ait referansta .isInitialized kullanın:
 */

//if (foo::bar.isInitailized) {
//    println(foo.bar)
//}

/**
 * Bu kontrol yalnızca aynı türde, dış türlerden
 * birinde veya aynı dosyada en üst düzeyde
 * bildirildiğinde sözcüksel olarak erişilebilir
 * olan özellikler için kullanılabilir.
 */

/**
 * Delegated Properties
 *
 * En yaygın özellik türü basitçe bir destek
 * alanından okur (ve belki de ona yazar),
 * ancak özel alıcılar ve ayarlayıcılar, bir
 * özelliğin herhangi bir davranışını
 * uygulayabilmeniz için özellikleri kullanmanıza
 * olanak tanır. İlk türün basitliği ile ikinci
 * türün çeşitliliği arasında bir yerde,
 * özelliklerin neler yapabileceğine dair ortak
 * kalıplar vardır. Birkaç örnek: tembel değerler,
 * belirli bir anahtarla bir haritadan okuma,
 * bir veritabanına erişme, erişimde bir
 * dinleyiciye bildirimde bulunma.
 *
 * Bu tür yaygın davranışlar, devredilmiş
 * özellikler kullanılarak kitaplıklar olarak
 * uygulanabilir.
 */