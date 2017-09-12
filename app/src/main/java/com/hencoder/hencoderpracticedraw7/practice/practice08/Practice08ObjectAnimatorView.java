package com.hencoder.hencoderpracticedraw7.practice.practice08;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static com.hencoder.hencoderpracticedraw7.Utils.dpToPixel;
import com.hencoder.hencoderpracticedraw7.R;

public class Practice08ObjectAnimatorView extends View {
    final float radius = dpToPixel(80);

    float degree = 0;
    float downdegree = 0;
    float updegree = 0;
    RectF arcRectF = new RectF();
    Bitmap bitmap;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Camera camera = new Camera();
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.music);
    }
    public Practice08ObjectAnimatorView(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public float getDegree() {
        return degree;
    }
    public void setDegree(float degree) {
        this.degree = degree;
        invalidate();
    }

    public float getUpdegree() {
        return updegree;
    }
    public void setUpdegree(float degree) {
        this.updegree = degree;
        invalidate();
    }

    public float getDowndegree() {
        return downdegree;
    }
    public void setDowndegree(float degree) {
        this.downdegree = degree;
        invalidate();
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        if (downdegree == 0) {
            canvas.save();
            canvas.drawBitmap(bitmap, x, y, paint);
            canvas.restore();
            return;
        }
        // 第一遍绘制：上半部分
        canvas.save();
        camera.save();
        camera.rotateX(updegree);
        canvas.translate(centerX, centerY);
        canvas.rotate(-degree);
        canvas.clipRect(-bitmapWidth, -bitmapHeight, bitmapWidth, 0);
        camera.applyToCanvas(canvas);
        canvas.rotate(degree);
        canvas.translate(-centerX, -centerY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        // 第二遍绘制：下半部分
        canvas.save();
        camera.save();
        camera.rotateX(downdegree);
        //camera.rotate(60*(90- Math.abs(degree % 90))/90f, -60*(Math.abs(degree % 90))/90f, 0);
        canvas.translate(centerX, centerY);
        canvas.rotate(-degree);
        canvas.clipRect(-bitmapWidth, 0, bitmapWidth, bitmapHeight);
        camera.applyToCanvas(canvas);
        canvas.rotate(degree);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();
    }
}
