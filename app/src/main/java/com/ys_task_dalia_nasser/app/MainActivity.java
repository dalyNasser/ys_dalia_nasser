package com.ys_task_dalia_nasser.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ys_task_dalia_nasser.app.auth.login_activity;

public class MainActivity extends  AppCompatActivity{
    @Override
    // Constractor of this Class ,Auto call when Class Loaded
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        LinearLayout Btn_Logout=findViewById(R.id.buttonLogout);
        Btn_Logout.setOnClickListener(v -> showCustomDialog());


    }
    private void showCustomDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(true) // Allow dialog to be canceled
                .create();
        Button BtnLogout = dialogView.findViewById(R.id.btn_logout);
        Button BtnCancel = dialogView.findViewById(R.id.btn_cancel);

        BtnLogout.setOnClickListener(v -> {
            this.finish();
            Intent loginActivity = new Intent(MainActivity.this, login_activity.class);
            loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(loginActivity);
            dialog.dismiss();
        });

        BtnCancel.setOnClickListener(v -> {
            dialog.dismiss();
        });


        dialog.show();
    }
}