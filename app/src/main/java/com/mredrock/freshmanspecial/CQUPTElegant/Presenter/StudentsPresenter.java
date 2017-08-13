package com.mredrock.freshmanspecial.CQUPTElegant.Presenter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationFrg;
import com.mredrock.freshmanspecial.CQUPTElegant.Interface.IOrganizationPre;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Organization;
import com.mredrock.freshmanspecial.CQUPTElegant.View.StudentsView.OrganizationsFragment;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class StudentsPresenter implements IOrganizationPre {

    private IOrganizationFrg iOrganizationFrg;

    public StudentsPresenter(IOrganizationFrg iOrganizationFrg) {
        this.iOrganizationFrg = iOrganizationFrg;
    }

    @Override
    public void setTabLayout(final Context context, FragmentManager manager, final TabLayout tabLayout) {

        final List<Fragment> fragments = new ArrayList<>();

        NetUtil.getGetData("http://yangruixin.com/", "organizations", NetUtil.TEXT_GET, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    Organization organization = gson.fromJson(responseBody.string(), new TypeToken<Organization>() {
                    }.getType());
                    for (int i = 0; i < organization.getData().size(); i++) {
                        tabLayout.addTab(tabLayout.newTab().setText(organization.getData().get(i).getName()));
                        fragments.add(new OrganizationsFragment(organization.getData().get(i)));
                    }

                    replaceFragment(fragments.get(0));
                    tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
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

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = iOrganizationFrg.getTheFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.special_2017_frg_organization_fl, fragment);
        transaction.commit();
    }

}
