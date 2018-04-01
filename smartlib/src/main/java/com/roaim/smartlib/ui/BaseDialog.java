package com.roaim.smartlib.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.roaim.smartlib.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hridoy on 05-Mar-18.
 */

public abstract class BaseDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener {
    public static final int DEFAULT_VALUE = 0;
    public static final float DEFAULT_WIDTH_FACTOR = .88f;

    private static int getDesiredWidth(float factor) {
        return getDesiredWidth(getScreenWidth(), factor);
    }

    private static int getDesiredWidth(int screenWidth, float factor) {
        if (screenWidth==0) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (screenWidth == ViewGroup.LayoutParams.MATCH_PARENT ||
                screenWidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
            return screenWidth;
        } else {
            return (int) (screenWidth * factor);
        }
    }

    private static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public void setDimensions(int width, int height) {
        Window window = getWindow();
        if (window != null) {
            window.setLayout(width, height);
        }
    }

    public BaseDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();

        if (window!=null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            if (getBackgroundColor() != DEFAULT_VALUE) window.setBackgroundDrawableResource(getBackgroundColor());
            window.getAttributes().windowAnimations = R.style.AnimationBaseSmartDialog;
        }

        setCancelable(isCancelable());
        setOnShowListener(this);
        setOnDismissListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        onCreateView();
    }

    public <V extends View> V getChildView(int resId, Class<V> viewType) {
        return findViewById(resId);
    }

    protected abstract void onCreateView();
    protected abstract int getLayout();
    protected abstract int getBackgroundColor();
    protected abstract boolean isCancelable();
    protected abstract boolean isFullscreen();
    protected abstract float getWidthFactor();

    @Override
    public void onShow(DialogInterface dialogInterface) {
        if (isFullscreen()) {
            setDimensions(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            float factor = getWidthFactor() == 0 ? DEFAULT_WIDTH_FACTOR : getWidthFactor();
            setDimensions(getDesiredWidth(factor), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {

    }
}
