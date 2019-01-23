package com.nunonelas.ugo.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nunonelas.ugo.R;
import com.nunonelas.ugo.activities.events.SuggestionsFragment;
import com.nunonelas.ugo.activities.events.WhatsNewFragment;
import com.nunonelas.ugo.activities.user.UserFragment;

import lib.kingja.switchbutton.SwitchMultiButton;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mOrderFragment;
    private boolean itsclosedfragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton mOpenFragment = (ImageButton) findViewById(R.id.btn_open_order);
        mOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itsclosedfragment){
                    mOrderFragment.setVisibility(View.VISIBLE);
                    itsclosedfragment = false;
                } else {
                    mOrderFragment.setVisibility(View.GONE);
                    itsclosedfragment = true;
                }
            }
        });

        createFragmentOrderBy();
        mOrderFragment = (RelativeLayout) findViewById(R.id.fragment_orderby);
        mOrderFragment.bringToFront();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.bottom_nav_whatsnew:
                                selectedFragment = WhatsNewFragment.newInstance();
                                break;
                            case R.id.bottow_nav_home:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.bottom_nav_suggestions:
                                selectedFragment = SuggestionsFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_account:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, UserFragment.newInstance());
                transaction.commit();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createFragmentOrderBy(){
        SwitchMultiButton mSMBPrice = (SwitchMultiButton) findViewById(R.id.switch_price);
        mSMBPrice.setText("Mais barato", "Mais caro").setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });

        SwitchMultiButton mSMBDate = (SwitchMultiButton) findViewById(R.id.switch_date);
        mSMBDate.setText("Mais recente", "Mais antigo").setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });

        SwitchMultiButton mSMBCat = (SwitchMultiButton) findViewById(R.id.switch_cat);
        mSMBCat.setText("Museus", "Concertos", "Atracções", "Teatros").setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });

        SwitchMultiButton mSMBLocation = (SwitchMultiButton) findViewById(R.id.switch_location);
        mSMBLocation.setText("Mais longe", "Mais perto").setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}