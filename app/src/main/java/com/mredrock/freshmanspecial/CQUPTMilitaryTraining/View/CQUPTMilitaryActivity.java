package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.ICQUPTMilitaryAct;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.ICQUPTMilitaryPre;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter.CQUPTMilitaryPresenter;
import com.mredrock.freshmanspecial.R;

import org.zackratos.ultimatebar.UltimateBar;

public class CQUPTMilitaryActivity extends AppCompatActivity implements ICQUPTMilitaryAct, TabLayout.OnTabSelectedListener {

    private ICQUPTMilitaryPre icquptMilitaryPre;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_cquptmilitary_);

        initView();
    }

    private void initView() {
        icquptMilitaryPre = new CQUPTMilitaryPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.special_2017_ac_military_tb);
        viewPager = (ViewPager) findViewById(R.id.special_2017_ac_military_vp);
        tabLayout = (TabLayout) findViewById(R.id.special_2017_ac_military_tl);

        FragmentManager manager = getSupportFragmentManager();
        icquptMilitaryPre.setTabLayout(manager, tabLayout, viewPager);
        tabLayout.addOnTabSelectedListener(this);
        icquptMilitaryPre.modifyTabLayout(tabLayout);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.mipmap.back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

}
