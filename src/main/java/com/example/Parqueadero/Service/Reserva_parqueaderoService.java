package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Reserva_parqueadero;
import com.example.Parqueadero.Repository.Reserva_parqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Reserva_parqueaderoService {
    @Autowired
    public Reserva_parqueaderoRepository reserva_parqueaderoRepository;

    public Reserva_parqueadero guardar(Reserva_parqueadero reserva_parqueadero){
        return reserva_parqueaderoRepository.save(reserva_parqueadero);
    }

    public List<Reserva_parqueadero> listar(){
        return reserva_parqueaderoRepository.findAll();
    }

    public Reserva_parqueadero buscar(long id) {
        if (reserva_parqueaderoRepository.existsById(id)) {
            return reserva_parqueaderoRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el ID " + id);
        }
    }

    public void eliminar(long id) {
        if (reserva_parqueaderoRepository.existsById(id)) {
            reserva_parqueaderoRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la ID " + id);
        }
    }

    public Reserva_parqueadero actualizar(long id, Reserva_parqueadero reserva_parqueadero) {
        reserva_parqueadero.setId_reserva(id);
        if (reserva_parqueaderoRepository.existsById(id)) {
            reserva_parqueadero.setId_reserva(id);
            return reserva_parqueaderoRepository.save(reserva_parqueadero);
        } else {
            throw new RuntimeException("Esta id no esta asignada.");
        }
    }
}
