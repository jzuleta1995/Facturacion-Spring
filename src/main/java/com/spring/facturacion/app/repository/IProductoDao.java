/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.repository;

import com.spring.facturacion.app.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author javie
 */
@Repository
public interface IProductoDao extends CrudRepository<Producto, Long>{
    
}
