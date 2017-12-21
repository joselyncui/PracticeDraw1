package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice10HistogramView extends View {
    private List<String> tags = new ArrayList<>();
    private List<Integer> datas = new ArrayList<>();
    private Paint paint;
    private Paint txtPaint;

    private float height;
    private float width;
    private float hMargin = 100;
    private float vMargin = 200;
    private float margin = 10;
    private int length = 10;
    private float max;
    private float unitHeight = 0;
    private float txtHeight;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){

        for (int i = 0; i < length; i++) {
            tags.add("i-" + i);
            datas.add((int)(Math.random()*length));
        }

        paint = new Paint();
        paint.setAntiAlias(true);
        max = getMax();

        txtPaint = new Paint();
        txtPaint.setColor(Color.WHITE);
        txtPaint.setAntiAlias(true);
        txtPaint.setTextSize(30);

        txtHeight = txtPaint.getFontMetrics().bottom-txtPaint.getFontMetrics().top;


    }

    private float getMax(){
        float max = datas.get(0);
        for (int i = 1; i < length;i++) {
            max = max< datas.get(i)? datas.get(i):max;
        }

        return max;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        width = getWidth()-hMargin * 2;
        height = getHeight() - vMargin * 2;
        unitHeight = height/(max+10);

        paint.setColor(Color.WHITE);
        //绘制坐标
        canvas.drawLine(hMargin,vMargin,hMargin,vMargin+ height,paint);
        canvas.drawLine(hMargin,vMargin+height,
                getWidth()-hMargin,vMargin+ height,paint);

        //计算矩形宽度
        float rectWidth = (width-margin*(length+1))/length;
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < length; i++) {
            //绘制文字
            canvas.drawText(tags.get(i),
                    hMargin+margin*(1+i)+ rectWidth*i+(rectWidth-txtPaint.measureText(tags.get(i)))/2,
                    getHeight()-vMargin+txtHeight,
                    txtPaint);
            //绘制直方块
            canvas.drawRect(hMargin+margin*(1+i)+ rectWidth*i,vMargin + height-unitHeight*datas.get(i),
                    hMargin+margin*(1+i) + rectWidth*(1+i),getHeight()-vMargin,paint);
        }


    }
}
