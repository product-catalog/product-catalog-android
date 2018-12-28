package com.pcatalog.productcatalog.views.addproductpicture;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Photo;
import com.pcatalog.productcatalog.models.PhotoDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;

import java.io.ByteArrayOutputStream;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Camera deviceCamera = Camera.open();

        ImageSurfaceView imageSurfaceView = new ImageSurfaceView(CameraActivity.this, deviceCamera);
        FrameLayout cameraPreviewLayout = findViewById(R.id.camera_preview);
        cameraPreviewLayout.addView(imageSurfaceView);

        Button captureButton = findViewById(R.id.button_camera_proceed);
        captureButton.setOnClickListener(v -> takePicture(deviceCamera));
    }

    private void takePicture(Camera deviceCamera) {
        deviceCamera.takePicture(
                null,
                null,
                (data, camera) -> {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    if (bitmap == null) {
                        Toast.makeText(CameraActivity.this, "Captured image is empty", Toast.LENGTH_LONG).show();
                        return;
                    }


                    ImageView capturedImageHolder = findViewById(R.id.captured_image);


                    capturedImageHolder.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 300, 200, true));
                    Bitmap bitmap2 = ((BitmapDrawable) capturedImageHolder.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] imageInByte = baos.toByteArray();
                    String uploadPicture = new String(imageInByte);
                    Intent intent = new Intent(this, AddProductPictureActivity.class);
                    if (getIntent().getExtras().get("productAction") == ProductAction.EDIT){
                        Product product = (Product)getIntent().getExtras().get("product");
                        product.getPhoto().setPhoto(BitMapToString(bitmap2));
                        intent.putExtra("product", product);
                    }
                    else {
                        ProductDto productDto = (ProductDto) getIntent().getExtras().get("product");
                        productDto.setPhoto(new PhotoDto("picture", imageInByte));
                        intent.putExtra("product", productDto);
                    }
                    intent.putExtra("image", BitMapToString(bitmap2));
                    startActivity(intent);
                    finish();
                });
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}


