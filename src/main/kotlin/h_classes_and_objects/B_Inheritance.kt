package h_classes_and_objects

/**
 * Inheritance
 *
 * Kotlin'deki tüm sınıfların ortak bir üst
 * sınıfı vardır, Any. Bu, hiçbir üst türü
 * tanımlanmamış bir sınıf için varsayılan
 * üst sınıftır:
 */

//class Example // Kapalı olarak Any snıfını miras alır

/**
 * Any'nin üç yöntemi vardır: equals(),
 * hashCode() ve toString(). Bu nedenle,
 * bu yöntemler tüm Kotlin sınıfları için
 * tanımlanmıştır.
 *
 * Varsayılan olarak, Kotlin sınıfları finaldir
 * -miras alınamazlar. Bir sınıfı miras alınabilir
 * yapmak için, onu open anahtar sözcüğüyle
 * işaretleyin:
 */

//open class Base // Class kalıtıma açıktır

/**
 * Açık bir üst tip bildirmek için, tipi
 * sınıf başlığında iki noktadan sonra
 * yerleştirin:
 */

//open class Base(p: Int)
//class Derived(p: Int) : Base(p)

/**
 * Türetilmiş sınıfın birincil bir kurucusu
 * varsa, temel sınıf parametrelerine göre
 * o birincil kurucuda başlatılabilir (ve
 * başlatılmalıdır).
 *
 * Türetilmiş sınıfın birincil kurucusu yoksa,
 * her ikincil kurucunun temel türü super
 * anahtar sözcüğünü kullanarak başlatması
 * veya bunu yapan başka bir kurucuya
 * devretmesi gerekir. Bu durumda farklı
 * ikincil kurucuların temel türün farklı
 * kurucularını çağırabileceğini unutmayın:
 */

//open class View(val ctx: Context, attrs: AttributeSet? = null)
//
//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

/**
 * Overriding Methods
 *
 * Kotlin, geçersiz kılınabilir üyeler ve
 * geçersiz kılmalar için açık değiştiriciler
 * gerektirir:
 */

//open class Shape {
//    open fun draw() { /*...*/ }
//    fun fill() { /*...*/ }
//}
//
//class Cirlce(): Shape() {
//    override fun draw() { /*...*/ }
//}

/**
 * Circle.draw() için override değiştiricisi
 * gereklidir. Eksikse, derleyici şikayet
 * edecektir. Shape.fill() gibi bir fonksiyonda
 * açık değiştirici yoksa, aynı imzaya sahip
 * bir yöntemi bir alt sınıfta, override ile
 * veya override olmadan bildirmek yasaktır.
 * Açık değiştirici, final sınıfın üyelerine
 * eklendiğinde hiçbir etkiye sahip değildir
 * (açık değiştiricisi olmayan bir sınıf.)
 *
 * Override olarak işaretlenen bir üye kendisi
 * açıktır, bu nedenle alt sınıflarda geçersiz
 * kılınabilir. Tekrar geçersiz kılmayı
 * yasaklamak istiyorsanız, final kullanın:
 */

//open class Shape {
//    open fun draw() { /*...*/ }
//    fun fill() { /*...*/ }
//}
//
//open class Cirlce(): Shape() {
//    final override fun draw() { /*...*/ }
//}

/**
 * Overriding Properties
 *
 * Geçersiz kılma mekanizması, özellikler
 * üzerinde yöntemlerde olduğu gibi çalışır.
 * Bir üst sınıfta bildirilen ve daha sonra
 * türetilmiş bir sınıfta yeniden bildirilen
 * özellikler, override ile ön eklenmeli ve
 * uyumlu bir türe sahip olmalıdır. Bildirilen
 * her özellik, başlatıcıya sahip bir özellik
 * veya get yöntemine sahip bir özellik
 * tarafından geçersiz kılınabilir:
 */

//open class Shape {
//    open val vertexCount: Int = 0
//}
//
//class Rectangle : Shape() {
//    override val vertexCount = 4
//}

/**
 * Ayrıca bir val özelliğini bir var
 * özelliğiyle geçersiz kılabilirsiniz,
 * ancak tam tersi mümkün değildir. Buna
 * izin verilir çünkü bir val özelliği
 * esasen bir get metodu bildirir ve onu
 * bir var olarak geçersiz kılmak
 * türetilmiş sınıfta ek olarak bir set
 * metodu bildirir.
 *
 * Birincil oluşturucuda özellik bildiriminin
 * bir parçası olarak override anahtar
 * kelimesini kullanabileceğinizi unutmayın:
 */

//interface Shape {
//    val vertexCount: Int
//}
//
//class Rectangle(override val vertexCount: Int = 4) : Shape // Always has 4 vertices
//
//class Polygon : Shape {
//    override var vertexCount: Int = 0 // Can be set to any number later
//}

/**
 * Derived Class Initialization Order
 *
 * Türetilmiş bir sınıfın yeni bir örneğinin
 * oluşturulması sırasında, temel sınıf başlatma
 * ilk adım olarak yapılır (sadece temel sınıf
 * oluşturucusunun argümanlarının
 * değerlendirilmesinden önce), bu da türetilmiş
 * sınıfın başlatma mantığı çalıştırılmadan
 * önce gerçekleştiği anlamına gelir.
 */

//open class Base(val name: String) {
//    init {
//        println("Initializing a base class")
//    }
//
//    open val size: Int =
//        name.length.also { println("Initializing size in the base class: $it") }
//}
//
//class Derived(
//    name: String,
//    val lastName: String,
//) : Base(name.replaceFirstChar {
//    it.uppercase()
//}.also {
//    println("Argument for the base class: $it")
//}) {
//    init {
//        println("Initializing a derived class")
//    }
//
//    override val size: Int =
//        (super.size + lastName.length).also {
//            println("Initializing size in the derived class: $it")
//        }
//}

/**
 * Bu, temel sınıf oluşturucusu yürütüldüğünde,
 * türetilmiş sınıfta bildirilen veya geçersiz
 * kılınan özelliklerin henüz başlatılmamış
 * olduğu anlamına gelir. Bu özelliklerden
 * herhangi birini temel sınıf başlatma
 * mantığında kullanmak (doğrudan veya dolaylı
 * olarak başka bir geçersiz kılınan açık üye
 * uygulaması aracılığıyla) yanlış davranışa
 * veya çalışma zamanı hatasına yol açabilir.
 * Bu nedenle, bir temel sınıf tasarlarken
 * oluşturucularda, özellik başlatıcılarında
 * veya init bloklarında açık üyeler
 * kullanmaktan kaçınmalısınız.
 */

/**
 * Calling The Superclass Implementation
 *
 * Türetilmiş bir sınıftaki kod, super anahtar
 * sözcüğünü kullanarak üst sınıf fonksiyonlarını
 * ve özellik erişim uygulamalarını çağırabilir:
 */

//open class Rectangle {
//    open fun draw() {
//        println("Drawing a rectangle")
//    }
//
//    val borderColor: String get() = "black"
//}
//
//class FilledRectangle : Rectangle() {
//    override fun draw() {
//        super.draw()
//        println("Filling the rectangle")
//    }
//
//    val fillColor: String get() = super.borderColor
//}

/**
 * İç sınıfın içinde, dış sınıfın üst sınıfına
 * erişim, dış sınıf adıyla nitelendirilen
 * super anahtar sözcüğü kullanılarak yapılır:
 * super@Outer:
 */

//open class Rectangle {
//    open fun draw() {
//        println("Drawing a rectangle")
//    }
//
//    val borderColor: String get() = "black"
//}
//
//class FilledRectangle : Rectangle() {
//    override fun draw() {
//        val filler = Filler()
//        filler.drawAndFill()
//    }
//
//    inner class Filler {
//        fun fill() {
//            println("Filling")
//        }
//
//        fun drawAndFill() {
//            super@FilledRectangle.draw() // Rectangle'ın draw() uygulamasını çağırır
//            fill()
//            println(
//                "Drawn a filled rectangle with color " +
//                        "\${super@FilledRectangle.borderColor}"
//            ) // Rectangle'ın borderColor'ın get() uygulamasını kullanır
//
//        }
//    }
//}

/**
 * Overriding Rules
 *
 * Kotlin'de, uygulama kalıtımı aşağıdaki
 * kuralla düzenlenir: bir sınıf, aynı üyenin
 * birden fazla uygulamasını doğrudan üst
 * sınıflarından miras alırsa, bu üyeyi
 * geçersiz kılmalı ve kendi uygulamasını
 * sağlamalıdır (belki de miras alınanlardan
 * birini kullanarak).
 *
 * Miras alınan uygulamanın alındığı üst türü
 * belirtmek için, açılı parantez içinde üst
 * tür adıyla super kullanın, örneğin
 * super<Base>:
 */

//open class Rectangle {
//    open fun draw() { /*...*/
//    }
//}
//
//interface Polygon {
//    fun draw() { /* ... */
//    } // interface members are 'open' by default
//}
//
//class Square() : Rectangle(), Polygon {
//    // Derleyici draw()'ın geçersiz kılınmasını gerektirir:
//    override fun draw() {
//        super<Rectangle>.draw() // call to Rectangle.draw()
//        super<Polygon>.draw() // call to Polygon.draw()
//    }
//}

/**
 * Hem Rectangle hem de Polygon'dan miras
 * almak sorun değil, ancak her ikisinin de
 * draw()'ın kendi uygulamaları var, bu
 * yüzden Square'deki draw()'ı geçersiz
 * kılmanız ve belirsizliği ortadan kaldırmak
 * için bunun için ayrı bir uygulama sağlamanız
 * gerekir.
 */