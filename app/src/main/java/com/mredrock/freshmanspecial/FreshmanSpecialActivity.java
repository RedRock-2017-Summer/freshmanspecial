package com.mredrock.freshmanspecial;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.mredrock.freshmanspecial.CQUPTData.View.CQUPTDataActivity;
import com.mredrock.freshmanspecial.CQUPTElegant.View.CQUPTElegantActivity;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View.CQUPTMilitaryActivity;
import com.mredrock.freshmanspecial.CQUPTStrategy.View.CQUPTStrategyActivity;
import com.mredrock.freshmanspecial.Utils.MyDialog;

import org.zackratos.ultimatebar.UltimateBar;

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

        getDialog();
        initView();
    }

    private void initView() {
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

        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    private void getDialog() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            MyDialog dialog = new MyDialog(this);
            dialog.setContentView(R.layout.special_2017_net_not_available_dialog);
            dialog.show();
            Button button = dialog.findViewById(R.id.special_2017_net_not_available_dialog_bt);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
