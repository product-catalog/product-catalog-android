package com.pcatalog.productcatalog.views.productslist;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsActivity;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsFragment;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ProductsListActivity
        extends BaseDrawerActivity
        implements ProductsListContracts.Navigator {
    public static final long IDENTIFIER = 6;

    @Inject
    ProductsListFragment mProductsListFragment;

    @Inject
    ProductsListContracts.Presenter mProductsListPresenter;

    @Inject
    ProductDetailsFragment mProductDetailsFragment;

    @Inject
    ProductDetailsPresenter mProductDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mProductsListFragment.setNavigator(this);
        mProductsListFragment.setPresenter(mProductsListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mProductsListFragment);

        transaction.commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Product product) {
        Intent intent = new Intent(
                this,
                ProductDetailsActivity.class
        );

        intent.putExtra(ProductDetailsActivity.EXTRA_KEY, product);
        intent.putExtra("token", getIntent().getExtras().get("token").toString());

        startActivity(intent);
    }
}

