package net.funol.legalfee.calculator;

/**
 * 支付令申请费计算器
 */
public class ZFLSQFCalculator extends CaseCalculator {
    @Override
    public String getResult() {
        double result = 0;
        double input = getCurrentInputValue();
        if ((input > 0) && (input <= 10000)) {
            result = 16.67;
        } else if ((input > 10000) && (input <= 100000)) {
            result = (input * 0.025 - 200) / 3;
        } else if ((input > 100000) && (input <= 200000)) {
            result = (input * 0.02 + 300) / 3;
        } else if ((input > 200000) && (input <= 500000)) {
            result = (input * 0.015 + 1300) / 3;
        } else if ((input > 500000) && (input <= 1000000)) {
            result = (input * 0.01 + 3800) / 3;
        } else if ((input > 1000000) && (input <= 2000000)) {
            result = (input * 0.009 + 4800) / 3;
        } else if ((input > 2000000) && (input <= 5000000)) {
            result = (input * 0.008 + 6800) / 3;
        } else if ((input > 5000000) && (input <= 10000000)) {
            result = (input * 0.007 + 11800) / 3;
        } else if ((input > 10000000) && (input <= 20000000)) {
            result = (input * 0.006 + 21800) / 3;
        } else if (input > 20000000) {
            result = (input * 0.005 + 41800) / 3;
        }
        return formatNumber(result) + "";
    }
}
