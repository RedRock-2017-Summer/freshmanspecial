package com.mredrock.freshmanspecial.CQUPTData.Interface;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

/**
 * Created by Anriku on 2017/8/3.
 */

public interface ICQUPTDataPre {
    void setTabLayout(FragmentManager fragmentManager,TabLayout tabLayout,ViewPager viewPager);
    void modifyTabLayout(TabLayout tabLayout);
}
