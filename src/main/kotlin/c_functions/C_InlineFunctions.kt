package c_functions

/**
 * Inline Functions
 *
 * Daha yüksek düzeyli işlevlerin kullanılması
 * belirli çalışma zamanı cezaları getirir:
 * her işlev bir nesnedir ve bir kapanış yakalar.
 * Bir kapanış, işlevin gövdesinde erişilebilen
 * bir değişken kapsamıdır. Bellek tahsisleri
 * (hem işlev nesneleri hem de sınıflar için)
 * ve sanal çağrılar çalışma zamanı ek yükü
 * getirir.
 *
 * Ancak birçok durumda bu tür ek yükün lambda
 * ifadelerinin satır içi olarak eklenmesiyle
 * ortadan kaldırılabileceği görülmektedir.
 * Aşağıda gösterilen işlevler budurumun iyi
 * örnekleridir. lock() işlevi çağrı sitelerinde
 * kolayca satır içi olarak eklenebilir.
 * Aşağıdaki durumu ele alalım:
 */

//fun lock(l: String, hof: () -> Unit) {}
//fun foo() {}
//
//fun main() {
//    val l = ""
//    lock(l) { foo() }
//}

/**
 * Parametre için bir fonksiyon nesnesi
 * oluşturup bir çağrı üretmek yerine,
 * derleyici aşağıdaki kodu yayabilir:
 */

//class L {
//    fun lock() {}
//    fun unlock() {}
//}
//
//fun foo() {}
//
//fun main() {
//    val l = L()
//    l.lock()
//    try {
//        foo()
//    } finally {
//        l.unlock()
//    }
//}

/**
 * Derleyicinin bunu yapmasını sağlamak için
 * lock() fonksiyonunu satır içi değiştiriciyle
 * işaretleyin:
 */

//class Lock
//
//inline fun <T> lock(lock: Lock, body: () -> T): T { /*...*/ }

/**
 * Satır içi değiştirici hem fonksiyonun kendisini
 * hem de ona geçirilen lambdaları etkiler: bunların
 * hepsi çağrı sitesine satır içi olarak eklenecektir.
 *
 * Satır içi ekleme, üretilen kodun büyümesine neden
 * olabilir. Ancak bunu makul bir şekilde yaparsanız
 * (büyük fonksiyonları satır içi eklemekten kaçınarak),
 * özellikle döngülerin içindeki "megamorfik" çağrı
 * sitelerinde performans açısından karşılığını
 * alırsınız.
 */

/**
 * noinline
 *
 * Bir satır içi fonksiyona geçirilen tüm lambdaların
 * satır içine alınmasını istemiyorsanız, fonksiyon
 * parametrelerinizden bazılarını noinline
 * değiştiricisiyle işaretleyin:
 */

//inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { /*...*/ }

/**
 * Satır içi olmayan lambdalar yalnızca satır içi
 * fonksiyonların içinde çağrılabilir veya satır
 * içi olmayan argümanlar olarak geçirilebilir.
 * Ancak satır içi olmayan lambdalar, alanlarda
 * saklanmak veya etrafta dolaştırılmak dahil
 * olmak üzere istediğiniz şekilde değiştirilebilir.
 */

/**
 * UYARI: Eğer satır içi bir fonksiyonun satır içine
 * yerleştirilebilen fonksiyon parametreleri ve
 * somutlaştırılmış tip parametreleri yoksa, derleyici
 * bir uyarı verecektir; çünkü bu tür fonksiyonları
 * satır içine yerleştirmenin yararlı olma olasılığı
 * çok düşüktür (eğer satır içine yerleştirmenin
 * gerekli olduğundan eminseniz, uyarıyı bastırmak için
 * @Suppress("NOTHING_TO_INLINE") açıklamasını
 * kullanabilirsiniz).
 */

/**
 * Non-Local Returns
 *
 * Kotlin'de, adlandırılmış bir fonksiyondan veya
 * anonim bir fonksiyondan çıkmak için yalnızca
 * normal, niteliksiz bir dönüş kullanabilirsiniz.
 * Bir lambdadan çıkmak için bir etiket kullanın.
 * Bir lambdanın içinde yalın bir dönüş yasaktır
 * çünkü bir lambda, çevreleyen fonksiyonun
 * dönmesini sağlayamaz:
 */

//fun ordinaryFunction(block: () -> Unit ) {
//    println("hi!")
//}
//
//fun foo() {
//    ordinaryFunction {
//        return // ERROR: cannot make `foo` return here
//    }
//}

/**
 * Ancak lambda'nın geçirildiği fonksiyon satır
 * içiyse, dönüş de satır içi olabilir. Bu yüzden
 * buna izin verilir:
 */

//inline fun inlined(block: () -> Unit) {
//    println("hi!")
//}
//
//fun foo() {
//    inlined {
//        return // OK: the lambda is inlined
//    }
//}

/**
 * Bu tür dönüşler (bir lambdada bulunan, ancak
 * çevreleyen işlevden çıkan) yerel olmayan
 * dönüşler olarak adlandırılır. Bu tür bir yapı
 * genellikle satır içi işlevlerin sıklıkla
 * çevrelediği döngülerde oluşur:
 */

//fun hasZeros(ints: List<Int>): Boolean {
//    ints.forEach {
//        if (it == 0) return true // returns from hasZeros
//    }
//    return false
//}

/**
 * Bazı satır içi işlevlerin, doğrudan işlev
 * gövdesinden değil, yerel bir nesne veya iç
 * içe geçmiş bir işlev gibi başka bir yürütme
 * bağlamından parametre olarak kendilerine
 * geçirilen lambdaları çağırabileceğini unutmayın.
 * Bu gibi durumlarda, lambdalarda yerel olmayan
 * kontrol akışına da izin verilmez. Satır içi
 * işlevin lambda parametresinin yerel olmayan
 * dönüşlerir kullanamayacağını belirtmek için,
 * lambda parametresini çapraz satır değiştiricisiyle
 * işaretleyin:
 */

//inline fun f(crossinline body: () -> Unit) {
//    val f = object : Runnable {
//        override fun run() = body()
//    }
//}

/**
 * UYARI: break ve continue henüz satır içi
 * lambdalarda mevcut değil, ancak bunları
 * da desteklemeyi planlıyoruz.
 */

/**
 * Reified Type Parameters
 *
 * Bazen parametre olarak geçirilen bir türe
 * erişmeniz gerekir:
 */

//fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
//    var p = parent
//    while (p != null && !clazz.isInstance(p)) {
//        p = p.parent
//    }
//    @Suppress("UNCHECKED_CAST")
//    return p as T?
//}

/**
 * Burada bir ağaca tırmanıyorsunuz ve bir
 * düğümün belirli bir türe sahip olup olmadığını
 * kontrol etmek için yansımayı kullanıyorsunuz.
 * Her şey yolunda, ancak çağrı sitesi pek hoş
 * değil:
 */

//treeNode.findParentOfType(MyTreeNode::class.java)

/**
 * Daha iyi bir çözüm, bu fonksiyona basitçe
 * bir tür geçirmek olacaktır. Bunu şu şekilde
 * çağırabilirsiniz:
 */

//treeNode.findParentOfType<MyTreeNode>()

/**
 * Bunu etkinleştirmek için satır içi işlevler
 * somutlaştırılmış tür parametrelerini
 * destekler, bu nedenle aşağıdakine benzer
 * bir şey yazabilirsiniz:
 */

//inline fun <reified T> TreeNode.findParentOfType(): T? {
//    var p = parent
//    while (p != null && p !is T) {
//        p = p.parent
//    }
//    return p as T?
//}

/**
 * Yukarıdaki kod, fonksiyon içinde erişilebilir
 * hale getirmek için tür parametresini
 * somutlaştırılmış değiştiriciyle niteler,
 * neredeyse normal bir sınıfmış gibi. Fonksiyon
 * satır içi olduğundan, herhangi bir yansımaya
 * gerek yoktur ve !is ve as gibi normal
 * operatörler artık sizin için kullanılabilir.
 * Ayrıca, fonksiyonu yukarıda gösterildiği gibi
 * çağırabilirsiniz:
 * myTree.findParentOfType<MyTreeNodeType>().
 *
 * Birçok durumda yansımaya gerek olmasa da,
 * yine de somutlaştırılmış bir tür parametresiyle
 * kullanabilirsiniz:
 */

//inline fun <reified T> membersOf() = T::class.members
//
//fun main() {
//    println(membersOf<StringBuilder>().joinToString("\n"))
//}

/**
 * Normal işlevler (satır içi olarak işaretlenmemiş)
 * somutlaştırılmış parametrelere sahip olamaz.
 * Çalışma zamanı gösterimi olmayan bir tür (örneğin,
 * somutlaştırılmamış bir tür parametresi veya Nothing
 * gibi hayali bir tür) somutlaştırılmış bir tür
 * parametresi için bir argüman olarak kullanılamaz.
 */

/**
 * Inline Properties
 *
 * Satır içi değiştirici, destek alanları olmayan
 * özelliklerin erişim araçlarında kullanılabilir.
 * Tek tek özellik erişim araçlarını açıklayabilirsiniz:
 */

//class Foo
//class Bar
//
//val foo: Foo
//    inline get() = Foo()
//
//var bar: Bar
//    get() = { /*...*/ }
//    inline set(v) { /*...*/ }

/**
 * Ayrıca, her iki erişimcisini de satır içi olarak
 * işaretleyen bir özelliğin tamamını da
 * ekleyebilirsiniz:
 */

//class Bar
//
//inline var bar: Bar
//    get() = { /*...*/ }
//    set(v) { /*...*/ }

/**
 * Çağrı yerinde, satır içi erişim işlevleri
 * düzenli satır içi işlevler olarak satır
 * içine yerleştirilir.
 */

/**
 * Restrictions For Public API Inline Functions
 *
 * Bir satır içi işlev herkese açık veya korumalı
 * olduğunda ancak özel veya dadhili bir bildirimin
 * parçası olmadığında, bir modülün genel API'si
 * olarak kabul edilir. Diğer modüllerde çağrılabilir
 * ve bu tür çağrı sitelerinde de satır içine alınır.
 *
 * Bu, çağrı yapan modül değişiklikten sonra
 * yeniden derlenmediğinde, satır içi bir işlevi
 * bildiren mmodüldeki değişikliklerden kaynaklanan
 * ikili uyumsuzluk risklerini beraberinde getirir.
 *
 * Bu tür uyumsuzluğun bir modülün genel olmayan bir
 * API'sindeki değişiklikle ortaya çıkma riskini
 * ortadan kaldırmak için, genel API satır içi
 * işlevlerinin gövdelerinde genel olmayan API
 * bildirimleri, yani özel ve dahili bildirimler
 * ve bunların parçalarını kullanmalarına izin
 * verilmez.
 *
 * Bir dahili bildirim, genel API satır içi
 * işlevlerinde kullanılmasına iizn veren
 * @PublishedApi ile açıklanabilir. Bir dahili
 * satır içi işlev @PublishedApi olarak
 * işaretlendiğinde, gövdesi de genelmiş gibi
 * kontrol edilir.
 */