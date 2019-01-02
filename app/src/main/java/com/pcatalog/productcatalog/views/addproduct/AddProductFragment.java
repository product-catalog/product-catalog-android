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

    @BindView(R.id.editText_addProduct_price)
    EditText productPrice;

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
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().containsKey("productAction") && getActivity().getIntent().getExtras().get("productAction") == ProductAction.EDIT) {
            Product product = (Product) getActivity().getIntent().getExtras().get("product");
            productName.setText(product.getName());
            productDescription.setText(product.getDescription());
            product.setDescription(productDescription.getText().toString());
            productPrice.setText(String.valueOf(product.getPrice()));
        }
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.button_addProduct_proceed)
    public void onProceedClick() {
        if (productName.getText().toString().equals("")) {
            productName.setError("Product Name cannot be empty");
        } else if (productDescription.getText().toString().equals("")) {
            productDescription.setError("Description cannot be empty");
        } else {
            ProductDto productDto = new ProductDto(productName.getText().toString(), productDescription.getText().toString(), null, 1.0);
            if (getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().containsKey("productAction") && getActivity().getIntent().getExtras().get("productAction") == ProductAction.EDIT) {
                Product product = (Product) getActivity().getIntent().getExtras().get("product");
                product.setName(productName.getText().toString());
                product.setDescription(productDescription.getText().toString());
                try {
                    product.setPrice(Double.parseDouble(productPrice.getText().toString()));
                    mNavigator.navigateToAddProductPictureEdit(product, ProductAction.EDIT);
                } catch (Exception e) {
                    productPrice.setError("Please provide valid floating point number");
                }
            } else {
                try {
                    productDto.setPrice(Double.parseDouble(productPrice.getText().toString()));
                    mNavigator.navigateToAddProductPictureAdd(productDto, ProductAction.ADD);
                } catch (Exception e) {
                    productPrice.setError("Please provide valid floating point number");
                }
            }
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
