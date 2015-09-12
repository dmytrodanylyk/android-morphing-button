package com.dd.morphingbutton;

import android.graphics.drawable.GradientDrawable;

public class StrokeGradientDrawable {

    private int mStrokeWidth;
    private int mStrokeColor;

    private GradientDrawable mGradientDrawable;
    private float mRadius;
    private int mColor;

    public StrokeGradientDrawable(GradientDrawable drawable) {
        mGradientDrawable = drawable;
    }

    public int getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        mStrokeWidth = strokeWidth;
        mGradientDrawable.setStroke(strokeWidth, getStrokeColor());
    }

    public int getStrokeColor() {
        return mStrokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        mStrokeColor = strokeColor;
        mGradientDrawable.setStroke(getStrokeWidth(), strokeColor);
    }

    public void setCornerRadius(float radius) {
        mRadius = radius;
        mGradientDrawable.setCornerRadius(radius);
    }

    public void setColor(int color) {
        mColor = color;
        mGradientDrawable.setColor(color);
    }

    public int getColor() {
        return mColor;
    }

    public float getRadius() {
        return mRadius;
    }

    public GradientDrawable getGradientDrawable() {
        return mGradientDrawable;
    }
}
