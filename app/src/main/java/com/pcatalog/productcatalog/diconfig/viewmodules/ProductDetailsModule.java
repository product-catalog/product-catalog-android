package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.addproduct.AddProductContracts;
import com.pcatalog.productcatalog.views.addproduct.AddProductFragment;
import com.pcatalog.productcatalog.views.addproduct.AddProductPresenter;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsContracts;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsFragment;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ProductDetailsFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract ProductDetailsContracts.Presenter loginPresenter(ProductDetailsPresenter presenter);
}
