package com.mredrock.freshmanspecial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.ExcellenceStu;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.DialogActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Anriku on 2017/8/12.
 */

public class ExcellenceStudentRecAdapter extends RecyclerView.Adapter<ExcellenceStudentRecAdapter.ViewHolder> {

    private Context context;
    private ExcellenceStu excellenceStu;

    public ExcellenceStudentRecAdapter(Context context, ExcellenceStu excellenceStu) {
        this.context = context;
        this.excellenceStu = excellenceStu;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_excellence_student_rec_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(excellenceStu.getData().get(position).getUrl()).into(holder.civ);
        holder.nameTv.setText(excellenceStu.getData().get(position).getName());
        holder.resumeTv.setText("颁奖词:" + excellenceStu.getData().get(position).getMotto());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DialogActivity.class);
                intent.putExtra("stu_data", excellenceStu.getData().get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return excellenceStu.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView civ;
        private TextView nameTv;
        private TextView resumeTv;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            civ = itemView.findViewById(R.id.special_2017_excellence_student_rec_item_civ);
            nameTv = itemView.findViewById(R.id.special_2017_excellence_student_rec_item_name_tv);
            resumeTv = itemView.findViewById(R.id.special_2017_excellence_student_rec_item_resume_tv);
        }
    }
}
