package com.mredrock.freshmanspecial.Interface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mredrock.freshmanspecial.Utils.StatisticsView;

/**
 * Created by Anriku on 2017/8/3.
 */

public interface IMostDifficultSubFrg {
    LayoutInflater getLayoutInflater();
    Window getWindow();
    StatisticsView getStatistics();
}
