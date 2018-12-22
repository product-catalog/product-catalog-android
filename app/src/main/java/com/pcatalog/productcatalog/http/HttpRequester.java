package com.pcatalog.productcatalog.http;

import java.io.IOException;

import okhttp3.ResponseBody;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

    ResponseBody getToken(String username, String password);

    ResponseBody getUser(String token);
}
