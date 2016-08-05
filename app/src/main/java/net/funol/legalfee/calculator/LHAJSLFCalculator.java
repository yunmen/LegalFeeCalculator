package net.funol.legalfee.calculator;

/**
 * 离婚案件受理费计算器
 */
public class LHAJSLFCalculator extends CaseCalculator {
    @Override
    public String getResult() {
        double result;
        double input = getCurrentInputValue();
        if (input > 200000) {
            result = (input - 200000) * 0.005;
            return formatNumber(result) + " + (50~300)";
        }
        return "50~300";
    }
}
