package net.funol.legalfee.calculator;

/**
 * 知识产权案受理费计算器
 */
public class ZSCQAJSLFCalculator extends CaseCalculator {
    @Override
    public String getResult() {
        double result = 0;
        double shuru = getCurrentInputValue();
        if ((shuru > 0) && (shuru <= 10000)) {
            result = 50;
        } else if ((shuru > 10000) && (shuru <= 100000)) {
            result = shuru * 0.025 - 200;
        } else if ((shuru > 100000) && (shuru <= 200000)) {
            result = shuru * 0.02 + 300;
        } else if ((shuru > 200000) && (shuru <= 500000)) {
            result = shuru * 0.015 + 1300;
        } else if ((shuru > 500000) && (shuru <= 1000000)) {
            result = shuru * 0.01 + 3800;
        } else if ((shuru > 1000000) && (shuru <= 2000000)) {
            result = shuru * 0.009 + 4800;
        } else if ((shuru > 2000000) && (shuru <= 5000000)) {
            result = shuru * 0.008 + 6800;
        } else if ((shuru > 5000000) && (shuru <= 10000000)) {
            result = shuru * 0.007 + 11800;
        } else if ((shuru > 10000000) && (shuru <= 20000000)) {
            result = shuru * 0.006 + 21800;
        } else if (shuru > 20000000) {
            result = shuru * 0.005 + 41800;
        }
        if (result != 0) {
            return formatNumber(result) + "";
        }
        return "500~1000";
    }
}
