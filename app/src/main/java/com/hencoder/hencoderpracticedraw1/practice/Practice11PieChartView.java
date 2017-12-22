package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice11PieChartView extends View {
    private Paint paint;
    private Paint txtPaint;

    private List<Integer> datas = new ArrayList<>();
    private float per;
    private RectF rectF;
    private int r = 250;
    private int txtSize = 24;
    private int maxPos = 0;
    private int pieDif = 20;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);

        txtPaint = new Paint();
        txtPaint.setStrokeWidth(3);
        txtPaint.setTextSize(txtSize);
        txtPaint.setAntiAlias(true);

        datas.add(30);
        datas.add(70);
        datas.add(15);
        datas.add(40);
        datas.add(3);
        datas.add(20);
        datas.add(51);
        datas.add(16);
        datas.add(5);
        datas.add(8);
        datas.add(90);
        datas.add(100);

        int sum = 0;
        for (int i = 0; i < datas.size();i++) {
            sum += datas.get(i);
            maxPos = datas.get(maxPos) > datas.get(i)? maxPos:i;
        }

        per = 360.0f/sum;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (rectF == null) {
            rectF = new RectF(getWidth()/2-r,getHeight()/2-r,getWidth()/2+r,getHeight()/2+r);
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int dif = 0;
        float total = 0;
        for (int i = 0; i < datas.size();i++) {

            // x y 相对于圆心

            // 绘制饼图
            RectF tempRectf = rectF;
            int lineDif = 0;
            if (maxPos == i) {
                lineDif = pieDif;
                double pieDifX = Math.cos((-total-datas.get(i)*per/2) * Math.PI / 180) * pieDif;
                double pieDifY = Math.sin((-total-datas.get(i)*per/2) *  Math.PI / 180) * pieDif;
                Log.i("point","--- " + pieDifX +"--- " + pieDifY);
                tempRectf = new RectF(rectF.left+(float) pieDifX,rectF.top-(float)pieDifY,
                        rectF.right+(float)pieDifX,rectF.bottom-(float)pieDifY);
            }
            paint.setColor(Color.parseColor("#"+getRandColorCode()));
            canvas.drawArc(tempRectf,total,datas.get(i)*per,true,paint);

            //划斜线
            double startX = Math.cos((-total-datas.get(i)*per/2) * Math.PI / 180) * (r+lineDif);
            double startY = Math.sin((-total-datas.get(i)*per/2) *  Math.PI / 180) * (r+lineDif);

            double endX = Math.cos((-total-datas.get(i)*per/2) * Math.PI / 180) * (r+30 + lineDif);
            double endY = Math.sin((-total-datas.get(i)*per/2) *  Math.PI / 180) * (r+30 + lineDif);

            txtPaint.setColor(Color.parseColor("#EBEBEB"));
            canvas.drawLine((float) (getWidth()/2 + startX),(float) (getHeight()/2-startY),
                    (float)( getWidth()/2+endX), (float)(getHeight()/2-endY),txtPaint);

            //绘制横线
            float hLength = startX>0? 60: -60;
            canvas.drawLine((float)( getWidth()/2+endX), (float)(getHeight()/2-endY),
                    (float)( getWidth()/2+endX)+hLength,(float)(getHeight()/2-endY),txtPaint);

            //绘制文字
            float txtWidth = txtPaint.measureText(datas.get(i)+"");
            double txtX = endX>0?endX + 10: endX-txtWidth-10;
            double txtY = endY-txtSize/2;
            canvas.drawText(datas.get(i)+"",(float)( getWidth()/2+txtX)+hLength,(float)(getHeight()/2-txtY    ),txtPaint );




            total+= datas.get(i) * per;
        }
    }

    /**
     * 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML ,
     * @return String
     */
    public static String getRandColorCode(){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;

        return r+g+b;
    }

}
