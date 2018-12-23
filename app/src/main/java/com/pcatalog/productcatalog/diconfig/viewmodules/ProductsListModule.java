package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsContracts;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsFragment;
import com.pcatalog.productcatalog.views.productdetails.ProductDetailsPresenter;
import com.pcatalog.productcatalog.views.productslist.ProductsListContracts;
import com.pcatalog.productcatalog.views.productslist.ProductsListFragment;
import com.pcatalog.productcatalog.views.productslist.ProductsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract ProductsListFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract ProductsListContracts.Presenter loginPresenter(ProductsListPresenter presenter);
}
