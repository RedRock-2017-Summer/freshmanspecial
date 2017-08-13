package com.mredrock.freshmanspecial.CQUPTStrategy.View;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.ICQUPTStrategyAct;
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.ICQUPTStrategyPre;
import com.mredrock.freshmanspecial.CQUPTStrategy.Presenter.CQUPTStrategyPresenter;
import com.mredrock.freshmanspecial.R;

import org.zackratos.ultimatebar.UltimateBar;

public class CQUPTStrategyActivity extends AppCompatActivity implements ICQUPTStrategyAct, TabLayout.OnTabSelectedListener {

    private ICQUPTStrategyPre icquptStrategyPre;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_cquptstrategy);

        initView();
    }

    private void initView() {
        icquptStrategyPre = new CQUPTStrategyPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.special_2017_ac_strategy_tb);
        viewPager = (ViewPager) findViewById(R.id.special_2017_ac_strategy_vp);
        tabLayout = (TabLayout) findViewById(R.id.special_2017_ac_strategy_tl);

        FragmentManager manager = getSupportFragmentManager();
        icquptStrategyPre.setTabLayout(manager, tabLayout, viewPager);
        tabLayout.addOnTabSelectedListener(this);
        icquptStrategyPre.modifyTabLayout(tabLayout);

        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.colorPrimary));

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
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
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
