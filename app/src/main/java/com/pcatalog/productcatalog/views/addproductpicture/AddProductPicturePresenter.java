package com.pcatalog.productcatalog.views.addproductpicture;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;

import javax.inject.Inject;

public class AddProductPicturePresenter implements AddProductPictureContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;
    private AddProductPictureContracts.View mView;

    @Inject
    public AddProductPicturePresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(AddProductPictureContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
