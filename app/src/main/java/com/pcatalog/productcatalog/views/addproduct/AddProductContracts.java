package com.pcatalog.productcatalog.views.addproduct;

import com.pcatalog.productcatalog.enums.ProductAction;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;

public interface AddProductContracts {
    interface View {

        void setPresenter(AddProductContracts.Presenter presenter);

        void navigateToAddProductPicture(ProductDto productDto, ProductAction productAction);

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(AddProductContracts.View view);

        void unsubscribe();
    }

    public interface Navigator {

        void navigateToAddProductPicture(ProductDto productDto, ProductAction productAction);
    }
}
