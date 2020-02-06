package com.hummer.educationalgame;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private Rect r = new Rect();

    private Context context;


    public GamePanel(Context context) {
        super(context);

        this.context = context;

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch(Exception e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        Typeface summer = Typeface.create("casual", Typeface.NORMAL);
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setTypeface(summer);
        paint.setColor(Color.BLUE);
        drawCentreText(canvas, paint, "Tap To Start!");
    }

    private void drawCentreText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = 4*cHeight / 5f + 4*r.height() / 5f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }
}
