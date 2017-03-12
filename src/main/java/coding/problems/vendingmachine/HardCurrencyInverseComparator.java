package coding.problems.vendingmachine;

import java.util.Comparator;

public class HardCurrencyInverseComparator implements Comparator<HardCurrency> {

	@Override
	public int compare(HardCurrency o1, HardCurrency o2) {
		return o2.getValue().compareTo(o1.getValue());
	}

}
