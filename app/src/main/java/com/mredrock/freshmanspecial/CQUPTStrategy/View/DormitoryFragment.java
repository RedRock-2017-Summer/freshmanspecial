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
import com.mredrock.freshmanspecial.Adapter.DormitoryRecAdapter;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.Dormitory;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class DormitoryFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private DormitoryRecAdapter adapter;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_dormitory,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.special_2017_frg_dormitory_rv);

        NetUtil.getGetData("Dormitory", new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    Dormitory dormitory = gson.fromJson(responseBody.string(),new TypeToken<Dormitory>(){}.getType());
                    adapter = new DormitoryRecAdapter(getContext(),dormitory);
                    manager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
