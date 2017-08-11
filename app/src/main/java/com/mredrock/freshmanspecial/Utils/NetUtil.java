package com.mredrock.freshmanspecial.Utils;

import com.google.gson.Gson;
import com.mredrock.freshmanspecial.API.GetApi;
import com.mredrock.freshmanspecial.API.PostApi;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anriku on 2017/8/9.
 */

public class NetUtil {

    public interface HttpCallBackListener{
        void onFinish(ResponseBody responseBody);
    }

    public static void getData(String value, final HttpCallBackListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.yangruixin.com/")
                .build();

        PostApi postApi = retrofit.create(PostApi.class);

        final Call<ResponseBody> call = postApi.testHttpGet(value);

        Observable.create(new ObservableOnSubscribe<ResponseBody>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<ResponseBody> e) throws Exception {
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        e.onNext(response.body());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        e.onError(t);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        listener.onFinish(responseBody);
                    }
                });
    }

    public static void getGetData(String value, final HttpCallBackListener listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.yangruixin.com/")
                .build();

        GetApi getApi = retrofit.create(GetApi.class);

        final Call<ResponseBody> call = getApi.get(value);

        Observable.create(new ObservableOnSubscribe<ResponseBody>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<ResponseBody> e) throws Exception {
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        e.onNext(response.body());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        e.onError(t);
                    }
                });
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        listener.onFinish(responseBody);
                    }
                });
    }
}
