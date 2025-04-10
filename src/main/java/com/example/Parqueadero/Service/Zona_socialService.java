package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Zona_social;
import com.example.Parqueadero.Repository.Zona_socialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Zona_socialService {
    @Autowired
    public Zona_socialRepository zona_socialRepository;

    public Zona_social guardar(Zona_social zona_social){
        return zona_socialRepository.save(zona_social);
    }

    public List<Zona_social> listar(){
        return zona_socialRepository.findAll();
    }

    public Zona_social buscar(long id) {
        if (zona_socialRepository.existsById(id)) {
            return zona_socialRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el ID " + id);
        }
    }

    public void eliminar(long id) {
        if (zona_socialRepository.existsById(id)) {
            zona_socialRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la ID " + id);
        }
    }

    public Zona_social actualizar(long id, Zona_social zona_social) {
        zona_social.setId_zona(id);
        if (zona_socialRepository.existsById(id)) {
            zona_social.setId_zona(id);
            return zona_socialRepository.save(zona_social);
        } else {
            throw new RuntimeException("Esta id no esta asignada.");
        }
    }
}
