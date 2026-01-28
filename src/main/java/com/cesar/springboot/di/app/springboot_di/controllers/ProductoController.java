package com.cesar.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.springboot.di.app.springboot_di.models.Producto;
import com.cesar.springboot.di.app.springboot_di.services.IProductoService;



@RestController
@RequestMapping("/api")
public class ProductoController {

    //private ProductoServiceImpl servicio = new ProductoServiceImpl();
    //@Autowired
    private IProductoService servicio;
    public ProductoController(IProductoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Producto> list(){
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public Producto show(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
}
