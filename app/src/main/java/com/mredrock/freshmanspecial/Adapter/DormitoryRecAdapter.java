package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.Dormitory;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.ImageActivity;

/**
 * Created by Anriku on 2017/8/11.
 */

public class DormitoryRecAdapter extends RecyclerView.Adapter<DormitoryRecAdapter.ViewHolder>{


    private Context context;
    private Dormitory dormitory;

    public DormitoryRecAdapter(Context context, Dormitory dormitory) {
        this.context = context;
        this.dormitory = dormitory;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_dormitory_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (dormitory.getStatus().equals("200")){
            holder.titleTv.setText(dormitory.getData().get(position).getName());
            holder.contentTv.setText(dormitory.getData().get(position).getResume());
            holder.countTv.setText(String.valueOf(dormitory.getData().get(position).getUrl().size()) + "张");
            Glide.with(context).load(dormitory.getData().get(position).getUrl().get(0)).into(holder.imageView);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("image_data",dormitory.getData().get(position));
                    context.startActivity(intent);
                }
            });
        }else {
            Toast.makeText(context,"请求数据失败,请检查你的网络连接!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return dormitory.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView countTv;
        private TextView titleTv;
        private TextView contentTv;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.special_2017_dormitory_item_iv);
            countTv = itemView.findViewById(R.id.special_2017_dormitory_item_count_tv);
            titleTv = itemView.findViewById(R.id.special_2017_dormitory_item_title_tv);
            contentTv = itemView.findViewById(R.id.special_2017_frg_dormitory_item_content_tv);
        }
    }
}
