/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Factura;
import java.util.List;

/**
 *
 * @author javie
 */
public interface IFacturaService {
    public Factura save(Factura factura);
    public Factura findById(Long id);
    public List<Factura> findAll();
}
