/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Producto;
import com.spring.facturacion.app.repository.IProductoDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author javie
 */
@Service
public class ProductoServiceImpl implements IProductoService {
    
    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return this.productoDao.findById(id).get();
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return this.productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) this.productoDao.findAll();
    }
    
}
