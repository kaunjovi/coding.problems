package coding.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchTestData {

	final static Logger logger = LoggerFactory.getLogger(FetchTestData.class);

	@Test
	@Ignore
	public void testDataInputFromDataFileInResourcesFolder()
			throws FileNotFoundException {

		ClassLoader cl = getClass().getClassLoader();
		File f = new File(cl.getResource("testcase001.txt").getFile());
		Scanner fin = new Scanner(f);
		readDataForTestCase(fin);

	}

	@Test
	@Ignore
	public void testDataInputFromConsole() {
		logger.debug("Say something ...");
		Scanner cin = new Scanner(System.in);
		readDataForTestCase(cin);
	}

	private void readDataForTestCase(Scanner scanner) {
		String greeting = scanner.next();
		logger.debug("The greeting [{}].", greeting);
	}

}
