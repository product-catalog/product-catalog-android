package com.pcatalog.productcatalog.views.login;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.TokenDto;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements LoginContracts.View {


    private LoginContracts.Presenter mPresenter;

    private LoginContracts.Navigator mNavigator;

    @BindView(R.id.button_login_login)
    Button login;

    @BindView(R.id.editText_login_password)
    EditText password;

    @BindView(R.id.editText_login_username)
    EditText username;

    @Inject
    public LoginFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        password = view.findViewById(R.id.editText_login_password);
        password.setText("admin");
        username = view.findViewById(R.id.editText_login_username);
        username.setText("admin");
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

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
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

    public void setNavigator(LoginContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnClick(R.id.button_login_login)
    public void navigateToMenu() {
        LoginDto loginDto = new LoginDto(username.getText().toString(), password.getText().toString());
        OkHttpHttpRequester example = new OkHttpHttpRequester();
        TokenDto tokenDto = example.getToken(loginDto);
        if (tokenDto.getToken() != null) {
            mNavigator.navigateToMenu(tokenDto.getToken());
        } else {
            Toast.makeText(getContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }

}
