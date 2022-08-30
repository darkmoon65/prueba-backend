package com.pruebas.Mantenimiento.controllers;

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

import com.pruebas.Mantenimiento.model.TipoContribuyente;
import com.pruebas.Mantenimiento.repository.TipoContribuyenteRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class TipoContribuyenteController {
    @Autowired
    private TipoContribuyenteRepositorio repo;
    
    @GetMapping("/TipoContribuyente")
    public List<TipoContribuyente> getTipoContribuyentes(){
        return repo.findAll();
    }
    @PostMapping("/TipoContribuyente")
    public TipoContribuyente guardarTipoContribuyente(@RequestBody TipoContribuyente tipoContribuyente){
        return repo.save(tipoContribuyente);
    }

    @GetMapping("/TipoContribuyente/{id}")
    public ResponseEntity<TipoContribuyente> getTipoContribuyenteById(@PathVariable int id){
        TipoContribuyente tipo = repo.findById(id).orElseThrow();
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/TipoContribuyente/{id}")
    public ResponseEntity<TipoContribuyente> actualizarTipoContribuyente(@PathVariable int id, @RequestBody TipoContribuyente tipoContribuyente){
        TipoContribuyente tipo = repo.findById(id).orElseThrow();
        
        tipo.setNombre(tipoContribuyente.getNombre());
        tipo.setEstado(tipoContribuyente.getEstado());

        TipoContribuyente actualizado = repo.save(tipo);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/TipoContribuyente/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarTipoContribuyente(@PathVariable int id){

        TipoContribuyente tipo = repo.findById(id).orElseThrow();
        
        repo.delete(tipo);
        Map<String, Boolean> response = new HashMap<>();
		response.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(response);
    }
}