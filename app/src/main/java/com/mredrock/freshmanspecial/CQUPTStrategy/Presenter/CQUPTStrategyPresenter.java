package com.mredrock.freshmanspecial.CQUPTStrategy.Presenter;

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
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.ICQUPTStrategyAct;
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.ICQUPTStrategyPre;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.DailyFoodSceneryFragment;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.DormitoryMessFragment;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.EnvironmentFragment;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.NoticeFragment;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.QQGroupFragment;
import com.mredrock.freshmanspecial.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anriku on 2017/8/10.
 */

public class CQUPTStrategyPresenter implements ICQUPTStrategyPre {

    private ICQUPTStrategyAct icquptStrategyAct;

    public CQUPTStrategyPresenter(ICQUPTStrategyAct icquptStrategyAct) {
        this.icquptStrategyAct = icquptStrategyAct;
    }

    @Override
    public void setTabLayout(FragmentManager fragmentManager, TabLayout tabLayout, ViewPager viewPager) {
        String[] titles = {"校园环境", "学生寝室", "学校食堂", "入学须知", "QQ群", "日常生活", "周边美食", "周边美景"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new EnvironmentFragment());
        fragments.add(new DormitoryMessFragment("Dormitory"));
        fragments.add(new DormitoryMessFragment("Canteen"));
        fragments.add(new NoticeFragment());
        fragments.add(new QQGroupFragment());
        fragments.add(new DailyFoodSceneryFragment("LifeInNear"));
        fragments.add(new DailyFoodSceneryFragment("Cate"));
        fragments.add(new DailyFoodSceneryFragment("BeautyInNear"));

        for (String title :
                titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        FreshmanSpecialViewPagerAdapter viewPagerAdapter = new FreshmanSpecialViewPagerAdapter(fragmentManager, fragments, titles);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void modifyTabLayout(TabLayout tabLayout) {
        try {
            Class<?> tab = tabLayout.getClass();
            Field tabStrip = tab.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout linearLayout = (LinearLayout) tabStrip.get(tabLayout);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View child = linearLayout.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
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
