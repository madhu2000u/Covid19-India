package com.madhu.covid_19india;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Covid19IndiaGetter {

    private Retrofit retrofit;
    private List<StateDataPOJO> dataList;
    //private Context MainActivityContext;

    public Covid19IndiaGetter() {
        //this.MainActivityContext=context;

         retrofit=new Retrofit.Builder()
                .baseUrl("https://covid19india.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void requestData(){
        Covid19API api=retrofit.create(Covid19API.class);
        Call<Covid_India_ResponsePOJO> call=api.getData();


        call.enqueue(new Callback<Covid_India_ResponsePOJO>() {
            @Override
            public void onResponse(Call<Covid_India_ResponsePOJO> call, Response<Covid_India_ResponsePOJO> response) {
                Log.d("msg","In onResponse()");

                dataList=response.body().getResponse();
                EnqueCalback(MainActivity.getInstance());



                Log.d("msg",""+response.body().getResponse());
            }

            @Override
            public void onFailure(Call<Covid_India_ResponsePOJO> call, Throwable t) {

                Log.d("msg","In onFailure()"+t.getCause().getMessage());

            }
        });


    }

    private void EnqueCalback(EnqueListener listener){
        listener.onEnqueComplete(dataList);
    }



    public List<StateDataPOJO> getDataList() {
        return dataList;
    }
}
