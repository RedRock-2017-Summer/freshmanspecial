package com.mredrock.freshmanspecial.Utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.CQUPTElegant.Model.ExcellenceStu;
import com.mredrock.freshmanspecial.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DialogActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView nameTv;
    private TextView resumeTv;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_dialog);

        initView();
    }

    private void initView() {
        circleImageView = (CircleImageView) findViewById(R.id.special_2017_ac_dialog_civ);
        nameTv = (TextView) findViewById(R.id.special_2017_ac_dialog_name_tv);
        resumeTv = (TextView) findViewById(R.id.special_2017_ac_dialog_resume_tv);
        imageView = (ImageView) findViewById(R.id.special_2017_ac_dialog_iv);

        Intent intent = getIntent();
        ExcellenceStu.ExcellenceStuData excellenceStuData  = (ExcellenceStu.ExcellenceStuData) intent.getSerializableExtra("stu_data");
        Glide.with(this).load(excellenceStuData.getUrl()).into(circleImageView);
        nameTv.setText(excellenceStuData.getName());
        resumeTv.setText(excellenceStuData.getResume());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
