package net.funol.legalfee.calculater;

/**
 * 知识产权案受理费
 */
public class ZSCQAJSLFCase extends LegalCase {

    public ZSCQAJSLFCase() {
        super("知识产权案受理费", "知识产权民事案件，没有争议金额或者价额的，每件交纳500元至1000元；有争议金额或者价额的，按照财产案件的标准交纳。省、自治区、直辖市人民政府可以结合本地实际情况在规定的幅度内制定具体交纳标准。");
    }

    @Override
    public Calculator createCalculator() {
        return new ZSCQAJSLFCalculator();
    }
}
