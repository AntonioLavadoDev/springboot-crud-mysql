package com.crudmysql.crud_mysql.service;

import java.util.List;
import java.util.Optional;

import com.crudmysql.crud_mysql.model.Product;

public interface IProductService {
    List<Product> listAll();
    Optional<Product> listById(Long id);
    Product updateProduct(Product product);
    void deleteProduct(Long id);

}
