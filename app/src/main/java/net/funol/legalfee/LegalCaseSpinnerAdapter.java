package net.funol.legalfee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.funol.legalfee.legalcase.LegalCase;

import java.util.ArrayList;
import java.util.List;

public class LegalCaseSpinnerAdapter extends BaseAdapter {

    private Context mContext;
    private List<LegalCase> mItems = new ArrayList<>();

    public LegalCaseSpinnerAdapter(Context context, List<LegalCase> items) {
        this.mItems = items;
        this.mContext = context;
        if(mItems == null){
            mItems = new ArrayList<>();
        }
    }

    public void clear() {
        mItems.clear();
    }

    public void addItem(LegalCase legalCase) {
        mItems.add(legalCase);
    }

    public void addItems(List<LegalCase> legalCases) {
        mItems.addAll(legalCases);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public LegalCase getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_spinner_list, parent, false);
            view.setTag("DROPDOWN");
        }

        TextView textView = (TextView) view.findViewById(R.id.spinner_name);
        textView.setText(getTitle(position));

        return view;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
            view = LayoutInflater.from(mContext).inflate(R.layout.
                    item_spinner_selected, parent, false);
            view.setTag("NON_DROPDOWN");
        }
        TextView textView = (TextView) view.findViewById(R.id.spinner_name);
        textView.setText(getTitle(position));
        return view;
    }

    private String getTitle(int position) {
        return position >= 0 && position < mItems.size() ? mItems.get(position).getName() : "";
    }
}