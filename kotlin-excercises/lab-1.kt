import java.util.*

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
    print("capitalizing")
    daysOfWeek.map {it.}
    
    
    
}

fun isPrime(number: Int): Boolean {
    if ( number &lt; 2 ) return false
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

fun messageCoding(msg: String, func: (String) -&gt; String): String{
    return func(msg)
}

