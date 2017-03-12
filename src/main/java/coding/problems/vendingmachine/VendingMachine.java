package coding.problems.vendingmachine;

import java.math.BigDecimal;

public interface VendingMachine {

	BigDecimal displayBalance();

	BigDecimal loadMoney(BigDecimal pAYMENT);

	int requestProduct(int pRODUCT_CODE);

	BigDecimal requestChange();

}
