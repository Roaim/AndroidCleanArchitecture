package com.roaim.smartlib.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.roaim.smartlib.R;

/**
 * Created by hridoy on 4/1/18.
 */

public abstract class SmartProgressDialog extends BaseDialog {

    private TextView textViewMsg;

    public SmartProgressDialog(@NonNull Context context) {
        super(context);
    }

    public void setMsg(String msg) {
        textViewMsg.setText(msg);
    }

    @Override
    protected void onCreateView() {
        textViewMsg = getChildView(R.id.tvProgressDialog, TextView.class);
    }

    @Override
    protected int getLayout() {
        return R.layout.view_progress_dialog;
    }

    @Override
    protected int getBackgroundColor() {
        return 0;
    }

    @Override
    protected boolean isFullscreen() {
        return false;
    }

    @Override
    protected float getWidthFactor() {
        return 0;
    }

    public void destroy() {
        textViewMsg = null;
    }
}
