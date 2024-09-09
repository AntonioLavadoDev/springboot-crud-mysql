package com.crudmysql.crud_mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudmysql.crud_mysql.model.Product;
import com.crudmysql.crud_mysql.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Listar todos los productos
    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    //Listar un producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Product> listById(@PathVariable Long id){
        Optional<Product> productOpt = productService.listById(id);
        //Esto es una expresión lambda, si el producto existe lo devolvemos con un status 200, si no existe devolvemos un status 404
        return productOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Guardar o actualizar un producto
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    //Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productOpt = productService.listById(id);
        if(productOpt.isPresent()){
            Product productExist = productOpt.get();
            productExist.setName(product.getName());
            productExist.setPrice(product.getPrice());
            productExist.setDescription(product.getDescription());
            return ResponseEntity.ok(productService.updateProduct(productExist));        
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }




}
