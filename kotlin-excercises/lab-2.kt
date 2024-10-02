/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import java.util.*

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





fun main() {
//     val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
//     println("Number of words: ${dict.size()}")
//     var word: String? = "aa"

//     println("Result: ${word?.let { dict.find(it)}}")
    
    
    val name = "John Smith"
    println(name.nameMonogram())
    val list = listOf("apple", "pear", "melon")
    println(list.joinElements("8"))
    println(list.longestElement())
    
}

fun String.nameMonogram(): String { //extension function
   return this.split(" ").map {it[0]}.joinToString("")
}

fun List<String>.joinElements(separator: String) : String = this.joinToString(separator)

fun List<String>.longestElement() : String = this.maxByOrNull { it.length }.tostring()
data class Date(val a: String) { // model osztaly
    
}














