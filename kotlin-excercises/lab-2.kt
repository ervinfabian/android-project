/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import java.util.*
import java.time.LocalDate
import java.time.Month


interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int
    
    companion object {
        const val DICTIONARY_NAME = ""
    } 
}

object ListDictionary : IDictionary {
    private val words = mutableListOf<String>()
    
    init { //konstruktor
        //File(IDictionary.DICTIONARY_NAME).forEachLine {add(it)}
        mockDictionaryData()
    }
    
    override fun add(word: String) = words.add(word)
    override fun find(word: String) = words.find { it == word } != null
    override fun size() = words.size
    
        private fun mockDictionaryData() {
        words.add("a")
        words.add("abalone")
        words.add("abandonments")
        words.add("abashing")
        words.add("armageddon's")
        words.add("benchmark")
        words.add("benediction")
        words.add("benedictory")
        words.add("coeducational")
        words.add("coeducational")
        words.add("coercible")
        words.add("degenerateness")     
    }
}

enum class DictionaryType {
    ARRAY_LIST,
    TREE_SET,
    HASH_SET    
}

object TreeSetDictionary : IDictionary {
    private var words = TreeSet<String>()
    
    init { //konstruktor
        //File(IDictionary.DICTIONARY_NAME).forEachLine {add(it)}
        mockDictionaryData()
    }
    
    override fun add(word: String) = words.add(word)
    override fun find(word: String) = words.find { it == word } != null
    override fun size() = words.size
    
        private fun mockDictionaryData() {
        words.add("a")
        words.add("abalone")
        words.add("abandonments")
        words.add("abashing")
        words.add("armageddon's")
        words.add("benchmark")
        words.add("benediction")
        words.add("benedictory")
        words.add("coeducational")
        words.add("coeducational")
        words.add("coercible")
        words.add("degenerateness")     
    }
}

object HashSetDictionary : IDictionary {
    private val words = HashSet<String>()
    
    init { //konstruktor
        //File(IDictionary.DICTIONARY_NAME).forEachLine {add(it)}
        mockDictionaryData()
    }
    
    override fun add(word: String) = words.add(word)
    override fun find(word: String) = words.find { it == word } != null
    override fun size() = words.size
    
        private fun mockDictionaryData() {
        words.add("a")
        words.add("abalone")
        words.add("abandonments")
        words.add("abashing")
        words.add("armageddon's")
        words.add("benchmark")
        words.add("benediction")
        words.add("benedictory")
        words.add("coeducational")
        words.add("coeducational")
        words.add("coercible")
        words.add("degenerateness")     
    }
}

// ha object-nek definialunk valami az singleton
class DictionaryProvider {
    
    companion object{ //a statikus fuggvenyeket ilyenbe kell tenni
        fun createDictionary(type: DictionaryType) : IDictionary {
            return when (type) {
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET -> TreeSetDictionary
                DictionaryType.HASH_SET -> HashSetDictionary
            }
        }
    }    
    
}

data class Date(
    val year: Int = LocalDate.now().year,
    val month: Int = LocalDate.now().monthValue,
    val day: Int = LocalDate.now().dayOfMonth

) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        return compareValuesBy(this, other, Date::year, Date::month, Date::day)
    }
    
    override fun toString(): String {
        return "$day-$month-$year"
    }
}
    





fun main() {
    println("Elso feladat")
    println()
//     list dictionary
    println("list")
    val dict1: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    println("Number of words: ${dict1.size()}")
    var word1: String? = "aa"

    println("Result: ${word1?.let { dict1.find(it)}}")
    println("...........................................")
    
//     tree set dictionary
	println("tree set")
    val dict2: IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
    println("Number of words: ${dict2.size()}")
    var word2: String? = "aa"

    println("Result: ${word2?.let { dict2.find(it)}}")
    println("...........................................")

    // hash set dictionary
    println("hash set")
    val dict3: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict3.size()}")
    var word3: String? = "aa"

    println("Result: ${word3?.let { dict3.find(it)}}")
    println("...........................................")
    println("...........................................")
    println()

    // masodik feladat
    println("Masodik feladat")
    println()
    val name = "John Smith"
    println(name.nameMonogram())
    val list = listOf("apple", "pear", "melon")
    println(list.joinElements("8"))
    println(list.longestElement())
    println("...........................................")
    println("...........................................")
    println()
    println("Harmadik feladat")
    println()
    
    val random = Random()
    val validDates = mutableListOf<Date>()
    
    while (validDates.size < 10){
        val randomYear = random.nextInt(2000, 2050)
        val randomMonth = random.nextInt(1,12)
        val randomDay = random.nextInt(1,31)
        
        val date = Date(randomYear, randomMonth, randomDay)
        if (date.isValid()){
            validDates.add(date)
            
        }
        else{
            println("Invalid date: $date")
        }
    }
    // kiiratas
    println("valid dates:")
    validDates.forEach {
        println(it)
    }
    println("...........................................")
    // sort
    println("Sorted dates")
    validDates.sort()
    validDates.forEach {
        println(it)
    }
    println("...........................................")
    //dates
    println("Reversed dates")
    validDates.reverse()
    validDates.forEach {
        println(it)
    }
    println("...........................................")
    // custom ordering
    println("custom ordering")
    validDates.sortWith(Comparator {d1, d2 ->
        compareValuesBy(d1, d2, Date::year, Date::day, Date::month)
    })
    validDates.forEach {
        println(it)
    }
}

fun String.nameMonogram(): String { //extension function
   return this.split(" ").map {it[0]}.joinToString("")
}

fun List<String>.joinElements(separator: String) : String = this.joinToString(separator)

fun List<String>.longestElement() : String = this.maxByOrNull { it.length }.toString()

// extension functions for date
fun Date.isLeapYear(): Boolean {
    return (this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0)
}

fun Date.isValid(): Boolean { // minden honap 31 naposnak van veve
    return (this.year < LocalDate.now().year) || (this.year == LocalDate.now().year && this.month < LocalDate.now().monthValue) || (this.year == LocalDate.now().year && this.month == LocalDate.now().monthValue && this.day < LocalDate.now().dayOfMonth )
}













 