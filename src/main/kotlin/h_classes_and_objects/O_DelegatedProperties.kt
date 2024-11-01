package h_classes_and_objects

/**
 * Delegated Properties
 *
 * Bazı yaygın özellik türlerinde, her
 * ihtiyaç duyduğunuzda bunları manuel
 * olarak uygulayabilmenize rağmen, bunları
 * bir kez uygulamak, bir kütüphaneye
 * eklemek ve daha sonra yeniden kullanmak
 * daha faydalıdır. Örneğin:
 *
 * - Tembel özellikler: değer yalnızca ilk
 * erişimde hesaplanır.
 * - Gözlemlenebilir özellikler: dinleyiciler
 * bu özellikteki değişiklikler hakkında
 * bilgilendirilir.
 * - Özellikleri her özellik için ayrı bir
 * alan yerine bir haritada depolamak.
 *
 * Bu (ve diğer) durumları kapsamak için
 * Kotlin, devredilmiş özellikleri destekler:
 */

//class Example {
//    var p: String by Delegate()
//}

/**
 * Sözdizimi şöyledir: val/var <özellik adı>:
 * <Tür> by <ifade>. by'dan sonraki ifade bir
 * temsilcidir, çünkü özelliğe karşılık gelen
 * get() (ve set()) onun getValue() ve setValue()
 * yöntemlerine devredilecektir. Özellik
 * temsilcilerinin bir arayüz uygulaması
 * gerekmez ancak bir getValue() işlevi
 * (ve değişkenler için setValue())
 * sağlamaları gerekir.
 *
 * Örneğin:
 */

//class Delegate {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
//        return "$thisRef, thank you for delegating '${property.name}' to me!"
//    }
//
//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//        println("$value has been assigned to '${property.name}' in $thisRef.")
//    }
//}

/**
 * Delegate örneğine temsilci atan p'den
 * okuduğunuzda, Delegate'ten getValue()
 * fonksiyonu çağrılır. İlk parametresi p'yi
 * okuduğunuz nesnedir ve ikinci parametresi
 * p'nin kendsinin bir açıklamasını tutar
 * (örneğin, adını alabilirsiniz).
 */

//val e = Example()
//println(e.p)

/**
 * Şunu yazdırır:
 * Example@33a17727, thank you for delegating 'p' to me!
 */

/**
 * Benzer şekilde, p'ye atama yaptığınızda,
 * setValue() fonksiyonu çağrılır. İlk iki
 * parametre aynıdır ve üçüncüsü atanan
 * değeri tutar:
 */

//e.p = "NEW"

/**
 * Şunu yazdırır:
 * NEW has been assigned to 'p' in Example@33a17727.
 */

/**
 * Delege edilen nesne için gerekliliklerin
 * tanımı aşağıda bulunabilir.
 *
 * Bir fonksiyon veya kod bloğunun içinde
 * delege edilen bir özellik bildirebilirsiniz;
 * bir sınıfın üyesi olmak zorunda değildir.
 * Aşağıda bir örnek bulabilirsiniz.
 */

/**
 * Standart Delegates
 *
 * Kotlin standart kütüphanesi çeşitli
 * yararlı temsilci türleri için fabrika
 * metotları sağlar.
 */

/**
 * Lazy Properties
 *
 * lazy(), bir lambda alan ve bir lazy
 * özelliğini uygulamak için bir temsilci
 * olarak hizmet edebilen Lazy<T> örneğini
 * döndüren bir fonksiyondur. get()'e
 * yapılan ilk çağrı, lazy()'e geçirilen
 * lambda'yı yürütür ve sonucu hatırlar.
 * get()'e yapılan sonraki çağrılar
 * yalnızca hatırlanan sonucu döndürür.
 */

//val lazyValue: String by lazy {
//    println("computed!")
//    "Hello"
//}
//
//fun main() {
//    println(lazyValue)
//    println(lazyValue)
//}

/**
 * Varsayılan olarak, tembel özelliklerin
 * değerlendirilmesi senkronize edilir:
 * değer yalnızca bir iş parçacığında
 * hesaplanır, ancak tüm iş parçacıkları
 * aynı değeri görür. Başlatma temsilcisinin
 * senkronizasyonu, birden fazla iş
 * parçacığının aynı anda yürütmesine
 * izin vermek için gerekli değilse lazy()'ye
 * bir parametre olarak
 * LazyThreadSafetyMode.PUBLICATION geçirin.
 *
 * Başlatmanın her zaman özelliği kullandığınız
 * iş parçacığıyla aynı iş parçacığında
 * gerçekleşeceğinden eminseniz,
 * LazyThreadSafetyMode.NONE kullanabilirsiniz.
 * Herhangi bir iş parçacığı güvenliği
 * garantisi ve ilgili ek yük oluşturmaz.
 */

/**
 * Observable Properties
 *
 * Delegates.observable() iki argüman alır:
 * başlangıç değeri ve değişiklikler için bir
 * işleyici.
 *
 * İşleyici, özelilğe her atama yaptığınızda
 * (atama gerçekleştirildikten sonra) çağrılır.
 * Üç parametresi vardır: atanan özellik,
 * eski değer ve yeni değer:
 */

//class User {
//    var name: String by Delegates.observable("<no name>") { prop, old, new ->
//        println("$old -> $new")
//    }
//}
//
//fun main() {
//    val user = User()
//    user.name = "first"
//    user.name = "second"
//}

/**
 * Atamaları engellemek ve veto etmek istiyorsanız,
 * observable() yerine vetoable() kullanın.
 * Vetoable'a geçirilen işleyici, yeni bir özellik
 * değerinin atanmasından önce çağrılacaktır.
 */

/**
 * Delegating To Another Property
 *
 * Bir özellik, getter ve setter'ını başka bir
 * özelliğe devredebilir. Bu tür bir devretme
 * hem üst düzey hem de sınıf özellikleri
 * (üye ve uzantı) için kullanılabilir.
 * Delege özelliği şunlar olabilir:
 *
 * - Üst düzey bir özellik
 * - Aynı sınıfın bir üyesi veya uzantı
 * özelliği
 * - Başka bir sınıfın bir üyesi veya
 * uzantı özelliği
 *
 * Bir özelliği başka bir özelliğe devretmek
 * için, temsilci adında :: niteleyicisini
 * kullanın, örneğin, this::delegate veya
 * MyClass::delegate.
 */

//var topLevelInt: Int = 0
//
//class ClassWithDelegate(val anotherClassInt: Int)
//
//class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
//    var delegatedToMember: Int by this::memberInt
//    var delegatedToTopLevel: Int by ::topLevelInt
//
//    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
//}
//
//var MyClass.extDelegated: Int by ::topLevelInt

/**
 * Örneğin, bir özelliği geriye dönük uyumlu
 * bir şekilde yeniden adlandırmak istediğinizde
 * bu yararlı olabilir: yeni bir özellik tanıtın,
 * eskisini @Deprecated açıklamasıyla açıklayın
 * ve uygulamasını devredin.
 */

//class MyClass {
//    var newName: Int = 0
//
//    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
//    var oldName: Int by this::newName
//}
//
//fun main() {
//    val myClass = MyClass()
//    // Notification: 'oldName: Int' is deprecated.
//    // Use 'newName' instead
//    myClass.oldName = 42
//    println(myClass.newName) // 42
//}

/**
 * Storing Properties In a Map
 *
 * Yaygın bir kullanım örneği, özelliklerin
 * değerlerini bir haritada depolamaktır. Bu,
 * JSON ayrıştırma veya diğer dinamik görevleri
 * gerçekleştirme gibi şeyler için uygulamalarda
 * sıklıkla karşımıza çıkar. Bu durumda, harita
 * örneğini, devredilen bir özellik için temsilci
 * olarak kullanabilirsiniz.
 */

//class User(val map: Map<String, Any?>) {
//    val name: String by map
//    val age: Int by map
//}

/**
 * Bu örnekte, oluşturucu bir haritayı alır:
 */

//class User(val map: Map<String, Any?>) {
//    val name: String by map
//    val age: Int by map
//}
//
//fun main() {
//    val user = User(
//        mapOf(
//            "name" to "John Doe",
//            "age" to 25
//        )
//    )
//}

/**
 * Delege edilen özellikler, özelliklerin
 * adlarıyla ilişkilendirilen dize anahtarları
 * aracılığıyla bu haritadan değerler alır:
 */

//println(user.name)  // Prints "John Doe"
//println(user.age)   // Prints 25

/**
 * Sal okunur bir Map yerine MutableMap
 * kullanıyorsanız bu, var'ın özellikleri
 * için de işe yarar:
 */

//class MutableUser(val map: MutableMap<String, Any?>) {
//    var name: String by map
//    var age: Int by map
//}

/**
 * Local Delegated Properties
 *
 * Yerel değişkenleri devredilmiş özellikler
 * olarak bildirebilirsiniz. Örneğin, yerel
 * bir değişkeni tembel yapabilirsiniz:
 */

//fun example(computeFoo: () -> Foo) {
//    val memoizedFoo by lazy(computeFoo)
//
//    if (someCondition && memoizedFoo.isValid()) {
//        memoizedFoo.doSomething()
//    }
//}

/**
 * memoizedFoo değişkeni yalnızca ilk
 * erişimde hesaplanacaktır. someCondition
 * başarısız olursa, değişken hiç
 * hesaplanmayacaktır.
 */

/**
 * Property Delegate Requirements
 *
 * Salt okunur bir özellik (val) için, bir
 * temsilci getValue() operatör işlevine
 * aşağıdaki parametreleri sağlamalıdır:
 *
 * - thisRef, özellik sahibiyle aynı türde
 * veya onun bir üst türü olmalıdır (genişletme
 * özellikleri için, genişletilen tür olmalıdır).
 * - property, KProperty<*> türünde veya onun
 * üst türünde olmalıdır.
 *
 * getValue() özelliğin (veya alt türünün)
 * aynı türünü döndürmelidir.
 */

//class Resource
//
//class Owner {
//    val valResource: Resource by ResourceDelegate()
//}
//
//class ResourceDelegate {
//    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
//        return Resource()
//    }
//}

/**
 * Değiştirilebilir bir özellik (var) için,
 * bir temsilcinin ayrıca aşağıdaki
 * parametrelere sahip bir operatör işlevi
 * setValue() sağlaması gerekir:
 *
 * - thisRef, özellik sahibiyle aynı türde
 * veya onun bir üst türü olmalıdır (genişletme
 * özellikleri için, genişletilen tür olmalıdır).
 * - property, KProperty<*> türünde veya onun
 * üst türünde olmalıdır.
 * - value, özellik (veya onun üst türü) ile
 * aynı türde olmalıdır.
 */

//class Resource
//
//class Owner {
//    var varResource: Resource by ResourceDelegate()
//}
//
//class ResourceDelegate(private var resource: Resource = Resource()) {
//    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
//        return resource
//    }
//
//    operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
//        if (value is Resource) {
//            resource = value
//        }
//    }
//}

/**
 * getValue() ve/veya setValue() işlevleri,
 * temsilci sınıfının üye işlevleri veya
 * uzantı işlevleri olarak sağlanabilir.
 * İkincisi, başlangıçta bu işlevleri
 * sağlamayan bir nesneye bir özellik
 * devretmeniz gerektiğinde kullanışlıdır.
 * Her iki işlevin de operator anahtar
 * sözcüğüyle işaretlenmesi gerekir.
 *
 * Kotlin standart kütüphanesinden
 * ReadOnlyProperty ve ReadWriteProperty
 * arayüzlerini kullanarak, yeni sınıflar
 * oluşturmadan anonim nesneler olarak
 * temsilciler oluşturabilirsiniz. Bunlar
 * gerekli yöntemleri sağlar: getValue(),
 * ReadOnlyProperty içinde bildirilir;
 * ReadWriteProperty bunu genişletir ve
 * setValue() ekler. Bu, bir ReadOnlyProperty
 * beklendiğinde bir ReadWriteProperty
 * geçirebileceğiniz anlamına gelir.
 */

//class Resource
//
//fun resourceDelegate(
//    resource: Resource = Resource()
//): ReadWriteProperty<Any?, Resource> =
//    object : ReadWriteProperty<Any?, Resource> {
//        var curValue = resource
//        override fun getValue(
//            thisRef: Any?,
//            property: KProperty<*>
//        ): Resource = curValue
//
//        override fun setValue(
//            thisRef: Any?,
//            property: KProperty<*>,
//            value: Resource
//        ) {
//            curValue = value
//        }
//    }
//
//val readOnlyResource: Resource by resourceDelegate() // ReadWriteProperty as val
//var readWriteResource: Resource by resourceDelegate()

/**
 * Translation Rules For Delegated Properties
 *
 * Kotlin derleyicisi, perde arkasında, bazı
 * devredilmiş özellik türleri için yardımcı
 * özellikler üretir ve daha sonra bunlara
 * devreder.
 */

/**
 * UYARI: Optimizasyon amaçları için derleyici
 * birkaç durumda yardımcı özellikler üretmez.
 */

/**
 * Örneğin, prop özelliği için gizli özellik
 * prop$delegate'i üretir ve erişimcilerin
 * kodu basitçe bu ek özelliğe yetki devreder:
 */

//class C {
//    var prop: Type by MyDelegate()
//}

//// bunun yerine derleyici tarafından bu kod üretilir:
//class C {
//    private val prop$delegate = MyDelegate()
//    var prop: Type
//        get() = prop$delegate.getValue(this, this::prop)
//        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
//}

/**
 * Kotlin derleyicisi prop hakkında gerekli
 * tüm bilgileri argümanlarda sağlar: ilk
 * argüman this, dış sınıf C'nin bir
 * örneğine atıfta bulunur ve this::prop,
 * prop'un kendisini tanımlayan KProperty
 * türünün bir yansıma nesnesidir.
 */

/**
 * Optimized Class For Delegated Properties
 *
 * Bir temsilci şu durumdaysa $delegate alanı
 * atlanacaktır:
 */

/**
 * - Başvurulan bir özellik:
 */

//class C<Type> {
//    private var impl: Type = /*...*/
//    var prop: Type by ::impl
//}

/**
 * - Adlandırılmış nesne:
 */

//object NamedObject {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = ...
//}

/**
 * - Aynı modülde bir destek alanı ve varsayılan
 * bir getter'a sahip son bir val özelliği:
 */

//val impl: ReadOnlyProperty<Any?, String> = ...
//
//class A {
//    val s: String by impl
//}

/**
 * - Sabit bir ifade, enum giriş, this,
 * null. This örneği:
 */

//class A {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>) ...
//
//    val s by this
//}

/**
 * Translation Rules When Delegating To Another Property
 *
 * Başka bir özelliğe yetki devrederken, Kotlin
 * derleyicisi başvurulan özelliğe anında erişim
 * oluşturur. Bu, derleyicinin prop$delegate
 * alanını oluşturmadığı anlamına gelir. Bu
 * optimizasyon, bellek tasarrufuna yardımcı
 * olur.
 *
 * Örneğin, aşağıdaki kodu ele alalım:
 */

//class C<Type> {
//    private var impl: Type = ...
//    var prop: Type by ::impl
//}

/**
 * Prop değişkeninin özellik erişimleri,
 * devredilen özelliğin getValue ve setValue
 * operatörlerini atlayarak doğrudan impl
 * değişkenini çağırır ve böylece KProperty
 * referans nesnesine gerek kalmaz.
 *
 * Yukarıdaki kod için derleyici aşağıdaki
 * kodu üretir:
 */

//class C<Type> {
//    private var impl: Type = ...
//
//    var prop: Type
//        get() = impl
//        set(value) {
//            impl = value
//        }
//
//    fun getProp$delegate(): Type = impl // Bu yalnızca reflection için gereklidir
//}

/**
 * Providing a Delegate
 *
 * provideDelegate operatörünü tanımlayarak,
 * özellik uygulamasının devredildiği nesneyi
 * oluşturma mantığını genişletebilirsiniz.
 * Sağ tarafta kullanılan nesne provideDelegate'i
 * bir üye veya uzantı işlevi olarak tanımlıyorsa,
 * bu işlev özellik temsilcisi örneğini oluşturmak
 * için çağrılır.
 *
 * provideDelegate'in olası kullanım durumlarından
 * biri, özelliğin başlatılması sırasında
 * tutarlılığını kontrol etmektir.
 *
 * Örneğin, bağlamadan önce özellik adını kontrol
 * etmek için aşğıdaki gibi bir şey yazabilirsiniz:
 */

//class ResourceDelegate<T> : ReadOnlyProperty<MyUI, T> {
//    override fun getValue(thisRef: MyUI, property: KProperty<*>): T { ... }
//}
//
//class ResourceLoader<T>(id: ResourceID<T>) {
//    operator fun provideDelegate(
//        thisRef: MyUI,
//        prop: KProperty<*>
//    ): ReadOnlyProperty<MyUI, T> {
//        checkProperty(thisRef, prop.name)
//        // create delegate
//        return ResourceDelegate()
//    }
//
//    private fun checkProperty(thisRef: MyUI, name: String) { ... }
//}
//
//class MyUI {
//    fun <T> bindResource(id: ResourceID<T>): ResourceLoader<T> { ... }
//
//    val image by bindResource(ResourceID.image_id)
//    val text by bindResource(ResourceID.text_id)
//}

/**
 * provideDelegate'in parametreleri getValue'nun
 * parametreleriyle aynıdır:
 *
 * - thisRef,özellik sahibiyle aynı türde veya onun
 * bir üst türü olmalıdır (genişletme özellikleri
 * için, genişletilen tür olmalıdır);
 * - property, KProperty<*> veya onun üst türünde
 * olmalıdır.
 *
 * provideDelegate yöntemi, MyUI örneğinin
 * oluşturulması sırasında her özellik için
 * çağrılır ve gerekli doğrulamayı hemen
 * gerçekleştirir.
 *
 * Özellik ile temsilcisi arasındaki bağlantıyı
 * kesme yeteneği olmadan, aynı işlevi elde
 * etmek için özellik adını açıkça geçirmeniz
 * gerekir ki bu da pek kullanışlı değildir:
 */

//class MyUI {
//    val image by bindResource(ResourceID.image_id, "image")
//    val text by bindResource(ResourceID.text_id, "text")
//}
//
//fun <T> MyUI.bindResource(
//    id: ResourceID<T>,
//    propertyName: String
//): ReadOnlyProperty<MyUI, T> {
//    checkProperty(this, propertyName)
//    // create delegate
//}

/**
 * Oluşturulan kodda, yardımcı prop$delegate
 * özelliğini başlatmak için provideDelegate
 * yöntemi çağrılır. val prop: Type by
 * MyDelegate() özelliği bildirimi için
 * oluşturulan kodu yukarıdaki oluşturulan
 * kodla karşılaştırın (provideDelegate
 * yöntemi mevcut olmadığında):
 */

//class C {
//    var prop: Type by MyDelegate()
//}

//// bu kod derleyici tarafından üretilir
//// 'provideDelegate' fonksiyonu kullanılabilir olduğunda:
//class C {
//    // ek "delegate" özelliğini oluşturmak için "provideDelegate" çağrılıyor
//    private val prop$delegate = MyDelegate().provideDelegate(this, this::prop)
//    var prop: Type
//        get() = prop$delegate.getValue(this, this::prop)
//        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
//}

/**
 * provideDelegate yönteminin yalnızca yardımcı
 * özelliğin oluşturulmasını etkilediğini ve
 * getter veya setter için oluşturulan kodu
 * etkilemediğini unutmayın.
 *
 * Standart kütüphaneden PropertyDelegateProvider
 * arayüzüyle, yeni sınıflar oluşturmadan temsilci
 * sağlayıcıları oluşturabilirsiniz.
 */

//val provider = PropertyDelegateProvider { thisRef: Any?, property ->
//    ReadOnlyProperty<Any?, Int> { _, property -> 42 }
//}
//val delegate: Int by provider