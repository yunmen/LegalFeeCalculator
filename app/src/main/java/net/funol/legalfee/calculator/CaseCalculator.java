package net.funol.legalfee.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by ZHAOWEIWEI on 2016/8/5.
 */
public abstract class CaseCalculator implements Calculator {

    protected String mCurrentDisplay = "0";
    private DecimalFormat mResultFormater;

    public CaseCalculator() {
        mResultFormater = new DecimalFormat("#,###.00");
        clear();
    }

    @Override
    public String input(char input) {

        if (mCurrentDisplay.contains(".") &&
                mCurrentDisplay.split("\\.").length > 1 && mCurrentDisplay.split("\\.")[1].length() == 2) {
            return getDisplay();
        }

        //输入0
        if (input == '0') {
            if (mCurrentDisplay.equals("0")) {
                return getDisplay();
            }
        }

        //输入.
        if (input == '.') {
            if (mCurrentDisplay.contains(".")) {
                return getDisplay();
            }
            if (mCurrentDisplay.equals("")) {
                mCurrentDisplay += "0";
                mCurrentDisplay += input;
                return getDisplay();
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
        if (mCurrentDisplay.length() > 1 && mCurrentDisplay.charAt(mCurrentDisplay.length() - 1) == '.') {
            return formatDisplay(mCurrentDisplay.substring(0, mCurrentDisplay.length() - 1));
        }
        return formatDisplay(mCurrentDisplay);
    }

    public double getCurrentInputValue() {
        return Double.parseDouble(mCurrentDisplay);
    }

    protected String formatNumber(double number) {
        return mResultFormater.format(new BigDecimal(number + "").setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    private String formatDisplay(String display) {
        DecimalFormat format = new DecimalFormat("###,###");
        if (display.contains(".") && mCurrentDisplay.split("\\.").length > 1) {
            display = format.format((int) Double.parseDouble(display)) + "." + display.split("\\.")[1];
        } else {
            display = format.format(Double.parseDouble(display));
        }
        return display;
    }

    @Override
    public abstract String getResult();
}
