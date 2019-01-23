package com.nunonelas.ugo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nunonelas.ugo.R;
import com.squareup.picasso.Picasso;

/**
 * Created by nunonelas on 16/12/17.
 */

public class ImageAdapter extends PagerAdapter {

    Context context;

    private int[] GalImages = new int[] {
            R.drawable.img_01,
            R.drawable.img_02,
            R.drawable.img_03
    };

    public ImageAdapter (Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Picasso.with(context)
                .load(GalImages[position])
                .fit()
                .centerCrop()
                .into(imageView);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}