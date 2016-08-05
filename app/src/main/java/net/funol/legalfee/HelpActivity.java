package net.funol.legalfee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelpActivity extends AppCompatActivity {

    @BindView(R.id.help_content)
    TextView mContent;
    @BindView(R.id.help_title)
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);

        mTitle.setText(getIntent().getStringExtra("title"));
        mContent.setText("\u3000\u3000" + getIntent().getStringExtra("content"));
    }

    @OnClick(R.id.help_title)
    public void onClick() {
        finish();
    }
}
