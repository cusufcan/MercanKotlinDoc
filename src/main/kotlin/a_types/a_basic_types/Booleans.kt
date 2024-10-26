package a_types.a_basic_types

/**
 * Booleans
 *
 * Boolean türü, iki değere sahip olabilen Boole nesnelerini temsil
 * eder: true ve false. Boolean'ın, Boolean? olarak tanımlanan nullable
 * bir karşılığı vardır.
 *
 * NOT: JVM'de, primitive boole türü olarak depolanan boolean'lar
 * genellikle 8 bit kullanır.
 *
 * Boolean'lar üzerindeki yerleşik işlemler şunlardır:
 *
 * || - (mantıksal VEYA)
 * && - (mantıksal VE)
 * !  - (mantıksal DEĞİL)
 *
 * Örneğin:
 */

//fun main() {
//    val myTrue: Boolean = true
//    val myFalse: Boolean = false
//    val boolNull: Boolean? = null
//
//    println(myTrue || myFalse)
//    // true
//    println(myTrue && myFalse)
//    // false
//    println(!myTrue)
//    // false
//    println(boolNull)
//    // null
//}

/**
 * || ve && operatörleri tembel bir şekilde çalışır, bu da şu
 * anlama gelir:
 *
 * Eğer ilk işlenen doğruysa, || operatörü ikinci işleneni değerlendirmez.
 * Eğer ilk işlenen yanlışsa, && operatörü ikinci işleneni değerlendirmez.
 *
 * NOT: JVM'de boolean nesnelere yapılan nullable referanslar, tıpkı
 * sayılarda olduğu gibi Java sınıflarında kutulanır.
 */