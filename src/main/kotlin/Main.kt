fun main(args: Array<String>) {
    print("Your name: ")
    val name = readlnOrNull()
    val nameLength = name?.length ?: 0
    println("Hello, $name${"!".repeat(nameLength)}")
}