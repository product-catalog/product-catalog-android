package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.diconfig.viewmodules.AddProductModule;
import com.pcatalog.productcatalog.diconfig.viewmodules.AddProductPictureModule;
import com.pcatalog.productcatalog.diconfig.viewmodules.LoginModule;
import com.pcatalog.productcatalog.diconfig.viewmodules.ProductDetailsModule;
import com.pcatalog.productcatalog.diconfig.viewmodules.ProductsListModule;
import com.pcatalog.productcatalog.diconfig.viewmodules.WelcomeMenuModule;
import com.pcatalog.productcatalog.views.addproduct.AddProductActivity;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureActivity;
import com.pcatalog.productcatalog.views.login.LoginActivity;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsActivity;
import com.pcatalog.productcatalog.views.productslist.ProductsListActivity;
import com.pcatalog.productcatalog.views.welcomemenu.WelcomeMenuActivity;

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

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = ProductDetailsModule.class
    )
    abstract ProductDetailsActivity productDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = ProductsListModule.class
    )
    abstract ProductsListActivity productsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = LoginModule.class
    )
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = WelcomeMenuModule.class
    )
    abstract WelcomeMenuActivity welcomeMenuActivity();
}