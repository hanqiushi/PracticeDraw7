package com.hencoder.hencoderpracticedraw7.practice.practice08;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

import java.security.Key;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                animateBt.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
    /*                    Keyframe f1 = Keyframe.ofFloat(0, 90);
                        Keyframe g1 = Keyframe.ofInt(0, 0);
                        //Keyframe f2 = Keyframe.ofFloat(0.5f, 1000);
                        Keyframe f2 = Keyframe.ofFloat(1, 360);
                        Keyframe g2 = Keyframe.ofInt(1, 270);
                        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("degree", f1, *//*f2,*//* f2);
                        ValueAnimator anim = ObjectAnimator.ofPropertyValuesHolder(view, holder);
                        anim.setDuration(10000);
                        //anim.setInterpolator(new FastOutSlowInInterpolator());
                        anim.start();*/

                        ObjectAnimator animator10 = ObjectAnimator.ofFloat(view, "degree", 90, 90);
                        ObjectAnimator animator11 = ObjectAnimator.ofFloat(view, "downdegree", 0, 45);
                        ObjectAnimator animator12 = ObjectAnimator.ofFloat(view, "updegree", 0, 0);

                        ObjectAnimator animator20 = ObjectAnimator.ofFloat(view, "degree", 90, 360);

                        ObjectAnimator animator30 = ObjectAnimator.ofFloat(view, "updegree", 0, 45);
                        animator10.setDuration(1000);
                        animator11.setDuration(1000);
                        animator12.setDuration(1000);
                        animator20.setDuration(3000);
                        animator30.setDuration(1000);

                        AnimatorSet animatorSet = new AnimatorSet();
                        // 用 AnimatorSet 的方法来让三个动画协作执行
                        // 要求 1： animator1 先执行，animator2 在 animator1 完成后立即开始
                        // 要求 2： animator2 和 animator3 同时开始

                        animatorSet.play(animator10).with(animator11).with(animator12);
                        animatorSet.play(animator20).after(animator10);
                        animatorSet.play(animator30).after(animator20);
                        animatorSet.start();
                    }
                });
            }
        });
    }
}
