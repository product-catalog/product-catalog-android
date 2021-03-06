package com.pcatalog.productcatalog.http;

import android.os.StrictMode;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.ProductEdit;
import com.pcatalog.productcatalog.models.TokenDto;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpHttpRequester implements HttpRequester {

    public OkHttpHttpRequester() {

    }

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
    public List<Product> getAllProducts(String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Log.d("token", token);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
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
        Type listType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        ArrayList<Product> productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsDetailsDtos;
    }

    @Override
    public List<Product> getFilteredProductsByName(String pattern, String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .url(host + "/product/getByName?name=" + pattern)
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
        Type listType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        ArrayList<Product> productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productsDetailsDtos;
    }

    @Override
    public List<Product> getFilteredProducts(String patternName, FilterField filterField, String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request;
        if (filterField == FilterField.BETWEEN0AND25) {
            request = new Request.Builder()
                    .get()
                    .addHeader("Authorization", "Bearer " + token)
                    .url(host + "/product/getByNameAndPrice?name=" + patternName + "&minPrice=0&maxPrice=25")
                    .build();
        } else if (filterField == FilterField.BETWEEN25AND50) {
            request = new Request.Builder()
                    .get()
                    .addHeader("Authorization", "Bearer " + token)
                    .url(host + "/product/getByNameAndPrice?name=" + patternName + "&minPrice=25&maxPrice=50")
                    .build();
        } else if (filterField == FilterField.BETWEEN50AND75) {
            request = new Request.Builder()
                    .get()
                    .addHeader("Authorization", "Bearer " + token)
                    .url(host + "/product/getByNameAndPrice?name=" + patternName + "&minPrice=50&maxPrice=75")
                    .build();
        } else {
            request = new Request.Builder()
                    .get()
                    .addHeader("Authorization", "Bearer " + token)
                    .url(host + "/product/getByNameAndPrice?name=" + patternName + "&minPrice=75&maxPrice=100")
                    .build();
        }

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        Type listType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        List<Product> productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productsDetailsDtos;
    }

    @Override
    public Product createNewProduct(ProductDto productDto, String token) {
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = null;
        try {
            carAsString = objectMapper.writeValueAsString(productDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .post(requestBody)
                .url(host + "/product/new")
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
        Type listType = new TypeToken<Product>() {
        }.getType();
        try {
            return new Gson().fromJson(body2.string(), listType);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Product editProduct(ProductEdit productEdit, String token) {
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = null;
        try {
            carAsString = objectMapper.writeValueAsString(productEdit);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .put(requestBody)
                .url(host + "/product/edit")
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
        Type listType = new TypeToken<Product>() {
        }.getType();
        try {
            return new Gson().fromJson(body2.string(), listType);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResponseBody deleteProduct(Long id, String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .delete()
                .url(host + "/product/delete?id=" + id)
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
    public ResponseBody registerUser(LoginDto productDto) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = null;
        try {
            carAsString = objectMapper.writeValueAsString(productDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
        Request request = new Request.Builder()
                .get()
                .post(requestBody)
                .url(host + "/signup")
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
    public Product getProductById(Long id, String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
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
        Type listType = new TypeToken<Product>() {
        }.getType();
        Product productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsDetailsDtos;
    }


    @Override
    public TokenDto getToken(LoginDto loginDto) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        String carAsString = null;
        try {
            carAsString = objectMapper.writeValueAsString(loginDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(JSON, carAsString);
        Request request = new Request.Builder()
                .get()
                .post(requestBody)
                .url(host + "/token/generateToken")
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
        Type listType = new TypeToken<TokenDto>() {
        }.getType();
        TokenDto tokenDto = new TokenDto("null");
        try {
            tokenDto = new Gson().fromJson(body2.string(), listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenDto;
    }

    @Override
    public Boolean isAdmin(String token) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .addHeader("Authorization", "Bearer " + token)
                .url(host + "/token/isAdmin")
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
        try {
            return Boolean.valueOf(body2.string());
        } catch (IOException e) {
            return false;
        }
    }
}
