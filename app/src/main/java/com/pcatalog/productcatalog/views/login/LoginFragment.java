package com.pcatalog.productcatalog.views.login;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pcatalog.productcatalog.R;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.validators.Patterns;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        password = view.findViewById(R.id.editText_login_password);
        password.setText("123");
        username = view.findViewById(R.id.editText_login_username);
        username.setText("bobi");
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
    public void navigateToMenu(){
        if (!Pattern.matches(Patterns.PATTERN_STRING, username.getText().toString())){
            username.setError("Username is not valid");
        }
        else if (!Pattern.matches(Patterns.PATTERN_STRING, password.getText().toString())){
            password.setError("Password is not valid");
        }
        else if (Pattern.matches(Patterns.PATTERN_STRING, username.getText().toString()) && Pattern.matches(Patterns.PATTERN_STRING, password.getText().toString())){
            OkHttpHttpRequester example = new OkHttpHttpRequester();
            ResponseBody response2 = example.getToken(username.getText().toString(), password.getText().toString());
            String token = null;
            String response3 = null;
            try {
                //
                response3 = response2.string();
                token = response3.substring(17, response3.indexOf("\",\"token_type"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            ResponseBody responseRole = example.getUser(token);
            String role = null;
            String responseRole2 = null;
            try {
                //
                responseRole2 = responseRole.string();
                role = responseRole2.substring(responseRole2.indexOf("role") + 7, responseRole2.indexOf("comments") - 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            mNavigator.navigateToMenu(token, role);
        }
    }

}
