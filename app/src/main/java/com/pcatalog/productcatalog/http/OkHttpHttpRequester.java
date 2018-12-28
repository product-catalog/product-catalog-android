package com.pcatalog.productcatalog.http;

import android.os.StrictMode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpHttpRequester implements HttpRequester {
    public OkHttpHttpRequester() {

    }

    //private String host = "http://192.168.0.100:8080";
    private String host = "http://10.0.2.2:8080";

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String body = response.body().string();
        return body;
    }

    @Override
    public String post(String url, String bodyString) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString
        );

        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .url(host + "/product/getAll")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
        ArrayList<Product> productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        return productsDetailsDtos;
    }

    @Override
    public ResponseBody createNewProduct(ProductDto productDto) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = objectMapper.writeValueAsString(productDto);
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("somParam", "someValue")
//                .build();
        Request request = new Request.Builder()
                .get()
                .post(requestBody)
                .url(host + "/product/new")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();



        ResponseBody body2 = response.body();
        return body2;
    }

    @Override
    public ResponseBody editProduct(Product product) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = objectMapper.writeValueAsString(product);
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("somParam", "someValue")
//                .build();
        Request request = new Request.Builder()
                .get()
                .put(requestBody)
                .url(host + "/product/edit")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();



        ResponseBody body2 = response.body();
        return body2;
    }

    @Override
    public ResponseBody deleteProduct(Long id) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Request request = new Request.Builder()
                .get()
                .delete()
                .url(host + "/product/delete?id=" + id)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();



        ResponseBody body2 = response.body();
        return body2;
    }

    @Override
    public Product getProductById(Long id) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .url(host + "/product/getById?id=" + id)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        Type listType = new TypeToken<Product>() {}.getType();
        Product productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        return productsDetailsDtos;
    }

    @Override
    public List<Product> getFilteredProducts(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();

        return getAllProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }


    @Override
    public ResponseBody getToken(String username, String password) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/x-www-form-urlencoded");
        RequestBody requestBody2 = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", username)
                .addFormDataPart("password", password)
                .addFormDataPart("grant_type", "password")
                .build();
        Request request = new Request.Builder()
                .get()
                .header("Authorization", Credentials.basic("getmydrivercard", "bobi96"))
                .post(requestBody2)
                .url(host + "/oauth/token")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        return body2;
    }

    @Override
    public ResponseBody getUser(String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "bearer " + token)
                .url(host + "/user/getUser")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        return body2;
    }

}
