package com.pcatalog.productcatalog.views.productslist;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ProductsListActivity
        extends BaseDrawerActivity
        implements ProductsListContracts.Navigator {
    public static final long IDENTIFIER = 49;

    @Inject
    ProductsListFragment mProductsListFragment;

    @Inject
    ProductsListContracts.Presenter mListPresenter;

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

        if (!isPhone()) {
            mProductDetailsFragment.setPresenter(mProductDetailsPresenter);
            transaction.replace(R.id.content_details, mProductDetailsFragment);
        }

        transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Product product) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    ProductDetailsActivity.class
            );

            intent.putExtra(ProductDetailsActivity.EXTRA_KEY, product);

            startActivity(intent);
        } else {
            mProductDetailsPresenter.setProductId(product.getId());
            mProductDetailsPresenter.loadProduct();
        }
    }
}

