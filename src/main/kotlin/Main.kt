fun main(args: Array<String>) {
    print("Your name: ")
    val name = readlnOrNull()
    val message = messageFor(name)
    println(message)
}

private fun messageFor(name: String?) = if (name != null) {
    val nameLength = name.length
    "Hello, $name${"!".repeat(nameLength)}"
} else {
    "Hi"
}