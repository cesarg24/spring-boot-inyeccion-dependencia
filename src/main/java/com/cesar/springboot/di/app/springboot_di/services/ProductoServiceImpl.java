package com.cesar.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.cesar.springboot.di.app.springboot_di.models.Producto;
import com.cesar.springboot.di.app.springboot_di.repositories.ProductoRepositoryImpl;

public class ProductoServiceImpl implements IProductoService {

    private ProductoRepositoryImpl repository = new ProductoRepositoryImpl();

    @Override
    public List<Producto> findAll(){
        return repository.findAll().stream()
        .map(prod->{
            Double priceImp = prod.getPrecio() * 1.25d;
            //prod.setPrecio(priceImp.longValue());
            Producto newProducto = new Producto(prod.getId(), prod.getNombre(), priceImp.longValue());
            return newProducto;
        }).collect(Collectors.toList());
    }

    @Override
    public Producto findById(Long id){
        return repository.findById(id);
    }
}
