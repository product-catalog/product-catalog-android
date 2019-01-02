package com.pcatalog.productcatalog.views.productslist;

import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.models.Product;

import java.util.List;

public interface ProductsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showProducts(List<Product> products);

        void showEmptyProductsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showProductDetails(Product product);
    }

    interface Presenter {
        void subscribe(View view);

        void loadProducts(String token);

        void filterProducts(String patternName, FilterField filterField, String token);

        void selectProduct(Product product);
    }

    interface Navigator {
        void navigateWith(Product product);
    }
}

