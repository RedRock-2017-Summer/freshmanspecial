package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model.MilitaryPhoto;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.ImageActivity;

/**
 * Created by Anriku on 2017/8/12.
 */

public class PhotoRecAdapter extends RecyclerView.Adapter<PhotoRecAdapter.ViewHolder> {

    private Context context;
    private MilitaryPhoto militaryPhoto;

    public PhotoRecAdapter(Context context, MilitaryPhoto militaryPhoto) {
        this.context = context;
        this.militaryPhoto = militaryPhoto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_photo_rec_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(militaryPhoto.getData().getTitle().get(position));
        Glide.with(context).load(militaryPhoto.getData().getUrl().get(position)).into(holder.imageView);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageActivity.class);
                String[] images = new String[militaryPhoto.getData().getUrl().size()];
                for (int i = 0; i < militaryPhoto.getData().getUrl().size(); i++) {
                    images[i] = militaryPhoto.getData().getUrl().get(i);
                }
                intent.putExtra("image_data", images);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return militaryPhoto.getData().getTitle().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.special_2017_photo_rec_item_iv);
            textView = itemView.findViewById(R.id.special_2017_photo_rec_item_tv);
        }
    }
}
