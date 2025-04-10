package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Propietario;
import com.example.Parqueadero.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropietarioService {
    @Autowired //private final->@RequiredArgsConstructor
    public PropietarioRepository propietarioRepository;

    public Propietario guardar(Propietario propietario) {
        if (propietario.getVisitantes() != null) {
            propietario.getVisitantes().forEach(v -> v.setPropietario(propietario));
        }
        if (propietario.getReserva_zonas() != null) {
            propietario.getReserva_zonas().forEach(rz -> rz.setPropietario(propietario));
        }
        if (propietario.getReserva_parqueadero() != null) {
            propietario.getReserva_parqueadero().setPropietario(propietario);
        }
        return propietarioRepository.save(propietario);
    }


    public List<Propietario> listar(){
        return propietarioRepository.findAll();
    }

    public Propietario buscar(long id) {
        if (propietarioRepository.existsById(id)) {
            return propietarioRepository.getById(id);
        } else {
            throw new RuntimeException("No existe el ID " + id);
        }
    }

    public void eliminar(long id) {
        if (propietarioRepository.existsById(id)) {
            propietarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la ID " + id);
        }
    }

    public Propietario actualizar(long id, Propietario propietario) {
        propietario.setId_propietario(id);
        if (propietarioRepository.existsById(id)) {
            propietario.setId_propietario(id);
            return propietarioRepository.save(propietario);
        } else {
            throw new RuntimeException("Esta id no esta asignada.");
        }
    }

    //CONSULTAS
    public List<Propietario> getPropietariosConVisitantes() {
        List<Propietario> propietarios = propietarioRepository.PropietariosConVisitantes();
        propietarios.forEach(p -> {
            p.setReserva_zonas(null);
            p.setReserva_parqueadero(null);
        });
        return propietarios;
    }

    public List<Propietario> getPropietariosConReservaParqueadero() {
        List<Propietario> propietarios = propietarioRepository.PropietariosConReservaParqueadero();
        propietarios.forEach(p -> {
            p.setReserva_zonas(null);
            p.setVisitantes(null);
        });
        return propietarios;
    }

    public List<Propietario> getPropietariosConReservaZona() {
        List<Propietario> propietarios = propietarioRepository.PropietariosConReservaZona();
        propietarios.forEach(p -> {
            p.setVisitantes(null);
            p.setReserva_parqueadero(null);
        });
        return propietarios;
    }

    public List<Propietario> getPropietariosConVisitanteYParqueadero() {
        List<Propietario> propietarios = propietarioRepository.PropietariosConVisitanteYParqueadero();
        propietarios.forEach(p -> {
            p.setReserva_zonas(null);
        });
        return propietarios;
    }
}
