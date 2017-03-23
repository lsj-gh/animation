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
import android.view.animation.ScaleAnimation;
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
    private int aniType = 0;

    public Drawable getRotateSrc() {
        return rotateSrc;
    }

    public int getRotateDuration() {
        return rotateDuration;
    }

    public int getRotateStartOff() {
        return rotateStartOff;
    }

    public int getRotateRepeatCount() {
        return rotateRepeatCount;
    }

    public AnimationType getAnimationType() {
        return AnimationType.values()[aniType];
    }

    public void setAnimationType(AnimationType animationType) {
        this.aniType = animationType.ordinal();

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
        aniType = typedArray.getInt(R.styleable.RotateImageView_ani_type, aniType);
        LayoutInflater.from(context).inflate(R.layout.view_rotateimageview_layout, this);
        loadImage = (ImageView) findViewById(R.id.image);
        loadImage.setImageDrawable(rotateSrc);


        if (aniType == 0){
            createRotateAnimation(isComplete);
        }else if(aniType == 1){
            createScaleAnimation();
        }
    }

    private void createRotateAnimation(boolean isComplete) {
        if (isComplete) {
            RotateAnimation ta = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation
                    .RELATIVE_TO_SELF, 0.5f);
            ta.setInterpolator(new LinearInterpolator());
            ta.setRepeatCount(rotateRepeatCount);
            ta.setDuration(rotateDuration);
            loadImage.startAnimation(ta);
            invalidate();
        } else {
            RotateAnimation tar = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation
                    .RELATIVE_TO_SELF, 0.5f);
            tar.setStartOffset(rotateStartOff);
            tar.setInterpolator(new AccelerateDecelerateInterpolator());
            tar.setRepeatCount(rotateRepeatCount);
            tar.setDuration(rotateDuration);
            loadImage.startAnimation(tar);
            invalidate();
        }

    }

    private void createScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 5f, 1.0f, 5f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        loadImage.startAnimation(scaleAnimation);
        invalidate();

    }

    public enum AnimationType {
        ROTATE(0),
        SCALE(1);

        int type;

        AnimationType(int type) {
            this.type = type;
        }
    }

}
