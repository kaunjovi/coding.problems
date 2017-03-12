package coding.problems.vendingmachine;

import java.math.BigDecimal;

public interface VendingMachine {

	BigDecimal displayBalance();

	// You could load money using digital payment method.
	BigDecimal loadMoney(BigDecimal pAYMENT);

	// You could load money by putting in currencies.
	BigDecimal loadMoney(HardCurrency cash);

	int requestProduct(int pRODUCT_CODE);

	BigDecimal requestChange();

}
