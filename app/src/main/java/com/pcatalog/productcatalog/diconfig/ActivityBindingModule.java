package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = AddProductModule.class
    )
    abstract AddProductActivity addProductActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = AddProductPictureModule.class
    )
    abstract AddProductPictureActivity addProductPictureActivity();
}