package coding.problems.vendingmachine;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardCurrencyTest {

	final static Logger logger = LoggerFactory
			.getLogger(HardCurrencyTest.class);

	@Test
	public void test() {

		HardCurrency hc = HardCurrency.FIFTY;
		logger.debug("The value is {}.", hc.getValue());
		assertTrue("It is not representing the value of a fifty rupee note.",
				hc.getValue().compareTo(new BigDecimal(50.00)) == 0);

	}

}
