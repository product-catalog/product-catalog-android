package com.pcatalog.productcatalog.views.productdetails;

import android.util.Log;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.PhotoDto;
import com.pcatalog.productcatalog.models.Product;

import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class ProductDetailsPresenter
        implements ProductDetailsContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;

    private ProductDetailsContracts.View mView;
    private Long mProductId;

    @Inject
    public ProductDetailsPresenter(
            SchedulerProvider schedulerProvider
    ) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ProductDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProduct(String token) {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    Product product = okHttpHttpRequester.getProductById(mProductId, token);
                    emitter.onNext(product);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showProduct);
    }

    @Override
    public void setProductId(Long productId) {
        mProductId = productId;
    }

    @Override
    public Long getProductId() {
        return mProductId;
    }

}

