package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Visitante;
import com.example.Parqueadero.Service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitante")
public class VisitanteController {
    @Autowired
    public VisitanteService visitanteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Visitante>> listar() {
        List<Visitante> visitantes = visitanteService.listar();
        return ResponseEntity.ok(visitantes);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Visitante visitante = visitanteService.buscar(id);
            return ResponseEntity.ok(visitante);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Visitante visitante) {
        Visitante nuevoVisitante = visitanteService.guardar(visitante);
        return ResponseEntity.status(HttpStatus.CREATED).body("Visitante guardado exitosamente con ID: " + nuevoVisitante.getId_visitante());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Visitante visitante) {
        try {
            Visitante visitanteActualizado = visitanteService.actualizar(id, visitante);
            return ResponseEntity.ok("Visitante actualizado correctamente con ID: " + visitanteActualizado.getId_visitante());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            visitanteService.eliminar(id);
            return ResponseEntity.ok("El visitante con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
