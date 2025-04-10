package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Reserva_zona;
import com.example.Parqueadero.Service.Reserva_zonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_zona")
public class Reserva_zonaController {
    @Autowired
    public Reserva_zonaService reserva_zonaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Reserva_zona>> listar() {
        List<Reserva_zona> reserva_zonas = reserva_zonaService.listar();
        return ResponseEntity.ok(reserva_zonas);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Reserva_zona reserva_zona = reserva_zonaService.buscar(id);
            return ResponseEntity.ok(reserva_zona);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Reserva_zona reserva_zona) {
        Reserva_zona nuevoReserva_zona = reserva_zonaService.guardar(reserva_zona);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva_zona guardado exitosamente con ID: " + nuevoReserva_zona.getId_reserva());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Reserva_zona reserva_zona) {
        try {
            Reserva_zona reserva_zonaActualizado = reserva_zonaService.actualizar(id, reserva_zona);
            return ResponseEntity.ok("Reserva_zona actualizado correctamente con ID: " + reserva_zonaActualizado.getId_reserva());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            reserva_zonaService.eliminar(id);
            return ResponseEntity.ok("La reserva_zona con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
