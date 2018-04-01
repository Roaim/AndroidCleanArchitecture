package com.roaim.sampleapp.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.roaim.sampleapp.Contract;
import com.roaim.sampleapp.R;
import com.roaim.sampleapp.presenter.SamplePresenter;
import com.roaim.smartlib.app.SmartProgressActivity;

import butterknife.OnClick;

public class SampleProgressActivity extends SmartProgressActivity<SamplePresenter> implements Contract.View {
    private static final String TAG = "SampleProgressActivity";

    @Override
    protected int getContentLayout() {
        return R.layout.activity_sample_progress;
    }

    @Override
    protected SamplePresenter onInitPresenter() {
        return new SamplePresenter(this);
    }

    @Override
    public void onTaskDone(String data) {
        Log.d(TAG, "onTaskDone() called with: data = [" + data + "]");
        longToast(data);
    }

    @Override
    public void onTaskFailed() {
        Log.d(TAG, "onTaskFailed() called");
    }

    @Override
    public boolean isProgressCancelable() {
        return false;
    }

    @OnClick(R.id.layoutProgressActivity)
    public void onContainerClick() {
        getPresenter().doTask();
    }

    public static void open(Context context) {
        context.startActivity(new Intent(context, SampleProgressActivity.class));
    }
}
