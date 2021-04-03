/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Cliente;
import com.spring.facturacion.app.repository.IClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author javie
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) this.clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return this.clienteDao.findById(id).get();
    }
    
}
