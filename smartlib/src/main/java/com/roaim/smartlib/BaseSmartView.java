package com.roaim.smartlib;

import android.app.Activity;
import android.content.res.Resources;

/**
 * Created by Roaim on 01-Oct-17.
 */

public interface BaseSmartView {
    void onSetUpViews();
    void onShowProgress(String msg);
    void onHideProgress();

    boolean isActivityAlive();
    Activity getActivity();
    Resources getRes();
    String getStr(int resId);
}