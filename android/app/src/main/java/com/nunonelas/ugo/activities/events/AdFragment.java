package com.nunonelas.ugo.activities.events;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nunonelas.ugo.R;
import com.nunonelas.ugo.adapter.ImageAdapter;
import com.nunonelas.ugo.utils.Common;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by nunonelas on 16/12/17.
 */

public class AdFragment extends Fragment implements OnMapReadyCallback {

    public static AdFragment newInstance() {
        return new AdFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ad, container, false);

        setup(view);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(getContext());
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
        /* For devices equal or higher than lollipop set the translation above everything else */
            indicator.bringToFront();
        /* Redraw the view to show the translation */
            //photoHeader.invalidate();
        }

        ImageView mImageBol = (ImageView) view.findViewById(R.id.img_logo_bol);
        mImageBol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bol.pt/"));
                startActivity(intent);
            }
        });

        ImageView mImageBlueTicket = (ImageView) view.findViewById(R.id.img_logo_blueticket);
        mImageBlueTicket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://blueticket.pt/"));
                startActivity(intent);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng marker = new LatLng(38.720961,-9.1357513);
        googleMap.addMarker(new MarkerOptions().position(marker).title("Casa Independente"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker));
    }

    private void setup(View view){
        RelativeLayout mSearchBar = (RelativeLayout) getActivity().findViewById(R.id.fragment_searchbar);
        mSearchBar.setVisibility(View.GONE);
        FrameLayout mFrameLayout = (FrameLayout) getActivity().findViewById(R.id.frame_layout);
        Common.setMargins(mFrameLayout, 0,0,0,0);
    }
}
