package com.pcatalog.productcatalog.views.productslist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductsListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsListFragment
        extends Fragment
        implements ProductsListContracts.View, ProductsAdapter.OnProductClickListener {
    private ProductsListContracts.Navigator mNavigator;

    @BindView(R.id.lv_products)
    RecyclerView mProductsView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_filter)
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

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterProducts(pattern);
    }

    @Override
    public void onClick(Product product) {
        mPresenter.selectProduct(product);
    }
}
