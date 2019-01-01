package com.pcatalog.productcatalog.views.welcomemenu;

public interface WelcomeMenuContracts {
    interface View {

        void setPresenter(WelcomeMenuContracts.Presenter presenter);

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(WelcomeMenuContracts.View view);

        void unsubscribe();
    }

    public interface Navigator {
        void navigateToLoginPage();
        void navigateToRegisterPage();
    }
}