package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.async.AsyncSchedulerProvider;
import com.pcatalog.productcatalog.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
