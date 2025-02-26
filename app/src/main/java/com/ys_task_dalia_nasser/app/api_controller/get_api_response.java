package com.ys_task_dalia_nasser.app.api_controller;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class get_api_response {
    private final static  String BASE_URL = "http://mdev.yemensoft.net:8087/OnyxRmsService/api/OnyxChef/";
    private static Retrofit retrofit;
    public static Retrofit getRequestInstance(String order_type) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL+order_type)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
