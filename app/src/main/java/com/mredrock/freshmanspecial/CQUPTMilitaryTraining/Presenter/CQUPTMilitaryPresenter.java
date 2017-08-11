package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter;

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
import com.mredrock.freshmanspecial.CQUPTData.View.BoyAndGirlFragment;
import com.mredrock.freshmanspecial.CQUPTData.View.MostDifficultSubFragment;
import com.mredrock.freshmanspecial.CQUPTData.View.WorkFindFragment;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.ICQUPTMilitaryAct;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.ICQUPTMilitaryPre;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View.ElegantFragment;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View.TipsFragment;
import com.mredrock.freshmanspecial.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anriku on 2017/8/10.
 */

public class CQUPTMilitaryPresenter implements ICQUPTMilitaryPre{

    private ICQUPTMilitaryAct icquptMilitaryAct;

    public CQUPTMilitaryPresenter(ICQUPTMilitaryAct icquptMilitaryAct) {
        this.icquptMilitaryAct = icquptMilitaryAct;
    }

    @Override
    public void setTabLayout(FragmentManager fragmentManager, TabLayout tabLayout, ViewPager viewPager) {
        String[] titles = {"军训贴士","军训风采"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TipsFragment());
        fragments.add(new ElegantFragment());

        for (String title:
                titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        FreshmanSpecialViewPagerAdapter viewPagerAdapter = new FreshmanSpecialViewPagerAdapter(fragmentManager,fragments,titles);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void modifyTabLayout(TabLayout tabLayout) {
        try {
            LinearLayout layout = (LinearLayout) tabLayout.getChildAt(0);
            layout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            layout.setDividerDrawable(ContextCompat.getDrawable((Context)icquptMilitaryAct, R.drawable.diliver));
            Class<?> tab = tabLayout.getClass();
            Field tabStrip = tab.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout linearLayout = (LinearLayout) tabStrip.get(tabLayout);
            for (int i =0;i < linearLayout.getChildCount();i++){
                View child = linearLayout.getChildAt(i);
                child.setPadding(0,0,0,0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1);
                params.setMarginStart(80);
                params.setMarginEnd(80);
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
