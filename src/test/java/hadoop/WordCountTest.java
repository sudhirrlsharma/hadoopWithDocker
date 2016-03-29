package hadoop;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	private WordCount classUnderTest;

	@Before
	public void init(){
		classUnderTest = new WordCount();
	}
	@Test
	public void testRunJob() {
		String fileInput = "E:\\training\\GitHubWorkSpace\\Hadooplearning\\input\\file01";
		String fileoutPut = "E:\\training\\GitHubWorkSpace\\Hadooplearning\\output";
		try {
			classUnderTest.runJob(fileInput, fileoutPut);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
