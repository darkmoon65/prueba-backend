package com.pruebas.Mantenimiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_documento", nullable=false, unique=true)
    private int id_tipo_documento;
    
    @Column(name="codigo", length = 20, nullable = false)
    private String codigo;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="descripcion",length = 200, nullable = true)
    private String descripcion;
    
    @Column(name="estado", columnDefinition="bit(1) default true", nullable = false)
    private boolean estado;   
    
    public TipoDocumento(){
    }
    
    public int getId(){
        return id_tipo_documento;
    }
    public void setId(int id){
        this.id_tipo_documento = id;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(Boolean estado){
        this.estado = estado;
    }

}
