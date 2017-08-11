package com.mredrock.freshmanspecial.CQUPTData.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.mredrock.freshmanspecial.CQUPTData.Interface.IWorkFindFrg;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IWorkFindPre;
import com.mredrock.freshmanspecial.CQUPTData.Presenter.WorkFindPresenter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.StatisticsView;

/**
 * Created by Anriku on 2017/8/3.
 */

public class WorkFindFragment extends Fragment implements IWorkFindFrg {

    private Button button;
    private LayoutInflater inflater;
    private StatisticsView statisticsView;
    private IWorkFindPre iWorkFindPre;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.special_2017_fragment_work_find,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        iWorkFindPre = new WorkFindPresenter(this);
        statisticsView = view.findViewById(R.id.special_2017_frg_work_find_stv);
        button = view.findViewById(R.id.special_2017_frg_work_find_academic_bt);
        statisticsView = view.findViewById(R.id.special_2017_frg_work_find_stv);

        iWorkFindPre.setButtonListener(button);
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
    public StatisticsView getStatisticsView() {
        return statisticsView;
    }
}
