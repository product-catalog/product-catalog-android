package com.pcatalog.productcatalog.views.addproduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AddProductActivity extends BaseDrawerActivity implements AddProductContracts.Navigator {
    public static final long IDENTIFIER = 290;

    @Inject
    AddProductFragment mView;

    @Inject
    AddProductContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToAddProductPictureAdd(ProductDto productDto, ProductAction productAction) {
        Intent intent = new Intent(this, AddProductPictureActivity.class);
        intent.putExtra("product", productDto);
        intent.putExtra("productAction", productAction);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateToAddProductPictureEdit(Product product, ProductAction productAction) {
        Intent intent = new Intent(this, AddProductPictureActivity.class);
        intent.putExtra("product", product);
        intent.putExtra("productAction", productAction);
        startActivity(intent);
        finish();
    }
}
