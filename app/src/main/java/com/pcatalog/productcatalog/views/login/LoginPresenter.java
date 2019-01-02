package com.pcatalog.productcatalog.views.login;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.TokenDto;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;
    private LoginContracts.View mView;

    @Inject
    public LoginPresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

}
