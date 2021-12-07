package hello

/*
	unlike Java the main method does not require args param
	fun main (args: Array<String>)
	if it is not used in the implementation
 */
fun main() {
	println("What's your name?")
	val name = readLine()
	println("Hello $name, welcome to Kotlin")
}

