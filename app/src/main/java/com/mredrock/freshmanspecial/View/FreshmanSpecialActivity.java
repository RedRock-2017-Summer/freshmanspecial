package com.mredrock.freshmanspecial.View;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Adapter.FreshmanSpecialViewPagerAdapter;
import com.mredrock.freshmanspecial.Interface.IFreshmanSpecialAct;
import com.mredrock.freshmanspecial.Interface.IFreshmanSpecialPre;
import com.mredrock.freshmanspecial.Presenter.FreshmanSpecialPresenter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

public class FreshmanSpecialActivity extends AppCompatActivity implements IFreshmanSpecialAct, TabLayout.OnTabSelectedListener {

    private IFreshmanSpecialPre iFreshmanSpecialPre;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_freshman_special);
        initView();
    }

    private void initView() {
        iFreshmanSpecialPre = new FreshmanSpecialPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.special_2017_ac_freshman_tb);
        tabLayout = (TabLayout) findViewById(R.id.special_2017_ac_freshman_tl);
        viewPager = (ViewPager) findViewById(R.id.special_2017_ac_freshman_vp);

        FragmentManager manager = getSupportFragmentManager();
        iFreshmanSpecialPre.setTabLayout(manager,tabLayout,viewPager);
        tabLayout.addOnTabSelectedListener(this);
        iFreshmanSpecialPre.modifyTabLayout(tabLayout);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
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
        switch (item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show();
                break;
            default:break;
        }
        return true;
    }
}
