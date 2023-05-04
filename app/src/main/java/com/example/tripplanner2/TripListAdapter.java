package com.example.tripplanner2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TripListAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<TripModel> mTripListModel;

    public TripListAdapter(Context context,List< TripModel> tripList) {
        mContext = context;
        mTripListModel = tripList;
    }
    private static class ViewHolder {
        TextView nameTextView;
        TextView destinationTextView;
        TextView datestartTextView;
        TextView dateendTextView;
    }


    @Override
    public int getCount() {
        return mTripListModel.size();
    }

    @Override
    public Object getItem(int position) {
        return mTripListModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTripListModel.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.trip_list_item, parent, false);
            holder = new ViewHolder();
            holder.nameTextView = convertView.findViewById(R.id.nameTripEditText);
            holder.destinationTextView = convertView.findViewById(R.id.locationEditText);

            holder.datestartTextView = convertView.findViewById(R.id.startDateEditText);
            holder.dateendTextView = convertView.findViewById(R.id.endDateEditText);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TripModel tripModel = mTripListModel.get(position);
        holder.nameTextView.setText(tripModel.getLocation());
        holder.destinationTextView.setText(tripModel.getLocation());

        holder.datestartTextView.setText(tripModel.getStartDate());
        holder.dateendTextView.setText(tripModel.getEndDate());


        return convertView;
    }



    }

