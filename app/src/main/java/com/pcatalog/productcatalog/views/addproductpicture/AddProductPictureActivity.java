package com.pcatalog.productcatalog.views.addproductpicture;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Photo;
import com.pcatalog.productcatalog.models.PhotoDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.ProductEdit;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.productslist.ProductsListActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProductPictureActivity extends BaseDrawerActivity implements AddProductPictureContracts.Navigator {

    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 300;
    private static String imageStoragePath;
    private static int RESULT_LOAD_IMAGE = 1;
    public static final long IDENTIFIER = 2;

    @Inject
    AddProductPictureFragment mView;

    @Inject
    AddProductPictureContracts.Presenter mPresenter;

    @BindView(R.id.button_addProductPicture_save)
    Button save;

    @BindView(R.id.frameLayout_addProductPicture_cameraPreview)
    FrameLayout cameraPreview;

    @BindView(R.id.imageView_addProductPicture_imageView)
    ImageView imageView;

    @BindView(R.id.txt_desc)
    TextView nextPicture;

    @BindView(R.id.button_pictures_capture)
    Button capture;

    @BindView(R.id.btnCamera)
    Button takeAPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_picture);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);
        try {
            Product product = (Product) getIntent().getExtras().getSerializable("product");
            imageView = (ImageView) findViewById(R.id.imageView_addProductPicture_imageView);
            Bitmap bitmap2 = StringToBitMap(product.getPhoto().getPhoto());
            imageView.setImageBitmap(bitmap2);
            imageView.setBackgroundColor(Color.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getIntent().getExtras().containsKey("image")) {
            imageView = (ImageView) findViewById(R.id.imageView_addProductPicture_imageView);
            Bitmap bitmap2 = StringToBitMap(getIntent().getExtras().get("image").toString());
            imageView.setImageBitmap(bitmap2);
            imageView.setBackgroundColor(Color.BLACK);
        }
        Button buttonLoadImage = (Button) findViewById(R.id.button_pictures_capture);
        if (imageView.getDrawable() == null) {
            nextPicture.setText("Picture Will Be Shown Here After You Choose One");
        } else {
            nextPicture.setVisibility(View.INVISIBLE);
        }
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                i.putExtra("token", getIntent().getExtras().get("token").toString());
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        if (!CameraUtils.isDeviceSupportCamera(getApplicationContext())) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            finish();
        }

        Button btnCapturePicture = findViewById(R.id.btnCapturePicture);
        btnCapturePicture.setOnClickListener(v -> {
            if (CameraUtils.checkPermissions(getApplicationContext())) {
                captureImage();
            } else {
                requestCameraPermission();
            }
        });

        Button btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener((v) -> {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            }
            else {
                Intent intent = new Intent(AddProductPictureActivity.this, CameraActivity.class);
                if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("productAction") && getIntent().getExtras().get("productAction") == ProductAction.EDIT) {
                    Product product = (Product) getIntent().getExtras().getSerializable("product");
                    intent.putExtra("product", product);
                    intent.putExtra("productAction", ProductAction.EDIT);
                    intent.putExtra("token", getIntent().getExtras().get("token").toString());
                } else {
                    ProductDto productDto = (ProductDto) getIntent().getExtras().getSerializable("product");
                    intent.putExtra("product", productDto);
                    intent.putExtra("productAction", ProductAction.ADD);
                    intent.putExtra("token", getIntent().getExtras().get("token").toString());
                }
                startActivity(intent);
                finish();
            }
        });

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToProductList() {
        Intent intent = new Intent(this, ProductsListActivity.class);
        intent.putExtra("token", getIntent().getExtras().get("token").toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            CameraUtils.refreshGallery(getApplicationContext(), imageStoragePath);
            previewCapturedImage();
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(),
                    "User cancelled image capture", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                    .show();
        }
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imageView_addProductPicture_imageView);
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bitmap);

        }
    }

    @OnClick(R.id.button_addProductPicture_save)
    public void onSaveClicked() {
        if (imageView.getDrawable() == null) {
            Toast.makeText(this, "Please choose or create a picture", Toast.LENGTH_SHORT).show();
        } else {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageInByte2 = baos.toByteArray();
            String imageInByte = new String(imageInByte2);
            if (getIntent().getExtras().containsKey("productAction") && getIntent().getExtras().get("productAction") == ProductAction.EDIT) {
                try {
                    Product product = null;
                    product = (Product) getIntent().getExtras().getSerializable("product");
                    product.setPhoto(new Photo(product.getPhoto().getRecordId(), product.getPhoto().getRecordCreated(), product.getPhoto().getRecordLastTimeEdited(), "image", BitMapToString(bitmap)));
                    ProductEdit productEdit = new ProductEdit(product.getRecordId(), product.getRecordCreated(), product.getRecordLastTimeEdited(), product.getName(), product.getDescription(),
                            new Photo(product.getPhoto().getRecordId(), product.getPhoto().getRecordCreated(), product.getPhoto().getRecordLastTimeEdited(), product.getPhoto().getName(), product.getPhoto().getPhoto()), product.getPrice());
                    mPresenter.editProduct(productEdit, getIntent().getExtras().get("token").toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    ProductDto productDto = null;
                    productDto = (ProductDto) getIntent().getExtras().getSerializable("product");
                    productDto.setPhoto(new PhotoDto("image", imageInByte2));
                    mPresenter.createProduct(new ProductDto(productDto.getName(), productDto.getDescription(), new PhotoDto("image", imageInByte2), productDto.getPrice()), getIntent().getExtras().get("token").toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            navigateToProductList();
        }
    }

    @OnClick(R.id.button_addProductPicture_goToProductsList)
    public void goToProductList() {
        navigateToProductList();
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private void restoreFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(CameraUtils.KEY_IMAGE_STORAGE_PATH)) {
                imageStoragePath = savedInstanceState.getString(CameraUtils.KEY_IMAGE_STORAGE_PATH);
                if (!TextUtils.isEmpty(imageStoragePath)) {
                    if (imageStoragePath.substring(imageStoragePath.lastIndexOf(".")).equals("." + CameraUtils.IMAGE_EXTENSION)) {
                        previewCapturedImage();
                    }
                }
            }
        }
    }

    private void requestCameraPermission() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            captureImage();
                        } else if (report.isAnyPermissionPermanentlyDenied()) {
                            showPermissionsAlert();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("token", getIntent().getExtras().get("token").toString());
        File file = CameraUtils.getOutputMediaFile();
        if (file != null) {
            imageStoragePath = file.getAbsolutePath();
        }

        Uri fileUri = CameraUtils.getOutputMediaFileUri(getApplicationContext(), file);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(CameraUtils.KEY_IMAGE_STORAGE_PATH, imageStoragePath);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        imageStoragePath = savedInstanceState.getString(CameraUtils.KEY_IMAGE_STORAGE_PATH);
    }


    private void previewCapturedImage() {
        try {
            TextView txtPreview = findViewById(R.id.txt_desc);
            txtPreview.setVisibility(View.GONE);

            ImageView imgPreview = findViewById(R.id.imgPreview);
            imgPreview.setVisibility(View.VISIBLE);
            Bitmap bitmap = CameraUtils.optimizeBitmap(CameraUtils.BITMAP_SAMPLE_SIZE, imageStoragePath);
            imgPreview.setImageBitmap(bitmap);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void showPermissionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissions required!")
                .setMessage("Camera needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", (dialog, which) -> CameraUtils.openSettings(AddProductPictureActivity.this))
                .setNegativeButton("CANCEL", (dialog, which) -> {
                }).show();
    }

}
