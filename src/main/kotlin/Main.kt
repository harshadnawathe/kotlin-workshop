fun main(args: Array<String>) {
    print("Your name: ")
    val name = readlnOrNull()
    val message = if(name != null) {
        val nameLength = name.length
        "Hello, $name${"!".repeat(nameLength)}"
    } else {
        "Hi"
    }
    println(message)
}