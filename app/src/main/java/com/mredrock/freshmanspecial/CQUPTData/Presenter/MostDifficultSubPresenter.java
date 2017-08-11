package com.mredrock.freshmanspecial.CQUPTData.Presenter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IMostDifficultSubFrg;
import com.mredrock.freshmanspecial.CQUPTData.Interface.IMostDifficultSubPre;
import com.mredrock.freshmanspecial.CQUPTData.Model.FailRatio;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;
import com.mredrock.freshmanspecial.Utils.PopupWindowUtil;
import com.mredrock.freshmanspecial.Utils.SelectorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/3.
 */

public class MostDifficultSubPresenter implements IMostDifficultSubPre {

    private IMostDifficultSubFrg iMostDifficultSubFrg;
    private FailRatio failRatio;

    public MostDifficultSubPresenter(IMostDifficultSubFrg iMostDifficultSubFrg) {
        this.iMostDifficultSubFrg = iMostDifficultSubFrg;
    }


    @Override
    public void setButton(final Button academicButton, final Button majorButton, final Context context) {

        academicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupWindowUtil popupWindowUtil = PopupWindowUtil.getInstance(R.layout.special_2017_window_popup, R.style.Popupwindow
                        , iMostDifficultSubFrg.getLayoutInflater(), iMostDifficultSubFrg.getWindow());
                //用于实现两个个Button间的PopupView不会冲突
                if (popupWindowUtil.getPopupWindow() == null || !popupWindowUtil.getPopupWindow().isShowing()) {
                    popupWindowUtil.bottomWindow(view);
                    FrameLayout frameLayout = popupWindowUtil.getFrameLayout();
                    //特别注意SelectorView的加载要放在方法里面直接后面会得不到数据
                    getAcademiesData(academicButton, frameLayout);
                    TextView textView = frameLayout.findViewById(R.id.special_2017_popup_window_tv);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupWindowUtil.getPopupWindow().dismiss();
                        }
                    });
                }
            }
        });

        majorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (academicButton.getText().equals("请选择学院")) {
                    Toast.makeText(context, "请先输入学院!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    final PopupWindowUtil popupWindowUtil = PopupWindowUtil.getInstance(R.layout.special_2017_window_popup, R.style.Popupwindow
                            , iMostDifficultSubFrg.getLayoutInflater(), iMostDifficultSubFrg.getWindow());
                    if (popupWindowUtil.getPopupWindow() == null || !popupWindowUtil.getPopupWindow().isShowing()) {
                        popupWindowUtil.bottomWindow(view);
                        FrameLayout frameLayout = popupWindowUtil.getFrameLayout();
                        getMajorsData(academicButton, majorButton, frameLayout);
                        TextView textView = frameLayout.findViewById(R.id.special_2017_popup_window_tv);
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                getRatio(majorButton);
                                popupWindowUtil.getPopupWindow().dismiss();
                            }
                        });
                    }
                }
            }
        });
    }

    private void getRatio(Button majorButton) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < failRatio.getData().size(); i++) {
            if (failRatio.getData().get(i).getMajor().equals(majorButton.getText())) {
                index.add(i);
            }
        }
        dataSort(index);
        String[] subs = new String[index.size()];
        float[] values = new float[index.size()];
        for (int i = 0; i < index.size(); i++) {
            subs[i] = failRatio.getData().get(index.get(i)).getCourse();
            values[i] = Float.parseFloat(failRatio.getData().get(index.get(i)).getRatio());
        }
        iMostDifficultSubFrg.getStatistics().setSubs(subs);
        iMostDifficultSubFrg.getStatistics().setValues(values);
    }

    private void getMajorsData(Button academicButton, Button majorButton, FrameLayout frameLayout) {
        String academy = (String) academicButton.getText();
        List<String> majors = new ArrayList<>();
        //获取专业
        for (int i = 0; i < failRatio.getData().size(); i++) {
            if (academy.equals(failRatio.getData().get(i).getCollege())) {
                int j;
                String major = failRatio.getData().get(i).getMajor();
                for (j = 0; j < majors.size(); j++) {
                    if (majors.get(j).equals(major)) {
                        break;
                    }
                }
                if (j >= majors.size()) {
                    majors.add(major);
                }
            }
        }
        SelectorView selectorView = frameLayout.findViewById(R.id.special_2017_popup_window_sev);
        selectorView.setButton(majorButton);
        selectorView.setAcademies(majors);
    }


    //进行从大到小的排序
    private void dataSort(List<Integer> index) {
        int k, temp;
        for (int i = 0; i < index.size() - 1; i++) {
            k = i;
            for (int j = i + 1; j < index.size(); j++) {
                if (Float.parseFloat(failRatio.getData().get(index.get(i)).getRatio()) <
                        Float.parseFloat(failRatio.getData().get(index.get(j)).getRatio())) {
                    k = j;
                }
            }
            if (k != i) {
                temp = index.get(i);
                index.set(i, index.get(k));
                index.set(k, temp);
            }
        }
    }

    private void getAcademiesData(final Button academicButton, final FrameLayout frameLayout) {
        final List<String> academies = new ArrayList<>();
        NetUtil.getData("FailRatio", new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    failRatio = gson.fromJson(responseBody.string(), new TypeToken<FailRatio>() {
                    }.getType());
                    if (failRatio.getStatus().equals("200")) {
                        int j;
                        String ac;
                        for (int i = 0; i < failRatio.getData().size(); i++) {
                            ac = failRatio.getData().get(i).getCollege();
                            for (j = 0; j < academies.size(); j++) {
                                if (ac.equals(academies.get(j))) {
                                    break;
                                }
                            }
                            if (j >= academies.size()) {
                                academies.add(ac);
                            }
                        }
                    }
                    SelectorView selectorView = frameLayout.findViewById(R.id.special_2017_popup_window_sev);
                    selectorView.setButton(academicButton);
                    selectorView.setAcademies(academies);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
