package h_classes_and_objects

/**
 * Nested and Inner Classes
 *
 * Sınıflar diğer sınıfların içine yerleştirilebilir:
 */

//class Outer {
//    private val bar: Int = 1
//
//    class Nested {
//        fun foo() = 2
//    }
//}
//
//val demo = Outer.Nested().foo() // == 2

/**
 * Arayüzleri yuvalama ile de kullanabilirsiniz.
 * Sınıfların ve arayüzlerin tüm kombinasyonları
 * mümkündür: Arayüzleri sınıfların içine, sınıfları
 * arayüzlerin içine ve arayüzleri arayüzlerin
 * içine yuvalayabilirsiniz.
 */

//interface OuterInterface {
//    class InnerClass
//    interface InnerInterface
//}
//
//class OuterClass {
//    class InnerClass
//    interface InnterInterface
//}

/**
 * Inner Classes
 *
 * inner olarak işaretlenen iç içe geçmiş bir
 * sınıf, dış sınıfının üyelerine erişebilir.
 * İç sınıflar, dış sınıfın bir nesnesine bir
 * referans taşır:
 */

//class Outer {
//    private val bar: Int = 1
//
//    inner class Inner {
//        fun foo() = bar
//    }
//}
//
//val demo = Outer().Inner().foo() // == 1

/**
 * Anonymous Inner Classes
 *
 * Anonim iç sınıf örnekleri bir nesne ifadesi
 * kullanılarak oluşturulur:
 */

//windows.addMouseListener(object : MouseAdapter() {
//    override fun mouseClicked(e: MouseEvent) { /*...*/ }
//    override fun mouseEntered(e: MouseEvent) { /*...*/ }
//})

/**
 * UYARI: JVM'de, nesne işlevsel bir Java
 * arayüzünün (yani tek bir soyut yöntemi
 * olan bir Java arayüzü) örneğiyse, arayüzün
 * türüyle örneklenen bir lambda ifadesi
 * kullanarak bunu oluşturabilirsiniz:
 */

//val listener = ActionListener { println("clicked") }