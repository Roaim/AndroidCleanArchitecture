package com.roaim.sampleapp.custom_ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;

import com.roaim.sampleapp.R;
import com.roaim.smartlib.ui.SimpleDialog;

/**
 * Created by hridoy on 3/28/18.
 */

public abstract class SampleDialog extends SimpleDialog {
    public SampleDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getBackgroundColor() {
        return 0;
    }

    @Override
    protected int getIcon() {
        return R.drawable.ic_info;
    }

    @Override
    protected int getTitle() {
        return R.string.title_base_smart_dialog;
    }

    @Override
    protected int getMsg() {
        return R.string.a_long_msg;
    }

    @Override
    protected int getPositiveButtonText() {
        return R.string.button_continue;
    }

    @Override
    protected int getNegativeButtonText() {
        return R.string.button_cancel;
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
    protected void onNegativeButtonClick() {

    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        destroy();
    }
}
