package coding.problems.vendingmachine;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestVendingMachine {

	final static Logger logger = LoggerFactory
			.getLogger(TestVendingMachine.class);

	@Test
	public void testSimpleVendingMachine() {

		final int PRODUCT_CODE = 100;
		final BigDecimal START_BALANCE = new BigDecimal(0);
		final BigDecimal PAYMENT = new BigDecimal(10);
		final BigDecimal EXPECTED_CHANGE = new BigDecimal(2.75);

		logger.debug("Test case : Product code {} and Payment {}.",
				PRODUCT_CODE, PAYMENT);

		VendingMachine simpleVendingMachine = new SimpleVendingMachine();

		BigDecimal balance = simpleVendingMachine.displayBalance();
		logger.debug(
				"We expect the balance to be 0 at the begining. Balance {}.",
				balance);
		assertTrue("Balance has an unexpected value.",
				balance.compareTo(START_BALANCE) == 0);

		balance = simpleVendingMachine.loadMoney(PAYMENT);
		logger.debug("Balance {}. Payment {}.", balance, PAYMENT);
		assertTrue("Balance returned was not as expected.",
				balance.compareTo(PAYMENT) == 0);

		int exitCode = simpleVendingMachine.requestProduct(PRODUCT_CODE);
		logger.debug("Exit code {}. Product code {}.", exitCode, PRODUCT_CODE);
		assertTrue("The exit code is not as expected.",
				exitCode == PRODUCT_CODE);

		BigDecimal changeTendered = simpleVendingMachine.requestChange();

		logger.debug("Change Tendered {}. Expected change {}.", changeTendered,
				EXPECTED_CHANGE);
		assertTrue("The change tendered is not as expected.",
				changeTendered.compareTo(EXPECTED_CHANGE) == 0);

		fail("Not yet implemented");
	}
}
