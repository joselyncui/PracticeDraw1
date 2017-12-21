package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint paint = new Paint();
    private Paint paintStoke = new Paint();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paintStoke.setStrokeWidth(1);
        paintStoke.setStyle(Paint.Style.STROKE);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        RectF rectF = new RectF(getWidth()/2-150,getHeight()/2-100,getWidth()/2+150,getHeight()/2+100);
        canvas.drawArc(rectF,20,140,false,paint);

        canvas.drawArc(rectF,180,60,false,paintStoke);
        canvas.drawArc(rectF,250,100,true,paint);
    }
}
