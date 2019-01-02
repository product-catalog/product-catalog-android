package com.pcatalog.productcatalog.views.register;

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
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.TokenDto;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class RegisterFragment extends Fragment implements RegisterContracts.View {


    private RegisterContracts.Presenter mPresenter;

    @BindView(R.id.editText_register_password)
    EditText password;

    @BindView(R.id.editText_register_username)
    EditText username;

    private RegisterContracts.Navigator mNavigator;

    @Inject
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
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

    @OnClick(R.id.button_register_register)
    public void onRegisterSaveClicked() {
        OkHttpHttpRequester example = new OkHttpHttpRequester();
        example.registerUser(new LoginDto(username.getText().toString(), password.getText().toString()));
        TokenDto tokenDto = example.getToken(new LoginDto(username.getText().toString(), password.getText().toString()));
        mNavigator.navigateToProductsList(tokenDto.getToken());
    }

    @Override
    public void setPresenter(RegisterContracts.Presenter presenter) {
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

    public void setNavigator(RegisterContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}
