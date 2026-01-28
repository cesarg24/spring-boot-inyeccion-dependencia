package com.cesar.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesar.springboot.di.app.springboot_di.models.Producto;
import com.cesar.springboot.di.app.springboot_di.repositories.IProductoRepository;


@Service
public class ProductoServiceImpl implements IProductoService {

    //@Autowired
    private IProductoRepository repository;

    public ProductoServiceImpl(IProductoRepository repository) {
     this.repository = repository;
    }
    
    /* private ProductoRepositoryImpl repository = new ProductoRepositoryImpl(); 
    En lugar de que nosotros llamemos al objeto (repository), el contenedor nos llama a nosotros y nos provee el objeto, principio Hollywood*/

    @Override
    public List<Producto> findAll(){
        return repository.findAll().stream()
        .map(prod->{
            Double priceImp = prod.getPrecio() * 1.25d;
            //prod.setPrecio(priceImp.longValue());//mutable
            Producto newProducto = new Producto(prod.getId(), prod.getNombre(), priceImp.longValue());
            return newProducto;
        }).collect(Collectors.toList());
    }

    @Override
    public Producto findById(Long id){
        return repository.findById(id);
    }
    
}
