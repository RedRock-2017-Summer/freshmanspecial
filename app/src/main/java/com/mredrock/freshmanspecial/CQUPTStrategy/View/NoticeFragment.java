package com.mredrock.freshmanspecial.CQUPTStrategy.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Adapter.TextReAdapter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.TxtReadUtil;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Anriku on 2017/8/10.
 */

public class NoticeFragment extends Fragment {

    private View view;
    private RecyclerView listRec;
    private RecyclerView securityRec;
    private RecyclerView ridingRec;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_notice, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        listRec = view.findViewById(R.id.special_2017_frg_notice_list_rv);
        securityRec = view.findViewById(R.id.special_2017_frg_notice_security_rv);
        ridingRec = view.findViewById(R.id.special_2017_frg_notice_riding_rv);

        TextReAdapter adapter = new TextReAdapter(getLocalData(R.raw.list));

        listRec.setLayoutManager(new LinearLayoutManager(getContext()));
        listRec.setAdapter(adapter);

        TextReAdapter adapter1 = new TextReAdapter(getLocalData(R.raw.security));
        securityRec.setLayoutManager(new LinearLayoutManager(getContext()));
        securityRec.setAdapter(adapter1);

        TextReAdapter adapter2 = new TextReAdapter(getLocalData(R.raw.riding));
        ridingRec.setLayoutManager(new LinearLayoutManager(getContext()));
        ridingRec.setAdapter(adapter2);
    }

    private String[] getLocalData(int resource) {
        InputStream inputStream = getResources().openRawResource(resource);
        String string = TxtReadUtil.getContent(inputStream);
        String[] strings = string.split("~");
        return strings;
    }
}
