package aoc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * testing a static Kotlin class via jUnit / Java
 *
 */
public class FileUtilTest {
	
	public static final String NON_EXISTENT_FILE_NAME = "notThere.txt";
	public static final String HELLO_WORLD_FILE_NAME = "helloWorld.txt";
	
	@Rule  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_reading_non_existent_file_as_string() {
		String fileName = NON_EXISTENT_FILE_NAME;
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Resource " + fileName + " was not found");
		FileUtil.readClassPathFileToString(fileName);
	}
	
	@Test
	public void test_reading_non_existent_file_as_list() {
		String fileName = NON_EXISTENT_FILE_NAME;
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Resource " + fileName + " was not found");
		FileUtil.readClassPathFileToList(fileName);
	}
	
	@Test
	public void test_reading_file_as_string() {
		String fileName = HELLO_WORLD_FILE_NAME;
		
		String fileContents = FileUtil.readClassPathFileToString(fileName);
		assertEquals("Hello\nFoo Bar", fileContents);
	}
	
	@Test
	public void test_reading_file_as_list() {
		String fileName = HELLO_WORLD_FILE_NAME;
		
		List<String> fileContents = FileUtil.readClassPathFileToList(fileName);
		
		assertNotNull(fileContents);
		assertEquals("Hello", fileContents.get(0));
		assertEquals("Foo Bar", fileContents.get(1));
	}

}
