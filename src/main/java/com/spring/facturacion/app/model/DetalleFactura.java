/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author javie
 */
@Entity
@Table(name = "detalles_factura")
@IdClass(DetalleFacturaPK.class)
public class DetalleFactura implements Serializable {

    @Id
    @Column(name="num_detalle")
    private Long numDetalle;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_factura")
    private Factura factura;

    @JoinColumn(name = "id_producto", nullable = false)
    @OneToOne()
    private Producto producto;

    private int cantidad;

    private long precio;

    public DetalleFactura() {
    }

    public Long getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(Long numDetalle) {
        this.numDetalle = numDetalle;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    private static final Long serialVersionUID = 1L;
}
