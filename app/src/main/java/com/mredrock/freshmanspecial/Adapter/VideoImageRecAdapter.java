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
import com.mredrock.freshmanspecial.CQUPTElegant.Model.Nature;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.VideoUtil;

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
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_video_image_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (nature.getStatus().equals("200")){
//            Glide.with(context).
//                    asBitmap().
//                    load(VideoUtil.getVideoThumbnail(nature.getData().get(position).getUrl())).
//                    into(holder.iv);
            holder.tv.setText(nature.getData().get(position).getName());
        }else {
            Toast.makeText(context,"请求失败,请检查你网络连接!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return nature.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.special_2017_video_image_rec_item_iv);
            tv = itemView.findViewById(R.id.special_2017_video_image_rec_item_tv);
        }
    }
}
