package com.mredrock.freshmanspecial.CQUPTElegant.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationFrg;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationPre;
import com.mredrock.freshmanspecial.CQUPTElegant.Presenter.OrganizationPresenter;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/10.
 */

public class OrganizationFragment extends Fragment implements IOrganizationFrg, TabLayout.OnTabSelectedListener {

    private IOrganizationPre iOrganizationPre;
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_organization, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        iOrganizationPre = new OrganizationPresenter(this);
        tabLayout = view.findViewById(R.id.special_2017_frg_organization_tl);
        viewPager = view.findViewById(R.id.special_2017_frg_organization_vp);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        iOrganizationPre.setTabLayout(manager,tabLayout,viewPager);
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}