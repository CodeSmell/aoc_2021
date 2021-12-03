@file:JvmName("FileReader")

package aoc.util

import java.io.File
import java.net.URL
import java.net.URI

/*
 
 collection of static methods used to read in file contents
 
 */


//
// read a file and return each line as an element in an array
//
fun readClassPathFileToList(fileName: String): List<String> {
	return findResource(fileName).openStream().bufferedReader(Charsets.UTF_8).readLines()
}

//
// read a file and return the entire contents as a string
//
fun readClassPathFileToString(fileName: String): String {
	return findResource(fileName).readText(Charsets.UTF_8)
}

private fun findResource(fileName: String): URL {
	//return String::class.java.getResource(fileName);
	val resource = Thread.currentThread().contextClassLoader.getResource(fileName)
    requireNotNull(resource) { "Resource $fileName was not found" }
    return resource
}