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

import com.pruebas.Mantenimiento.model.TipoDocumento;
import com.pruebas.Mantenimiento.repository.TipoDocumentoRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoRepositorio repo;
    
    @GetMapping("/TipoDocumento")
    public List<TipoDocumento> getTipoDocumentos(){
        return repo.findAll();
    }

    @PostMapping("/TipoDocumento")
    public TipoDocumento guardarTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
        return repo.save(tipoDocumento);
    }

    @GetMapping("/TipoDocumento/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable int id){
        TipoDocumento tipo = repo.findById(id).orElseThrow();
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/TipoDocumento/{id}")
    public ResponseEntity<TipoDocumento> actualizarTipoDocumento(@PathVariable int id, @RequestBody TipoDocumento tipoDocumento){
        TipoDocumento tipo = repo.findById(id).orElseThrow();
        
        tipo.setCodigo(tipoDocumento.getCodigo());
        tipo.setNombre(tipoDocumento.getNombre());
        tipo.setDescripcion(tipoDocumento.getDescripcion());
        tipo.setEstado(tipoDocumento.getEstado());

        TipoDocumento actualizado = repo.save(tipo);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/TipoDocumento/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarTipoDocumento(@PathVariable int id){

        TipoDocumento tipo = repo.findById(id).orElseThrow();
        
        repo.delete(tipo);
        Map<String, Boolean> response = new HashMap<>();
		response.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(response);
    }
}