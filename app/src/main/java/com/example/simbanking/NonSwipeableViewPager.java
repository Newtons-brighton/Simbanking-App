package com.example.simbanking;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;
public class NonSwipeableViewPager extends ViewPager {

    private boolean swipeEnabled = false;

    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Disable swiping by always returning false for onInterceptTouchEvent
        return swipeEnabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Disable swiping by always returning false for onTouchEvent
        return swipeEnabled && super.onTouchEvent(event);
    }

    // Use this method to enable or disable swiping programmatically
    public void setSwipeEnabled(boolean enabled) {
        this.swipeEnabled = enabled;
    }
}
