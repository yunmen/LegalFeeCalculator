package net.funol.legalfee.calculator;

/**
 * 人格权案件受理费计算器
 */
public class RGQAJSLFCalculator extends CaseCalculator {
    @Override
    public String getResult() {
        double result;
        double input = getCurrentInputValue();
        if ((input > 50000) && (input <= 100000)) {
            result = (input - 50000) * 0.01;
            return formatNumber(result) + " + (100~500)";
        } else if (input > 100000) {
            result = (input - 100000) * 0.005 + 500;
            return formatNumber(result) + " + (100~500)";
        }
        return "100~500";
    }
}
