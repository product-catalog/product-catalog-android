package com.pcatalog.productcatalog.http;

import com.pcatalog.productcatalog.enums.FilterField;
import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;
import com.pcatalog.productcatalog.models.ProductEdit;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

    ResponseBody getToken(String username, String password);

    ResponseBody getUser(String token);

    List<Product> getAllProducts() throws IOException;

    Product getProductById(Long id) throws IOException;

    List<Product> getFilteredProducts(String patternName, FilterField filterField) throws Exception;

    List<Product> getFilteredProductsByName(String pattern) throws IOException;

    List<Product> getFilteredProductsByPrice(FilterField filterField) throws IOException;

    ResponseBody createNewProduct(ProductDto productDto) throws IOException;

    ResponseBody deleteProduct(Long id) throws IOException;

    ResponseBody editProduct(ProductEdit product) throws IOException;
}
