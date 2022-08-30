package com.pruebas.Mantenimiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entidad", nullable=false, unique=true)
    private int id_entidad;

    @OneToOne
    @JoinColumn(name="id_tipo_documento", referencedColumnName = "id_tipo_documento", nullable = false)
    private TipoDocumento id_tipo_documento;

    @Column(name="nro_documento", length = 25, nullable = false, unique = true)
    private String nro_documento;

    @Column(name="razon_social", length = 100, nullable = false)
    private String razon_social;

    @Column(name="nombre_comercial", length = 100, nullable = true)
    private String nombre_comercial;

    @OneToOne
    @JoinColumn(name="id_tipo_contribuyente", referencedColumnName = "id_tipo_contribuyente", nullable=true)
    private TipoContribuyente id_tipo_contribuyente;
    
    @Column(name="direccion", length = 250, nullable = true)
    private String direccion;

    @Column(name="telefono", length = 50, nullable = true)
    private String telefono;
    
    @Column(name="estado", columnDefinition="bit(1) default true", nullable = false)
    private boolean estado;

    public Entidad(){   
    }
    
    public int getId(){
        return id_entidad;
    }
    public void setId(int id){
        this.id_entidad = id;
    }
    public TipoDocumento getIdDocumento(){
        return id_tipo_documento;
    }
    public void setIdDocumento(TipoDocumento id){
        this.id_tipo_documento = id;
    }
    public String getNroDocumento(){
        return nro_documento;
    }
    public void setNroDocumento(String numero){
        this.nro_documento = numero;
    }
    public String getRazonSocial(){
        return razon_social;
    }
    public void setRazonSocial(String razon){
        this.razon_social = razon;
    }
    public String getNombreComercial(){
        return nombre_comercial;
    }
    public void setNombreComercial(String nombre_comercial){
        this.nombre_comercial = nombre_comercial;
    }
    public TipoContribuyente getIdContribuyente(){
        return id_tipo_contribuyente;
    }
    public void setIdContribuyente(TipoContribuyente id){
        this.id_tipo_contribuyente = id;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(Boolean estado){
        this.estado = estado;
    }
}
