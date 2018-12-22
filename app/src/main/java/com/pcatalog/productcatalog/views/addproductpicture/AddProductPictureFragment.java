package com.pcatalog.productcatalog.views.addproductpicture;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.views.addproduct.AddProductContracts;

import java.text.NumberFormat;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductPictureFragment extends Fragment implements AddProductPictureContracts.View {

    private AddProductPictureContracts.Presenter mPresenter;
//
//    @BindView(R.id.button_register_registerUser)
//    Button registerUserButton;

    private static int RESULT_LOAD_IMAGE = 1;
    private AddProductPictureContracts.Navigator mNavigator;

    @Inject
    public AddProductPictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product_picture, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(AddProductPictureContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToProductList() {
        mNavigator.navigateToProductList();
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(AddProductPictureContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}