package com.roaim.sampleapp.view;

import android.util.Log;

import com.roaim.sampleapp.Contract;
import com.roaim.sampleapp.R;
import com.roaim.sampleapp.custom_ui.SampleDialog;
import com.roaim.sampleapp.presenter.SamplePresenter;
import com.roaim.smartlib.app.SmartActivity;

import butterknife.OnClick;

public class SampleActivity extends SmartActivity<SamplePresenter> implements Contract.View {
    private static final String TAG = "SampleActivity";

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected SamplePresenter onInitPresenter() {
        return new SamplePresenter(this);
    }

    @Override
    public void onSetUpViews() {
        super.onSetUpViews();
    }

    @Override
    public void onShowProgress(String msg) {
        Log.d(TAG, "onShowProgress() called with: msg = [" + msg + "]");
        shortToast(msg);
    }

    @Override
    public void onHideProgress() {
        Log.d(TAG, "onHideProgress() called");
    }

    @OnClick(R.id.textViewHelloWorld)
    public void onHelloWorldClick() {
        getPresenter().doTask();
    }

    @Override
    public void onTaskDone(String data) {
        Log.d(TAG, "onTaskDone() called with: data = [" + data + "]");
        SampleDialog sampleDialog = new SampleDialog(this) {
            @Override
            protected void onPositiveButtonClick() {
                SampleProgressActivity.open(getActivity());
            }
        };
        sampleDialog.show();
    }

    @Override
    public void onTaskFailed() {
        Log.d(TAG, "onTaskFailed() called");
    }
}
