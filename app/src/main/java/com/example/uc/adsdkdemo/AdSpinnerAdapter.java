package com.example.uc.adsdkdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by UC on 2017/9/26.
 */

public class AdSpinnerAdapter extends BaseAdapter {
    private Context mContext;
    private List<AdProperty> mData;
    private LayoutInflater mInflater;

    public AdSpinnerAdapter(Context context, List<AdProperty> data) {
        mData = data;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    @Override
    public AdProperty getItem(int i) {
        if (mData != null) {
            return mData.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) mInflater.inflate(android.R.layout.simple_list_item_single_choice, null);
        textView.setText(mData.get(i).getName());
        return textView;
    }
}
