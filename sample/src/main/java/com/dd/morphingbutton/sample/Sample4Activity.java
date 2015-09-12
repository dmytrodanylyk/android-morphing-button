package com.dd.morphingbutton.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import com.dd.morphingbutton.impl.IndeterminateProgressButton;
import com.dd.morphingbutton.MorphingButton;

public class Sample4Activity extends BaseActivity {

    private int mMorphCounter1 = 1;
    private int mMorphCounter2 = 1;

    public static void startThisActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, Sample4Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sample_linear_indet);

        final IndeterminateProgressButton btnMorph1 = (IndeterminateProgressButton) findViewById(R.id.btnMorph1);
        btnMorph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMorphButton1Clicked(btnMorph1);
            }
        });

        final IndeterminateProgressButton btnMorph2 = (IndeterminateProgressButton) findViewById(R.id.btnMorph2);
        btnMorph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMorphButton2Clicked(btnMorph2);
            }
        });

        morphToSquare(btnMorph1, 0);
        morphToFailure(btnMorph2, 0);

    }

    private void onMorphButton1Clicked(final IndeterminateProgressButton btnMorph) {
        if (mMorphCounter1 == 0) {
            mMorphCounter1++;
            morphToSquare(btnMorph, integer(R.integer.mb_animation));
        } else if (mMorphCounter1 == 1) {
            mMorphCounter1 = 0;
            simulateProgress1(btnMorph);
        }
    }

    private void onMorphButton2Clicked(final IndeterminateProgressButton btnMorph) {
        if (mMorphCounter2 == 0) {
            mMorphCounter2++;
            morphToFailure(btnMorph, integer(R.integer.mb_animation));
        } else if (mMorphCounter2 == 1) {
            mMorphCounter2 = 0;
            simulateProgress2(btnMorph);
        }
    }

    private void morphToSquare(final IndeterminateProgressButton btnMorph, int duration) {
        MorphingButton.Params square = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(dimen(R.dimen.mb_corner_radius_2))
                .width(dimen(R.dimen.mb_width_100))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_blue))
                .colorPressed(color(R.color.mb_blue_dark))
                .text(getString(R.string.mb_button));
        btnMorph.morph(square);
    }

    private void morphToSuccess(final IndeterminateProgressButton btnMorph) {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(integer(R.integer.mb_animation))
                .cornerRadius(dimen(R.dimen.mb_height_56))
                .width(dimen(R.dimen.mb_height_56))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_green))
                .colorPressed(color(R.color.mb_green_dark))
                .icon(R.drawable.ic_done);
        btnMorph.morph(circle);
    }

    private void morphToFailure(final IndeterminateProgressButton btnMorph, int duration) {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(dimen(R.dimen.mb_height_56))
                .width(dimen(R.dimen.mb_height_56))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_red))
                .colorPressed(color(R.color.mb_red_dark))
                .icon(R.drawable.ic_lock);
        btnMorph.morph(circle);
    }

    private void simulateProgress2(@NonNull final IndeterminateProgressButton button) {
        int progressColor = color(R.color.mb_blue);
        int color = color(R.color.mb_gray);
        int progressCornerRadius = dimen(R.dimen.mb_corner_radius_4);
        int width = dimen(R.dimen.mb_width_200);
        int height = dimen(R.dimen.mb_height_8);
        int duration = integer(R.integer.mb_animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                morphToSquare(button, integer(R.integer.mb_animation));
                button.unblockTouch();
            }
        }, 4000);

        button.blockTouch(); // prevent user from clicking while button is in progress
        button.morphToProgress(color, progressCornerRadius, width, height, duration, progressColor);
    }

    private void simulateProgress1(@NonNull final IndeterminateProgressButton button) {
        int progressColor1 = color(R.color.holo_blue_bright);
        int progressColor2 = color(R.color.holo_green_light);
        int progressColor3 = color(R.color.holo_orange_light);
        int progressColor4 = color(R.color.holo_red_light);
        int color = color(R.color.mb_gray);
        int progressCornerRadius = dimen(R.dimen.mb_corner_radius_4);
        int width = dimen(R.dimen.mb_width_200);
        int height = dimen(R.dimen.mb_height_8);
        int duration = integer(R.integer.mb_animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                morphToSuccess(button);
                button.unblockTouch();
            }
        }, 4000);

        button.blockTouch(); // prevent user from clicking while button is in progress
        button.morphToProgress(color, progressCornerRadius, width, height, duration, progressColor1, progressColor2,
                progressColor3, progressColor4);
    }

}
