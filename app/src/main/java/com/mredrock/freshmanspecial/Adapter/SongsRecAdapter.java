package com.mredrock.freshmanspecial.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by Anriku on 2017/8/13.
 */

public class SongsRecAdapter extends RecyclerView.Adapter<SongsRecAdapter.ViewHolder> {

    private String[] names = {"强军战歌","咱当兵的人","团结就是力量","军中绿花","战友还记得吗","一二三四歌",
    "打靶归来","75厘米","精忠报国","我的老班长","保卫黄河","国际歌"};
    private String[] singers = {"阎维文","刘斌","霍勇","小曾","小曾","阎维文","阎维文","小曾","屠洪刚","小曾",
    "瞿弦和","张穆庭"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_2017_songs_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < 9){
            holder.numTv.setText("0" + String.valueOf(position + 1));
        }else {
            holder.numTv.setText(String.valueOf(position + 1));
        }
        holder.nameTv.setText(names[position]);
        holder.singerTv.setText(singers[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView numTv;
        private TextView nameTv;
        private TextView singerTv;
        public ViewHolder(View itemView) {
            super(itemView);
            numTv = itemView.findViewById(R.id.special_2017_songs_rec_item_num_tv);
            nameTv = itemView.findViewById(R.id.special_2017_songs_rec_item_name_tv);
            singerTv = itemView.findViewById(R.id.special_2017_songs_rec_item_singer_tv);
        }
    }
}
