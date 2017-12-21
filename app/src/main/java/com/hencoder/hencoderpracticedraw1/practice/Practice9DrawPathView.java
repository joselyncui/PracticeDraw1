package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);

        Path path = new Path();
        RectF rectF1 = new RectF(getWidth()/2-100,getHeight()/2-50,getWidth()/2,getHeight()/2+50);
        path.addArc(rectF1,-225,225);
        RectF rectF2 = new RectF(getWidth()/2,getHeight()/2-50,getWidth()/2+100,getHeight()/2+50);
        path.arcTo(rectF2,-180,225);
        path.lineTo(getWidth()/2,getHeight()/2+130);
//        path.close();
        canvas.drawPath(path,paint);

    }
}
