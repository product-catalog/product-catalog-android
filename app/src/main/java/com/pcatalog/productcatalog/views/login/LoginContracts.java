package com.pcatalog.productcatalog.views.login;

public interface LoginContracts {
    interface View {

        void setPresenter(LoginContracts.Presenter presenter);

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(LoginContracts.View view);

        void unsubscribe();

    }

    interface Navigator {
        void navigateToMenu(String token);
    }
}
