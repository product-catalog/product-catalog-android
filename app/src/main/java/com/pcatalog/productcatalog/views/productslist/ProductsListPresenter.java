package com.pcatalog.productcatalog.views.productslist;

import android.util.Log;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;
import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class ProductsListPresenter
        implements ProductsListContracts.Presenter {
//
//    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private ProductsListContracts.View mView;

    @Inject
    public ProductsListPresenter(
            //ProductsService productsService,
            SchedulerProvider schedulerProvider) {
        //mProductsService = productsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    // same as // setView(SuperheroesListContracts.View view)
    public void subscribe(ProductsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts() {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = okHttpHttpRequester.getAllProducts();
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentProductsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void filterProducts(String patternName, FilterField filterField) {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = okHttpHttpRequester.getFilteredProducts(patternName, filterField);
                    emitter.onNext(products);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentProductsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void selectProduct(Product product) {
        mView.showProductDetails(product);
    }

    private void presentProductsToView(List<Product> products) {
        if (products.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(products);
        }
    }
}

