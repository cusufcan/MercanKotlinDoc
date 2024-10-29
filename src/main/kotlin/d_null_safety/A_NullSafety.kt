package d_null_safety

/**
 * Null Safety
 *
 * Null safety, Milyar Dolarlık Hata olarak da
 * bilinen boş referans riskini önemli ölçüde
 * azaltmak için tasarlanmış bir Kotlin özelliğidir.
 *
 * Java dahil olmak üzere birçok programlama dilinde
 * en yaygın tuzaklardan biri, boş bir referansın bir
 * üyesine erişmenin boş referans istisnasıyla
 * sonuçlanmasıdır. Java'da bu, NullPointerException
 * veya kısaca NPE'ye eşdeğerdir.
 *
 * Kotlin, tür sisteminin bir parçası olarak boş
 * bırakılabilirliği açıkça destekler, yani hangi
 * değişkenlerin veya özelliklerin boş olmasına
 * izin verildiğini açıkça bildirebilirsiniz.
 * Ayrıca, boş olmayan değişkenler bildirdiğinizde,
 * derleyici bu değişkenlerin boş bir değer
 * tutamayacağını ve NPE'yi önleyeceğini zorunlu
 * kılar.
 *
 * Kotlin'in null güvenliği, çalışma zamanından
 * ziyade derleme zamanında olası boşla ilgili
 * sorunları yakalayarak daha güvenli kod sağlar.
 * Bu özellik, boş değerleri açıkça ifade ederek
 * kodun sağlamlığını, okunabilirliğini ve
 * sürdürülebilirliğini artırır ve kodun
 * anlaşılmasını ve yönetilmesinin kolaylaştırır.
 *
 * Kotlin'de NPE'nin olası tek nedenleri şunlardır:
 *
 * - NullPointerException() fırlatmak için açık bir
 * çağrı.
 * - Boş olmayan doğrulama operatörünün kullanımı (!!).
 * - Başlatma sırasında veri tutarsızlığı, örneğin:
 *  - Bir kurucuda bulunan başlatılmamış bir this başka
 *  bir yerde kullanılır ("sızan this").
 *  - Türetilmiş sınıftaki uygulaması başlatılmamış bir
 *  durum kullanan açık bir üyeyi çağıran bir üst sınıf
 *  kurucusu.
 * - Java birlikte çalışması:
 *  - Bir platform türünün null referansının bir üyesine
 *  erişme girişimleri.
 *  - Genel türlerle ilgili null sorunları. Örneğin,
 *  Kotlin MutableList<String>'e null ekleyen bir Java
 *  kodu parçası, MutableList<String?>'in bunu düzgün
 *  bir şekilde işlemesini gerektirir.
 *  - Harici Java kodunun neden olduğu diğer sorunlar.
 */

/**
 * NOT: NPE'nin yanı sıra, null güvenliğiyle ilgili
 * bir diğer istisna UninitializedPropertyAccessException'dır.
 * Kotlin, başlatılmamış bir özelliğe erişmeye çalıştığınızda
 * bu istisnayı fırlatır ve null edilemeyen özelliklerin
 * hazır olana kadar kullanılmamasını sağlar. Bu genellikle
 * lateinit özellikleriyle olur.
 */

/**
 * Nullable Types and Non-Nullable Types
 *
 * Kotlin'de, tip sistemi null tutabilen (nullable tipler)
 * ve tutamayan (non-nullable tipler) tipler arasında ayrım
 * yapar. Örneğin, String tipinde düzenli bir değişken
 * null tutamaz:
 */

//fun main() {
//    // Bir değişkene null olmayan bir dize atar
//    var a: String = "abc"
//    // Null olmayan değişkene null'ı yeniden atamayı dener
//    a = null
//    println(a)
//    // Null, null olmayan bir String türünün değeri olamaz
//}

/**
 * a üzerinde bir yöntemi güvenli çağırabilir veya bir
 * özelliğe erişebilirsiniz. a boş bırakılamayan bir
 * değişken olduğundan NPE'ye neden olmayacağı garanti
 * edilir. Derleyici, a'nın her zaman geçerli bir String
 * değeri tuttuğundan emin olur, bu nedenle boş olduğunda
 * özelliklerine veya yöntemlerine erişme riski yoktur:
 */

//fun main() {
//    // Bir değişkene boş olmayan bir dize atar
//    val a: String = "abc"
//    // Boş olmayan bir değişkenin uzunluğunu döndürür
//    val l = a.length
//    println(1)
//    // 3
//}

/**
 * Boş değerlere izin vermek için, değişken türünden
 * hemen sonra ? işaretiyle bir değişken bildirin.
 * Örneğin, String? yazarak boş bırakılabilir bir dize
 * bildirebilirsiniz. Bu ifade String'i boş kabul
 * edebilen bir tür yapar:
 */

//fun main() {
//    // Boş değer atanabilir bir dizeyi bir değişkene atar
//    var b: String? = "abc"
//    // Boş değeri atanabilir değişkene başarıyla yeniden atar
//    b = null
//    println(b)
//    // null
//}

/**
 * Eğer b üzerinde doğrudan length'e erişmeye çalışırsanız,
 * derleyici bir hata bildirir. Bunun nedeni b'nin nullable
 * bir değişken olarak bildirilmesi ve null değerleri
 * tutabilmesidir. Nullable'lar üzerindeki özelliklere
 * doğrudan erişmeye çalışmak bir NPE'ye yol açar:
 */

//fun main() {
//    // Boş değer atanabilir bir dizeyi bir değişkene atar
//    var b: String? = "abc"
//    // Boş değeri atanabilir değişkene tekrar atar
//    b = null
//    // Boş değer atanabilir bir değişkenin uzunluğunu doğrudan döndürmeye çalışır
//    val l = b.length
//    println(l)
//    // Yalnızca güvenli (?.) veya boş olmayan onaylanmış (!!.) çağrılar,
//    // String? türündeki boş değer atanabilir bir alıcıda izin verilir.
//}

/**
 * Yukarıdaki örnekte, derleyici özelliklere erişmeden
 * veya işlemler gerçekleştirmeden önce nullable olup
 * olmadığını kontrol etmek için güvenli çağrılar
 * kullanmanızı gerektirir. Nullable'ları işlemenin
 * birkaç yolu vardır:
 *
 * - if koşulu ile null olup olmadığını kontrol edin
 * - Güvenli çağrı operatörü (?.)
 * - Elvis operatörü (?:)
 * - Null olmayan doğrulama operatörü (!!)
 * - Boş bırakılabilir alıcı
 * - let fonksiyonu
 * - Güvenli dönüşümler (as?)
 * - Boş bırakılabilir bir türün koleksiyonları
 *
 * Null işleme araçları ve tekniklerinin ayrıntıları
 * ve örnekleri için sonraki bölümleri okuyun.
 */

/**
 * Check For Null With The If Conditional
 *
 * Nullable türlerle çalışırken, bir NPE'den kaçınmak
 * için nullable'lığı güvenli bir şekilde ele almanız
 * gerekir. Bunu ele almanın bir yolu, if koşullu
 * ifadesiyle açıkça nullable'lığı kontrol etmektir.
 *
 * Örneğin, b'nin null olup olmadığını kontrol edin
 * ve ardından b.length'e erişin:
 */

//fun main() {
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = null
//    // Önce boş değer olup olmadığını kontrol eder ve sonra uzunluğa erişir
//    val l = if (b != null) b.length else -1
//    println(l)
//    // -1
//}

/**
 * Yukarıdaki örnekte, derleyici türü nullable
 * String?'den nullable olmayan String'e değiştirmek
 * için akıllı bir dönüştürme gerçekleştirir. Ayrıca
 * gerçekleştirdiğiniz kontrol hakkındaki bilgileri
 * izler ve if koşulunun içinde length çağrısına
 * izin verir.
 *
 * Daha karmaşık koşullar da desteklenir:
 */

//fun main() {
//    // Bir değişkene null olabilen bir dize atar
//    val b: String? = "Kotlin"
//
//    // Önce null olup olmadığını kontrol eder ve sonra length değerine erişir
//    if (b != null && b.length > 0) {
//        println("String of length ${b.length}")
//        // Koşul karşılanmazsa alternatif sağlar
//    } else {
//        println("Empty string")
//        // String of length 6
//    }
//}

/**
 * Yukarıdaki örneğin, derleyicinin b'nin kontrol
 * ve kullanım arasında değişmeyeceğini garanti
 * edebildiği durumlarda işe yaradığını unutmayın;
 * akıllı dönüştürme önkoşulları ile aynı.
 */

/**
 * Safe Call Operator
 *
 * Güvenli çağrı operatörü (?.), null'ı daha kısa
 * bir biçimde güvenli bir şekilde işlemenize olanak
 * tanır. Bir NPE fırlatmak yerine, nesne null ise,
 * ?. operatörü basitçe null döndürür:
 */

//fun main() {
//    // Boş değer atanabilir bir dizeyi bir değişkene atar
//    val a: String? = "Kotlin"
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = null
//
//    // Boş değer atanabilirliğini kontrol eder ve length veya null döndürür
//    println(a?.length)
//    // 6
//    println(b?.length)
//    // null
//}

/**
 * b?.length ifadesi null olma durumunu kontrol eder
 * ve b null değilse b.length değerini, aksi takdirde
 * null değerini döndürür. Bu ifadenin türü Int?'dir.
 *
 * Kotlin'de hem var hem de val değişkenleriyle ?.
 * operatörünü kullanabilirsiniz:
 *
 * - Boş değer atanabilir bir değişken, bir boş değer
 * (örneğin, var nullableValue: String? = null) veya
 * boş olmayan bir değer (örneğin, var nullableValue:
 * String? = "Kotlin") tutabilir. Boş olmayan bir
 * değerse, istediğiniz zaman boş olarak
 * değiştirebilirsiniz.
 * - Boş değer atnabilir bir val, bir null (örneğin,
 * val nullableValue: String? = null) veya null olmayan
 * bir değer (örneğin, val nullableValue: String? =
 * "Kotlin") tutabilir. Boş değer atanabilir bir val
 * ise, daha sonra null olarak değiştiremezsiniz.
 */

/**
 * Güvenli çağrılar zincirlerde faydalıdır. Örneğin,
 * Bob bir departmana atanmış (veya atanmamış) bir
 * çalışandır. Bu departman da, departman başkanı
 * olarak başka bir çalışana sahip olabilir. Bob'un
 * departman başkanının adını (eğer varsa) almak için,
 * aşağıdakileri yazarsınız:
 */

//bob?.department?.head?.name

/**
 * Bu zincir, özelliklerinden herhangi biri null ise
 * null döndürür. İşte aynı güvenli çağrının if
 * koşullu eşdeğeri:
 */

//if(person != null && person.department != null) {
//    person.department.head = managersPool.getManager()
//}

/**
 * Ayrıca bir eşitlemenin sol tarafına güvenli bir
 * çağrı da yerleştirebilirsiniz:
 */

//person?.deparmtent?.head = managersPool.getManager()

/**
 * Yukarıdaki örnekte, güvenli çağrı zincirindeki
 * alıcılardan biri boşsa, atama atlanır ve sağdaki
 * ifade hiç değerlendirilmez. Örneğin, person
 * veya person.department boşsa, fonksiyon çağrılmaz.
 */

/**
 * Evlis Operator
 *
 * Boş olabilen türlerle çalışırken, boş olup olmadığını
 * kontrol edebilir ve alternatif bir değer sağlayabilirsiniz.
 * Örneğin, b boş değilse b.length'e erişin. Aksi takdirde,
 * alternatif bir değer döndürün:
 */

//fun main() {
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = null
//    // Boş değer olup olmadığını kontrol eder. Boş değilse, uzunluğu döndürür.
//    // Boşsa, 0 döndürür
//    val l: Int = if (b != null) b.length else 0
//    // 0
//}

/**
 * If ifadesinin tamamını yazmak yerine, bunu Elvis
 * operatörü ?: ile daha öz bir şekilde halledebilirsiniz:
 */

//fun main() {
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = null
//    // Boş değer olup olmadığını kontrol eder. Boş değilse, uzunluğu döndürür.
//    // Boşsa, 0 döndürür
//    val l = b?.length ?: 0
//    println(l)
//    // 0
//}

/**
 * ?: ifadesinin solundaki ifade null değile, Elvis
 * operatörü bunu döndürür. Aksi takdirde, Elvis
 * operatörü sağdaki ifadeyi döndürür. Sağ taraftaki
 * ifade yalnızca sol taraf null ise değerlendirilir.
 *
 * throw ve return Kotlin'de ifadeler olduğundan,
 * bunları Elvis operatörünün sağ tarafında da
 * kullanabilirsiniz. Bu, örneğin, fonksiyon
 * argümanlarını kontrol ederken kullanışlı olabilir:
 */

//class Node {
//    fun getParent(): Node? = null
//    fun getName(): String? = null
//}
//
//fun foo(node: Node): String? {
//    // getParent()'ı kontrol eder. Boş değilse, ebeveyne atanır.
//    // Boşsa, boş döndürür
//    val parent = node.getParent() ?: return null
//    // getName()'i kontrol eder. Boş değilse, name'e atanır.
//    // Boşsa, istisna atar
//    val name = node.getName() ?: throw IllegalArgumentException("name expected")
//}

/**
 * Not-Null Assertion Operator
 *
 * Boş olmayan doğruama operatörü (!!) herhangi bir
 * değeri boş olmayan bir türe dönüştürür.
 *
 * !! operatörünü değeri boş olmayan bir değişkene
 * uyguladığınızda, güvenli bir şekilde boş olmayan
 * bir tür olarka işlenir ve kod normal şekilde
 * yürütülür. Ancak, değer boşsa, !! operatörü bunun
 * boş olmayan bir tür olarak ele alınmasını zorlar
 * ve bu da bir NPE ile sonuçlanır.
 *
 * b boş olmadığında ve !! operatörü boş olmayan
 * değerini (bu örnekte bir String olan) döndürmesini
 * sağladığında, length'e doğru şekilde erişir:
 */

//fun main() {
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = "Kotlin"
//    // b'yi boş olmayan bir değer olarak ele alır ve uzunluğuna erişir
//    val l = b!!.length
//    println(l)
//    // 6
//}

/**
 * b null olduğunda ve !! operatörü b'nin null
 * olmayan değerinin döndürmesini sağladığında,
 * NPE meydana gelir:
 */

//fun main() {
//    // Boş değer atanabilir bir değişkene boş değer atar
//    val b: String? = null
//    // b'yi boş olmayan bir değer olarak ele alır ve uzunluğuna erişmeye çalışır
//    val l = b!!.length
//    println(l)
//    // Exception in thread "main" java.lang.NullPointerException
//}

/**
 * !! operatörü, bir değerin null olmadığından ve
 * NPE alma şansının olmadığından emin olduğunuzda
 * özellikle yararlıdır, ancak derleyici belirli
 * kurallar nedeniyle bunu garnati edemez. Bu gibi
 * durumlarda, derleyiciye değerin null olmadığını
 * açıkça söylemek için !! operatörünü kullanabilirsiniz.
 */

/**
 * Nullable Receiver
 *
 * Boş değer atanabilir bir alıcı türüyle uzantı
 * işlevlerini kullanabilir ve bu işlevlerin boş
 * olabilecek değişkenler üzerinde çağrılmasına
 * izin verebilirsiniz.
 *
 * Boş değer atanabilir bir alıcı türünde bir uzantı
 * işlevi tanımlayarak, işlevi çağırdığınız her
 * yerde boş değer olup olmadığını kontrol etmek yerine,
 * boş değerleri işlevin kendisi içinde işleyebilirsiniz.
 *
 * Örneğin, .toString() uzantı işlevi boş değer
 * atanabilir bir alıcı üzerinde çağrılabilir. Boş
 * bir değer üzerinde çağrıldığında, bir istisna
 * oluşturmadan güvenli bir şekilde "null" dizesini
 * döndürür:
 */

//fun main() {
//    // Kişi değişkeninde saklanan null olabilen bir Person nesnesine null atar
//    val person: Person? = null
//
//    // .toString'i null olabilen kişi değişkenin uygular ve bir String yazdırır
//    println(person.toString())
//    // null
//}
//
//// Basit bir Person sınıfını tanımlar
//data class Person(val name: String)

/**
 * Yukarıdaki örnekte, person null olsa bile,
 * .toString() fonksiyonu güvenli bir şekilde
 * "null" dizesini döndürür. Bu, hata ayıklama
 * ve günlük kaydı için yararlı olabilir.
 *
 * .toString() fonksiyonunun null olabilen bir
 * dize (bir dize gösterimi veya null)
 * döndürmesini bekliyorsanız, güvenli çağrı
 * operatörü ?.. kullanın. ?. operatörü,
 * .toString()'i yalnızca nesne null değilse
 * çağırır, aksi takdirde null döndürür:
 */

//fun main() {
//    // Boş değer atanabilir bir Person nesnesini bir değişkene atar
//    val person1: Person? = null
//    val person2: Person? = Person("Alice")
//
//    // Kişi boşsa "null" yazdırır; aksi takdirde person.toString() sonucunu yazdırır
//    println(person1?.toString())
//    // null
//    println(person2?.toString())
//    // Person(name=Alice)
//}
//
//// Basit bir Person sınıfını tanımlar
//data class Person(val name: String)

/**
 * ?. operatörü, nesnelerin null olabilecek
 * özelliklerine veya işlevlerine erişirken,
 * potansiyel null değerlerini güvenli bir
 * şekilde işlemenize olanak tanır.
 */

/**
 * Let Function
 *
 * Boş değerleri işlemek ve yalnızca boş
 * olmayan türlerle işlem yapmak için,
 * güvenli çağrı operatörü ?.'yi let işleviyle
 * birlikte kullanabilirsiniz.
 *
 * Bu kombinasyon, bir ifadeyi değerlendirmek,
 * sonucu boş olup olmadığını kontrol etmek ve
 * yalnızca boş değilse kodu yürütmek için
 * kullanışlıdır; böylece manuel boş
 * kontrollerden kaçınılır:
 */

//fun main() {
//    // Boş değer atanabilir dizelerin bir listesini bildirir
//    val listWithNulls: List<String?> = listOf("Kotlin", null)
//
//    // Listedeki her bir öğe üzerinde yineleme yapar
//    for (item in listWithNulls) {
//        // Öğenin boş olup olmadığını kontrol eder ve yalnızca boş olmayan
//        // değerleri yazdırır
//        item?.let { println(it) }
//        // Kotlin
//    }
//}

/**
 * Safe Casts
 *
 * Tip dönüşümleri için düzenli Kotlin operatörü
 * as operatörüdür. Ancak, nesne hedef tipte
 * değilse düzenli dönüşümler bir istisnaya
 * neden olabilir.
 *
 * Güvenli dönüşümler için as? operatörünü
 * kullanabilirsiniz. Bir değeri belirtilen
 * tipe dönüştürmeye çalışır ve değer o tipte
 * değilse null döndürür:
 */

//fun main() {
//    // Herhangi bir değer türünü tutabilen Any türünde bir değişken bildirir
//    val a: Any = "Hello, Kotlin"
//    // 'as?' operatörünü kullanarak Int'e güvenli dönüştürür
//    val aInt: Int? = a as? Int
//    // 'as?' operatörünü kullanarak String'e güvenli dönüştürür
//    val aString: String? = a as? String
//
//    println(aInt)
//    // null
//
//    println(aString)
//    // "Hello, Kotlin!"
//}

/**
 * Yukarıdaki kod null yazdırır çünkü a bir
 * Int değildir, bu yüzden dönüştürme güvenli
 * bir şekilde başarısız olur. Ayrıca "Hello,
 * Kotlin!" yazdırır çünkü String? türüyle
 * eşleşir, bu yüzden güvenli dönüştürme
 * başarılı olur.
 */

/**
 * Collections Of A Nullable Type
 *
 * Boş değer alabilen öğelerden oluşan bir
 * koleksiyonunuz varsa ve yalnızca boş
 * olmayanları tutmak istiyorsanız,
 * filterNotNull() fonksiyonunu kullanın:
 */

//fun main() {
//    // Bazı null ve null olmayan tamsayı değerleri içeren bir liste bildirir
//    val nullableList: List<Int?> = listOf(1, 2, null, 4)
//    // Null olmayan tamsayılardan oluşan bir listeyle sonuçlanan null
//    // değerleri filtreler
//    val intList: List<Int> = nullableList.filterNotNull()
//
//    println(intList)
//    // [1, 2, 4]
//}