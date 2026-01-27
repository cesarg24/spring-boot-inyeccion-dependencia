package com.cesar.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.cesar.springboot.di.app.springboot_di.models.Producto;

public interface IProductoRepository {
    List<Producto> findAll();
    Producto findById(Long id);
    
}
