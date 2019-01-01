package com.pcatalog.productcatalog.views.productslist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.models.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class ProductsListFragment
        extends Fragment
        implements ProductsListContracts.View, ProductsAdapter.OnProductClickListener {
    private ProductsListContracts.Navigator mNavigator;

    @BindView(R.id.recyclerView_productsList_products)
    RecyclerView mProductsView;

    @BindView(R.id.progressBar_productsList_loading)
    ProgressBar mLoadingView;

    @BindView(R.id.editText_productsList_filterName)
    EditText mFilterNameEditText;

    @BindView(R.id.spinner_productsList_priceRange)
    Spinner mFilterPriceSpinner;

    @Inject
    ProductsAdapter mProductsAdapter;

    private ProductsListContracts.Presenter mPresenter;
    private GridLayoutManager mProductsViewLayoutManager;

    @Inject
    public ProductsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mProductsAdapter.setOnProductClickListener(this);

        mProductsView.setAdapter(mProductsAdapter);
        mProductsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mProductsView.setLayoutManager(mProductsViewLayoutManager);

//create a list of items for the spinner.
        String[] items = new String[]{"ALL", "BETWEEN 0 AND 25", "BETWEEN 25 AND 50", "BETWEEN 50 AND 75", "BETWEEN 75 AND 100"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        mFilterPriceSpinner.setAdapter(adapter);
        mFilterPriceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String patternName = mFilterNameEditText.getText().toString();
                String filterField = mFilterPriceSpinner.getSelectedItem().toString().replaceAll("\\s+","");
                Log.d("ivan", filterField);
                mPresenter.filterProducts(patternName, FilterField.valueOf(filterField));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadProducts();
    }

    @Override
    public void setPresenter(ProductsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProducts(List<Product> products) {
        mProductsAdapter.clear();
        mProductsAdapter.addAll(products);
        mProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyProductsList() {
        showProducts(new ArrayList<>());
        Toast.makeText(getContext(),
                "No products",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mProductsView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProductsView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showProductDetails(Product product) {
        mNavigator.navigateWith(product);
    }

    void setNavigator(ProductsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnTextChanged(R.id.editText_productsList_filterName)
    public void onFilterNameTextChanged() {
        String patternName = mFilterNameEditText.getText().toString();
        mPresenter.filterProducts(patternName, FilterField.valueOf(mFilterPriceSpinner.getSelectedItem().toString().replaceAll("\\s+","")));
    }

    @Override
    public void onClick(Product product) {
        mPresenter.selectProduct(product);
    }
}
