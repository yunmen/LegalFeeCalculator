package net.funol.legalfee.legalcase;

import net.funol.legalfee.calculator.Calculator;
import net.funol.legalfee.calculator.PCAJSLFCalculator;

/**
 * 破产案件受理费
 */
public class PCAJSLFCase extends LegalCase {

    public PCAJSLFCase() {
        super("破产案件受理费", "破产案件依据破产财产总额计算，按照财产案件受理费标准减半交纳，但是，最高不超过30万元。");
    }

    @Override
    protected Calculator createCalculator() {
        return new PCAJSLFCalculator();
    }
}
