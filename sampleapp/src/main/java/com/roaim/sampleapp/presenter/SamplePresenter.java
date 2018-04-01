package com.roaim.sampleapp.presenter;

import com.roaim.sampleapp.Contract;
import com.roaim.sampleapp.model.SampleRepository;
import com.roaim.smartlib.app.SmartPresenter;

/**
 * Created by hridoy on 4/2/18.
 */

public class SamplePresenter extends SmartPresenter<Contract.View> implements Contract.Presenter {
    private Contract.Repository repository;
    public SamplePresenter(Contract.View view) {
        super(view);
        repository = new SampleRepository();
    }

    @Override
    public void doTask() {
        getView().onShowProgress("Getting data...");
        repository.getData(new Contract.OnCompleteListener() {
            @Override
            public void onComplete(String data) {
                getView().onHideProgress();
                if (data != null) {
                    getView().onTaskDone(data);
                } else {
                    getView().onTaskFailed();
                }
            }
        });
    }
}
