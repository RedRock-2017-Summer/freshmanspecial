package com.mredrock.freshmanspecial.CQUPTElegant.View.StudentsView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Adapter.OrganizationsRecAdapter;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Organization;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/10.
 */

public class OrganizationsFragment extends Fragment{

    private Organization.OrganizationData organizationData;
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private OrganizationsRecAdapter adapter;

    public OrganizationsFragment(Organization.OrganizationData organizationData) {
        this.organizationData = organizationData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_organizations,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.special_2017_frg_organizations_rv);
        manager = new LinearLayoutManager(getContext());
        adapter = new OrganizationsRecAdapter(getContext(),organizationData);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
