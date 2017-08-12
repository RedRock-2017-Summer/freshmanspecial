package com.mredrock.freshmanspecial.CQUPTStrategy.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.Adapter.DailyAndSceneryRecAdapter;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.DailyFoodScenery;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class DailyFoodSceneryFragment extends Fragment{

    private String value;
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private DailyAndSceneryRecAdapter adapter;

    public DailyFoodSceneryFragment(String value) {
        this.value = value;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_daily_food_scenery,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.special_2017_frg_daily_food_scenery_rv);
        manager = new LinearLayoutManager(getContext());

        NetUtil.getGetData("http://www.yangruixin.com/",value,NetUtil.GUIDE_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    DailyFoodScenery dailyFoodScenery = gson.fromJson(responseBody.string(),new TypeToken<DailyFoodScenery>(){}.getType());
                    adapter = new DailyAndSceneryRecAdapter(getContext(),dailyFoodScenery);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
