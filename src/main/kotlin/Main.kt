fun main(args: Array<String>) {
    print("Your name: ")
    val name = readlnOrNull()
    if(name != null) {
        val nameLength = name.length
        print("Hello", name, nameLength)
    } else {
        print("Hi", "Stranger", 0)
    }
}

fun print(greeting: String, name: String, excitationLevel: Int) {
    println("$greeting, $name${"!".repeat(excitationLevel)}")
}