package com.example.eronmac.actwellness;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.eronmac.actwellness.Excercises;

import java.util.List;

/**
 * Created by zaira on 4/19/2017.
 */

public class ExcerciseAdapter extends BaseAdapter{
    private Context myContext;
    private List<Excercises> mExcercisesList;

    public ExcerciseAdapter(Context myContext, List<Excercises> mExcercisesList) {
        this.myContext = myContext;
        this.mExcercisesList = mExcercisesList;
    }

    @Override
    public int getCount() {
        return mExcercisesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mExcercisesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mExcercisesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(myContext, R.layout.item_listview, null);
        TextView tvName = (TextView)v.findViewById(R.id.tv_exc_name);
        TextView tvReps = (TextView)v.findViewById(R.id.tv_product_reps);
        TextView tvSets = (TextView)v.findViewById(R.id.tv_exc_sets);
        tvName.setText(mExcercisesList.get(position).getName());
        tvReps.setText(mExcercisesList.get(position).getReps());
        tvSets.setText(mExcercisesList.get(position).getSets());
        /**tvReps.setText(String.valueOf(mExcercisesList.get(position).getReps()));
        tvSets.setText(String.valueOf(mExcercisesList.get(position).getSets()));*/
        return v;
    }
}
