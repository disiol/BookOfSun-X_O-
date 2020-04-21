package com.bookofsun.api;


import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {

   @POST("136cS3")
   Observable<Response<ResponseBody>> sendRequest();
}
