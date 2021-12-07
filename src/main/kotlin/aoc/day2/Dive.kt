package aoc.day2

import aoc.util.readClassPathFileToList

class Dive {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val commandList = readClassPathFileToList("day2/input.txt")
            // a 2nd look over this
            // would probably want a Dive interface or abstract class (w/ parse and process command methods)
            // then would run two different concrete subclasses (Day1Dive and Day2Dive)
            // so that Position wouldn't be an input parameter and processCommands could return it instead
            val position = Day2Position()
            Dive().processCommands(commandList, position)

            println(position.getHorizontalPosition() * position.getDepth())
        }
    }

    fun processCommands(commandList: List<String>, position: Position): Unit {

        commandList.forEach {
            val cmd = this.parseCommand(it)
            this.processCommand(cmd, position)
        }
    }

    fun parseCommand(command: String): Command {
        val splitCommand = command.split(" ")
        return Command(splitCommand.first().lowercase(), splitCommand.last().toInt())
    }

    fun processCommand(cmd: Command, position: Position): Unit {
        when(cmd.commandName) {
            "forward" -> {
                position.moveForward(cmd.commandValue)
            }
            "up" -> {
                position.moveUp(cmd.commandValue)
            }
            "down" -> {
                position.moveDown(cmd.commandValue)
            }
        }
    }

    // immutable (val) nested class to manage command parsing
    // that has two read-only properties
    class Command(cmdName:String, cmdValue: Int) {
        val commandName = cmdName
        val commandValue = cmdValue
    }

    // mutable class implementing Position
    // holding the position of the submarine
    class Day1Position : Position {
        private var horizontalPosition: Int = 0
        private var verticalPosition: Int = 0

        override fun moveForward(amount: Int) {
            horizontalPosition += amount
        }

        override fun moveUp(amount: Int) {
            verticalPosition -= amount
        }

        override fun moveDown(amount: Int) {
            verticalPosition += amount
        }

        override fun getDepth(): Int {
            return verticalPosition
        }

        override fun getHorizontalPosition(): Int {
            return horizontalPosition
        }
    }

    // mutable class implementing Position
    // holding the position of the submarine
    class Day2Position : Position {
        private var horizontalPosition: Int = 0
        private var verticalPosition: Int = 0
        private var aim:  Int = 0

        override fun moveForward(amount: Int) {
            horizontalPosition += amount
            verticalPosition += (aim * amount)
        }

        override fun moveUp(amount: Int) {
            aim -= amount
        }

        override fun moveDown(amount: Int) {
            aim += amount
        }

        override fun getDepth(): Int {
            return verticalPosition
        }

        override fun getHorizontalPosition(): Int {
            return horizontalPosition
        }
    }
}