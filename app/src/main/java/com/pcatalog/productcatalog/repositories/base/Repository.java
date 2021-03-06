package com.pcatalog.productcatalog.repositories.base;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    List<T> getAll() throws IOException;

    T add(T item) throws IOException;

    T getById(int id) throws IOException;
}
