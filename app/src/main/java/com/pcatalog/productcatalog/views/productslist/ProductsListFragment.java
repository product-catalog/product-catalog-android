package com.pcatalog.productcatalog.views.productslist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;

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

    @BindView(R.id.editText_productsList_filter)
    EditText mFilterEditText;

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
        Toast.makeText(getContext(),
                "No products",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
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

    @OnTextChanged(R.id.editText_productsList_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterProducts(pattern);
    }

    @Override
    public void onClick(Product product) {
        mPresenter.selectProduct(product);
    }
}
