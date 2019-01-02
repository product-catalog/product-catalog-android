package com.pcatalog.productcatalog.views.register;

import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.ProductEdit;

public interface RegisterContracts {
    interface View {

        void setPresenter(RegisterContracts.Presenter presenter);

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(RegisterContracts.View view);

        void unsubscribe();

        void registerUser(LoginDto loginDto);
    }

    public interface Navigator {

        void navigateToProductsList(String token);
    }
}
