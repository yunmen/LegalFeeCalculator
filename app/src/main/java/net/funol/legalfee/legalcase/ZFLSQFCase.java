package net.funol.legalfee.legalcase;

import net.funol.legalfee.calculator.Calculator;
import net.funol.legalfee.calculator.ZFLSQFCalculator;

/**
 * 支付令申请费
 */
public class ZFLSQFCase extends LegalCase {

    public ZFLSQFCase() {
        super("支付令申请费", "依法申请支付令的，比照财产案件受理费标准的1/3交纳。");
    }

    @Override
    public Calculator createCalculator() {
        return new ZFLSQFCalculator();
    }
}
