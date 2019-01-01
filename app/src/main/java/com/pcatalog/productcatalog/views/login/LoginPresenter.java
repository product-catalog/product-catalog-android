package com.pcatalog.productcatalog.views.login;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;

import javax.inject.Inject;

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
