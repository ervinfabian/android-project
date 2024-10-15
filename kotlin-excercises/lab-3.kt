/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import java.util.*


data class Item(
	val question: String,
    val answers: MutableList<String>,
    val correct: Int   
)

object ItemRepository { //singleton
    private var items = mutableListOf<Item>()
    init {
//         val lines = File("")
//         for ( in lines )
        mockData()
    }
    private fun mockData() {
        val item1 = Item("What is the capital of France?", mutableListOf("London", "Berlin", "Paris", "Rome"),1)
        items.add(item1)
        val item2 = Item("Which planet is known as the Red Planet?", mutableListOf("Venus", "Mars", "Jupiter", "Mercury"),1)
        items.add(item1)
        val item3 = Item("How many continents are there on Earth?", mutableListOf("7", "6", "8", "5"),1)
        items.add(item1)
        val item4 = Item("What is the largest ocean on Earth?", mutableListOf("Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Arctic Ocean"),1)
        items.add(item1)
        val item5 = Item("What is the freezing point of water in Celsius?", mutableListOf("0°C", "100°C", "-5°C", "50°C"),1)
        items.add(item1)
        val item6 = Item("Which animal is known as the King of the Jungle?", mutableListOf("Tiger", "Lion", "Elephant", "Gorilla"),1)
        items.add(item1)
        val item7 = Item("Which is the largest mammal?", mutableListOf("Elephant", "Giraffe", "Blue whale", "Rhinoceros"),1)
        items.add(item1)
        val item8 = Item("What is the smallest prime number?", mutableListOf("2", "3", "1", "5"),1)
        items.add(item1)
        val item9 = Item("Who wrote 'Romeo and Juliet'?", mutableListOf("Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"),1)
        items.add(item1)
        val item10 = Item("Which country is famous for pizza and pasta?", mutableListOf("Spain", "France", "Greece", "Italy"),1)
        items.add(item1)
    }
    
    fun randomItem() = items.random()
    fun save(item: Item) = items.add(item)
    fun size() = items.size
    
}

class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(numberOfItems: Int): List<Item> {
        println("selectRandomItems")
        if ( itemRepository.size() < numberOfItems) {
            println("The given number is higher than should be!")
        	return emptyList()
        }    
        val items = mutableListOf<Item>()
    	while (items.size < numberOfItems) {
            println("whileban van")
        	val item = itemRepository.randomItem()
        	if ( !items.contains(item)){
                println("while if")
            	items.add(item)
        	}
    	}
    	return items
    }
   
}

class ItemController {
    val itemService = ItemService()
    
}



fun main() {
    val repo = ItemRepository
    
    val quizItem = repo.randomItem()
    println("Question = " + quizItem.question)    
    println("------------------------------------")
    val service = ItemService(repo)
    val quizItems = service.selectRandomItems(3)
//     for ( item in quizItems ){
//         println("Question = " + item.question)
//     }
    
}