package com.pcatalog.productcatalog.views.addproduct;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;

import javax.inject.Inject;

public class AddProductPresenter implements AddProductContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;
    private AddProductContracts.View mView;

    @Inject
    public AddProductPresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(AddProductContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
