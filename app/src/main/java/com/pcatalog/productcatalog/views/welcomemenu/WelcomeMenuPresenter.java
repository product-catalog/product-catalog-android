package com.pcatalog.productcatalog.views.welcomemenu;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;

import javax.inject.Inject;

public class WelcomeMenuPresenter implements WelcomeMenuContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;
    private WelcomeMenuContracts.View mView;

    @Inject
    public WelcomeMenuPresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(WelcomeMenuContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
