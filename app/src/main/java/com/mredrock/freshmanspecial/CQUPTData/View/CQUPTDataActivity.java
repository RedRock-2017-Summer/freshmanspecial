package com.mredrock.freshmanspecial.CQUPTData.View;

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

import com.mredrock.freshmanspecial.CQUPTData.Interface.ICAUPTDataAct;
import com.mredrock.freshmanspecial.CQUPTData.Interface.ICQUPTDataPre;
import com.mredrock.freshmanspecial.CQUPTData.Presenter.CQUPTDataPresenter;
import com.mredrock.freshmanspecial.R;

import org.zackratos.ultimatebar.UltimateBar;

public class CQUPTDataActivity extends AppCompatActivity implements ICAUPTDataAct, TabLayout.OnTabSelectedListener {

    private ICQUPTDataPre ICQUPTDataPre;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_cquptdata);
        initView();
    }

    private void initView() {
        ICQUPTDataPre = new CQUPTDataPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.special_2017_ac_data_tb);
        tabLayout = (TabLayout) findViewById(R.id.special_2017_ac_data_tl);
        viewPager = (ViewPager) findViewById(R.id.special_2017_ac_data_vp);

        FragmentManager manager = getSupportFragmentManager();
        ICQUPTDataPre.setTabLayout(manager, tabLayout, viewPager);
        tabLayout.addOnTabSelectedListener(this);
        ICQUPTDataPre.modifyTabLayout(tabLayout);


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
