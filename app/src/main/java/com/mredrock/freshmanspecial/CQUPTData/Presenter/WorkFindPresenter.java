package com.mredrock.freshmanspecial.CQUPTData.Presenter;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IWorkFindFrg;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IWorkFindPre;
import com.mredrock.freshmanspecial.CQUPTData.Model.WorkRatio;
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

public class WorkFindPresenter implements IWorkFindPre {

    private IWorkFindFrg iWorkFindFrg;
    private WorkRatio workRatio;

    public WorkFindPresenter(IWorkFindFrg iWorkFindFrg) {
        this.iWorkFindFrg = iWorkFindFrg;
    }

    @Override
    public void setButtonListener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupWindowUtil popupWindowUtil = PopupWindowUtil.getInstance(R.layout.special_2017_window_popup, R.style.Popupwindow
                        , iWorkFindFrg.getTheLayoutInflater(), iWorkFindFrg.getTheWindow());
                popupWindowUtil.bottomWindow(view);
                FrameLayout frameLayout = popupWindowUtil.getFrameLayout();
                final SelectorView selectorView = frameLayout.findViewById(R.id.special_2017_popup_window_sev);
                getWorkData(button, selectorView);
                TextView textView = frameLayout.findViewById(R.id.special_2017_popup_window_tv);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        iWorkFindFrg.getStatisticsView().setSubs(new String[]{(String) button.getText()});
                        iWorkFindFrg.getStatisticsView().setValues(new float[]{Float.parseFloat(workRatio.getData().get(selectorView.getFlag()).getRatio())});
                        popupWindowUtil.getPopupWindow().dismiss();
                    }
                });
            }
        });
    }

    private void getWorkData(final Button button, final SelectorView selectorView) {
        NetUtil.getPostData("http://www.yangruixin.com/","WorkRatio",NetUtil.RATIO_POST, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    workRatio = gson.fromJson(responseBody.string(), new TypeToken<WorkRatio>() {
                    }.getType());
                    List<String> academies = new ArrayList<>();
                    for (int i = 0; i < workRatio.getData().size(); i++) {
                        academies.add(workRatio.getData().get(i).getCollege());
                    }
                    selectorView.setButton(button);
                    selectorView.setAcademies(academies);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
