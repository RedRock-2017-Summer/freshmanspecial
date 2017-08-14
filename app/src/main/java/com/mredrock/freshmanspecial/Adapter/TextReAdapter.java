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

public class TextReAdapter extends RecyclerView.Adapter<TextReAdapter.ViewHolder> {

    private String[] strings;

    public TextReAdapter(String[] strings) {
        this.strings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_2017_frg_notice_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTv.setText(strings[position * 2]);
        holder.contentTv.setText(strings[position * 2 + 1]);
    }

    @Override
    public int getItemCount() {
        return strings.length / 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private TextView contentTv;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.special_2017_frg_notice_rec_item_title_tv);
            contentTv = itemView.findViewById(R.id.special_2017_frg_notice_rec_item_content_tv);
        }
    }
}
