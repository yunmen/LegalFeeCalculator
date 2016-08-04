package net.funol.legalfee.calculater;

/**
 * Created by ZHAOWEIWEI on 2016/8/4.
 */
public abstract class LegalCase {

    private String name;
    private String describe;
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

    public abstract Calculator createCalculator();

}
