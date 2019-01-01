package com.pcatalog.productcatalog.views.welcomemenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pcatalog.productcatalog.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeMenuFragment extends Fragment implements WelcomeMenuContracts.View {


    private WelcomeMenuContracts.Presenter mPresenter;

    @BindView(R.id.button_welcome_login)
    Button mNameEditText;

    @BindView(R.id.button_welcome_register)
    Button mSecretIdentity;

    private WelcomeMenuContracts.Navigator mNavigator;

    @Inject
    public WelcomeMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.button_welcome_login)
    public void goToLoginPage() {
        mNavigator.navigateToLoginPage();
    }

    @OnClick(R.id.button_welcome_register)
    public void goToRegisterPage() {
        mNavigator.navigateToRegisterPage();
    }

    @Override
    public void setPresenter(WelcomeMenuContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    public void setNavigator(WelcomeMenuContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}
