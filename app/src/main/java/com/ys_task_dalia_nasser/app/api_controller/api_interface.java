package com.ys_task_dalia_nasser.app.api_controller;


import com.ys_task_dalia_nasser.app.Model.login_model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface api_interface {
    @POST("OnyxChef/User/GetUserDetails")
    Call<Void> login(@Body login_model loginRequest);
}