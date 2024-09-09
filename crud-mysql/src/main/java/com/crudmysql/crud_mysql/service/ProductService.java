package com.crudmysql.crud_mysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudmysql.crud_mysql.model.Product;
import com.crudmysql.crud_mysql.repository.ProductRepository;

@Service
public class ProductService {

    //Si no inyectamos el repositorio no podremos hacer uso de los métodos de JPA
    @Autowired
    private ProductRepository productRepository;

    //Listar todos los productos
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    //Aquí utilizamos optional para evitar errores en caso de que no se encuentre el producto
    public Optional<Product> listById(Long id){
        return productRepository.findById(id);
    }

    //Guardar o actualizar un producto
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    //Eliminar un producto, no lleva return porque no necesitamos devolver nada
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
