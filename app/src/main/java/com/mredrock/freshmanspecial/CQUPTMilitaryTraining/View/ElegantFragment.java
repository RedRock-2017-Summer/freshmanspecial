package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.Adapter.PhotoRecAdapter;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantFrg;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantPre;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model.MilitaryPhoto;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter.ElegantPresenter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class ElegantFragment extends Fragment implements IElegantFrg{

    private IElegantPre iElegantPre;
    private View view;
    private RecyclerView photoRec;
    private RecyclerView videoRec;
    private RecyclerView songsRec;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.specail_2017_fragment_elegant,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        iElegantPre = new ElegantPresenter(this);
        photoRec = view.findViewById(R.id.special_2017_frg_elegant_photo_rv);
        videoRec = view.findViewById(R.id.special_2017_frg_elegant_video_rv);
        songsRec = view.findViewById(R.id.special_2017_frg_elegant_songs_rv);

        iElegantPre.setPhotos(getContext(),photoRec);
        iElegantPre.setVideos(getContext(),videoRec);
        iElegantPre.setSongs(getContext(),songsRec);
    }
}
