package com.kupa.footing.view;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Camera;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by admin on 2017/7/17.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {


    private Camera camera = null;
    private SurfaceHolder surfaceHolder = null;

    private Canvas canvas;

    public MySurfaceView(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public MySurfaceView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        //根本没有可处理的SurfaceView
        if (surfaceHolder.getSurface() == null) {
            return;
        }

        //先停止Camera的预览
        try {
            camera.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //这里可以做一些我们要做的变换。
        Log.i("mita", "宽：" + width);
        Log.i("mita", "高：" + height);

        //重新开启Camera的预览功能
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

}
