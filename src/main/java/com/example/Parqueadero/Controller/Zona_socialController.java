package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Zona_social;
import com.example.Parqueadero.Service.Zona_socialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zona_social")
public class Zona_socialController {
    @Autowired
    public Zona_socialService zona_socialService;

    @GetMapping("/listar")
    public ResponseEntity<List<Zona_social>> listar() {
        List<Zona_social> zona_sociales = zona_socialService.listar();
        return ResponseEntity.ok(zona_sociales);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Zona_social zona_social = zona_socialService.buscar(id);
            return ResponseEntity.ok(zona_social);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Zona_social zona_social) {
        Zona_social nuevoZona_social = zona_socialService.guardar(zona_social);
        return ResponseEntity.status(HttpStatus.CREATED).body("Zona_social guardado exitosamente con ID: " + nuevoZona_social.getId_zona());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Zona_social zona_social) {
        try {
            Zona_social zona_socialActualizado = zona_socialService.actualizar(id, zona_social);
            return ResponseEntity.ok("Zona_social actualizado correctamente con ID: " + zona_socialActualizado.getId_zona());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            zona_socialService.eliminar(id);
            return ResponseEntity.ok("La zona_social con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
