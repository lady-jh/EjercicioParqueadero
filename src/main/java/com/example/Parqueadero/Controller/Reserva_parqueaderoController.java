package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Reserva_parqueadero;
import com.example.Parqueadero.Service.Reserva_parqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_parqueadero")
public class Reserva_parqueaderoController {
    @Autowired
    public Reserva_parqueaderoService reserva_parqueaderoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Reserva_parqueadero>> listar() {
        List<Reserva_parqueadero> reserva_parqueaderos = reserva_parqueaderoService.listar();
        return ResponseEntity.ok(reserva_parqueaderos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            Reserva_parqueadero reserva_parqueadero = reserva_parqueaderoService.buscar(id);
            return ResponseEntity.ok(reserva_parqueadero);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Reserva_parqueadero reserva_parqueadero) {
        Reserva_parqueadero nuevoReserva_parqueadero = reserva_parqueaderoService.guardar(reserva_parqueadero);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva_parqueadero guardado exitosamente con ID: " + nuevoReserva_parqueadero.getId_reserva());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable long id, @RequestBody Reserva_parqueadero reserva_parqueadero) {
        try {
            Reserva_parqueadero reserva_parqueaderoActualizado = reserva_parqueaderoService.actualizar(id, reserva_parqueadero);
            return ResponseEntity.ok("Reserva_parqueadero actualizado correctamente con ID: " + reserva_parqueaderoActualizado.getId_reserva());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        try {
            reserva_parqueaderoService.eliminar(id);
            return ResponseEntity.ok("La reserva_parqueadero con ID " + id + " fue eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
}
