package com.roaim.smartlib.app;

import android.content.Context;
import android.content.res.Resources;

import com.roaim.smartlib.BaseSmartPresenter;
import com.roaim.smartlib.BaseSmartView;
import com.roaim.smartlib.utils.SmartPref;
import com.roaim.smartlib.utils.SmartPrefCreator;

import java.util.Locale;

/**
 * Created by hridoy on 3/25/18.
 */

public class SmartPresenter<V extends BaseSmartView> implements BaseSmartPresenter {
    private V view;
    private SmartPref smartPref;

    public V getView() {
        return view;
    }

    public SmartPresenter(V view) {
        this.view = view;
    }

    @Override
    public Context createContextWithLocale(Context newBase) {
        this.smartPref = SmartPrefCreator.createDefault(newBase);
        Locale locale = smartPref.getLocale();
        return SmartContextWrapper.wrap(newBase, locale);
    }

    @Override
    public void create() {
        view.onSetUpViews();
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        view = null;
        smartPref.destroy();
        smartPref = null;
    }

    @Override
    public Context getContext() {
        return view.getActivity();
    }

    @Override
    public Resources getResources() {
        return view.getRes();
    }

    @Override
    public String getString(int resId) {
        return view.getStr(resId);
    }

    @Override
    public SmartPref getSmartPref() {
        return smartPref;
    }
}
