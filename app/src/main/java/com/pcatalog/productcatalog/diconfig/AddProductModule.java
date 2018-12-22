package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.views.addproduct.AddProductContracts;
import com.pcatalog.productcatalog.views.addproduct.AddProductFragment;
import com.pcatalog.productcatalog.views.addproduct.AddProductPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AddProductModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract AddProductFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract AddProductContracts.Presenter loginPresenter(AddProductPresenter presenter);
}
