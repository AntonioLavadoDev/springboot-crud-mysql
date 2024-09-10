package com.crudmysql.crud_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudmysql.crud_mysql.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, IProductRepository {

}
