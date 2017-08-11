package com.mredrock.freshmanspecial.CQUPTData.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.mredrock.freshmanspecial.CQUPTData.Interface.IBoyAndGirlFrg;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IBoyAndGirlPre;
import com.mredrock.freshmanspecial.CQUPTData.Presenter.BoyAndGirlPresenter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.StatisticsView;

/**
 * Created by Anriku on 2017/8/3.
 */

public class BoyAndGirlFragment extends Fragment implements IBoyAndGirlFrg {

    private IBoyAndGirlPre iBoyAndGirlPre;
    private View view;
    private StatisticsView statisticsView;
    private Button button;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.special_2017_fragment_boy_and_girl, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        statisticsView = view.findViewById(R.id.special_2017_frg_boy_and_girl_stv);
        iBoyAndGirlPre = new BoyAndGirlPresenter(this);
        button = view.findViewById(R.id.special_2017_frg_boy_and_girl_academic_bt);
        statisticsView.setSubs(new String[]{"女生","男生"});
        statisticsView.setColors(new int[]{Color.parseColor("#ffcccc"),Color.parseColor("#ccccff")});
        statisticsView.setValues(new float[]{0,0});

        iBoyAndGirlPre.setButtonListener(button);
    }

    @Override
    public LayoutInflater getTheLayoutInflater() {
        return inflater;
    }

    @Override
    public Window getTheWindow() {
        return getActivity().getWindow();
    }

    @Override
    public StatisticsView getStatisticView() {
        return statisticsView;
    }
}
