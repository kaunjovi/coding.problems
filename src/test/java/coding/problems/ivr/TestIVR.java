package coding.problems.ivr;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIVR {

	final static Logger logger = LoggerFactory.getLogger(TestIVR.class);
	final String START_IVR = "START";
	final String END = "#";
	final String DELIMITER = ".";
	Map<String, Option> callTree;

	@Before
	public void setUp() throws FileNotFoundException {

		callTree = new HashMap<String, Option>();

		ClassLoader classLoader = getClass().getClassLoader();
		File f = new File(classLoader.getResource("ivroption001.txt").getFile());
		Scanner fin = new Scanner(f);

		int numberOfOptions = fin.nextInt();
		logger.debug("There are [{}] options in this IVR.", numberOfOptions);

		fin.nextLine();
		for (int counter = 1; counter <= numberOfOptions; counter++) {
			String breadCrumb = fin.nextLine().trim();
			String welcomeMessage = fin.nextLine().trim();
			logger.debug(
					"Counter [{}]. Bread crumb [{}]. Weclome message [{}].",
					counter, breadCrumb, welcomeMessage);

			Option option = new Option(breadCrumb, welcomeMessage);
			callTree.put(breadCrumb, option);

		}

	}

	@Test
	public void test() throws FileNotFoundException {

		StringBuffer customerResponse = new StringBuffer();
		customerResponse.append(START_IVR).append(DELIMITER);

		Scanner cin = new Scanner(System.in);

		String response;
		response = traverseCallTree(cin, customerResponse.toString());
		logger.debug("Final response [{}].", response);

		fail("Not yet implemented");
	}

	private String traverseCallTree(Scanner cin, String existingCustomerResponse) {

		logger.debug("Customer reponse [{}].", existingCustomerResponse);
		Option option = callTree.get(existingCustomerResponse);
		logger.debug("{}", option.getWelcomeMessage());
		String consoleResponse = cin.next();

		StringBuffer customerResponse = new StringBuffer(
				existingCustomerResponse).append(consoleResponse).append(
						DELIMITER);

		if (consoleResponse.equals(END)) {
			return customerResponse.toString();
		} else {
			return traverseCallTree(cin, customerResponse.toString());
		}

	}
}
