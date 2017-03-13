package coding.problems.vendingmachine;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinDispensingAlgoTest {

	final static Logger logger = LoggerFactory
			.getLogger(CoinDispensingAlgoTest.class);

	@Test
	public void test() {

		genericTestForAlgo(new BigDecimal(2000));
		genericTestForAlgo(new BigDecimal(500));
		genericTestForAlgo(new BigDecimal(100));
		genericTestForAlgo(new BigDecimal(50));
		genericTestForAlgo(new BigDecimal(10));
		genericTestForAlgo(new BigDecimal(5));

		genericTestForAlgo(new BigDecimal(2005));

	}

	private void genericTestForAlgo(BigDecimal RETURNABLE_AMOUNT) {

		List<Change> dispensedChange = CoinDispensingAlgo
				.convertToHardCurrencies(RETURNABLE_AMOUNT);
		BigDecimal amountReturned = calculateValue(dispensedChange);

		logger.debug("Returnable amount [{}]. Amount returned [{}].",
				RETURNABLE_AMOUNT, amountReturned);
		assertTrue("The value of change returned is not as expected.",
				amountReturned.compareTo(RETURNABLE_AMOUNT) == 0);
	}

	private BigDecimal calculateValue(List<Change> dispensedChange) {
		BigDecimal amountReturned = BigDecimal.ZERO;
		for (Change change : dispensedChange) {
			amountReturned = amountReturned.add(change.getValue());
		}
		return amountReturned;
	}
}
