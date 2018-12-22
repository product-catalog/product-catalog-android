package com.pcatalog.productcatalog.views.addproductpicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import com.pcatalog.productcatalog.R;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    //    DrawingView dv ;
//    private Paint mPaint;
    private Button save;

    @BindView(R.id.canvas)
    CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        canvasView = (CanvasView)findViewById(R.id.canvas);
        save = findViewById(R.id.button_draw_savePicture);
        save.setOnClickListener(this);
//        dv = new DrawingView(this);
////        dv.setPadding(30, 30, 30, 30);
//        dv.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
//        dv.setMinimumWidth(100);
//        setContentView(dv);
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setDither(true);
//        mPaint.setColor(Color.GREEN);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStrokeWidth(12);
    }

    public void clearCanvas(View v){
        canvasView.clearCanvas();
    }

    public CanvasView getCanvas(){
        return canvasView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddProductPictureActivity.class);
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = loadBitmapFromView(canvasView);
        view.setDrawingCacheEnabled(false);
        String image = BitMapToString(bitmap);
        intent.putExtra("picture", image);
        startActivity(intent);
        finish();
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }
}

