package com.pcatalog.productcatalog.views.addproductpicture;

import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.views.addproduct.AddProductContracts;

public interface AddProductPictureContracts {
    interface View {

        void setPresenter(AddProductPictureContracts.Presenter presenter);

        void navigateToProductList();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(AddProductPictureContracts.View view);

        void unsubscribe();
    }

    interface Navigator {
        void navigateToProductList();
    }
}
