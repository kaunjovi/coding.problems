package coding.problems.vendingmachine;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum HardCurrency {
	TWO_THOUSAND(2000), FIVE_HUNDRED(500), HUNDRED(100), FIFTY(50), TWENTY(20), TEN(
			10), FIVE(5), ONE(1);

	final static Logger logger = LoggerFactory.getLogger(HardCurrency.class);

	private final BigDecimal value;

	HardCurrency(int value) {
		this.value = new BigDecimal(value);
	}

	public BigDecimal getValue() {
		return value;
	}

}
