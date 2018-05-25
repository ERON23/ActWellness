package com.example.eronmac.actwellness;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class SleepAdapter extends BaseAdapter {

    private Activity activity;
    private List<String> whats;
    private List<String> whens;


    public SleepAdapter(Activity activity, List<String> itemWhats, List<String> itemWhens) {
        super();
        this.activity = activity;
        this.whats = itemWhats;
        this.whens = itemWhens;
    }

    @Override
    public int getCount() {
        return whats.size();
    }

    @Override
    public Object getItem(int position) {
        return whats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.sleep_row_layout, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.what);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.time);
            holder.txtThird = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        String what = whats.get(position);
        String when = whens.get(position);

        Log.d("ADAPTER >>>", "WHEN: "+when+" WHAT: "+what);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime(when);

        String clock = dt.getHourOfDay() + ":" + dt.getMinuteOfHour();
        //String date = dt.getDayOfMonth() + "/" + dt.getMonthOfYear() + " - " +dt.getYearOfCentury();
        String date = "(" + dt.getMonthOfYear() + "/" + dt.getDayOfMonth() + "/" +dt.getYearOfCentury() +")";

        if (what.equals("Slept @")) {
            holder.txtFirst.setText(what+"  ");
        } else {
            holder.txtFirst.setText(what);
        }

        holder.txtSecond.setText(clock);
        holder.txtThird.setText(date);

        return convertView;
    }

}
