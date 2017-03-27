package com.example.kj.refresh.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.kj.refresh.R;

import java.util.ArrayList;
import java.util.List;

public class NumberView extends View {
    private Paint mPaint = new Paint();

    private int mRow = 7;
    private int mDefaultColor = Color.RED;
    private int mSecondColor = Color.BLUE;

    private int mWidth;
    private int mHeight;
    private float mX;
    private float mY;

    private List<List<String>> mItemList = new ArrayList<>();

    private OnItemSelectListener mListener;
    public interface OnItemSelectListener{
        void onItemSelected(int item, int type);
    }

    public NumberView(Context context) {
        super(context);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberView);
        mRow = typedArray.getInt(R.styleable.NumberView_row, mRow);
        mDefaultColor = typedArray.getColor(R.styleable.NumberView_default_color, mDefaultColor);
        mSecondColor = typedArray.getColor(R.styleable.NumberView_second_color, mSecondColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        mHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, getResources().getDisplayMetrics()));
        float x;
        float y;
        String text;
        for (int i = 0; i < 33; i++) {
            List<String> list = parseItemInfo(i, 0);
            x = Float.parseFloat(list.get(0));
            y = Float.parseFloat(list.get(1));
            text = list.get(2);
            canvas.drawText(text, x, y, mPaint);
        }
        mPaint.setColor(Color.BLUE);
        for (int i = 0; i < 16; i++) {
            List<String> list = parseItemInfo(i, 5);
            x = Float.parseFloat(list.get(0));
            y = Float.parseFloat(list.get(1));
            text = list.get(2);
            canvas.drawText(text, x, y, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                float x = event.getX();
                float y = event.getY();
                List<String> list = getItem(x, y);
                List<List<String>> items = new ArrayList<>();
                if (list != null) {
                    items.add(list);
                    int item = Integer.parseInt(list.get(2));
                    int type = Integer.parseInt(list.get(3));
                    if (mListener != null) {
                        mListener.onItemSelected(item, type);
                    }
                }
                return true;
        }
        return super.onTouchEvent(event);
    }

    public void setItemSelectListener(OnItemSelectListener listener){
        mListener = listener;
    }

    private List<String> parseItemInfo(int position, int type) {
        List<String> list = new ArrayList<>();
        float margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        float x = position % mRow * mWidth / mRow;
        float y = ((position / mRow + type) * mHeight / (mRow + 1)) + margin;
        list.add(String.valueOf(x));
        list.add(String.valueOf(y));
        String text;
        if (position < 9) {
            text = "0" + (position + 1);
        } else {
            text = String.valueOf(position + 1);
        }
        list.add(text);
        if (type != 0){
            position += 32;
        }
        list.add(String.valueOf(position));
        mItemList.add(list);
        return list;
    }

    private List<String> getItem(float itemX, float itemY) {
        float x;
        float y;
        for (List<String> list: mItemList){
            x = Float.parseFloat(list.get(0));
            y = Float.parseFloat(list.get(1));
            if (itemX > x - mWidth/20 && itemX < x + mWidth/20 && itemY > y - mHeight/20 && itemY < y + mHeight/20){
                return list;
            }
        }
        return null;
    }

    private String getInfoAndSort(List<List<String>> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++){
                for (int j = 1; j < list.size() -1; j++){

                }
            }
        }
        return "";
    }
}
