package com.pcatalog.productcatalog.diconfig;

import com.pcatalog.productcatalog.Constants;
import com.pcatalog.productcatalog.http.HttpRequester;
import com.pcatalog.productcatalog.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
