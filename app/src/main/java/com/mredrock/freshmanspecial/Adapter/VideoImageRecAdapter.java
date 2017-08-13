package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Nature;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.VideoUtil;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class VideoImageRecAdapter extends RecyclerView.Adapter<VideoImageRecAdapter.ViewHolder> {

    private Context context;
    private Nature nature;

    public VideoImageRecAdapter(Context context, Nature nature) {
        this.context = context;
        this.nature = nature;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_video_image_rec_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText("《" + nature.getData().get(position).getName() + "》");
        Glide.with(context).load(nature.getData().get(position).getCover()).into(holder.iv);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(nature.getData().get(position).getUrl());
                intent.setData(content_url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nature.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            iv = itemView.findViewById(R.id.special_2017_video_image_rec_item_iv);
            tv = itemView.findViewById(R.id.special_2017_video_image_rec_item_tv);
        }
    }
}
