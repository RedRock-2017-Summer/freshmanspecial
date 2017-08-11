package com.mredrock.freshmanspecial.CQUPTElegant.Presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.Adapter.FreshmanSpecialViewPagerAdapter;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationFrg;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationPre;
import com.mredrock.freshmanspecial.CQUPTElegant.View.BeautifulFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.ExcellenceFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.RedRockFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OriginalFragment;
import com.mredrock.freshmanspecial.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anriku on 2017/8/10.
 */

public class OrganizationPresenter implements IOrganizationPre {

    private IOrganizationFrg iOrganizationFrg;

    public OrganizationPresenter(IOrganizationFrg iOrganizationFrg) {
        this.iOrganizationFrg = iOrganizationFrg;
    }

    @Override
    public void setTabLayout(FragmentManager manager, TabLayout tabLayout, ViewPager viewPager) {
        String[] titles = {"校团委","红岩网校","科联","校青协","大艺团","校学生会","社联"};
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0;i < titles.length;i++){
            fragments.add(new RedRockFragment());
        }

        for (String title:
                titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        FreshmanSpecialViewPagerAdapter viewPagerAdapter = new FreshmanSpecialViewPagerAdapter(manager,fragments,titles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
