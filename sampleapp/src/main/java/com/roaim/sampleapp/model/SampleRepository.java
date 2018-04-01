package com.roaim.sampleapp.model;

import android.os.AsyncTask;

import com.roaim.sampleapp.Contract;

/**
 * Created by hridoy on 4/2/18.
 */

public class SampleRepository implements Contract.Repository {
    @Override
    public void getData(final Contract.OnCompleteListener listener) {
        new MyTask(listener).execute();
    }

    private static class MyTask extends AsyncTask<Void,Void,Void> {
        Contract.OnCompleteListener listener;

        public MyTask(Contract.OnCompleteListener listener) {
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listener.onComplete("Data parsed!");
        }
    }
}
