package com.mredrock.freshmanspecial.CQUPTStrategy.Interface;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

/**
 * Created by Anriku on 2017/8/10.
 */

public interface ICQUPTStrategyPre {
    void setTabLayout(FragmentManager fragmentManager, TabLayout tabLayout, ViewPager viewPager);
    void modifyTabLayout(TabLayout tabLayout);
}
