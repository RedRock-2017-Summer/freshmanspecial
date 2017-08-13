package com.mredrock.freshmanspecial.Utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.mredrock.freshmanspecial.R;

/**
 * Created by Anriku on 2017/8/13.
 */

public class MyDialog extends Dialog
{
    public MyDialog(@NonNull Context context) {
        this(context, R.style.Theme_ActivityDialogStyle);
    }

    public MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams params = dialogWindow.getAttributes();
        params.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(params);
    }
}
