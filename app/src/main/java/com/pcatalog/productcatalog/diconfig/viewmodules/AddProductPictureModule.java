package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureContracts;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPictureFragment;
import com.pcatalog.productcatalog.views.addproductpicture.AddProductPicturePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AddProductPictureModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract AddProductPictureFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract AddProductPictureContracts.Presenter loginPresenter(AddProductPicturePresenter presenter);
}
