package com.cesar.springboot.di.app.springboot_di.services;

import java.util.List;

import com.cesar.springboot.di.app.springboot_di.models.Producto;

public interface IProductoService {

    List<Producto> findAll();
    Producto findById(Long id);
}
