package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.register.RegisterContracts;
import com.pcatalog.productcatalog.views.register.RegisterFragment;
import com.pcatalog.productcatalog.views.register.RegisterPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RegisterModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RegisterFragment registerFragment();

    @ActivityScoped
    @Binds
    abstract RegisterContracts.Presenter presenter(RegisterPresenter presenter);
}