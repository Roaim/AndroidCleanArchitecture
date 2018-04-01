package com.roaim.smartlib.app;

import com.roaim.smartlib.ui.SmartProgressDialog;

/**
 * Created by hridoy on 4/1/18.
 */

public abstract class SmartProgressActivity<P extends SmartPresenter> extends SmartActivity<P> {

    private SmartProgressDialog smartProgressDialog;

    public abstract boolean isProgressCancelable();

    @Override
    public void onSetUpViews() {
        super.onSetUpViews();
        smartProgressDialog = new SmartProgressDialog(this) {
            @Override
            protected boolean isCancelable() {
                return isProgressCancelable();
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (smartProgressDialog != null) {
            smartProgressDialog.dismiss();
            smartProgressDialog.destroy();
            smartProgressDialog = null;
        }
    }

    @Override
    public void onShowProgress(String msg) {
        smartProgressDialog.show();
        smartProgressDialog.setMsg(msg);
    }

    @Override
    public void onHideProgress() {
        smartProgressDialog.dismiss();
    }
}
