package com.mredrock.freshmanspecial.Interface;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

import com.mredrock.freshmanspecial.Adapter.FreshmanSpecialViewPagerAdapter;

/**
 * Created by Anriku on 2017/8/3.
 */

public interface IFreshmanSpecialPre {
    void setTabLayout(FragmentManager fragmentManager,TabLayout tabLayout,ViewPager viewPager);
    void modifyTabLayout(TabLayout tabLayout);
}
