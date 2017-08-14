package com.mredrock.freshmanspecial.CQUPTStrategy.Interface;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anriku on 2017/8/10.
 */

public interface IQQGroupPre {
    void setAutoCompleteTextView(Context context, AutoCompleteTextView autoCompleteTextView,
                                 TextView cancelTv, Button searchBt, Button cancelBt, TextView resultTv);
}
