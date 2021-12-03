# Advent of Code (2021)
The Advent of Code puzzles for each day are available [here](https://adventofcode.com/2021)

## Setup
Installing the compiler
	
	brew update
	brew install kotlin
	
### Description of Environment	
Using Kotlin 1.5.x with JDK 11
Using the Eclipse IDE with Kotlin plugin 

- Eclipse version 2021-09 (4.21.0)
- Kotlin plugin version 0.8.22

Using Maven

### Notes
Found that Eclipse is not building the Kotlin files/classes and have to do that via the command line
	
	mvn clean test-compile
	
Not sure what is wrong with development environment setup

Getting these errors:

	/Volumes/dev/aoc_2021/src/main/kotlin/aoc/util/FileUtil.kt
		ERROR: Unresolved reference: java (5, 8)
		ERROR: Unresolved reference: java (6, 8)
		ERROR: Unresolved reference: java (7, 8)
		
Because Eclipse is not compiling Kotlin classes doing this isn't working either

	package aoc.day1

	import aoc.util.FileUtil
	
	class SonarSweep {
		
		fun runMe() {
			
			List<String> sonarData = FileUtil.readClassPathFileToList("testData.txt");
			
		}
	}
	
That gives 

	ERROR: Unresolved reference: FileUtil (3, 17)
	

	