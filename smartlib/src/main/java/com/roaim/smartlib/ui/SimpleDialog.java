package com.roaim.smartlib.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.roaim.smartlib.R;

/**
 * Created by hridoy on 3/28/18.
 */

public abstract class SimpleDialog extends BaseDialog implements View.OnClickListener {
    private TextView textViewTitle;
    private TextView textViewMsg;

    public void setMsg(String msg) {
        textViewMsg.setText(msg);
        textViewMsg.setVisibility(View.VISIBLE);
    }

    public void setTtl(String title) {
        textViewTitle.setText(title);
        textViewTitle.setVisibility(View.VISIBLE);
    }

    public SimpleDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreateView() {
        ImageView imageViewIcon = getChildView(R.id.imageViewIcon, ImageView.class);
        textViewTitle = getChildView(R.id.textViewTitle, TextView.class);
        textViewMsg = getChildView(R.id.textViewMsg, TextView.class);
        Button buttonPositive = getChildView(R.id.buttonPositive, Button.class);
        Button buttonNegative = getChildView(R.id.buttonNegative, Button.class);

        if (getIcon()!= DEFAULT_VALUE) {
            imageViewIcon.setImageResource(getIcon());
        } else {
            imageViewIcon.setVisibility(View.GONE);
        }
        if (getTitle()!= DEFAULT_VALUE) {
            textViewTitle.setText(getTitle());
        } else {
            textViewTitle.setVisibility(View.GONE);
        }
        if (getMsg()!= DEFAULT_VALUE) {
            textViewMsg.setText(getMsg());
        } else {
            textViewMsg.setVisibility(View.GONE);
        }
        if (getPositiveButtonText()!= DEFAULT_VALUE) {
            buttonPositive.setText(getPositiveButtonText());
            buttonPositive.setOnClickListener(this);
        } else {
            buttonPositive.setVisibility(View.GONE);
        }
        if (getNegativeButtonText()!= DEFAULT_VALUE) {
            buttonNegative.setText(getNegativeButtonText());
            buttonNegative.setOnClickListener(this);
        } else {
            buttonNegative.setVisibility(View.GONE);
        }
    }

    public void destroy() {
        textViewMsg = null;
        textViewTitle = null;
    }

    protected abstract int getIcon();
    protected abstract int getTitle();
    protected abstract int getMsg();
    protected abstract int getPositiveButtonText();
    protected abstract int getNegativeButtonText();
    protected abstract void onPositiveButtonClick();
    protected abstract void onNegativeButtonClick();

    @Override
    protected int getLayout() {
        return R.layout.view_base_smart_dialog;
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

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.buttonPositive) {
            onPositiveButtonClick();
            dismiss();
        } else if (view.getId()==R.id.buttonNegative) {
            onNegativeButtonClick();
            dismiss();
        }
    }
}
