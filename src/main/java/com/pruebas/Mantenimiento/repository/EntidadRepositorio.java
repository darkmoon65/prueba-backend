package com.pruebas.Mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.Mantenimiento.model.Entidad;

@Repository
public interface EntidadRepositorio extends JpaRepository<Entidad, Integer>{
}
