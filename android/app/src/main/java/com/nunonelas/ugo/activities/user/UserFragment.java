package com.nunonelas.ugo.activities.user;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nunonelas.ugo.R;
import com.nunonelas.ugo.utils.Common;

/**
 * Created by nunonelas on 12/12/17.
 */

public class UserFragment extends Fragment {

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        setup(view);

        TextView mBtnDef = (TextView) view.findViewById(R.id.btn_user_def);
        mBtnDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, UserPrefFragment.newInstance());
                transaction.commit();
            }
        });

        View photoHeader = view.findViewById(R.id.user_profile_photo);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
        /* For devices equal or higher than lollipop set the translation above everything else */
            photoHeader.bringToFront();
        /* Redraw the view to show the translation */
            photoHeader.invalidate();
        }

        return view;
    }

    private void setup(View view){
        RelativeLayout mSearchBar = (RelativeLayout) getActivity().findViewById(R.id.fragment_searchbar);
        mSearchBar.setVisibility(View.GONE);
        FrameLayout mFrameLayout = (FrameLayout) getActivity().findViewById(R.id.frame_layout);
        Common.setMargins(mFrameLayout, 0,0,0,0);
    }
}