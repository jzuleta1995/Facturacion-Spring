/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.controller;

import com.spring.facturacion.app.model.DetalleFactura;
import com.spring.facturacion.app.model.Factura;
import com.spring.facturacion.app.model.Producto;
import com.spring.facturacion.app.service.IFacturaService;
import com.spring.facturacion.app.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javie
 */
@RestController
@RequestMapping("${config.baseURL}/facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping
    public ResponseEntity<List<Factura>> obtenerFacturas() throws Exception{
        try{
            List<Factura> facturas = this.facturaService.findAll();
            
            if(facturas.size() > 0){
                return ResponseEntity.ok().body(this.facturaService.findAll());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) throws Exception{
        try{
            factura.getDetalle().forEach(detalle -> {
                Producto producto = detalle.getProducto();
                producto.updateStock(detalle.getCantidad());
                this.productoService.save(producto);
                
                detalle.setFactura(factura);
            });
             
            return ResponseEntity.status(HttpStatus.CREATED).body(this.facturaService.save(factura));
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Factura> verFactura(@PathVariable Long id) throws Exception{
        try{
            Factura factura = this.facturaService.findById(id);
        
            if(factura == null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(factura);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
    }
}
