package com.pcatalog.productcatalog.http;

import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.models.LoginDto;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.ProductEdit;
import com.pcatalog.productcatalog.models.TokenDto;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

    TokenDto getToken(LoginDto loginDto) throws IOException;

    ResponseBody getUser(String token);

    List<Product> getAllProducts(String token) throws IOException;

    Product getProductById(Long id, String token) throws IOException;

    List<Product> getFilteredProducts(String patternName, FilterField filterField, String token) throws Exception;

    List<Product> getFilteredProductsByName(String pattern, String token) throws IOException;

    List<Product> getFilteredProductsByPrice(FilterField filterField, String token) throws IOException;

    ResponseBody createNewProduct(ProductDto productDto, String token) throws IOException;

    ResponseBody deleteProduct(Long id, String token) throws IOException;

    ResponseBody editProduct(ProductEdit product, String token) throws IOException;
}
