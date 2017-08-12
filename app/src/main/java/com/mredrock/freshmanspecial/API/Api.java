package com.mredrock.freshmanspecial.API;


import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Anriku on 2017/8/6.
 */

public interface Api {
    @FormUrlEncoded
    @POST("test/apiRatio.php/")
    Call<ResponseBody> ratioPost(@Field("RequestType") String value);

    @GET("test/apiForText.php")
    Call<ResponseBody> textGet(@Query("RequestType") String value);

    @GET("test/apiRatio.php")
    Call<ResponseBody> ratioGet(@Query("RequestType") String value);

    @GET("test/apiForGuide.php")
    Call<ResponseBody> guideGet(@Query("RequestType") String value);
}

