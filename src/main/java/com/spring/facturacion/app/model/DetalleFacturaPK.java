/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author javie
 */
public class DetalleFacturaPK implements Serializable{
    
    private Factura factura;
    
    private Long numDetalle;
    
    public DetalleFacturaPK(){}

    public DetalleFacturaPK(Factura factura, Long numDetalle) {
        this.factura = factura;
        this.numDetalle = numDetalle;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(Long numDetalle) {
        this.numDetalle = numDetalle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFactura(), getNumDetalle());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(!(obj instanceof DetalleFacturaPK)) return false;
        
        DetalleFacturaPK that = (DetalleFacturaPK) obj;
        
        return Objects.equals(getFactura(), that.getFactura()) &&
                Objects.equals(getNumDetalle(), that.getNumDetalle());
    }

    private static Long serialVersionUID = 1L;

}
