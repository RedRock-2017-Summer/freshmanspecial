package com.mredrock.freshmanspecial.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Anriku on 2017/8/7.
 */

public class BackGroundView extends View {

    private int height;

    public BackGroundView(Context context) {
        super(context);
    }

    public BackGroundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BackGroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        height = getHeight() / 5;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(height);
        paint.setColor(Color.parseColor("#99ccff"));
        canvas.drawLine(0,getHeight()/ 2,getWidth(),getHeight() / 2,paint);
    }
}
