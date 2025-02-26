package com.ys_task_dalia_nasser.app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ys_task_dalia_nasser.app.auth.login_activity;


public class splash_activity extends Activity {
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ctx = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StartApp();
            }
        }, 600L);


    }

    private void StartApp() {
        splash_activity.this.finish();
        Intent loginActivity = new Intent(splash_activity.this, login_activity.class);
        loginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginActivity);
    }

}
