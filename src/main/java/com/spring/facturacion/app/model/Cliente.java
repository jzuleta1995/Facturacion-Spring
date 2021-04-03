/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.facturacion.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author javie
 */
@Entity
@Table(name="clientes")
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
public class Cliente implements Serializable {
    
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCliente;
    
    @Column(nullable=false)
    private String nombre;
    
    private String apellido;
    
    private String direccion;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy/MM/dd")
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    
    private String telefono;
    
    private String email;
    
    @OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnoreProperties(value = "cliente", allowSetters = true)
    @JsonIgnore
    private List<Factura> facturas;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechanNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    private static final long serialVersionUID = 1L;
}
