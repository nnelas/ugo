package com.nunonelas.ugo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.nunonelas.ugo.R;
import com.nunonelas.ugo.activities.events.PlacesListFragment;
import com.nunonelas.ugo.utils.Common;

/**
 * Created by nunonelas on 12/12/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setup(view);

        return view;
    }

    private void setup(View view){
        RelativeLayout mSearchBar = (RelativeLayout) getActivity().findViewById(R.id.fragment_searchbar);
        mSearchBar.setVisibility(View.VISIBLE);
        FrameLayout mFrameLayout = (FrameLayout) getActivity().findViewById(R.id.frame_layout);
        Common.setMargins(mFrameLayout, 0,30,0,0);

        ImageButton mBtnAttractions = (ImageButton) view.findViewById(R.id.btn_attractions);
        ImageButton mBtnMuseum = (ImageButton) view.findViewById(R.id.btn_museum);
        ImageButton mBtnTheatre = (ImageButton) view.findViewById(R.id.btn_theatre);
        ImageButton mBtnFestivals = (ImageButton) view.findViewById(R.id.btn_festivals);

        mBtnAttractions.setOnClickListener(this);
        mBtnMuseum.setOnClickListener(this);
        mBtnTheatre.setOnClickListener(this);
        mBtnFestivals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {
            case R.id.btn_attractions:
            case R.id.btn_museum:
            case R.id.btn_theatre:
            case R.id.btn_festivals:
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, PlacesListFragment.newInstance());
                transaction.commit();
                break;
        }
    }
}