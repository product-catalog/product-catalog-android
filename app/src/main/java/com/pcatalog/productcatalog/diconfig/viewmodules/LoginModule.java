package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureContracts;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureFragment;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPicturePresenter;
import com.pcatalog.productcatalog.views.login.LoginContracts;
import com.pcatalog.productcatalog.views.login.LoginFragment;
import com.pcatalog.productcatalog.views.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract LoginContracts.Presenter loginPresenter(LoginPresenter presenter);
}
