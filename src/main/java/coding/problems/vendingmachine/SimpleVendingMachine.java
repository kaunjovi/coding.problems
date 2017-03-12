package coding.problems.vendingmachine;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleVendingMachine implements VendingMachine {

	final static Logger logger = LoggerFactory
			.getLogger(SimpleVendingMachine.class);

	BigDecimal balance = BigDecimal.ZERO;

	@Override
	public BigDecimal displayBalance() {
		logger.debug("The current balance is {}.", balance);
		return balance;
	}

	@Override
	public BigDecimal loadMoney(BigDecimal payment) {

		logger.debug(
				"The current balance is {}. Payment of {} is being added.",
				balance, payment);

		balance = balance.add(payment);

		return balance;
	}

	@Override
	public int requestProduct(int productCode) {

		// TODO Provide code here. There needs to be check about the cost and
		// availability of the product.

		return productCode;
	}

	@Override
	public BigDecimal requestChange() {
		BigDecimal changeTendered = new BigDecimal(balance.doubleValue());
		balance = BigDecimal.ZERO;

		logger.debug("Balance money has been returned {}", changeTendered);

		return changeTendered;
	}

}
