package com.pcatalog.productcatalog.views.welcomemenu;

import android.content.Intent;
import android.os.Bundle;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.views.BaseDrawerActivity;
import com.pcatalog.productcatalog.views.login.LoginActivity;
import com.pcatalog.productcatalog.views.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class WelcomeMenuActivity extends BaseDrawerActivity implements WelcomeMenuContracts.Navigator {
    public static final long IDENTIFIER = 7;

    @Inject
    WelcomeMenuFragment mView;

    @Inject
    WelcomeMenuContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_menu);
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
    public void navigateToLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateToRegisterPage() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }


}
