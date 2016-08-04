package net.funol.legalfee.legalcase;

import net.funol.legalfee.calculator.Calculator;
import net.funol.legalfee.calculator.SSFJBSECalculator;

/**
 * 诉讼费减半数额
 */
public class SSFJBSECase extends LegalCase {

    public SSFJBSECase() {
        super("诉讼费减半数额", "以调解方式结案或者当事人申请撤诉的，减半交纳案件受理费。适用简易程序审理的案件减半交纳案件受理费。被告提起反诉、有独立请求权的第三人提出与本案有关的诉讼请求，人民法院决定合并审理的，分别减半交纳案件受理费。");
    }

    @Override
    public Calculator createCalculator() {
        return new SSFJBSECalculator();
    }
}
