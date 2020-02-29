
var userOption: Int = 0
val items = arrayOf<String>("pencil", "calculator", "eraser", "Chromebook", "compass", "straight-edge")
val quantity = arrayOf("1", "2", "3", "4", "5", "6")
var classInventory = arrayOf<Array<String>>()

fun main() {
    var again = ""
    classInventory += items
    classInventory += quantity

    var rowCount = classInventory[0].size-1

    do {
        printMenu()
        when (userOption) {
            1 -> searchItem(rowCount)
            2 -> addItem(rowCount)
            3 -> subItem(rowCount)
            4 -> println("You chose to EXIT the program")
        }
        print("Would you like to continue? Y or N: ")
        again = readLine()!!.toString().toUpperCase()
    } while (again != "N")
}

fun addItem(rowCount: Int){
    var numAddItem = 0
    do {
        for (i in 0..rowCount)
            println("${i+1}: ${classInventory[0][i]}")

        print("What item are you adding to: ")
        userOption = readLine()!!.toInt()
        if (userOption < 1 || userOption > rowCount+1)
            println("Please enter a number between 1 and ${rowCount+1}")
    } while (userOption < 1 || userOption > rowCount+1)
    println("**************************************************************************")
    println("The class currently has ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)")
    print("How many ${classInventory[0][userOption-1]}s would you like to add: ")
    numAddItem = readLine()!!.toInt()
    numAddItem = classInventory[1][userOption-1].toInt()+numAddItem
    classInventory[1][userOption-1]=numAddItem.toString()
    println("The class now has ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)\n")

}

fun subItem(rowCount: Int){
    var numSubItem = 0
    do {
        for (i in 0..rowCount)
            println("${i+1}: ${classInventory[0][i]}")

        print("What item are you subtracting from: ")
        userOption = readLine()!!.toInt()
        if (userOption < 1 || userOption > rowCount+1)
            println("Please enter a number between 1 and ${rowCount+1}")
    } while (userOption < 1 || userOption > rowCount+1)
    println("**************************************************************************")
    println("The class currently has ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)")
    print("How many ${classInventory[0][userOption-1]}s would you like to add: ")
    numSubItem = readLine()!!.toInt()
    numSubItem = classInventory[1][userOption-1].toInt()-numSubItem
    if (numSubItem<0){
        numSubItem = 0
        println("Sorry you can only remove ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)")
    }
    classInventory[1][userOption-1]=numSubItem.toString()
    println("The class now has ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)\n")

}

fun searchItem(rowCount:Int) {
    //for (i in 0.. rowCount)
       // println("${classInventory[0][i]} = ${classInventory[1][i]}")

    do {
        for (i in 0..rowCount)
            println("${i+1}: ${classInventory[0][i]}")

        print("What item are you looking for: ")
        userOption = readLine()!!.toInt()
        if (userOption < 1 || userOption > rowCount+1)
            println("Please enter a number between 1 and ${rowCount+1}")
    } while (userOption < 1 || userOption > rowCount+1)
    println("**************************************************************************")
    println("The class currently has ${classInventory[1][userOption-1]} ${classInventory[0][userOption-1]}(s)\n")
}

fun printMenu(){
    do {
        println("What do you want to do?")
        println("1: Search for an item")
        println("2: Add an item")
        println("3: Subtract an item")
        println("4: Exit")
        print("Please choose your option: ")
        userOption = readLine()!!.toInt()
        if (userOption < 1 || userOption > 4)
            println("Please enter a number between 1 and 4")
    } while (userOption < 1 || userOption > 4)
}