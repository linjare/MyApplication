package com.example.kj.refresh.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.example.kj.refresh.R;

public class TableEditTextView extends android.support.v7.widget.AppCompatEditText {
    private Paint mPaint;
    private int mTableRow = 7;
    private int mDefaultColor;
    private int mLastColor;
    private float mTableRadius;

    private int mWidth;
    private int mHeight;

    public TableEditTextView(Context context) {
        super(context);
    }

    public TableEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TableEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TableEditTextView);
//        mTableRow = typedArray.getInt(R.styleable.TableEditTextView_table_row, 7);
//        mDefaultColor = typedArray.getColor(R.styleable.TableEditTextView_default_color, Color.RED);
//        mLastColor = typedArray.getColor(R.styleable.TableEditTextView_last_table_color, Color.BLUE);
//        mTableRadius = typedArray.getDimension(R.styleable.TableEditTextView_table_radius, 3);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.RED);
        mWidth = getWidth();
        mHeight = getHeight();
        RectF rect = new RectF(0, 0, mWidth, mHeight);
        canvas.drawRoundRect(rect,4,4,mPaint);
        for (int i = 1; i < mTableRow; i++){
            float y = mWidth*i /mTableRow;
            canvas.drawLine(y,0,y,mHeight,mPaint);
        }

    }

    public void setTablerow(int row) {
        mTableRow = row;
    }

    public void setDefaultColor(int color) {
        mDefaultColor = color;
    }

    public void setLastColor(int color) {
        mLastColor = color;
    }

    public void setTableRadius(float radius) {
        mTableRadius = radius;
    }
}
