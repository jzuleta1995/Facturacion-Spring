/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.service;

import com.spring.facturacion.app.model.Cliente;
import java.util.List;

/**
 *
 * @author javie
 */
public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long id);
}
