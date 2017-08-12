package com.mredrock.freshmanspecial.CQUPTElegant.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationFrg;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationPre;
import com.mredrock.freshmanspecial.CQUPTElegant.Presenter.StudentsPresenter;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/10.
 */

public class StudentsFragment extends Fragment implements IOrganizationFrg {

    private IOrganizationPre iOrganizationPre;
    private View view;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_student, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        iOrganizationPre = new StudentsPresenter(this);
        tabLayout = view.findViewById(R.id.special_2017_frg_organization_tl);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        iOrganizationPre.setTabLayout(getContext(),manager,tabLayout);
    }

    @Override
    public FragmentManager getTheFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }
}
