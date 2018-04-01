package com.roaim.smartlib;

import android.content.Context;
import android.content.res.Resources;

import com.roaim.smartlib.utils.SmartPref;

/**
 * Created by hridoy on 3/25/18.
 */

public interface BaseSmartPresenter {
    Context createContextWithLocale(Context newBase);
    void create();
    void start();
    void resume();
    void pause();
    void stop();
    void destroy();

    Context getContext();
    Resources getResources();
    String getString(int resId);
    SmartPref getSmartPref();
}
