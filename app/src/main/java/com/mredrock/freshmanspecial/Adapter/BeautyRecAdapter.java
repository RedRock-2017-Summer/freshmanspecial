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
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Beauty;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/12.
 */

public class BeautyRecAdapter extends RecyclerView.Adapter<BeautyRecAdapter.ViewHolder>{

    private Context context;
    private Beauty beauty;

    public BeautyRecAdapter(Context context, Beauty beauty) {
        this.context = context;
        this.beauty = beauty;
    }

    @Override
    public BeautyRecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_environment_beauty_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyRecAdapter.ViewHolder holder, int position) {
        if (beauty.getStatus().equals("200")){
            Beauty.BeautyData data = beauty.getData().get(position);
            holder.titleTv.setText(data.getTitle());
            holder.contentTv.setText(data.getContent());
            Glide.with(context).load(data.getUrl()).into(holder.imageView);
        }else {
            Toast.makeText(context,"请求数据失败,请检查你的网络连接!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return beauty.getData().size();
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
