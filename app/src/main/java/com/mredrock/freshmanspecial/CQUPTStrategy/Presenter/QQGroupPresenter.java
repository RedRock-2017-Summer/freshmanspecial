package com.mredrock.freshmanspecial.CQUPTStrategy.Presenter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.IQQGroupFrg;
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.IQQGroupPre;
import com.mredrock.freshmanspecial.CQUPTStrategy.Model.QQGroup;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Utils.NetUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import okhttp3.ResponseBody;

/**
 * Created by Anriku on 2017/8/10.
 */

public class QQGroupPresenter implements IQQGroupPre {

    private IQQGroupFrg iqqGroupFrg;

    public QQGroupPresenter(IQQGroupFrg iqqGroupFrg) {
        this.iqqGroupFrg = iqqGroupFrg;
    }

    @Override
    public void setAutoCompleteTextView(final Context context, final AutoCompleteTextView autoCompleteTextView,
                                        final TextView cancelTv, final Button searchBt, final Button cancelBt,
                                        final TextView resultTv) {
        NetUtil.getPostData("http://www.yangruixin.com/", "QQGroup", NetUtil.RATIO_POST, new NetUtil.HttpCallBackListener() {
            @Override
            public void onFinish(ResponseBody responseBody) {
                //Gson解析
                Gson gson = new Gson();
                try {
                    final QQGroup qqGroup = gson.fromJson(responseBody.string(), new TypeToken<QQGroup>() {
                    }.getType());
                    final String[] groups = new String[qqGroup.getData().size()];
                    if (qqGroup.getStatus().equals("200")) {
                        for (int i = 0; i < qqGroup.getData().size(); i++) {
                            groups[i] = qqGroup.getData().get(i).getGroupName();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_expandable_list_item_1, groups);
                        autoCompleteTextView.setAdapter(adapter);

                        //对取消进行监听
                        cancelTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                autoCompleteTextView.setText("");
                                cancelBt.setVisibility(View.GONE);
                                cancelTv.setVisibility(View.GONE);
                            }
                        });
                        //对AutoCompleteTextView进行监听
                        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                cancelBt.setVisibility(View.VISIBLE);
                                cancelTv.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });

                        //dui查询按键进行监听
                        searchBt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(searchBt.getWindowToken(), 0);
                                if (!TextUtils.isEmpty(autoCompleteTextView.getText())) {
                                    String sc = String.valueOf(autoCompleteTextView.getText());
                                    List<Integer> index = new ArrayList<>();
                                    for (int i = 0; i < qqGroup.getData().size(); i++) {
                                        if (qqGroup.getData().get(i).getGroupName().length() >= sc.length()) {
                                            if (sc.equals(qqGroup.getData().get(i).getGroupName().substring(0, sc.length()))) {
                                                index.add(i);
                                            }
                                        }
                                    }

                                    StringBuilder result = new StringBuilder(100);
                                    result.append("搜索结果\n");
                                    for (int i = 0; i < index.size(); i++) {
                                        result.append(qqGroup.getData().get(index.get(i)).getGroupName())
                                                .append(":")
                                                .append(qqGroup.getData().get(index.get(i)).getNumber())
                                                .append("\n");
                                    }
                                    resultTv.setTextSize(20);
                                    resultTv.setText(result);
                                } else {
                                    StringBuilder result = new StringBuilder(100);
                                    result.append("全部群:\n");
                                    for (int i = 0; i < qqGroup.getData().size(); i++) {
                                        result.append(qqGroup.getData().get(i).getGroupName())
                                                .append(":")
                                                .append(qqGroup.getData().get(i).getNumber())
                                                .append("\n");
                                    }
                                    resultTv.setTextSize(20);
                                    resultTv.setText(result);
                                }
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
