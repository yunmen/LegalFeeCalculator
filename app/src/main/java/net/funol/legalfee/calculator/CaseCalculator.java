package net.funol.legalfee.calculator;

import java.math.BigDecimal;

/**
 * Created by ZHAOWEIWEI on 2016/8/5.
 */
public abstract class CaseCalculator implements Calculator {

    protected String mCurrentDisplay = "0";

    public CaseCalculator() {
        clear();
    }

    @Override
    public String input(char input) {

        //输入0
        if (input == '0') {
            if (mCurrentDisplay.equals("0")) {
                return mCurrentDisplay;
            }
        }

        //输入.
        if (input == '.') {
            if (mCurrentDisplay.contains(".")) {
                return mCurrentDisplay;
            }
            if (mCurrentDisplay.equals("")) {
                mCurrentDisplay += "0";
                mCurrentDisplay += input;
                return mCurrentDisplay;
            }
        }

        if (mCurrentDisplay.equals("0") && input != '.') {
            mCurrentDisplay = "";
        }
        mCurrentDisplay += input;

        return getDisplay();
    }

    @Override
    public String backspace() {
        if (mCurrentDisplay.equals("0")) {
            return getDisplay();
        }
        if (mCurrentDisplay.length() > 1) {
            mCurrentDisplay = mCurrentDisplay.substring(0, mCurrentDisplay.length() - 1);
        } else if (mCurrentDisplay.length() == 1) {
            mCurrentDisplay = "0";
        }
        return getDisplay();
    }

    @Override
    public String clear() {
        mCurrentDisplay = "0";
        return getDisplay();
    }

    @Override
    public String getDisplay() {
        if (mCurrentDisplay.charAt(mCurrentDisplay.length() - 1) == '.') {
            return mCurrentDisplay.substring(0, mCurrentDisplay.length() - 1);
        }
        return mCurrentDisplay;
    }

    public double getCurrentInputValue() {
        return Double.parseDouble(mCurrentDisplay);
    }

    protected double formatNumber(double number) {
        BigDecimal b = new BigDecimal(number + "");
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public abstract String getResult();
}
