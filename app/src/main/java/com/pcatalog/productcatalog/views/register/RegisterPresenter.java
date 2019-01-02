package com.pcatalog.productcatalog.views.register;

import com.pcatalog.productcatalog.async.base.SchedulerProvider;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductEdit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class RegisterPresenter implements RegisterContracts.Presenter {
    private final SchedulerProvider mSchedulerProvider;
    private RegisterContracts.View mView;

    @Inject
    public RegisterPresenter(
            SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(RegisterContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void registerUser(LoginDto loginDto){
        Disposable observable = Observable
                .create((ObservableOnSubscribe<ResponseBody>) emitter -> {
                    ResponseBody responseBody = new OkHttpHttpRequester().registerUser(loginDto);
                    emitter.onNext(responseBody);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                );
    }
}
