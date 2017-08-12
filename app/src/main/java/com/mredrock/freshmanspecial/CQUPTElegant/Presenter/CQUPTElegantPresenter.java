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
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.ICQUPTElegantAct;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.ICQUPTElegantPre;
import com.mredrock.freshmanspecial.CQUPTElegant.View.BeautifulFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.ExcellenceStuFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.ExcellenceTechFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.StudentsFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.NatureFragment;
import com.mredrock.freshmanspecial.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anriku on 2017/8/10.
 */

public class CQUPTElegantPresenter implements ICQUPTElegantPre {

    private ICQUPTElegantAct icquptElegantAct;

    public CQUPTElegantPresenter(ICQUPTElegantAct icquptElegantAct) {
        this.icquptElegantAct = icquptElegantAct;
    }

    @Override
    public void setTabLayout(FragmentManager fragmentManager, TabLayout tabLayout, ViewPager viewPager) {
        String[] titles = {"学生组织","原创重邮","美在重邮","优秀老师","优秀学生"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new StudentsFragment());
        fragments.add(new NatureFragment());
        fragments.add(new BeautifulFragment());
        fragments.add(new ExcellenceTechFragment());
        fragments.add(new ExcellenceStuFragment());

        for (String title:
                titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        FreshmanSpecialViewPagerAdapter viewPagerAdapter = new FreshmanSpecialViewPagerAdapter(fragmentManager,fragments,titles);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void modifyTabLayout(TabLayout tabLayout) {
        try {
            LinearLayout layout = (LinearLayout) tabLayout.getChildAt(0);
            layout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            layout.setDividerDrawable(ContextCompat.getDrawable((Context)icquptElegantAct, R.drawable.diliver));
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
