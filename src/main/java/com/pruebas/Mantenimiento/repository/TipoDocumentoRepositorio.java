package com.pruebas.Mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.Mantenimiento.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Integer>{ 
}
