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

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model.MilitaryVideo;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/12.
 */

public class VideoRecAdapter extends RecyclerView.Adapter<VideoRecAdapter.ViewHolder> {

    private Context context;
    private MilitaryVideo militaryVideo;

    public VideoRecAdapter(Context context, MilitaryVideo militaryVideo) {
        this.context = context;
        this.militaryVideo = militaryVideo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_video_rec_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(militaryVideo.getData().get(position).getTitle());
        Glide.with(context).load(militaryVideo.getData().get(position).getCover()).into(holder.imageView);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(militaryVideo.getData().get(position).getUrl());
                intent.setData(content_url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return militaryVideo.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.special_2017_video_rec_item_iv);
            textView = itemView.findViewById(R.id.special_2017_video_video_rec_item_tv);
        }
    }
}
