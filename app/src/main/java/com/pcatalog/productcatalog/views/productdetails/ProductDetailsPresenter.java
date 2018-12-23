package com.pcatalog.productcatalog.views.productdetails;

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
    //private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;

    private ProductDetailsContracts.View mView;
    private Long mProductId;

    @Inject
    public ProductDetailsPresenter(
            //ProductsService productsService,
            SchedulerProvider schedulerProvider
    ) {
        //mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ProductDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProduct() {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Product>) emitter -> {
                    ResponseBody responseBody = okHttpHttpRequester.getProductById(mProductId);
                    Product product = new Product(1L, new Date(), new Date(), "10", "11", new PhotoDto("a", "A"), 1.0);
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
}

