package net.funol.legalfee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.Format;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cal_op_backspace)
    ImageView mOpBackspace;
    @BindView(R.id.cal_op_clear)
    TextView mOpClear;
    @BindView(R.id.cal_op_result)
    TextView mOpResult;
    @BindView(R.id.cal_result)
    TextView mResult;
    @BindView(R.id.cal_input)
    TextView mInput;

    private String input = "0";
    private String result = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mInput.setText(input);
        mResult.setText(result);

        setTitle("财产案件" + getTitle());
    }

    protected void addNumber(String num) {
        if (num.equals("0")) {
            if (input.equals("0")) {
                return;
            }
        }
        //输入.
        if (num.equals(".")) {
            if (input.contains(".")) {
                return;
            }
            if (input.equals("")) {
                input += "0";
            }
        }

        if (input.equals("0") && !num.equals(".")) {
            input = "";
        }
        input += num;

        if (num.equals(".")) {
            mInput.setText(input.substring(0, input.length() - 1));
        } else {
            mInput.setText(input);
        }
    }

    protected void backspace() {
        if (input.equals("0")) {
            return;
        }
        if (input.length() > 1) {
            input = input.substring(0, input.length() - 1);
        } else if (input.length() == 1) {
            input = "0";
        }
        mInput.setText(input);
    }

    protected void clear() {
        input = "0";
        mInput.setText(input);
    }

    public double getResult(double input) {
        if (input == 0) {
            return 0;
        }
        double result = 0;
        double level = 10000;
        double preLevel = 0;
        // 不超过1万元的，每件交纳50元；
        result += 50;
        preLevel = level;

        //2. 超过1万元至10万元的部分，按照2 .5 % 交纳；
        if (input > preLevel && input <= (level = 10 * 10000)) {
            result += (input - preLevel) * 0.025;
            preLevel = level;
        }
        //3. 超过10万元至20万元的部分，按照2 % 交纳；
        if (input > preLevel && input <= (level = 20 * 10000)) {
            result += (input - preLevel) * 0.02;
            preLevel = level;
        }
        //4. 超过20万元至50万元的部分，按照1 .5 % 交纳；
        if (input > preLevel && input <= (level = 50 * 10000)) {
            result += (input - preLevel) * 0.015;
            preLevel = level;
        }
        //5. 超过50万元至100万元的部分，按照1 % 交纳；
        if (input > preLevel && input <= (level = 100 * 10000)) {
            result += (input - preLevel) * 0.01;
            preLevel = level;
        }
        //6. 超过100万元至200万元的部分，按照0 .9 % 交纳；
        if (input > preLevel && input <= (level = 200 * 10000)) {
            result += (input - preLevel) * 0.009;
            preLevel = level;
        }
        //7. 超过200万元至500万元的部分，按照0 .8 % 交纳；
        if (input > preLevel && input <= (level = 500 * 10000)) {
            result += (input - preLevel) * 0.008;
            preLevel = level;
        }
        //8. 超过500万元至1000万元的部分，按照0 .7 % 交纳；
        if (input > preLevel && input <= (level = 1000 * 10000)) {
            result += (input - preLevel) * 0.007;
            preLevel = level;
        }
        // 9. 超过1000万元至2000万元的部分，按照0 .6 % 交纳；
        if (input > preLevel && input <= (level = 2000 * 10000)) {
            result += (input - preLevel) * 0.006;
            preLevel = level;
        }
        //10. 超过2000万元的部分，按照0 .5 % 交纳。
        if (input > (level = 2000 * 1000)) {
            result += (input - preLevel) * 0.005;
            preLevel = level;
        }
        BigDecimal b = new BigDecimal(result + "");
        result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    @OnClick({R.id.cal_number_7,
            R.id.cal_number_8,
            R.id.cal_number_9,
            R.id.cal_number_4,
            R.id.cal_number_5,
            R.id.cal_number_6,
            R.id.cal_number_1,
            R.id.cal_number_2,
            R.id.cal_number_3,
            R.id.cal_number_0,
            R.id.cal_number_dot,
            R.id.cal_op_backspace,
            R.id.cal_op_clear,
            R.id.cal_op_result})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cal_number_0:
                addNumber("0");
                break;
            case R.id.cal_number_1:
                addNumber("1");
                break;
            case R.id.cal_number_2:
                addNumber("2");
                break;
            case R.id.cal_number_3:
                addNumber("3");
                break;
            case R.id.cal_number_4:
                addNumber("4");
                break;
            case R.id.cal_number_5:
                addNumber("5");
                break;
            case R.id.cal_number_6:
                addNumber("6");
                break;
            case R.id.cal_number_7:
                addNumber("7");
                break;
            case R.id.cal_number_8:
                addNumber("8");
                break;
            case R.id.cal_number_9:
                addNumber("9");
                break;
            case R.id.cal_number_dot:
                addNumber(".");
                break;
            case R.id.cal_op_backspace:
                backspace();
                break;
            case R.id.cal_op_clear:
                clear();
                break;
            case R.id.cal_op_result:
                double in = Double.parseDouble(input);
                mResult.setText(getResult(in) + "");
                break;
        }
    }

}
