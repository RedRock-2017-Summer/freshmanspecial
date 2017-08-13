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
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.DailyFoodScenery;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.ImageActivity;

/**
 * Created by Anriku on 2017/8/12.
 */

public class DailyAndSceneryRecAdapter extends RecyclerView.Adapter<DailyAndSceneryRecAdapter.ViewHolder> {

    private Context context;
    private DailyFoodScenery dailyFoodScenery;

    public DailyAndSceneryRecAdapter(Context context, DailyFoodScenery dailyFoodScenery) {
        this.context = context;
        this.dailyFoodScenery = dailyFoodScenery;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_daily_food_scenery_rec_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleTv.setText(dailyFoodScenery.getData().get(position).getName());
        holder.locationTv.setText(dailyFoodScenery.getData().get(position).getLocation());
        holder.traitTv.setText(dailyFoodScenery.getData().get(position).getResume());
        Glide.with(context).load(dailyFoodScenery.getData().get(position).getUrl().get(0)).into(holder.imageView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageActivity.class);
                String[] images = new String[dailyFoodScenery.getData().get(position).getUrl().size()];
                for (int i = 0;i < dailyFoodScenery.getData().get(position).getUrl().size();i++){
                    images[i] = dailyFoodScenery.getData().get(position).getUrl().get(i);
                }
                intent.putExtra("image_data",images);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dailyFoodScenery.getData().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTv;
        private TextView traitTv;
        private TextView locationTv;
        private View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView = itemView.findViewById(R.id.special_2017_daily_food_scenery_rec_item_iv);
            titleTv = itemView.findViewById(R.id.special_2017_daily_food_scenery_rec_item_title_tv);
            traitTv = itemView.findViewById(R.id.special_2017_daily_food_scenery_rec_item_trait_tv);
            locationTv = itemView.findViewById(R.id.special_2017_daily_rec_item_location_tv);
        }
    }
}
