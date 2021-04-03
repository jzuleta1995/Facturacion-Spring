/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Factura;
import com.spring.facturacion.app.repository.IFacturaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author javie
 */
@Service
public class FacturaServiceImpl implements IFacturaService{
    
    @Autowired
    private IFacturaDao facturaDao; 

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return this.facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return (List<Factura>) this.facturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findById(Long id) {
        return this.facturaDao.findById(id).get();
    }
}
