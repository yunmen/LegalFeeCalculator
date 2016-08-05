package net.funol.legalfee.calculator;

/**
 * 强制执行申请费计算器
 */
public class QZZXSQFCalculator extends CaseCalculator {
    @Override
    public String getResult() {
        double result = 0;
        double input = getCurrentInputValue();
        if ((input > 0) && (input < 10000)) {
            result = 50;
        } else if ((input >= 10000) && (input <= 500000)) {
            result = input * 0.015 - 100;
        } else if ((input >= 500000) && (input <= 5000000)) {
            result = input * 0.01 + 2400;
        } else if ((input >= 5000000) && (input <= 10000000)) {
            result = input * 0.005 + 27400;
        } else if (input > 10000000) {
            result = input * 0.001 + 67400;
        }
        if (result != 0) {
            return formatNumber(result);
        } else {
            return "50~500";
        }
    }
}
