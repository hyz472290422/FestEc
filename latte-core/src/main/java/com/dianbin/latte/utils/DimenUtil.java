package com.dianbin.latte.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.dianbin.latte.app.Latte;

/**
 * Created by 63206 on 2017/9/21.
 */

public class DimenUtil {

    public static  int getScreenWidth(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static  int getScreenHeight(){
        final  Resources resources = Latte.getApplication().getResources();
        final  DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
