package com.pcatalog.productcatalog.diconfig.viewmodules;

import com.pcatalog.productcatalog.diconfig.ActivityScoped;
import com.pcatalog.productcatalog.diconfig.FragmentScoped;
import com.pcatalog.productcatalog.views.productslist.ProductsListContracts;
import com.pcatalog.productcatalog.views.productslist.ProductsListFragment;
import com.pcatalog.productcatalog.views.productslist.ProductsListPresenter;
import com.pcatalog.productcatalog.views.welcomemenu.WelcomeMenuContracts;
import com.pcatalog.productcatalog.views.welcomemenu.WelcomeMenuFragment;
import com.pcatalog.productcatalog.views.welcomemenu.WelcomeMenuPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class WelcomeMenuModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract WelcomeMenuFragment welcomeMenuFragment();

    @ActivityScoped
    @Binds
    abstract WelcomeMenuContracts.Presenter welcomeMenuContractsPresenter(WelcomeMenuPresenter presenter);
}
