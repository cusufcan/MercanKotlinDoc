package a_types.a_basic_types

/**
 * Unsigned Integer Types
 *
 * Kotlin, tam sayı türlerine ek olarak işaretsiz tam sayıları için
 * aşağıdaki türleri sağlar:
 *
 * UByte -> 8 bit -> [0, 255]
 * UShort -> 16 bit -> [0, 65,535]
 * UInt -> 32 bit -> [0, 4,294,967,295]
 * ULong -> 64 bit -> [0, 18,446,744,073,709,551,615]
 *
 * İşaretsiz tipler, işaretli tiplerin yaptığı işlemlerin çoğunu
 * destekler.
 */

/**
 * Unsigned Arrays And Ranges
 *
 * UYARI: İşaretsiz diziler ve bunlar üzerindeki işlemler Beta'dadır.
 * Bunlar her an uyumsuz bir şekilde değiştirilebilir.
 *
 * Primitive türlerde olduğu gibi, her işaretsiz türün, o türdeki
 * dizileri temsil eden karşılık gelen bir türü vardır:
 *
 * UByteArray
 * UShortArray
 * UIntArray
 * ULongArray
 */

/**
 * Unsigned Integers Literals
 *
 * İşaretsiz tam sayıların kullanımını kolaylaştırmak için Kotlin,
 * bir tam sayı sabitini belirli bir işaretsiz türü belirten bir
 * son ek ile etiketleme olanağı sağlar (Float veya Long'a benzer
 * şekilde):
 *
 * u ve U etiketi işaretsiz değişkenler içindir. Kesin tür,
 * beklenen türe göre belirlenir. Beklenen tür sağlanmazsa,
 * derleyici değişkenin boyutuna bağlı olarak UInt veya ULong
 * kullanır:
 */

//fun main() {
//    val b: UByte = 1u // UByte
//    val s: UShort = 1u // UShort
//    val l: ULong = 1u // ULong
//
//    val a1 = 42u // UInt
//    val a2 = 0xFFFF_FFFF_FFFFu // ULong
//
//    // uL ve UL, sabit değeri açıkça unsigned long olarak etiketler:
//    val a = 1UL
//}