package com.mredrock.freshmanspecial.CQUPTElegant.Presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.ArtFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.CommitteeFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.RedRockFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.SocietyFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.StudentFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.TechFragment;
import com.mredrock.freshmanspecial.CQUPTElegant.View.OrganizationView.VolunteerFragment;
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
    public void setTabLayout(FragmentManager manager, TabLayout tabLayout) {
        String[] titles = {"校团委","红岩网校","科联","校青协","大艺团","校学生会","社联"};
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CommitteeFragment());
        fragments.add(new RedRockFragment());
        fragments.add(new TechFragment());
        fragments.add(new VolunteerFragment());
        fragments.add(new ArtFragment());
        fragments.add(new StudentFragment());
        fragments.add(new SocietyFragment());

        for (String title:
                titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        replaceFragment(fragments.get(0));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                replaceFragment(fragments.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = iOrganizationFrg.getTheFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.special_2017_frg_organization_fl,fragment);
        transaction.commit();
    }

}
