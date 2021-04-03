/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.controller;

import com.spring.facturacion.app.model.Producto;
import com.spring.facturacion.app.service.IProductoService;
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
@RequestMapping("${config.baseURL}/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() throws Exception{
        try{
            List<Producto> productos = this.productoService.findAll();
            
            if(productos.size() > 0){
                return ResponseEntity.ok(productos);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerFactura(@PathVariable Long id) throws Exception{
        try{
            Producto producto = this.productoService.findById(id);
        
            if(producto == null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(producto);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
    }
}
