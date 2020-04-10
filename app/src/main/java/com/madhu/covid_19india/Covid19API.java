package com.madhu.covid_19india;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Covid19API {

    @Headers({
            "x-rapidapi-host: covid19india.p.rapidapi.com",
            "x-rapidapi-key: YOUR_API_KEY" //TODO add api key
    })
    @GET("getIndiaStateData")
    Call<Covid_India_ResponsePOJO> getData();
}
