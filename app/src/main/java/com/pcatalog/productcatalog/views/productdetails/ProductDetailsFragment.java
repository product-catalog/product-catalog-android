package com.pcatalog.productcatalog.views.productdetails;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.Photo;
import com.pcatalog.productcatalog.models.Product;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsFragment
        extends Fragment
        implements ProductDetailsContracts.View {

    private ProductDetailsContracts.Presenter mPresenter;

    private ProductDetailsContracts.Navigator mNavigator;

    @BindView(R.id.textView_productDetalils_productName)
    TextView mNameTextView;

    @BindView(R.id.textView_productDetalils_productDescription)
    TextView mDescriptionTextView;

    @BindView(R.id.textView_productDetalils_productPrice)
    TextView mPriceTextView;

    @BindView(R.id.imageView_productDetails_productImage)
    ImageView mProductImageImageView;

    @BindView(R.id.button_productDetails_delete)
    Button delete;

    Product mProduct;

    @Inject
    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProduct();
    }

    @Override
    public void showProduct(Product product) {
        mNameTextView.setText(product.getName());
        mDescriptionTextView.setText(product.getDescription());
        mPriceTextView.setText(String.valueOf(product.getPrice()));
        mProductImageImageView.setImageBitmap(StringToBitMap(product.getPhoto().getPhoto()));
        mProduct = product;
    }

    @Override
    public void setPresenter(ProductDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.button_productDetails_delete)
    public void deleteProduct() {
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        try {
            okHttpHttpRequester.deleteProduct(mPresenter.getProductId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mNavigator.navigateToProductsList();
    }

    @OnClick(R.id.button_productDetails_edit)
    public void editProduct() {
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Product product = new Product(1L, new Date(), new Date(), "name", "name", new Photo(1L, new Date(), new Date(), "name", "name"), 1.0);
        try {
            product = okHttpHttpRequester.getProductById(mPresenter.getProductId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mNavigator.navigateToAddProduct(product);
    }

    public void setNavigator(ProductDetailsContracts.Navigator navigator) {
        mNavigator = navigator;
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
}
