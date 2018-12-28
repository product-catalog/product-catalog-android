package com.pcatalog.productcatalog.views.addproduct;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment implements AddProductContracts.View {


    private AddProductContracts.Presenter mPresenter;

    @BindView(R.id.editText_addProduct_name)
    EditText productName;

    @BindView(R.id.editText_addProduct_description)
    EditText productDescription;

    @BindView(R.id.numberPicker_addProduct_price)
    NumberPicker productPrice;

    private AddProductContracts.Navigator mNavigator;

    @Inject
    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        ButterKnife.bind(this, view);
        productPrice.setMinValue(1);
        productPrice.setMaxValue(100);
        productPrice.setFormatter(formatter);
        //productPrice.setOnValueChangedListener(onValueChangeListener);
        return view;
    }

//    NumberPicker.OnValueChangeListener onValueChangeListener =
//            new NumberPicker.OnValueChangeListener() {
//                @Override
//                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                    Toast.makeText(getContext(),
//                            "selected number " + numberPicker.getValue(), Toast.LENGTH_SHORT);
//                }
//            };

    NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
        @Override
        public String format(int i) {
            return NumberFormat.getCurrencyInstance(Locale.UK).format((long) i).toString();
        }
    };

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

    @OnClick(R.id.button_addProduct_proceed)
    public void onProceedClick() {
        ProductDto productDto = new ProductDto(productName.getText().toString(), productDescription.getText().toString(), null, productPrice.getValue()/1.0);
        if (getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().containsKey("productAction") && getActivity().getIntent().getExtras().get("productAction") == ProductAction.EDIT){
            Product product = (Product)getActivity().getIntent().getExtras().get("product");
            product.setName(productName.getText().toString());
            product.setDescription(productDescription.getText().toString());
            product.setPrice(productPrice.getValue()/1.0);
            mNavigator.navigateToAddProductPictureEdit(product, ProductAction.EDIT);
        }
        else {
            mNavigator.navigateToAddProductPictureAdd(productDto, ProductAction.ADD);
        }
    }

    @Override
    public void setPresenter(AddProductContracts.Presenter presenter) {
        mPresenter = presenter;
    }

//    @Override
//    public void navigateToAddProductPicture(ProductDto productDto, ProductAction productAction) {
//        mNavigator.navigateToAddProductPicture(productDto, productAction);
//    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(AddProductContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}
