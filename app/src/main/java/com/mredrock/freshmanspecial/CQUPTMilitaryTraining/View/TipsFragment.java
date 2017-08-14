package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.TxtReadUtil;

/**
 * Created by Anriku on 2017/8/10.
 */

public class TipsFragment extends Fragment {

    private View view;
    private TextView foodTv;
    private TextView sunTv;
    private TextView medicineTv;
    private TextView otherTv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_tips,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        foodTv = view.findViewById(R.id.special_2017_frg_tips_food_tv);
        sunTv = view.findViewById(R.id.special_2017_frg_tips_sun_tv);
        medicineTv = view.findViewById(R.id.special_2017_frg_tips_medicine_tv);
        otherTv = view.findViewById(R.id.special_2017_frg_tips_other_tv);

        foodTv.setText(getTheString(TxtReadUtil.getContent(getResources().openRawResource(R.raw.food))));
        sunTv.setText(getTheString(TxtReadUtil.getContent(getResources().openRawResource(R.raw.sun))));
        medicineTv.setText(getTheString(TxtReadUtil.getContent(getResources().openRawResource(R.raw.medicine))));
        otherTv.setText(getTheString(TxtReadUtil.getContent(getResources().openRawResource(R.raw.other))));
    }

    private String getTheString(String string) {
        String[] foods = string.split(":");
        StringBuilder stringBuilder = new StringBuilder(100);
        for (int i = 0;i < foods.length;i++){
            stringBuilder.append(foods[i]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
