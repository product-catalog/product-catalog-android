package com.pcatalog.productcatalog.views.productdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;
import com.pcatalog.productcatalog.views.productslist.ProductsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ProductDetailsActivity extends BaseDrawerActivity implements ProductDetailsContracts.Navigator {
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

        getIntent().putExtra("productAction", ProductAction.ADD);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra(ProductDetailsActivity.EXTRA_KEY);
        mProductDetailsPresenter.setProductId(product.getRecordId());
        mProductDetailsFragment.setPresenter(mProductDetailsPresenter);
        mProductDetailsFragment.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mProductDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }

    @Override
    public void navigateToProductsList() {
        Intent intent = new Intent(this, ProductsListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateToAddProduct(Product product, ProductAction productAction) {
        Intent intent = new Intent(this, AddProductActivity.class);
        intent.putExtra("product", product);
        intent.putExtra("productAction", productAction);
        startActivity(intent);
        finish();
    }
}

