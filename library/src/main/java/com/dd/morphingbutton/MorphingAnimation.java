package com.dd.morphingbutton;

import android.animation.*;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class MorphingAnimation {

    public interface Listener {
        void onAnimationEnd();
    }

    public static class Params {

        private float fromCornerRadius;
        private float toCornerRadius;

        private int fromHeight;
        private int toHeight;

        private int fromWidth;
        private int toWidth;

        private int fromColor;
        private int toColor;

        private int duration;

        private int fromStrokeWidth;
        private int toStrokeWidth;

        private int fromStrokeColor;
        private int toStrokeColor;

        private MorphingButton button;
        private MorphingAnimation.Listener animationListener;

        private Params(@NonNull MorphingButton button) {
            this.button = button;
        }

        public static Params create(@NonNull MorphingButton button) {
            return new Params(button);
        }

        public Params duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Params listener(@NonNull MorphingAnimation.Listener animationListener) {
            this.animationListener = animationListener;
            return this;
        }

        public Params color(int fromColor, int toColor) {
            this.fromColor = fromColor;
            this.toColor = toColor;
            return this;
        }

        public Params cornerRadius(int fromCornerRadius, int toCornerRadius) {
            this.fromCornerRadius = fromCornerRadius;
            this.toCornerRadius = toCornerRadius;
            return this;
        }

        public Params height(int fromHeight, int toHeight) {
            this.fromHeight = fromHeight;
            this.toHeight = toHeight;
            return this;
        }

        public Params width(int fromWidth, int toWidth) {
            this.fromWidth = fromWidth;
            this.toWidth = toWidth;
            return this;
        }

        public Params strokeWidth(int fromStrokeWidth, int toStrokeWidth) {
            this.fromStrokeWidth = fromStrokeWidth;
            this.toStrokeWidth = toStrokeWidth;
            return this;
        }

        public Params strokeColor(int fromStrokeColor, int toStrokeColor) {
            this.fromStrokeColor = fromStrokeColor;
            this.toStrokeColor = toStrokeColor;
            return this;
        }

    }

    private Params mParams;

    public MorphingAnimation(@NonNull Params params) {
        mParams = params;
    }

    public void start() {
        StrokeGradientDrawable background = mParams.button.getDrawableNormal();

        ObjectAnimator cornerAnimation =
                ObjectAnimator.ofFloat(background, "cornerRadius", mParams.fromCornerRadius, mParams.toCornerRadius);

        ObjectAnimator strokeWidthAnimation =
                ObjectAnimator.ofInt(background, "strokeWidth", mParams.fromStrokeWidth, mParams.toStrokeWidth);

        ObjectAnimator strokeColorAnimation = ObjectAnimator.ofInt(background, "strokeColor", mParams.fromStrokeColor, mParams.toStrokeColor);
        strokeColorAnimation.setEvaluator(new ArgbEvaluator());

        ObjectAnimator bgColorAnimation = ObjectAnimator.ofInt(background, "color", mParams.fromColor, mParams.toColor);
        bgColorAnimation.setEvaluator(new ArgbEvaluator());

        ValueAnimator heightAnimation = ValueAnimator.ofInt(mParams.fromHeight, mParams.toHeight);
        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mParams.button.getLayoutParams();
                layoutParams.height = val;
                mParams.button.setLayoutParams(layoutParams);
            }
        });

        ValueAnimator widthAnimation = ValueAnimator.ofInt(mParams.fromWidth, mParams.toWidth);
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mParams.button.getLayoutParams();
                layoutParams.width = val;
                mParams.button.setLayoutParams(layoutParams);
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(mParams.duration);
        animatorSet.playTogether(strokeWidthAnimation, strokeColorAnimation, cornerAnimation, bgColorAnimation,
                heightAnimation, widthAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mParams.animationListener != null) {
                    mParams.animationListener.onAnimationEnd();
                }
            }
        });
        animatorSet.start();
    }

}
