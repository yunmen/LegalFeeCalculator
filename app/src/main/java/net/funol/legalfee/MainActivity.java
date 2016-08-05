package net.funol.legalfee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import net.funol.legalfee.legalcase.CCAJSLFCase;
import net.funol.legalfee.legalcase.CCBQSQFCase;
import net.funol.legalfee.legalcase.LHAJSLFCase;
import net.funol.legalfee.legalcase.LegalCase;
import net.funol.legalfee.legalcase.PCAJSLFCase;
import net.funol.legalfee.legalcase.QZZXSQFCase;
import net.funol.legalfee.legalcase.RGQAJSLFCase;
import net.funol.legalfee.legalcase.SSFJBSECase;
import net.funol.legalfee.legalcase.ZFLSQFCase;
import net.funol.legalfee.legalcase.ZSCQAJSLFCase;
import net.funol.legalfee.utils.Dimension;
import net.funol.legalfee.widget.AutoResizeTextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.cal_op_backspace)
    ImageView mOpBackspace;
    @BindView(R.id.cal_op_clear)
    TextView mOpClear;
    @BindView(R.id.cal_op_result)
    TextView mOpResult;
    @BindView(R.id.cal_result)
    TextView mResult;
    @BindView(R.id.cal_input)
    AutoResizeTextView mInput;
    @BindView(R.id.main_spinner)
    Spinner mSpinner;

    private LegalCaseSpinnerAdapter mAdapter;

    private LegalCase mCurrentLegalCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new LegalCaseSpinnerAdapter(this, getSupportLegalCases());
        mSpinner.setOnItemSelectedListener(this);
        mSpinner.setAdapter(mAdapter);
        mSpinner.setSelection(0);

        mInput.setMaxLines(3);
        mResult.setMaxLines(3);
    }

    protected void input(char num) {
        mInput.setText(mCurrentLegalCase.getCalculator().input(num));
    }

    protected void backspace() {
        mInput.setText(mCurrentLegalCase.getCalculator().backspace());
    }

    protected void clear() {
        mInput.setText(mCurrentLegalCase.getCalculator().clear());
        result();
    }

    public void result() {
        mResult.setText(mCurrentLegalCase.getCalculator().getResult());
    }

    /**
     * 获取支持计算的案件类型
     *
     * @return List<LegalCase>
     */
    private List<LegalCase> getSupportLegalCases() {
        List<LegalCase> cases = new ArrayList<>();
        cases.add(new CCAJSLFCase());
        cases.add(new CCBQSQFCase());
        cases.add(new QZZXSQFCase());
        cases.add(new LHAJSLFCase());
        cases.add(new ZFLSQFCase());
        cases.add(new RGQAJSLFCase());
        cases.add(new PCAJSLFCase());
        cases.add(new ZSCQAJSLFCase());
        //cases.add(new SSFJBSECase());
        return cases;
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
            R.id.cal_op_result,
            R.id.help})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cal_number_0:
            case R.id.cal_number_1:
            case R.id.cal_number_2:
            case R.id.cal_number_3:
            case R.id.cal_number_4:
            case R.id.cal_number_5:
            case R.id.cal_number_6:
            case R.id.cal_number_7:
            case R.id.cal_number_8:
            case R.id.cal_number_9:
            case R.id.cal_number_dot:
                input(((TextView) view).getText().charAt(0));
                break;
            case R.id.cal_op_backspace:
                backspace();
                break;
            case R.id.cal_op_clear:
                clear();
                break;
            case R.id.cal_op_result:
                result();
                break;
            case R.id.help:
                Intent intent = new Intent(this, HelpActivity.class);
                intent.putExtra("title", mCurrentLegalCase.getName());
                intent.putExtra("content", mCurrentLegalCase.getDescribe());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mCurrentLegalCase = mAdapter.getItem(position);
        clear();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mSpinner.setSelection(0);
    }
}
