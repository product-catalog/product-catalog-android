package com.pcatalog.productcatalog.http;

import com.pcatalog.productcatalog.models.Product;
import com.pcatalog.productcatalog.models.ProductDto;

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

    List<Product> getFilteredProducts(String pattern) throws Exception;

    ResponseBody createNewProduct(ProductDto productDto) throws IOException;

    ResponseBody deleteProduct(Long id) throws IOException;

    ResponseBody editProduct(Product product) throws IOException;
}
