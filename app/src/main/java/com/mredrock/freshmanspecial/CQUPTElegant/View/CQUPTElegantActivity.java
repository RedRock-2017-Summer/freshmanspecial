package com.mredrock.freshmanspecial.CQUPTElegant.View;

import android.graphics.Color;
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

import com.mredrock.freshmanspecial.CQUPTElegant.Interface.ICQUPTElegantAct;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.ICQUPTElegantPre;
import com.mredrock.freshmanspecial.CQUPTElegant.Presenter.CQUPTElegantPresenter;
import com.mredrock.freshmanspecial.R;

import org.zackratos.ultimatebar.UltimateBar;

public class CQUPTElegantActivity extends AppCompatActivity implements ICQUPTElegantAct, TabLayout.OnTabSelectedListener {

    private ICQUPTElegantPre icquptElegantPre;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_cquptelegant);

        initView();
    }

    private void initView() {
        icquptElegantPre = new CQUPTElegantPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.special_2017_ac_elegant_tb);
        tabLayout = (TabLayout) findViewById(R.id.special_2017_ac_elegant_tl);
        viewPager = (ViewPager) findViewById(R.id.special_2017_ac_elegant_vp);

        FragmentManager manager = getSupportFragmentManager();
        icquptElegantPre.setTabLayout(manager, tabLayout, viewPager);
        tabLayout.addOnTabSelectedListener(this);
        icquptElegantPre.modifyTabLayout(tabLayout);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.back);
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
