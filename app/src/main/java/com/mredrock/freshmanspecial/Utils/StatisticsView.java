package com.mredrock.freshmanspecial.Utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.mredrock.freshmanspecial.R;

import java.text.DecimalFormat;

/**
 * Created by Anriku on 2017/8/4.
 */

public class StatisticsView extends View {

    private boolean flag = false;
    private float[] fraction;
    private float[] values = {0f,0f};
    private String[] subs = {"无","无"};
    private float x;
    private float y;
    private float rOut;
    private float rIn;
    private int pLeft;
    private int pRight;
    private int pTop;
    private int pBottom;
    private static final int LINE_WIDTH = 25;
    private static final int DIVIDER = 10 + LINE_WIDTH*2;
    private static final int GREY = Color.parseColor("#cccccc");
    private static final int LIGHT_YELLOW = Color.parseColor("#ffff99");
    private static final int LIGHT_BLUE = Color.parseColor("#ccffff");
    private static final int LIGHT_PURPLE = Color.parseColor("#ccccff");
    private static final int LIGHT_ORANGE = Color.parseColor("#ffcc99");
    private int[] colors = {LIGHT_YELLOW,LIGHT_BLUE,LIGHT_PURPLE,LIGHT_ORANGE};
    private DecimalFormat format = new DecimalFormat( "0.00 ");

    public StatisticsView(Context context) {
        super(context);
    }


    public StatisticsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatisticsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init() {
        getAnimator();
    }

    private void getAnimator() {
        fraction = new float[values.length];
        for(int i= 0;i < values.length;i++){
            final ValueAnimator animator = ValueAnimator.ofFloat(values[i]).setDuration(1000);
            animator.setInterpolator(new LinearInterpolator());
            final int finalI = i;
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    fraction[finalI] = (float) animator.getAnimatedValue();
                    invalidate();
                }
            });
            animator.start();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        init();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setValues(float[] values) {
        this.values = values;
        requestLayout();
        invalidate();
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public void setSubs(String[] subs) {
        this.subs = subs;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                init();
                break;
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pLeft = getPaddingLeft();
        pRight = getPaddingRight();
        pTop = getPaddingTop();
        pBottom = getPaddingBottom();

        rOut = Math.min((getWidth() - pLeft - pRight) / 2, ((getHeight() - pTop - pBottom) / 2)*0.8f);
        x = rOut + pLeft + Math.abs((getWidth() - pLeft - pRight) / 2 - rOut);
        y = rOut + pTop + Math.abs(((getHeight() - pTop - pBottom) / 2)*0.8f - rOut);
        rIn = rOut - LINE_WIDTH * 2;


        if (this.isAttachedToWindow()){
            if (flag == false){
                init();
            }
            flag = true;
            for (int i = 0;i < values.length;i++){
                drawLittleCircle(canvas,i);
            }
        }
    }


    private void drawLittleCircle(Canvas canvas, int i) {
        int change = DIVIDER*i;

        Path path = new Path();
        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(5);

        paint1.setColor(colors[i % colors.length]);
        //描边
        path.addCircle(x, y, rOut - change, Path.Direction.CW);
        path.addCircle(x, y, rIn - change, Path.Direction.CW);

        //填充中间的部分
        Paint paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(45);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint4.setColor(colors[i % colors.length]);
        paint4.setAlpha(40);
        canvas.drawArc(new RectF(x - (rOut + rIn) / 2 + change, y - (rOut + rIn) / 2 + change, x + (rOut + rIn) / 2 - change,
                y + (rOut + rIn) / 2 - change), 270, 360, false, paint4);

        //填充要画的部分
        paint4.setAlpha(200);
        canvas.drawArc(new RectF(x - (rOut + rIn) / 2 + change, y - (rOut + rIn) / 2 + change, x + (rOut + rIn) / 2 - change,
                y + (rOut + rIn) / 2 - change), 270, fraction[i] * 360, false, paint4);


        paint1.setColor(GREY);

        //开始的半圆
        path.addArc(new RectF(x - LINE_WIDTH, y - rOut + change, x + LINE_WIDTH, y - rIn + change), 90, 180);
        //外圈
        path.addArc(new RectF(x - rOut + change, y - rOut +change, x + rOut - change, y + rOut - change), 270, fraction[i] * 360);
        float x1 = (float) (x + (rOut - LINE_WIDTH - change) * Math.sin(2 * fraction[i] * Math.PI));
        float y1 = (float) (y - (rOut - LINE_WIDTH - change) * Math.cos(2 * fraction[i] * Math.PI));

        //结束半圆
        path.addArc(new RectF(x1 - LINE_WIDTH, y1 - LINE_WIDTH, x1 + LINE_WIDTH, y1 + LINE_WIDTH), fraction[i] * 360 - 90, 180);
        //内圈
        path.addArc(new RectF(x - rIn + change, y - rIn + change, x + rIn - change, y + rIn - change), 270, fraction[i] * 360);

        //画下面的注释
        float vWidth = (getWidth() - pLeft - pRight) / values.length;
        float vHeight = rOut*2 + pTop + ((getHeight() - pTop - pBottom) / 2)*0.1f;
        float vR = ((getHeight() - pTop - pBottom) / 2)*0.1f*0.6f;
        path.addCircle(vWidth*i + vR,vHeight + ((getHeight() - pTop - pBottom) / 2)*0.1f*0.4f,vR, Path.Direction.CW);

        canvas.drawPath(path, paint1);

        //填充注释的圈
        Paint paint2 = new Paint();
        paint2.setColor(colors[i % colors.length]);
        paint2.setStyle(Paint.Style.FILL);
        canvas.drawCircle(vWidth*i + vR,vHeight + ((getHeight() - pTop - pBottom) / 2)*0.1f*0.4f,vR - 2.5f,paint2);


        //描写数量
        Paint paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3.setColor(colors[i % colors.length]);
        paint3.setTextSize(40);
        canvas.drawText(String.valueOf(format.format(fraction[i] * 100)) + " %", x - LINE_WIDTH * 6, 40 + pTop + change, paint3);

        //画注释圈的字
        paint3.setColor(Color.BLACK);
        paint3.setTextSize(vR*2);
        canvas.drawText(subs[i],vWidth*i + vR*2.5f,vHeight + ((getHeight() - pTop - pBottom) / 2)*0.1f*0.4f + vR,paint3);

    }
}
