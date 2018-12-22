package com.pcatalog.productcatalog.views.addproduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;

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
    public void navigateToAddProductPicture(ProductDto productDto) {
        Intent intent = new Intent(this, AddProductActivity.class);
        intent.putExtra("product", productDto);
        startActivity(intent);
        finish();
    }
}
