package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Propietario;
import com.example.Parqueadero.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {
    @Autowired
    public PropietarioService propietarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Propietario>> listar() {
        List<Propietario> propietarios = propietarioService.listar();
        return ResponseEntity.ok(propietarios);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Propietario propietario = propietarioService.buscar(id);
            return ResponseEntity.ok(propietario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioService.guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Propietario guardado exitosamente con ID " + nuevoPropietario.getId_propietario());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Propietario propietario) {
        try {
            Propietario propietarioActualizado = propietarioService.actualizar(id, propietario);
            return ResponseEntity.ok("Propietario actualizado correctamente con ID " + propietarioActualizado.getId_propietario());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            propietarioService.eliminar(id);
            return ResponseEntity.ok("El propietario con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    //CONSULTAS
    @GetMapping("/visitantes")
    public ResponseEntity<?> obtenerConVisitantes() {
        return ResponseEntity.ok(propietarioService.getPropietariosConVisitantes());
    }

    @GetMapping("/rparqueadero")
    public ResponseEntity<?> obtenerConReservaParqueadero() {
        return ResponseEntity.ok(propietarioService.getPropietariosConReservaParqueadero());
    }

    @GetMapping("/rzona")
    public ResponseEntity<?> obtenerConReservaZona() {
        return ResponseEntity.ok(propietarioService.getPropietariosConReservaZona());
    }

    @GetMapping("/visitanteRparqueadero")
    public ResponseEntity<?> obtenerConVisitantesYParqueadero() {
        return ResponseEntity.ok(propietarioService.getPropietariosConVisitanteYParqueadero());
    }
}
