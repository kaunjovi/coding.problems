package coding.problems.vendingmachine;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Change {

	final static Logger logger = LoggerFactory.getLogger(Change.class);

	private final int numberOfHardCurrency;
	private final HardCurrency denomination;

	Change(int numberOfHardCurrency, HardCurrency denomination) {
		this.numberOfHardCurrency = numberOfHardCurrency;
		this.denomination = denomination;
	}

	public int getNumberOfHardCurrency() {
		return numberOfHardCurrency;
	}

	public HardCurrency getDenomination() {
		return denomination;
	}

	public BigDecimal getValue() {

		logger.debug("Number of notes [{}]. Denomination [{}].",
				numberOfHardCurrency, denomination.getValue());

		return denomination.getValue().multiply(
				new BigDecimal(numberOfHardCurrency));
	}
}
