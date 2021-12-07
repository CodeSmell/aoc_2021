package aoc.day1

import aoc.util.*

class SonarSweep {
	//
	// kotlin does not support static functions
	// a companion object can contain methods that
	// are related a class but don't require an instance
	// when called
	//
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val sonarData = readClassPathFileToList ("day1/input.txt")
			// pass the data as list of Ints
			val largerThanPrev = SonarSweep().windowCountIncreaseInSonarData(
				sonarData.asSequence()
					.map{it.toIntOrNull() }
					.filterNotNull()
					.toList())

			println(largerThanPrev)
		}
	}

	// part 1
	fun countIncreasesInSonarData(sonarData: List<Int>): Int {
		var countLargerThanPrev = 0

		var prevValue = sonarData.first()
		for (currentValue in sonarData.subList(1, sonarData.size)) {
			if (isLarger(prevValue, currentValue))  countLargerThanPrev++
			prevValue = currentValue
		}

		return  countLargerThanPrev
	}

	// part 2
	fun windowCountIncreaseInSonarData(sonarData: List<Int>): Int {
		return countIncreasesInSonarData(slidingWindow(sonarData, 3))
	}

	fun slidingWindow(sonarData: List<Int>, windowSize: Int): List<Int> {
		return sonarData.asSequence()
			.windowed(windowSize, 1, false) {window -> window.sum()}
			.toList()
	}

	fun isLarger(prevValue: Int, currentValue: Int): Boolean {
		return (currentValue > prevValue)
	}

}