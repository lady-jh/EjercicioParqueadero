package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Visitante;
import com.example.Parqueadero.Repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitanteService {
    @Autowired
    public VisitanteRepository visitanteRepository;

    public Visitante guardar(Visitante visitante){
        return visitanteRepository.save(visitante);
    }

    public List<Visitante> listar(){
        return visitanteRepository.findAll();
    }

    public Visitante buscar(long id) {
        if (visitanteRepository.existsById(id)) {
            return visitanteRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el ID " + id);
        }
    }

    public void eliminar(long id) {
        if (visitanteRepository.existsById(id)) {
            visitanteRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la ID " + id);
        }
    }

    public Visitante actualizar(long id, Visitante visitante) {
        visitante.setId_visitante(id);
        if (visitanteRepository.existsById(id)) {
            visitante.setId_visitante(id);
            return visitanteRepository.save(visitante);
        } else {
            throw new RuntimeException("Esta id no esta asignada.");
        }
    }
}
