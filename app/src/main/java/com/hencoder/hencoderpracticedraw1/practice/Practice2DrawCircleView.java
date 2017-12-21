package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint paint;
    private Paint paintStoke;
    private int r;
    private int width;
    private int height;
    private int padding = 40;


    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paintStoke = new Paint();
        this.paintStoke.setAntiAlias(true);
        this.paintStoke.setStyle(Paint.Style.STROKE);
        this.r = 150;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (this.width==0 || this.height ==0) {
            this.width = getWidth();
            this.height = getHeight();
        }
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2-padding-r,height/2-padding-r,r,paint);

        paintStoke.setColor(Color.BLACK);
        paintStoke.setStrokeWidth(4);
        canvas.drawCircle(width/2+padding+r,height/2-padding-r,r,paintStoke);

        paint.setColor(Color.parseColor("#3397FF"));
        canvas.drawCircle(width/2-padding-r, height/2+r, r,paint);

        paintStoke.setStrokeWidth(60);
        canvas.drawCircle(width/2+padding+r, height/2+r,r, paintStoke);

    }
}
