package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Reserva_zona;
import com.example.Parqueadero.Repository.Reserva_zonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Reserva_zonaService {
    @Autowired
    public Reserva_zonaRepository reserva_zonaRepository;

    public Reserva_zona guardar(Reserva_zona reserva_zona){
        return reserva_zonaRepository.save(reserva_zona);
    }

    public List<Reserva_zona> listar(){
        return reserva_zonaRepository.findAll();
    }

    public Reserva_zona buscar(long id) {
        if (reserva_zonaRepository.existsById(id)) {
            return reserva_zonaRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el ID " + id);
        }
    }

    public void eliminar(long id) {
        if (reserva_zonaRepository.existsById(id)) {
            reserva_zonaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la ID " + id);
        }
    }

    public Reserva_zona actualizar(long id, Reserva_zona reserva_zona) {
        reserva_zona.setId_reserva(id);
        if (reserva_zonaRepository.existsById(id)) {
            reserva_zona.setId_reserva(id);
            return reserva_zonaRepository.save(reserva_zona);
        } else {
            throw new RuntimeException("Esta id no esta asignada.");
        }
    }
}
