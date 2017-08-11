package com.mredrock.freshmanspecial.CQUPTData.Presenter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IBoyAndGirlFrg;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IBoyAndGirlPre;
import com.mredrock.freshmanspecial.CQUPTData.Model.SexRatio;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;
import com.mredrock.freshmanspecial.Utils.PopupWindowUtil;
import com.mredrock.freshmanspecial.Utils.SelectorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;


/**
 * Created by Anriku on 2017/8/8.
 */

public class BoyAndGirlPresenter implements IBoyAndGirlPre {

    private IBoyAndGirlFrg iBoyAndGirlFrg;

    public BoyAndGirlPresenter(IBoyAndGirlFrg iBoyAndGirlFrg) {
        this.iBoyAndGirlFrg = iBoyAndGirlFrg;
    }

    @Override
    public void setButtonListener(final Button button) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupWindowUtil popupWindowUtil = PopupWindowUtil.getInstance(R.layout.special_2017_window_popup, R.style.Popupwindow,
                    iBoyAndGirlFrg.getTheLayoutInflater(), iBoyAndGirlFrg.getTheWindow());
                popupWindowUtil.bottomWindow(view);
                getData(button, popupWindowUtil);

            }
        });
    }

    private void getData(final Button button, final PopupWindowUtil popupWindowUtil) {


        NetUtil.getData("SexRatio", new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    final SexRatio sexRatio = gson.fromJson(responseBody.string(), new TypeToken<SexRatio>() {
                    }.getType());
                    if (sexRatio.getStatus().equals("200")) {
                        int length = sexRatio.getData().size();
                        List<String> academies = new ArrayList<>();
                        for (int i = 0; i < length; i++) {
                            academies.add(sexRatio.getData().get(i).getCollege());
                        }
                        final SelectorView selectorView = popupWindowUtil.getFrameLayout().findViewById(R.id.special_2017_popup_window_sev);
                        selectorView.setButton(button);
                        selectorView.setAcademies(academies);
                        TextView textView = popupWindowUtil.getFrameLayout().findViewById(R.id.special_2017_popup_window_tv);
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                iBoyAndGirlFrg.getStatisticView().setValues(new float[]{Float.parseFloat(sexRatio.getData().get(selectorView.getFlag()).getWomenRatio()),
                                        Float.parseFloat(sexRatio.getData().get(selectorView.getFlag()).getMenRatio())});
                                popupWindowUtil.getPopupWindow().dismiss();
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
