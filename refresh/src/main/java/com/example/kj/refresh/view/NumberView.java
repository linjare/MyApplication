package com.example.kj.refresh.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class NumberView extends View {
    private Paint mPaint = new Paint();

    public NumberView(Context context) {
        super(context);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
        int row = 7;
        int width = getWidth();
        int height = getHeight();
        float x = 0;
        float y = 0;
        for (int i = 0; i < 33; i++) {
            String text;
            if (i < 9) {
                text = "0" + (i + 1);
            } else {
                text = String.valueOf(i + 1);
            }
            x = i % row * width / row;
            y = i / row * height / 8;
            if (y == 0){
                y = 30;
            }
            canvas.drawText(text, x, y, mPaint);
        }
        mPaint.setColor(Color.BLUE);
        for (int i = 0; i < 16; i++) {
            String text;
            if (i < 9) {
                text = "0" + (i + 1);
            } else {
                text = String.valueOf(i + 1);
            }
            x = i % row * width / row;
            y = (i / row + 5) * height / 8;
            canvas.drawText(text, x, y, mPaint);
        }
    }
}
