package net.funol.legalfee.calculator;

/**
 * 财产保全申请费计算器
 */
public class CCBQSQFCalculator extends CaseCalculator {

    @Override
    public String getResult() {
        double result = 0;
        double input = getCurrentInputValue();
        if ((input > 0) && (input <= 1000)) {
            result = 30;
        } else if ((input > 1000) && (input <= 100000)) {
            result = input * 0.01 + 20;
        } else if (input > 100000) {
            result = input * 0.005 + 520;
        }
        if ((result >= 5000)) {
            result = 5000;
        }
        return formatNumber(result);
    }

}
