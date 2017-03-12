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

	public static List<HardCurrency> convertToHardCurrencies(BigDecimal value) {

		List<HardCurrency> sortedCurrency = Arrays
				.asList(HardCurrency.values());
		Collections.sort(sortedCurrency, new HardCurrencyInverseComparator());

		for (HardCurrency curr : sortedCurrency) {
			logger.debug("{}", curr.getValue());
		}

		List<HardCurrency> currencies = new ArrayList<HardCurrency>();

		return currencies;

	}

}
