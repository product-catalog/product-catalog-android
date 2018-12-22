package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = AddProductModule.class
    )
    abstract AddProductActivity renewalActivity();
}