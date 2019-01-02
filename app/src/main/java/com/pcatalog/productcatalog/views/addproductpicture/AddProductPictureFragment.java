package com.pcatalog.productcatalog.views.addproductpicture;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcatalog.productcatalog.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AddProductPictureFragment extends Fragment implements AddProductPictureContracts.View {

    private AddProductPictureContracts.Presenter mPresenter;

    private static int RESULT_LOAD_IMAGE = 1;

    private AddProductPictureContracts.Navigator mNavigator;

    @Inject
    public AddProductPictureFragment() {
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