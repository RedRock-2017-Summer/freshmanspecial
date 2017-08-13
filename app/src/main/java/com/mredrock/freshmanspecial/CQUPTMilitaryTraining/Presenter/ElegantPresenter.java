package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.Adapter.PhotoRecAdapter;
import com.mredrock.freshmanspecial.Adapter.SongsRecAdapter;
import com.mredrock.freshmanspecial.Adapter.VideoRecAdapter;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantFrg;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantPre;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model.MilitaryPhoto;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model.MilitaryVideo;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/12.
 */

public class ElegantPresenter implements IElegantPre {

    private IElegantFrg iElegantFrg;

    public ElegantPresenter(IElegantFrg iElegantFrg) {
        this.iElegantFrg = iElegantFrg;
    }

    @Override
    public void setPhotos(final Context context, final RecyclerView recyclerView) {
        final LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        NetUtil.getGetData("http://yangruixin.com/", "MilitaryTrainingPhoto", NetUtil.GUIDE_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    MilitaryPhoto militaryPhoto = gson.fromJson(responseBody.string(),new TypeToken<MilitaryPhoto>(){}.getType());
                    PhotoRecAdapter adapter = new PhotoRecAdapter(context,militaryPhoto);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void setVideos(final Context context, final RecyclerView recyclerView) {
        final LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        NetUtil.getGetData("http://yangruixin.com/", "MilitaryTrainingVideo", NetUtil.GUIDE_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    MilitaryVideo militaryVideo = gson.fromJson(responseBody.string(),new TypeToken<MilitaryVideo>(){}.getType());
                    VideoRecAdapter adapter = new VideoRecAdapter(context,militaryVideo);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void setSongs(Context context, RecyclerView recyclerView) {
        GridLayoutManager manager = new GridLayoutManager(context,2);
        SongsRecAdapter adapter = new SongsRecAdapter();
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

}
