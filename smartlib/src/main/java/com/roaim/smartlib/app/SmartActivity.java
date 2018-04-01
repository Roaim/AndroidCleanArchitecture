package com.roaim.smartlib.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roaim.smartlib.BaseSmartPresenter;
import com.roaim.smartlib.BaseSmartView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hridoy on 3/25/18.
 */

public abstract class SmartActivity<P extends BaseSmartPresenter> extends AppCompatActivity implements BaseSmartView {
    public static final int SPLASH = -17;
    private Unbinder unBinder;
    private P presenter;
    private boolean isFinished;

    protected abstract int getContentLayout();

    protected abstract P onInitPresenter();

    public P getPresenter() {
        return this.presenter;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        presenter = onInitPresenter();
        Context contextWithLocale = presenter.createContextWithLocale(newBase);
        super.attachBaseContext(contextWithLocale);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentLayout()!= SPLASH) {
            setContentView(getContentLayout());
            unBinder = ButterKnife.bind(this);
        }
        presenter.create();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    protected void onDestroy() {
        isFinished = true;
        if (getContentLayout()!=SPLASH) {
            unBinder.unbind();
            unBinder = null;
        }
        super.onDestroy();
        presenter.destroy();
        presenter = null;
    }

    @Override
    public void onSetUpViews() {
        // override in child view when needed
    }

    @Override
    public boolean isActivityAlive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return !(isFinishing() || isDestroyed());
        } else {
            return !(isFinishing() || isFinished);
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Resources getRes() {
        return getResources();
    }

    @Override
    public String getStr(int resId) {
        return getString(resId);
    }

    public void shortToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void longToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

}
