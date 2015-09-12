package com.dd.morphingbutton.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.dd.morphingbutton.IProgress;
import com.dd.morphingbutton.MorphingButton;

public class LinearProgressButton extends MorphingButton implements IProgress {

    public static final int MAX_PROGRESS = 100;
    public static final int MIN_PROGRESS = 0;

    private int mProgress;
    private int mProgressColor;
    private int mProgressCornerRadius;
    private Paint mPaint;
    private RectF mRectF;

    public LinearProgressButton(Context context) {
        super(context);
    }

    public LinearProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        if (!mAnimationInProgress && mProgress > MIN_PROGRESS && mProgress <= MAX_PROGRESS) {
            if (mPaint == null) {
                mPaint = new Paint();
                mPaint.setAntiAlias(true);
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(mProgressColor);
            }

            if (mRectF == null) {
                mRectF = new RectF();
            }

            mRectF.right = (getWidth() / MAX_PROGRESS) * mProgress;
            mRectF.bottom = getHeight();
            canvas.drawRoundRect(mRectF, mProgressCornerRadius, mProgressCornerRadius, mPaint);
        }
    }

    @Override
    public void morph(@NonNull Params params) {
        super.morph(params);
        mProgress = MIN_PROGRESS;
        mPaint = null;
        mRectF = null;
    }

    @Override
    public void setProgress(int progress) {
        mProgress = progress;
        invalidate();
    }

    public void morphToProgress(int color, int progressColor, int progressCornerRadius, int width, int height, int duration) {
        mProgressCornerRadius = progressCornerRadius;
        mProgressColor = progressColor;

        MorphingButton.Params longRoundedSquare = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(mProgressCornerRadius)
                .width(width)
                .height(height)
                .color(color)
                .colorPressed(color);
        morph(longRoundedSquare);
    }


}
