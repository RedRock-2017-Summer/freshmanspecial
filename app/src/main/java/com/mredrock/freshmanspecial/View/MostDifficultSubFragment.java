package com.mredrock.freshmanspecial.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.mredrock.freshmanspecial.Interface.IMostDifficultSubFrg;
import com.mredrock.freshmanspecial.Interface.IMostDifficultSubPre;
import com.mredrock.freshmanspecial.Presenter.MostDifficultSubPresenter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.StatisticsView;

/**
 * Created by Anriku on 2017/8/3.
 */

public class MostDifficultSubFragment extends Fragment implements IMostDifficultSubFrg {

    private View view;
    private IMostDifficultSubPre iMostDifficultSubPre;
    private Button academicButton;
    private Button majorButton;
    private StatisticsView statisticsView;
    private LayoutInflater layoutInflater;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_most_difficult_sub, null);
        layoutInflater = inflater;
        iMostDifficultSubPre = new MostDifficultSubPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        academicButton = view.findViewById(R.id.special_2017_frg_most_difficult_sub_academic_bt);
        majorButton = view.findViewById(R.id.special_2017_frg_most_difficult_sub_major_bt);
        statisticsView = view.findViewById(R.id.special_2017_frg_most_difficult_sub_stv);
        iMostDifficultSubPre.setButton(academicButton, majorButton, getContext());
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    @Override
    public Window getWindow() {
        return getActivity().getWindow();
    }

    @Override
    public StatisticsView getStatistics() {
        return statisticsView;
    }
}
