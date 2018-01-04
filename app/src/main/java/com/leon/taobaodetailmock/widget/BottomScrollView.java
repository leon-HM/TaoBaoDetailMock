package com.leon.taobaodetailmock.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * <br> ClassName: BottomScrollView
 * <br> Description: 第二页的ScrollView
 *
 * <br> Author: hemin
 * <br> Date: 2017/11/29 11:23
 */
public class BottomScrollView extends ScrollView {
    private static final int TOUCH_IDLE = 0;
    private static final int TOUCH_INNER_CONSIME = 1; // touch事件由ScrollView内部消费
    private static final int TOUCH_DRAG_LAYOUT = 2; // touch事件由上层的DragLayout去消费
    private static final int MODE_HORIZONTAL = 3;
    private static final String TAG = "leon";

    private int scrollMode;
    private float  downX;
    private float  downY;
    private int mTouchSlop = 4; // 判定为滑动的阈值，单位是像素
    boolean isAtTop = true;

    public BottomScrollView(Context context) {
        this(context,null);
    }

    public BottomScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
    }

   /*@Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //子View一定要Clickable才行，否则onInterceptTouchEvent工作不按正常来
        getChildAt(0).setClickable(true);
    }*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downX = ev.getRawX();
            downY = ev.getRawY();
            isAtTop = isAtTop();
            scrollMode = TOUCH_IDLE;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (scrollMode == TOUCH_IDLE) {

                float yOffset = downY - ev.getRawY();
                float xDistance = Math.abs(downX - ev.getRawX());
                float yDistance = Math.abs(yOffset);
                Log.d(TAG, "BottomScrollView onInterceptTouchEvent yOffset:"+yOffset+" yDistance:"+yDistance+" mTouchSlop:"+mTouchSlop+" isAtTop:"+isAtTop);
                if (xDistance > yDistance && xDistance > mTouchSlop) {
                    //横向滑动交给父控件处理
                    scrollMode = TOUCH_DRAG_LAYOUT;
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else if (yDistance > xDistance && yDistance > mTouchSlop) {
                    if (yOffset < 0 && isAtTop) {
                        scrollMode = TOUCH_DRAG_LAYOUT;
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    } else {
                        scrollMode = TOUCH_INNER_CONSIME;
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (scrollMode == TOUCH_DRAG_LAYOUT) {
            return false;
        }
        boolean result = super.onTouchEvent(ev);
        Log.d(TAG, "BottomScrollView onTouchEvent result:"+result);
        return result;


    }

    /**
     * 判断WebView是否在顶部
     *
     * @return 是否在顶部
     */
    public boolean isAtTop() {
        return getScrollY() == 0;
    }

}
