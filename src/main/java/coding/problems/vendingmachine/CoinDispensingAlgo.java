package coding.problems.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinDispensingAlgo {

	final static Logger logger = LoggerFactory
			.getLogger(CoinDispensingAlgo.class);

	public static List<Change> convertToHardCurrencies(BigDecimal value) {

		List<Change> currencies = new ArrayList<Change>();

		// Get all the values of the Enum in decreasing order of value.
		List<HardCurrency> sortedCurrency = Arrays
				.asList(HardCurrency.values());
		Collections.sort(sortedCurrency, new HardCurrencyInverseComparator());

		for (HardCurrency curr : sortedCurrency) {

			int numberOfNotes = value.divide(curr.getValue()).intValue();

			logger.debug(
					"Total change to tender [{}]. Current currency [{}]. Number of notes [{}].",
					value, curr.getValue(), numberOfNotes);

			if (numberOfNotes > 0) {

				currencies.add(new Change(numberOfNotes, curr));
				value = value.subtract(curr.getValue().multiply(
						new BigDecimal(numberOfNotes)));
				logger.debug("Value remaining to tender [{}].", value);
			}

			// if the change remaining to tender back Is zero, we dont need to
			// go through this anymore.
			if (value.compareTo(BigDecimal.ZERO) == 0) {
				break;
			}
		}

		return currencies;

	}

}
