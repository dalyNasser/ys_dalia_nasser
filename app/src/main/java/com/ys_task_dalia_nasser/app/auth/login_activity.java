package com.ys_task_dalia_nasser.app.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ys_task_dalia_nasser.app.MainActivity;
import com.ys_task_dalia_nasser.app.Model.Value;
import com.ys_task_dalia_nasser.app.Model.login_model;
import com.ys_task_dalia_nasser.app.R;
import com.ys_task_dalia_nasser.app.api_controller.api_interface;
import com.ys_task_dalia_nasser.app.api_controller.get_api_response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activity extends AppCompatActivity {
    String pin_code;
    private StringBuilder pinBuilder = new StringBuilder();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button BtnSubmit=findViewById(R.id.btn_submit);
        BtnSubmit.setOnClickListener(v -> submitPin());
        setupKeyboard();
    }

    private void setupKeyboard() {
        findViewById(R.id.button0).setOnClickListener(v -> appendToPin("0"));
        findViewById(R.id.button1).setOnClickListener(v -> appendToPin("1"));
        findViewById(R.id.button2).setOnClickListener(v -> appendToPin("2"));
        findViewById(R.id.button3).setOnClickListener(v -> appendToPin("3"));
        findViewById(R.id.button4).setOnClickListener(v -> appendToPin("4"));
        findViewById(R.id.button5).setOnClickListener(v -> appendToPin("5"));
        findViewById(R.id.button6).setOnClickListener(v -> appendToPin("6"));
        findViewById(R.id.button7).setOnClickListener(v -> appendToPin("7"));
        findViewById(R.id.button8).setOnClickListener(v -> appendToPin("8"));
        findViewById(R.id.button9).setOnClickListener(v -> appendToPin("9"));
        findViewById(R.id.button_clear).setOnClickListener(v -> clearPin());
        findViewById(R.id.button_close).setOnClickListener(v -> closeApp());
    }

    private void appendToPin(String number) {
        if (pinBuilder.length() < 6) {
            pinBuilder.append(number);
            pin_code = pinBuilder.toString();
        }
    }

    private void closeApp() {
        finish();

    }

    private void clearPin() {
        if (pinBuilder.length() > 0) {
            pinBuilder.deleteCharAt(pinBuilder.length() - 1);

        }
    }

    private void submitPin() {
        String pin = pinBuilder.toString();
        api_interface apiService = get_api_response.getRequestInstance("User/GetUserDetails/").create(api_interface.class);
        Value value = new Value("87", "1", pin);
        login_model loginRequest = new login_model(value);

        Call<Void> call = apiService.login(loginRequest);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Intent loginActivity = new Intent(login_activity.this, MainActivity.class);
                    loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(loginActivity);
                } else {

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle failure
            }
        });

    }
}
