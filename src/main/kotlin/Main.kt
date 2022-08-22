fun main(args: Array<String>) {
    kotlin.io.print("Your name: ")
    val name = readlnOrNull()
    if(name != null) {
        val nameLength = name.length
        print("Hello", name, nameLength)
    } else {
        print("Hi")
    }
}

fun print(greeting: String, name: String = "Stranger", excitationLevel: Int = 0) {
    println("$greeting, $name${"!".repeat(excitationLevel)}")
}