package com.pcatalog.productcatalog.views.productdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ProductDetailsActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "PRODUCT_EXTRA_KEY";

    @Inject
    ProductDetailsFragment mProductDetailsFragment;

    @Inject
    ProductDetailsContracts.Presenter mProductDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra(ProductDetailsActivity.EXTRA_KEY);

        mProductDetailsPresenter.setProductId(product.getRecordId());
        mProductDetailsFragment.setPresenter(mProductDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mProductDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}

