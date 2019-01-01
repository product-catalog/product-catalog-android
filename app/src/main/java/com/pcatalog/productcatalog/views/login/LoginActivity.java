package com.pcatalog.productcatalog.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.productslist.ProductsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseDrawerActivity implements LoginContracts.Navigator {

    public static final long IDENTIFIER = 290;

    @Inject
    LoginFragment mView;

    @Inject
    LoginContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
    public void navigateToMenu(String token) {
        Intent intent = new Intent(this, ProductsListActivity.class);
        intent.putExtra("token", token);
        startActivity(intent);
        finish();
    }
}
