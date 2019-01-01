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

    TokenDto getToken(LoginDto loginDto);

    ResponseBody getUser(String token);

    List<Product> getAllProducts(String token);

    Product getProductById(Long id, String token);

    List<Product> getFilteredProducts(String patternName, FilterField filterField, String token);

    List<Product> getFilteredProductsByName(String pattern, String token);

    List<Product> getFilteredProductsByPrice(FilterField filterField, String token);

    Product createNewProduct(ProductDto productDto, String token);

    ResponseBody deleteProduct(Long id, String token);

    ResponseBody editProduct(ProductEdit product, String token);

    Boolean isAdmin(String token);
}
