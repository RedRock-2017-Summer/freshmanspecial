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
import com.mredrock.freshmanspecial.CQUPTElegant.Model.ExcellenceTech;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/12.
 */

public class ExcellenceTechRecAdapter extends RecyclerView.Adapter<ExcellenceTechRecAdapter.ViewHolder> {

    private Context context;
    private ExcellenceTech excellenceTech;

    public ExcellenceTechRecAdapter(Context context, ExcellenceTech excellenceTech) {
        this.context = context;
        this.excellenceTech = excellenceTech;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_excellence_tech_rec_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (excellenceTech.getStatus().equals("200")) {
            holder.textView.setText(excellenceTech.getData().get(position).getName());
            Glide.with(context).load(excellenceTech.getData().get(position).getUrl()).into(holder.imageView);
        } else {
            Toast.makeText(context, "请求失败,请检查你的网络连接!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return excellenceTech.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.special_2017_excellence_tech_rec_item_iv);
            textView = itemView.findViewById(R.id.special_2017_excellence_tech_rec_item_tv);
        }
    }
}
