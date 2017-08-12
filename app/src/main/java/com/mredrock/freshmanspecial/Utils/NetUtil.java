package com.mredrock.freshmanspecial.Utils;

import com.mredrock.freshmanspecial.API.Api;

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

/**
 * Created by Anriku on 2017/8/9.
 */

public class NetUtil {

    public static final int RATIO_GET = 0;
    public static final int TEXT_GET = 1;
    public static final int RATIO_POST = 2;
    public static final int GUIDE_GET = 3;

    public interface HttpCallBackListener{
        void onFinish(ResponseBody responseBody);
    }

    public static void getPostData(String baseUrl,String value,int postMethod,final HttpCallBackListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();

        Api api = retrofit.create(Api.class);

        Call<ResponseBody> call = null;

        if (postMethod == NetUtil.RATIO_POST){
            call = api.ratioPost(value);
        }

        final Call<ResponseBody> finalCall = call;
        Observable.create(new ObservableOnSubscribe<ResponseBody>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<ResponseBody> e) throws Exception {
                finalCall.enqueue(new Callback<ResponseBody>() {
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

    public static void getGetData(String baseUrl,String value,int getMethod,final HttpCallBackListener listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();

        Api api = retrofit.create(Api.class);

        Call<ResponseBody> call = null;
        if (getMethod == NetUtil.TEXT_GET){
            call = api.textGet(value);
        }else if (getMethod == NetUtil.RATIO_GET){
            call = api.ratioGet(value);
        }else if (getMethod == NetUtil.GUIDE_GET){
            call = api.guideGet(value);
        }

        final Call<ResponseBody> finalCall = call;
        Observable.create(new ObservableOnSubscribe<ResponseBody>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<ResponseBody> e) throws Exception {
                finalCall.enqueue(new Callback<ResponseBody>() {
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
