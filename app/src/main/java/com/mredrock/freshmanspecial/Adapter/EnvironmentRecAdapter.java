package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.Environment;
import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by Anriku on 2017/8/11.
 */

public class EnvironmentRecAdapter extends RecyclerView.Adapter<EnvironmentRecAdapter.ViewHolder> {

    private Context context;
    private Environment environment;

    public EnvironmentRecAdapter(Context context, Environment environment) {
        this.context = context;
        this.environment = environment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_environment_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (environment.getStatus().equals("200")){
            Environment.EnvironmentData data = environment.getData().get(position);
            holder.titleTv.setText(data.getTitle());
            holder.contentTv.setText(data.getContent());
            Glide.with(context).load(data.getUrl().get(0)).into(holder.imageView);
        }else {
            Toast.makeText(context,"请求数据失败,请检查你的网络连接!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return environment.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTv;
        private TextView contentTv;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.special_2017_environment_item_iv);
            titleTv = itemView.findViewById(R.id.special_2017_environment_item_title_tv);
            contentTv = itemView.findViewById(R.id.special_2017_frg_environment_item_content_tv);
        }
    }
}
