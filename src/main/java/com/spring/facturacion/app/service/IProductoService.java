/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Producto;
import java.util.List;
/**
 *
 * @author javie
 */
public interface IProductoService {
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public List<Producto> findAll();
}
