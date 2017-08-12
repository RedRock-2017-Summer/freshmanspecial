package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.CQUPTElegant.Model.Organization;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/12.
 */

public class OrganizationsRecAdapter extends RecyclerView.Adapter<OrganizationsRecAdapter.ViewHolder> {

    private Context context;
    private Organization.OrganizationData organizationData;

    public OrganizationsRecAdapter(Context context, Organization.OrganizationData organizationData) {
        this.context = context;
        this.organizationData = organizationData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_organizations_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTv.setText(organizationData.getDepartment().get(position).getName());
        holder.contentTv.setText(organizationData.getDepartment().get(position).getResume());
    }

    @Override
    public int getItemCount() {
        return organizationData.getDepartment().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private TextView contentTv;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.special_2017_organizations_rec_item_title_tv);
            contentTv = itemView.findViewById(R.id.special_2017_organizations_rec_item_content_tv);
        }
    }
}
