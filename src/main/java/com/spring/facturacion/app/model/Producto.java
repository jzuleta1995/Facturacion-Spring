/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author javie
 */
@Entity
@Table(name="productos")
public class Producto implements Serializable {

    @Id
    @Column(name="id_producto")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProducto;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private Long precio;
    
    private int stock;
    
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void updateStock(int sellStock){
        this.stock -= sellStock;
    }
    
    private static final long serialVersionUID = 1L;
}
