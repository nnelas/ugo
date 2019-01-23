package com.nunonelas.ugo.activities.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.nunonelas.ugo.R;
import com.nunonelas.ugo.adapter.PlacesListViewAdapter;
import com.nunonelas.ugo.utils.Common;

import java.util.ArrayList;
import java.util.HashMap;

import static com.nunonelas.ugo.model.Constants.PLACE_CITY_COLUMN;
import static com.nunonelas.ugo.model.Constants.PLACE_DISTANCE_COLUMN;
import static com.nunonelas.ugo.model.Constants.PLACE_NAME_COLUMN;

/**
 * Created by nunonelas on 17/12/17.
 */

public class PlacesListFragment extends Fragment {

    ArrayList<HashMap<String, String>> list;

    public static PlacesListFragment newInstance() {
        return new PlacesListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listofplaces, container, false);

        setup(view);
        populateList(view);

        return view;
    }

    private void setup(View view){
        RelativeLayout mSearchBar = (RelativeLayout) getActivity().findViewById(R.id.fragment_searchbar);
        mSearchBar.setVisibility(View.VISIBLE);
        FrameLayout mFrameLayout = (FrameLayout) getActivity().findViewById(R.id.frame_layout);
        Common.setMargins(mFrameLayout, 0,30,0,0);
    }

    private void populateList(View view){
        ListView listView = (ListView) view.findViewById(R.id.places);

        list = new ArrayList<HashMap<String,String>>();

        //Just for dummy entries
        for (int i=0; i<15; i++) {
            HashMap<String, String> temp = new HashMap <String, String>();
            temp.put(PLACE_NAME_COLUMN, "Casa Independente");
            temp.put(PLACE_CITY_COLUMN, "Lisboa");
            temp.put(PLACE_DISTANCE_COLUMN, "a 3km de si");
            list.add(temp);
        }

        PlacesListViewAdapter adapter = new PlacesListViewAdapter(getActivity(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, EventsListFragment.newInstance());
                transaction.commit();
            }

        });
    }
}
