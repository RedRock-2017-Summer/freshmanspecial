package com.mredrock.freshmanspecial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mredrock.freshmanspecial.CQUPTData.View.CQUPTDataActivity;
import com.mredrock.freshmanspecial.CQUPTElegant.View.CQUPTElegantActivity;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View.CQUPTMilitaryActivity;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.CQUPTStrategyActivity;

public class FreshmanSpecialActivity extends AppCompatActivity {

    private ImageView strategy;
    private ImageView elegant;
    private ImageView data;
    private ImageView military;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_freshman_special);
        strategy = (ImageView) findViewById(R.id.special_2017_ac_freshman_special_strategy_iv);
        elegant = (ImageView) findViewById(R.id.special_2017_ac_freshman_special_elegant_iv);
        data = (ImageView) findViewById(R.id.special_2017_ac_freshman_special_data_iv);
        military = (ImageView) findViewById(R.id.special_2017_ac_freshman_special_military_iv);

        strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreshmanSpecialActivity.this, CQUPTStrategyActivity.class);
                startActivity(intent);
            }
        });

        elegant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreshmanSpecialActivity.this, CQUPTElegantActivity.class);
                startActivity(intent);
            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreshmanSpecialActivity.this, CQUPTDataActivity.class);
                startActivity(intent);
            }
        });

        military.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreshmanSpecialActivity.this, CQUPTMilitaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
