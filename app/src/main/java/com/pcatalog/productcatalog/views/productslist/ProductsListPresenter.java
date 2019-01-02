package com.pcatalog.productcatalog.views.productslist;

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

    private final SchedulerProvider mSchedulerProvider;
    private ProductsListContracts.View mView;

    @Inject
    public ProductsListPresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(ProductsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadProducts(String token) {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = okHttpHttpRequester.getAllProducts(token);
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
    public void filterProducts(String patternName, FilterField filterField, String token) {
        mView.showLoading();
        OkHttpHttpRequester okHttpHttpRequester = new OkHttpHttpRequester();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products;
                    if (filterField.equals(FilterField.ALL)) {
                        products = okHttpHttpRequester.getFilteredProductsByName(patternName, token);
                    } else {
                        products = okHttpHttpRequester.getFilteredProducts(patternName, filterField, token);
                    }
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

