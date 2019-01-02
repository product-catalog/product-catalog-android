package com.pcatalog.productcatalog.views.addproductpicture;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.ProductEdit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

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

    @Override
    public void editProduct(ProductEdit product, String token){
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    Product products = new OkHttpHttpRequester().editProduct(product, token);
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                );
    }

    @Override
    public void createProduct(ProductDto product, String token){
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    Product products = new OkHttpHttpRequester().createNewProduct(product, token);
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                );
    }
}
