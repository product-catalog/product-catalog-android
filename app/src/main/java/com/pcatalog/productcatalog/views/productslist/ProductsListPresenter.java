package com.pcatalog.productcatalog.views.productslist;

import com.pcatalog.productcatalog.models.Product;

public class ProductsListPresenter
        implements ProductsListContracts.Presenter {

    private final ProductsService mProductsService;
    private final SchedulerProvider mSchedulerProvider;
    private ProductsListContracts.View mView;

    @Inject
    public ProductsListPresenter(
            ProductsService productsService,
            SchedulerProvider schedulerProvider) {
        mProductsService = productsService;
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
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Superhero>>) emitter -> {
                    List<Product> products = mProductsService.getAllProducts();
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
    public void filterProducts(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Product>>) emitter -> {
                    List<Product> products = mProductsService.getFilteredProducts(pattern);
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

    private void presentSuperheroesToView(List<Product> products) {
        if (products.isEmpty()) {
            mView.showEmptyProductsList();
        } else {
            mView.showProducts(products);
        }
    }
}

