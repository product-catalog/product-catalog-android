package com.pcatalog.productcatalog.views.productdetails;

import com.pcatalog.productcatalog.models.Product;

public interface ProductDetailsContracts {
    interface View {
        void showProduct(Product product);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadProduct();

        void setProductId(Long id);

        Long getProductId();
    }

    interface Navigator {
        void navigateToProductsList();
    }
}

