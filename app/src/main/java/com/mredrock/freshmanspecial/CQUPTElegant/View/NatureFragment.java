package com.mredrock.freshmanspecial.CQUPTElegant.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.Adapter.VideoImageRecAdapter;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Nature;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class NatureFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private VideoImageRecAdapter adapter;
    private GridLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_nature,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.special_2017_frg_nature_rv);
        manager = new GridLayoutManager(getContext(),2);

        NetUtil.getGetData("http://yangruixin.com/", "natureCQUPT", NetUtil.TEXT_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    Nature nature = gson.fromJson(responseBody.string(),new TypeToken<Nature>(){}.getType());
                    adapter = new VideoImageRecAdapter(getContext(),nature);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
