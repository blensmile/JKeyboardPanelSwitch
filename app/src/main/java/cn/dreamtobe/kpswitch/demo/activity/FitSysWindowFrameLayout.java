package cn.dreamtobe.kpswitch.demo.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class FitSysWindowFrameLayout extends FrameLayout {
    private int[] mInsets = new int[4];

    public FitSysWindowFrameLayout(Context context) {
        super(context);
    }

    public FitSysWindowFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FitSysWindowFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public final int[] getInsets() {
        return mInsets;
    }

    @Override
    public WindowInsets computeSystemWindowInsets(WindowInsets in, Rect outLocalInsets) {
        outLocalInsets.left = 0;
        outLocalInsets.top = 0;
        outLocalInsets.right = 0;

        return super.computeSystemWindowInsets(in, outLocalInsets);
    }

    @Override
    protected final boolean fitSystemWindows(@NonNull Rect insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // Intentionally do not modify the bottom inset. For some reason,
            // if the bottom inset is modified, window resizing stops working.
            // TODO: Figure out why.

            mInsets[0] = insets.left;
            mInsets[1] = insets.top;
            mInsets[2] = insets.right;

            insets.left = 0;
            insets.top = 0;
            insets.right = 0;
        }

        return super.fitSystemWindows(insets);
    }
}
