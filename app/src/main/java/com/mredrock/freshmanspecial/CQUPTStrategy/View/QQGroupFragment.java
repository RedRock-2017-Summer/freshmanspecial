package com.mredrock.freshmanspecial.CQUPTStrategy.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.IQQGroupFrg;
import com.mredrock.freshmanspecial.CQUPTStrategy.Interface.IQQGroupPre;
import com.mredrock.freshmanspecial.CQUPTStrategy.Presenter.QQGroupPresenter;
import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/10.
 */

public class QQGroupFragment extends Fragment implements IQQGroupFrg {


    private TextView resultTv;
    private TextView cancelTv;
    private IQQGroupPre iqqGroupPre;
    private View view;
    private AutoCompleteTextView autoCompleteTextView;
    private Button searchBt;
    private Button cancelBt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.special_2017_fragment_qqgroup, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        iqqGroupPre = new QQGroupPresenter(this);
        cancelTv = view.findViewById(R.id.special_2017_frg_qqgroup_cancel_tv);
        autoCompleteTextView = view.findViewById(R.id.special_2017_frg_qqgroup_actv);
        searchBt = view.findViewById(R.id.special_2017_frg_qqgroup_search_bt);
        cancelBt = view.findViewById(R.id.special_2017_frg_qqgroup_cancel_bt);
        resultTv = view.findViewById(R.id.special_2017_frg_qqgroup_result_tv);
        iqqGroupPre.setAutoCompleteTextView(getContext(),autoCompleteTextView, cancelTv,
                searchBt, cancelBt, resultTv);
    }
}
