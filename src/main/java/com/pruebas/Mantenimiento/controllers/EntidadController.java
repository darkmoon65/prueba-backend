package com.pruebas.Mantenimiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.Mantenimiento.model.Entidad;
import com.pruebas.Mantenimiento.repository.EntidadRepositorio;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class EntidadController {

    @Autowired
    private EntidadRepositorio repo;
    
    @GetMapping("/Entidad")
    public List<Entidad> getEntidad(){
        return repo.findAll();
    }
    @PostMapping("/Entidad")
    public Entidad guardarEntidad(@RequestBody Entidad entidad){
        return repo.save(entidad);
    }

    @GetMapping("/Entidad/{id}")
    public ResponseEntity<Entidad> getEntidadById(@PathVariable int id){
        Entidad tipo = repo.findById(id).orElseThrow();
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/Entidad/{id}")
    public ResponseEntity<Entidad> actualizarEntidad(@PathVariable int id, @RequestBody Entidad entidad){
        Entidad en = repo.findById(id).orElseThrow();
        
        en.setIdContribuyente(entidad.getIdContribuyente());
        en.setDireccion(entidad.getDireccion());
        en.setIdDocumento(entidad.getIdDocumento());
        en.setNroDocumento(entidad.getNroDocumento());
        en.setRazonSocial(entidad.getRazonSocial());
        en.setNombreComercial(entidad.getNombreComercial());
        en.setTelefono(entidad.getTelefono());
        en.setEstado(entidad.getEstado());

        Entidad actualizado = repo.save(en);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/Entidad/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEntidad(@PathVariable int id){

        Entidad entidad = repo.findById(id).orElseThrow();
        
        repo.delete(entidad);
        Map<String, Boolean> response = new HashMap<>();
		response.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(response);
    }
}
