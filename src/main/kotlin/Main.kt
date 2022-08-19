fun main(args: Array<String>) {
    print("Your name: ")
    val name = readlnOrNull()
    if(name != null) {
        val nameLength = name.length
        println("Hello, $name${"!".repeat(nameLength)}")
    } else {
        println("Hi")
    }

}