package com.roaim.sampleapp;

import com.roaim.smartlib.BaseSmartPresenter;
import com.roaim.smartlib.BaseSmartView;

/**
 * Created by hridoy on 4/2/18.
 */

public interface Contract {
    interface View extends BaseSmartView {
        void onTaskDone(String data);
        void onTaskFailed();
    }

    interface Presenter extends BaseSmartPresenter {
        void doTask();
    }

    interface Repository {
        void getData(OnCompleteListener listener);
    }

    interface OnCompleteListener {
        void onComplete(String data);
    }
}
