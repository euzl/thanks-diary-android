package com.euzl.thanks_diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MomentAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MomentData> moment;

    public MomentAdapter(Context context, ArrayList<MomentData> data) {
        mContext = context;
        moment = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return moment.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MomentData getItem(int position) {
        return moment.get(position);
    }

    // TODO: 2020-04-09 예제는 했으니 정리좀 합시다 ~~ 
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.view_thanks, null);

        TextView month = (TextView)view.findViewById(R.id.month);
        TextView date = (TextView)view.findViewById(R.id.date);

//        month.setText(moment.get(position).getDate());
        date.setText(moment.get(position).getThing());

        return view;
    }
}
