package com.pruebas.Mantenimiento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_contribuyente")
public class TipoContribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_contribuyente", nullable=false, unique=true)
    private int id_tipo_contribuyente;

    @Column(name="nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name="estado", columnDefinition="bit(1) default true ", nullable = false)
    private boolean estado;    

    public TipoContribuyente(){
    }
    
    public int getId(){
        return id_tipo_contribuyente;
    }
    public void setId(int id){
        this.id_tipo_contribuyente = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(Boolean estado){
        this.estado = estado;
    }
}
