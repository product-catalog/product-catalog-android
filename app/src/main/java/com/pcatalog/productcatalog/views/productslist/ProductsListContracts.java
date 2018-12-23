package com.pcatalog.productcatalog.views.productslist;

import com.pcatalog.productcatalog.models.Product;

import java.util.List;

public interface ProductsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showProducts(List<Product> superheroes);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductDetails(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProducts();

        void filterProducts(String pattern);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}

