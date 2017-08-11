package com.mredrock.freshmanspecial.API;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Anriku on 2017/8/11.
 */

public interface GetApi {
    @GET("test/apiForGuide.php")
    Call<ResponseBody> get(@Query("RequestType") String value);
}
