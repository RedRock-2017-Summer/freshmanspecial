package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by Anriku on 2017/8/12.
 */

public interface IElegantPre {
    void setPhotos(Context context,RecyclerView recyclerView);
    void setVideos(Context context,RecyclerView recyclerView);
    void setSongs(Context context,RecyclerView recyclerView);
}
