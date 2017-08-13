package com.mredrock.freshmanspecial.CQUPTStrategy.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.TxtReadUtil;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Anriku on 2017/8/10.
 */

public class NoticeFragment extends Fragment{

    private View view;
    private TextView listTv;
    private TextView securityTv;
    private TextView ridingTv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_notice,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        listTv = view.findViewById(R.id.special_2017_frg_notice_list_tv);
        securityTv = view.findViewById(R.id.special_2017_frg_notice_security_tv);
        ridingTv = view.findViewById(R.id.special_2017_frg_notice_riding_tv);

        listTv.setText(getLocalData(R.raw.list));
        securityTv.setText(getLocalData(R.raw.security));
        ridingTv.setText(getLocalData(R.raw.riding));
    }

    private String getLocalData(int resource) {
        InputStream inputStream = getResources().openRawResource(resource);
        String string = TxtReadUtil.getContent(inputStream);
        return string;
    }
}
