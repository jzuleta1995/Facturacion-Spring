/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author javie
 */
@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @Column(name = "num_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numFactura;

    @JoinColumn(name = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties(value = "facturas")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(nullable = false)
    private Date fecha;

    @JsonIgnoreProperties(value = {"factura"}, allowSetters = true)
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalle;

    public Long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Long numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public void addDetalleFactura(DetalleFactura detalleFactura) {
        detalle.add(detalleFactura);
    }

    public void removeDetalleFactura(DetalleFactura detalleFactura) {
        detalle.remove(detalleFactura);
    }

    private static final Long serialVersionUID = 1L;
}
