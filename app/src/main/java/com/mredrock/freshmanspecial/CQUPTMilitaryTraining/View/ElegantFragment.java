package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantFrg;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantPre;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter.ElegantPresenter;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/10.
 */

public class ElegantFragment extends Fragment implements IElegantFrg{

    private View view;
    private IElegantPre iElegantPre;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.specail_2017_fragment_elegant,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        iElegantPre = new ElegantPresenter(this);

    }
}
