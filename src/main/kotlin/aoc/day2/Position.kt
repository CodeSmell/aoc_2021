package aoc.day2

interface Position {

    fun moveForward(amount: Int)

    fun moveUp(amount: Int)

    fun moveDown(amount: Int)

    fun getHorizontalPosition():Int

    fun getDepth():Int
}