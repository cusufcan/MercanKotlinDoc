package f_this_expressions

/**
 * This Expressions
 *
 * Mevcut alıcıyı belirtmek için şu ifadeleri
 * kullanırsınız:
 *
 * - Bir sınıfın üyesinde, bu o sınıfın mevcut
 * nesnesine atıfta bulunur.
 * - Bir uzantı işlevinde veya alıcısı olan bir
 * işlev sabitinde, bu bir noktanın sol tarafına
 * geçirilen alıcı parametresini belirtir.
 *
 * Eğer this niteleyici içermiyorsa, en içteki
 * kapsayıcı kapsama atıfta bulunur. Buna diğer
 * kapsamlarda atıfta bulunmak için etiket
 * niteleyicileri kullanılır:
 */

/**
 * Qualified This
 *
 * Buna dış bir kapsamdan (bir sınıf, uzantı
 * fonksiyonu veya alıcısı olan etiketli fonksiyon
 * sabiti) erişmek için this@label yazarsanız;
 * burada @label, bunun hangi kapsamdan gelmesi
 * gerektiğiyle ilgili bir etikettir:
 */

//class A { // implicit label @A
//    inner class B { // implicit label @B
//        fun Int.foo() { // implicit label @foo
//            val a = this@A // A's this
//            val b = this@B // B's this
//
//            val c = this // foo()'s receiver, an Int
//            val c1 = this@foo // foo()'s receiver, an Int
//
//            val funLit = lambda@ fun String.() {
//                val d = this // funLit's receiver, a String
//            }
//
//            val funLit2 = { s: String ->
//                // foo()'nun alıcısı, lambda ifadesini kapsadığından
//                // herhangi bir alıcısı yok
//                val d1 = this
//            }
//        }
//    }
//}

/**
 * Implicit This
 *
 * this üzerinde bir üye fonksiyonunu çağırdığınızda,
 * this. kısmını atlayabilirsiniz. Aynı isme sahip
 * üye olmayan bir fonksiyonunuz varsa, bunu dikkatli
 * kullanın çünkü bazı durumlarda bunun yerine
 * çağrılabilir:
 */

//fun printLine() {
//    println("Top-level function")
//}
//
//class A {
//    fun printLine() {
//        println("Member function")
//    }
//
//    fun invokePrintLine(omitThis: Boolean = false) {
//        if (omitThis) printLine()
//        else this.printLine()
//    }
//}
//
//fun main() {
//    A().invokePrintLine() // Member function
//    A().invokePrintLine(omitThis = true) // Top-level function
//}