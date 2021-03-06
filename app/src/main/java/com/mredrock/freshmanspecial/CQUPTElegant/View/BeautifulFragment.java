package com.mredrock.freshmanspecial.CQUPTElegant.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.Adapter.BeautyRecAdapter;
import com.mredrock.freshmanspecial.Adapter.EnvironmentRecAdapter;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Beauty;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.Environment;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class BeautifulFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private BeautyRecAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.specail_2017_fragment_beautiful, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.special_2017_frg_beautiful_rv);

        NetUtil.getGetData("http://www.yangruixin.com/", "beautyInCQUPT", NetUtil.TEXT_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    Beauty beauty = gson.fromJson(responseBody.string(), new TypeToken<Beauty>() {
                    }.getType());
                    adapter = new BeautyRecAdapter(getContext(),beauty);
                    LinearLayoutManager manager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
