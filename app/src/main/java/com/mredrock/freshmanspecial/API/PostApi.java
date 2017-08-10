package com.mredrock.freshmanspecial.API;


import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Anriku on 2017/8/6.
 */

public interface PostApi {
    @FormUrlEncoded
    @POST("test/apiRatio.php/")
    Call<ResponseBody> testHttpGet(@Field("RequestType") String value);
}

