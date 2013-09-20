package com.jaynewstrom.touchdelegatebug;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * Created by jnewstrom on 9/20/13.
 */
public final class ViewHelper {

    private ViewHelper() {
        // no instances
    }

    public static void expandTouchArea(final View bigView, final View smallView, final int extraPadding) {
        bigView.post(new Runnable() {

            @Override
            public void run() {
                Rect rect = new Rect();
                smallView.getHitRect(rect);
                rect.top -= extraPadding;
                rect.left -= extraPadding;
                rect.right += extraPadding;
                rect.bottom += extraPadding;
                bigView.setTouchDelegate(new TouchDelegate(rect, smallView));
            }
        });
    }
}
