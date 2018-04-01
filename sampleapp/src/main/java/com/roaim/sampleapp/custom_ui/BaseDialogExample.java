package com.roaim.sampleapp.custom_ui;

import android.content.Context;
import android.support.annotation.NonNull;

import com.roaim.sampleapp.R;
import com.roaim.smartlib.ui.BaseDialog;

/**
 * Created by hridoy on 3/28/18.
 */

public class BaseDialogExample extends BaseDialog {
    public BaseDialogExample(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreateView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getBackgroundColor() {
        return 0;
    }

    @Override
    protected boolean isCancelable() {
        return true;
    }

    @Override
    protected boolean isFullscreen() {
        return false;
    }

    @Override
    protected float getWidthFactor() {
        return 0;
    }

}
