package com.pruebas.Mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pruebas.Mantenimiento.model.TipoContribuyente;

@Repository
public interface TipoContribuyenteRepositorio extends JpaRepository<TipoContribuyente, Integer>{
    
}
