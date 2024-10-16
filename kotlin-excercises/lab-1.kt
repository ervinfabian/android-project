import java.util.*
import kotlin.random.Random

fun main() {
    val a = 2 //egyszer kap erteket
    var b = 3
    //elso feladat
    println("Elso feladat")
    val sum = 2 + 3
    println("SUM = $sum")
    println("SUM_2 = ${2+3}")
    println("-----------------------------------------")
    
    //masodik feladat
    println()
    println("Masodik feladat")
    val daysOfWeek = listOf("Monday", "Thuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for (day: String in daysOfWeek){
        println(day)
    }
    println("-----------------------------------------")
    daysOfWeek.filter { it.startsWith("T")}.forEach{
        println(it)
    }
    daysOfWeek.filter { it.contains("e")}.forEach {
        println(it)
    }
    daysOfWeek.filter {it.length == 6 }.forEach {
        println(it)
    }
    println("-----------------------------------------")
    //harmadik feladat
    println()
    println("Harmadik feladat")
    for ( i in 1..100){
        if (isPrime(i)){
            println(i)
        }
    }
    println("-----------------------------------------")
    //negyedik feladat
    println()
    println("Negyedik feladat")
    val message = "My message"
    val encodedMessage = messageCoding(message, ::encodeMessage)
    println(encodedMessage)
    val decodedMessage = messageCoding(encodedMessage, ::decodeMessage)
    println(decodedMessage)
    
    println("-----------------------------------------")
    //otodik feladat
    println()
    println("Otodik feladat")
    var numbers = intArrayOf(1,2,3,4,5,6,7,8)
    printEvenNumbers(numbers)
    
   	println("-----------------------------------------")
    //hatodik feladat
    println()
    println("Hatodik feladat")
    println("doubling")
    numbers.map {it * 2}.forEach{
        println(it)
    }
    println()
    println("capitalizing")
    daysOfWeek.map {it.uppercase()}.forEach{
        println(it)
    }
    println()
    println("first character")
    daysOfWeek.map {it.first().lowercase()}.forEach{
        println(it)
    }
    println()
    println("length")
    daysOfWeek.map {it.length}.forEach{
        println(it)
    }
    println()
    println("average length")
    val length = daysOfWeek.map { it.length }
    val averageLength = length.average()
    println(averageLength)  
    println("-----------------------------------------")
    //hetedik feladat
    println()
    println("Hetedik feladat")
    println()
    var mutableDaysOfWeek = daysOfWeek.toMutableList()
    mutableDaysOfWeek.removeAll { it.contains('n', ignoreCase = true)}
    println(mutableDaysOfWeek)
    println()
    mutableDaysOfWeek.withIndex().forEach { (index, day) -> 
    	println("Item at $index is $day")
    }
    println()
    mutableDaysOfWeek.sort()
    println(mutableDaysOfWeek)
    println("-----------------------------------------")
    //nyolcadik feladat
    println()
    println("nyolcadik feladat")
    println()
    println("Array")
    var randomArray = Array(10) {Random.nextInt(0, 101)}
    randomArray.forEach { println(it) }
    println()
    println("Sorted")
    var sortedArray = randomArray.sorted()
    sortedArray.forEach { println(it) }
    println()
    var containsEven = randomArray.any { it % 2 == 0 }
    println("Contains even: $containsEven")
    println()
    var allEven = randomArray.all { it % 2 == 0 }
    println("All are even: $allEven")
    println()
    var average = randomArray.average()
    println("the average: $average")
    
    
    
}

fun isPrime(number: Int): Boolean {
    if ( number < 2 ) return false
    for (i in 2..number / 2){
        if ( number % i == 0 ){
            return false
        }
    }
    return true
}

fun printEvenNumbers(x: IntArray) = x.filter {it % 2 == 0 }.forEach { println(it)}

fun encodeMessage (message: String): String{
    return Base64.getEncoder().encodeToString(message.toByteArray())
}

fun decodeMessage (encodedMessage: String): String{
    return String(Base64.getDecoder().decode(encodedMessage))
}

fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg)
}

