package com.mredrock.freshmanspecial.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anriku on 2017/8/7.
 */

public class SelectorView extends ViewGroup {

    public boolean isCreated = false;//用于判断是否是第一次进来
    private Button button;
    private float textSize = 5;
    private float xmlHeight;
    private List<View> views = new ArrayList<>();
    private List<String> academies = new ArrayList<>();
    private int mOldChildIndex;
    private int flag = 2;//用于指定中间的位置就是那一杠
    private int mChildSize;
    private int mChildHeight;
    private int mChildIndex;
    private int mLastX = 0;
    private int mLastY = 0;
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    public void setButton(Button button) {
        this.button = button;
    }

    public SelectorView(Context context) {
        super(context);
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        init();
    }

    public int getFlag() {
        return flag;
    }

    public SelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SelectorView);
        textSize = a.getDimension(R.styleable.SelectorView_text_size, 5);
        xmlHeight = a.getDimension(R.styleable.SelectorView_xml_height, 1);
        a.recycle();
        init();
    }

    public SelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        academies.add("亲,还没有选择");
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SelectorView);
        textSize = a.getDimension(R.styleable.SelectorView_text_size, 5);
        xmlHeight = a.getDimension(R.styleable.SelectorView_xml_height, 1);
        a.recycle();
        init();
    }


    private void init() {

        if (mScroller == null) {
            mScroller = new Scroller(getContext());
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }

        //动态添加TextView
        for (int i = 0; i < academies.size(); i++) {
            addTextView(i);
        }
        setView();
    }

    //进行TextView的添加
    private void addTextView(int i) {
        TextView textView = new TextView(getContext());
        textView.setTag(i);
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(dp2px(getContext(), 385));
        textView.setHeight((int) (xmlHeight / 5));


        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = (int) view.getTag();
                mOldChildIndex = flag - 2;
                smoothScrollBy(0, (int) ((flag - 2) * (xmlHeight / 5) - mScroller.getCurrY()));
            }
        });
        views.add(textView);
        this.addView(textView);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercepted = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                    intercepted = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                invalidate();
                int deltaY = y - mLastY;
                scrollBy(0, -deltaY);
                break;
            case MotionEvent.ACTION_UP:
                int scrollY = getScrollY();
                mVelocityTracker.computeCurrentVelocity(1000);
                float yVelocity = mVelocityTracker.getYVelocity();
                if (Math.abs(yVelocity) >= 50) {
                    mChildIndex = yVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
                } else {
                    mChildIndex = (getScrollY() + mChildHeight / 2) / mChildHeight;
                }

                mChildIndex = Math.max(-2, Math.min(mChildIndex, academies.size() - 3));
                int dy = mChildIndex * mChildHeight - scrollY;
                flag += (mChildIndex - mOldChildIndex);
                mOldChildIndex = mChildIndex;
                smoothScrollBy(0, dy);
                mVelocityTracker.clear();
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measureWidth = 0;
        int measureHeight = 0;

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            mChildSize = getChildCount();
            for (int i = 0; i < mChildSize; i++) {
                View view = getChildAt(i);
                measureHeight += view.getMeasuredHeight();
                measureWidth = view.getMeasuredWidth();
            }
            setMeasuredDimension(measureWidth, measureHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            measureWidth = getChildAt(0).getMeasuredWidth();
            setMeasuredDimension(measureWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            for (int i = 0; i < mChildSize; i++) {
                View view = getChildAt(i);
                measureHeight += view.getMeasuredHeight();
            }
            setMeasuredDimension(widthSpecSize, measureHeight);
        }
    }

    @Override
    protected void onLayout(boolean a, int l, int t, int r, int b) {
        int childTop = 0;
        final int childCount = getChildCount();
        mChildSize = childCount;

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE) {
                final int childHeight = childView.getMeasuredHeight();
                mChildHeight = childHeight;
                childView.layout(0, childTop, childView.getMeasuredWidth(), childTop + childHeight);
                childTop += childHeight;
            }
        }
    }

    private void smoothScrollBy(int dx, int dy) {
        mScroller.startScroll(0, getScrollY(), 0, dy, 500);
        setView();
        if (button != null) {
            button.setText(academies.get(flag));
        }
        invalidate();
    }

    //进行TextView字的设置,并进行渐变设置
    private void setView() {
        if (flag < academies.size()) {
            TextView textView = (TextView) views.get(flag);
            textView.setTextSize(dp2px(getContext(), textSize));
            textView.setTextColor(Color.WHITE);
            textView.setAlpha(0.8f);
            //当外面的代码进行动态添加的时候，此时中间代码字的显示
            textView.setText(academies.get(flag));
            for (int i = 1; i < academies.size(); i++) {
                if (flag - i >= 0) {
                    TextView textView2 = (TextView) views.get(flag - i);
                    setTextView(textView2, i);
                }
                if (flag + i < academies.size()) {
                    TextView textView3 = (TextView) views.get(flag + i);
                    setTextView(textView3, i);
                }
            }
        }

    }

    //对TextView进行输入
    private void setTextView(TextView textView, int i) {
        textView.setText(academies.get((int) textView.getTag()));
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(dp2px(getContext(), textSize * (10 - i) / 10f));
        textView.setAlpha((6 - i * 2) / 10f);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }


    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setAcademies(List<String> academies) {
        //当输入为0的返回
        if (academies.size() == 0) {
            academies.add("亲，没有选择");
        }
        //进行flag的设置
        if (!isCreated) {
            if (academies.size() > 2) {
                flag = 2;
            } else {
                flag = academies.size() - 1;
            }
            isCreated = true;
        }

        if (academies.size() < this.academies.size()) {
            for (int i = 1; i < this.academies.size(); i++) {
                if (i >= academies.size()) {
                    TextView textView = (TextView) views.get(i);
                    textView.setVisibility(GONE);
                }
                //当在代码中进行动态添加View的时候让中间的居中!我的天，这是我的救星!!!!!注意:这样进行计算的话academies必须设置为3个容量
                views.get(academies.size() / 2).callOnClick();
            }
        } else {
            for (int i = 0; i < academies.size(); i++) {
                //超级超级超级坑!!!!重要的事情说三遍，不加等号让我在这代码海中找得好惨
                if (i >= this.academies.size()) {
                    addTextView(i);
                }
            }
        }
        this.academies = academies;
        if (button != null) {
            button.setText(academies.get(flag));
        }
        setView();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    public List<View> getViews() {
        return views;
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
