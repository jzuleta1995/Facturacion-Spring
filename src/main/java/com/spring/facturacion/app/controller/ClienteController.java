/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.controller;

import com.spring.facturacion.app.model.Cliente;
import com.spring.facturacion.app.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javie
 */
@RestController
@RequestMapping("${config.baseURL}/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() throws Exception{
        try{
            List<Cliente> clientes = clienteService.findAll();
            
            if(clientes.size() > 0){
                return ResponseEntity.ok(clientes);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) throws Exception{
        try{
            Cliente cliente = this.clienteService.findById(id);
        
            if(cliente == null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(cliente);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
    }
}
