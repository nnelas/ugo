package com.nunonelas.ugo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nunonelas.ugo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import static com.nunonelas.ugo.model.Constants.EVENT_NAME_COLUMN;
import static com.nunonelas.ugo.model.Constants.PLACE_CITY_COLUMN;
import static com.nunonelas.ugo.model.Constants.PLACE_NAME_COLUMN;

/**
 * Created by nunonelas on 17/12/17.
 */

public class EventsListViewAdapter extends BaseAdapter {

    private ArrayList<HashMap<String, String>> list;

    private Activity activity;

    private TextView mEventName;
    private TextView mPlaceName;
    private TextView mPlaceCity;

    public EventsListViewAdapter (Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = activity.getLayoutInflater();

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_events, null);

            mEventName = (TextView) convertView.findViewById(R.id.str_event_name);
            mPlaceName = (TextView) convertView.findViewById(R.id.str_place_name);
            mPlaceCity = (TextView) convertView.findViewById(R.id.str_place_city);

        }

        HashMap<String, String> map=list.get(position);
        mEventName.setText(map.get(EVENT_NAME_COLUMN));
        mPlaceName.setText(map.get(PLACE_NAME_COLUMN));
        mPlaceCity.setText(map.get(PLACE_CITY_COLUMN));

        return convertView;
    }

}
