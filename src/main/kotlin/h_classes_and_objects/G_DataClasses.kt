package h_classes_and_objects

/**
 * Data Classes
 *
 * Kotlin'deki veri sınıfları öncelikli
 * olarak veri tutmak için kullanılır.
 * Her veri sınıfı için derleyici, bir
 * örneği okunabilir çıktıya yazdırmanıza,
 * örnekleri karşılaştırmanıza, örnekleri
 * kopyalamanıza ve daha fazlasına olanak
 * tanıyan ek üye işlevlerini otomatik
 * olarak üretir. Veri sınıfları verilerle
 * işaretlenir:
 */

//data class User(val name: String, val age: Int)

/**
 * Derleyici, birincil oluşturucuda bildirilen
 * tüm özelliklerden otomatik olarak aşağıdaki
 * üyeleri türetir:
 *
 * - equals() / hashCode() çifti.
 * - "User(name=John, age=42)" biçimindeki toString().
 * - componentN() işlevleri, bildirim sırasına göre
 * özelliklere karşılık gelir.
 * - copy() işlevi
 *
 * Üretilen kodun tutarlılığını ve anlamlı
 * davranışını sağlamak için, veri sınıflarının
 * aşağıdaki gereksinimleri karşılaması gerekir:
 *
 * - Birincil oluşturucunun en az bir parametresi
 * olmalıdır.
 * - Tüm birincil oluşturucu parametreleri val
 * veya var olarak işaretlenmelidir.
 * - Veri sınıfları abstract, open, sealed veya
 * inner olamaz
 *
 * Ek olarak, veri sınıfı üyelerinin oluşturulması,
 * üyelerin kalıtımına ilişkin şu kuralları izler:
 *
 * - Veri sınıfı gövdesinde equals(), hashCode()
 * veya toString()'in açık uygulamaları veya bir
 * üst sınıfta son uygulamalar varsa, bu işlevler
 * oluşturulmaz ve mevcut uygulamalar kullanılır.
 *
 * - Bir üst tipin açık ve uyumlu türler döndüren
 * componentN() işlevleri varsa, veri sınıfı için
 * karşılık gelen işlevler oluşturulur ve üst
 * tipin işlevlerini geçersiz kılar. Üst tipin
 * işlevleri uyumsuz imzalar veya son olmaları
 * nedeniyle geçersiz kılınamıyorsa, bir hata
 * bildirir.
 *
 * - componentN() ve copy() işlevleri için açık
 * uygulamalar sağlanmasına izin verilmez.
 *
 * Veri sınıfları diğer sınıfları genişletebilir.
 */

/**
 * UYARI: JVM'de, oluşturulan sınıfın parametresiz
 * bir oluşturucuya sahip olması gerekiyorsa,
 * özellikler için varsayılan değerler belirtilmelidir
 * (bkz. Oluşturucular):
 */

//data class User(val name: String = "", val age: Int = 0)

/**
 * Properties Declared In The Class Body
 *
 * Derleyici, otomatik olarak oluşturulan işlevler
 * için yalnızca birincil oluşturucunun içinde
 * tanımlanan özellikleri kullanır. Oluşturulan
 * uygulamalardan bir özelliği hariç tutmak için,
 * onu sınıf gövdesinin içinde bildirin:
 */

//data class Person(val name: String) {
//    var age: Int = 0
//}

/**
 * Aşağıdaki örnekte, toString(), equals(),
 * hashCode() ve copy() uygulamalarının içinde
 * varsayılan olarak yalnızca name özelliği
 * kullanılır ve yalnızca bir bileşen işlevi,
 * component1() vardır. Yaş özelliği sınıf
 * gövdesinin içinde bildirilir ve hariç
 * tutulur. Bu nedenle, aynı ada sahip ancak
 * farklı yaş değerlerine sahip iki Person
 * nesnesi eşit kabul eedilir çünkü equals()
 * yalnızca birincil oluşturucudan gelen
 * özellikleri değerlendirir:
 */

//data class Person(val name: String) {
//    var age: Int = 0
//}
//
//fun main() {
//    val person1 = Person("John")
//    val person2 = Person("John")
//    person1.age = 10
//    person2.age = 20
//
//    println("person1 == person2: ${person1 == person2}")
//    // person1 == person2: true
//
//    println("person1 with age ${person1.age}: ${person1}")
//    // person1 with age 10: Person(name=John)
//
//    println("person2 with age ${person2.age}: ${person2}")
//    // person2 with age 20: Person(name=John)
//}

/**
 * Copying
 *
 * Bir nesneyi kopyalamak için copy()
 * fonksiyonunu kullanın, bu sayede bazı
 * özelliklerini değiştirebilirken geri
 * kalanını değiştirmeden tutabilirsiniz.
 * Bu fonksiyonun yukarıdaki User sınıfı
 * için uygulanması şu şekilde olacaktır:
 */

//fun copy(name: String = this.name, age: Int = this.age) = User(name, age)

/**
 * Daha sonra şunu yazabilirsiniz:
 */

//val jack = User(name = "Jack", age = 1)
//val olderJack = jack.copy(age = 2)

/**
 * Data Classes and Destructuring Declarations
 *
 * Veri sınıfları için üretilen bileşen
 * fonksiyonları, bunların yapıbozuma
 * uğratılmış bildirimlerde kullanılmasını
 * mümkün kılar:
 */

//val jane = User("Jane", 35)
//val (name, age) = jane
//println("$name", $age years of age)
// Jane, 35 years of age

/**
 * Standart Data Classes
 *
 * Standart kütüphane Pair ve Triple
 * sınıflarını sağlar. Ancak çoğu durumda,
 * adlandırılmış veri sınıfları daha iyi
 * bir tasarım seçeneğidir çünkü özelliklere
 * anlamlı adlar sağlayarak kodun okunmasını
 * kolaylaştırırlar.
 */