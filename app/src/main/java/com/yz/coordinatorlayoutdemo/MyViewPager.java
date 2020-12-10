package com.yz.coordinatorlayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @Desc:
 * @Author: YiZe
 */
public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull Context context) {
        this(context, null);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                requestLayout();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //初始高度为0
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            // getChildMeasureSpec获取到child具体的高度
            view.measure(widthMeasureSpec,
                    getChildMeasureSpec(heightMeasureSpec,
                            0, view.getLayoutParams().height));
            int h = view.getMeasuredHeight();
            //采用最大的view的高度。
            if (h > height) {
                height = h;
            }
        }
        setMeasuredDimension(getMeasuredWidth(), height);
    }
}
