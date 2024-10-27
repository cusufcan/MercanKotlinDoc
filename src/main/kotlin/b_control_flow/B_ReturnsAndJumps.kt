package b_control_flow

/**
 * Returns and Jumps
 *
 * Kotlin'de üç yapısal atlama ifadesi vardır:
 *
 * return varsayımsal olarak en yakın çevreleyen
 * fonksiyondan veya anonim fonksiyondan döner.
 *
 * break en yakın çevreleyen döngüyü sonlandırır.
 *
 * continue en yakın çevreleyen döngünün bir
 * sonraki adımına ilerler.
 *
 * Bu ifadelerin tümü daha büyük ifadelerin parçası
 * olarak kullanılabilir:
 */

//data class Person(val name: String?)
//
//fun demo(person: Person) {
//    val s = person.name ?: return
//}

/**
 * Bu ifadelerin türü Nothing türüdür.
 */

/**
 * Break and Continue Labels
 *
 * Kotlin'deki herhangi bir ifade bir etiketle işaretlenebilir.
 * Etiketler, abc@ veya fooBar@ gibi @ işaretinin takip
 * ettiği bir tanımlayıcı biçimindedir. Bir ifadeyi etiketlemek
 * için, önüne bir etiket eklemeniz yeterlidir.
 */

//fun main() {
//    loop@ for (i in 1..100) {
//        // ...
//    }
//}

/**
 * Artık bir break'i veya continue'u bir etiketle
 * nitelendirebiliriz:
 */

//fun main() {
//    loop@ for (i in 1..100) {
//        for (j in 1..100) {
//            if (true) break@loop
//        }
//    }
//}

/**
 * Bir etiketle nitelendirilen bir break, o etiketle
 * işaretlenen döngüden hemen sonraki yürütme noktasına
 * atlar. Bir continue, o döngünün bir sonraki
 * yinelemesine ilerler.
 */

/**
 * Return to Labels
 *
 * Kotlin'de, fonksiyonlar fonksiyon sabitleri, yerel
 * fonksiyonlar ve nesne ifadeleri kullanılarak iç içe
 * yerleştirilebilir. Nitelikli dönüşler, dış bir
 * fonksiyondan dönmemize olanak tanır. En önemli
 * kullanım durumu, bir lambda ifadesinden dönmektir.
 * Aşağıdakini yazdığımızda, dönüş ifadesinin en yakın
 * çevreleyen fonksiyondan (foo) döndüğünü hatırlayın:
 */

//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach {
//        if (it == 3) return // yerel olmayan foo() çağıranına doğrudan dönüş
//        println(it)
//    }
//    println("this point is unreachable")
//}

/**
 * Bu tür yerel olmayan dönüşlerin yalnızca satır içi
 * işlevlere geçirilen lambda ifadeleri için desteklendiğini
 * unutmayın. Bir lambda ifadesinden dönmek için, ifadeyi
 * etiketleyin ve dönüşü niteleyin:
 */

//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach lit@{
//        if (it == 3) return@lit // lambda çağıranına yerel dönüş -forEach döngüsü
//        println(it)
//    }
//    println("done with explicit label")
//}

/**
 * Şimdi yalnızca lambda ifadesinden döner. Genellikle
 * örtük etiketler kullanmak daha uygundur, çünkü böyle
 * bir etiket, lambda'nın geçirildiği işlevle aynı ada
 * sahiptir.
 */

//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach {
//        if (it == 3) return@forEach // lambda çağıranına yerel dönüş - forEach döngüsü
//        println(it)
//    }
//    println("done with implicit label")
//}

/**
 * Alternatif olarak, lambda ifadesini anonim bir fonksiyonla
 * değiştirebilirsiniz. Anonim bir fonksiyondaki bir return
 * ifadesi, anonim fonksiyonun kendisinden dönecektir.
 */

//fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
//        if (value == 3) return // anonim fonksiyonun çağıranına yerel dönüş - forEach döngüsü
//        println(value)
//    })
//    println("done with anonymous function")
//}

/**
 * Önceki üç örnekte yerel dönüşlerin kullanımının, normal
 * döngülerdeki continue kullanımına benzediğini unutmayın.
 *
 * break için doğrudan bir eşdeğer yoktur, ancak başka bir
 * iç içe lambda eklenerek ve ondan yerel olmayan bir şekilde
 * dönülerek simüle edilebilir:
 */

//fun foo() {
//    run loop@{
//        listOf(1, 2, 3, 4, 5).forEach {
//            if (it == 3) return@loop
//            println(it)
//        }
//    }
//    println("done with nested loop")
//}

/**
 * Bir değer döndürülürken, ayrıştırıcı nitelikli
 * dönüşe öncelik verir:
 *
 * return @a 1
 *
 * Bu, "etiketli bir ifade (@a 1) döndür" yerine
 * "@a etiketinde 1 döndür" anlamında gelir.
 */