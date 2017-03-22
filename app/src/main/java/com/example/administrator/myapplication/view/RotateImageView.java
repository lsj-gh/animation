package com.example.administrator.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;


public class RotateImageView extends LinearLayout {
    private ImageView loadImage;
    private Drawable rotateSrc;
    private boolean isComplete;
    private int rotateDuration = 500;//速度
    private int rotateStartOff = 500;//间隔时间
    private int rotateRepeatCount = -1;//循环次数

    public int getRotateDuration() {
        return rotateDuration;
    }

    public int getRotateStartOff() {
        return rotateStartOff;
    }

    public int getRotateRepeatCount() {
        return rotateRepeatCount;
    }

    public void setRotateDuration(int rotateDuration) {
        this.rotateDuration = rotateDuration;
    }

    public void setRotateStartOff(int rotateStartOff) {
        this.rotateStartOff = rotateStartOff;
    }

    public void setRotateRepeatCount(int rotateRepeatCount) {
        this.rotateRepeatCount = rotateRepeatCount;
    }

    public void setRotateSrc(Drawable rotateSrc) {
        this.rotateSrc = rotateSrc;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Drawable getRotateSrc() {
        return rotateSrc;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public RotateImageView(Context context) {
        super(context);

    }

    public RotateImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs);
    }

    public RotateImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs);
    }

    private void initData(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RotateImageView);
        rotateSrc = typedArray.getDrawable(R.styleable.RotateImageView_rotateSrc);
        isComplete = typedArray.getBoolean(R.styleable.RotateImageView_isRound, false);
        rotateDuration = typedArray.getInt(R.styleable.RotateImageView_rotateDuration, rotateDuration);
        rotateStartOff = typedArray.getInt(R.styleable.RotateImageView_rotateStartOff, rotateStartOff);
        rotateRepeatCount = typedArray.getInt(R.styleable.RotateImageView_rotateRepeatCount, rotateRepeatCount);
        LayoutInflater.from(context).inflate(R.layout.view_rotateimageview_layout, this);
        loadImage = (ImageView) findViewById(R.id.image);
        loadImage.setImageDrawable(rotateSrc);

        createAnimation(isComplete);
    }

    private void createAnimation(boolean isComplete) {
        if (isComplete) {
            RotateAnimation ta = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            ta.setInterpolator(new LinearInterpolator());
            ta.setRepeatCount(rotateRepeatCount);
            ta.setDuration(rotateDuration);
            loadImage.startAnimation(ta);
            invalidate();
        } else {
            RotateAnimation tar = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            tar.setStartOffset(rotateStartOff);
            tar.setInterpolator(new AccelerateDecelerateInterpolator());
            tar.setRepeatCount(rotateRepeatCount);
            tar.setDuration(rotateDuration);
            loadImage.startAnimation(tar);
            invalidate();
        }

    }

}
