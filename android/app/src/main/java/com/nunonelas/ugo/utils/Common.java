package com.nunonelas.ugo.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nunonelas on 17/12/17.
 */

public class Common {

    public static void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
