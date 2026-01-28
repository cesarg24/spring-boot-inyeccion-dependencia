package com.cesar.springboot.di.app.springboot_di.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesar.springboot.di.app.springboot_di.models.Producto;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository {

    List<Producto> datos;

    public ProductoRepositoryImpl() {
        this.datos = List.of(
         new Producto(100L, "Televisor", 300L),
         new Producto(101L, "Lavadora", 250L),
         new Producto(102L, "Cocina", 200L)
        );
    }

    @Override
    public List<Producto> findAll(){
        return datos;
    }

    @Override
    public Producto findById(Long id){
        return datos.stream()
        .filter(prod -> prod.getId().equals(id)).findFirst().orElse(null);
    }
    
}
