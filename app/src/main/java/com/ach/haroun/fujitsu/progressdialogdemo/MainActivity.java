package com.ach.haroun.fujitsu.progressdialogdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    ProgressThread progressThead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Downloading file");
        progressDialog.setMessage("Download in progress...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setMax(20);
        progressDialog.show();
        progressThead = new ProgressThread();
        progressThead.start();
    }
    class ProgressThread extends Thread{

        @Override
        public void run() {
            super.run();
                while(progressDialog.getProgress()<20){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.incrementProgressBy(1);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                });

        }
    }
}
