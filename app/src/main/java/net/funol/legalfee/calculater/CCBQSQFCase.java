package net.funol.legalfee.calculater;

/**
 * 财产保全申请费
 */
public class CCBQSQFCase extends LegalCase {

    public CCBQSQFCase() {
        super("财产保全申请费", "财产保全数额不超过1000元或者不涉及财产数额的，每件交纳30元；超过1000元至10万元的部分，按照1%交纳；超过10万元的部分，按照0.5％交纳。但是，当事人申请保全措施交纳的费用最多不超过5000元。");
    }

    @Override
    public Calculator createCalculator() {
        return new CCBQSQFCalculator();
    }

}
