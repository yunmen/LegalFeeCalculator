package net.funol.legalfee.legalcase;

import net.funol.legalfee.calculator.Calculator;

/**
 * Created by ZHAOWEIWEI on 2016/8/4.
 */
public abstract class LegalCase {

    private String name;
    private String describe;
    /** 标的额 案件总额*/
    private double targetAmount;
    /** 诉讼费 */
    private double legalFee;
    private Calculator calculator;

    public LegalCase(String name, String describe) {
        this.name = name;
        this.describe = describe;
        this.calculator = createCalculator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getLegalFee() {
        return legalFee;
    }

    public void setLegalFee(double legalFee) {
        this.legalFee = legalFee;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    protected abstract Calculator createCalculator();

}
