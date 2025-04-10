package com.example.Parqueadero.Repository;

import com.example.Parqueadero.Model.Reserva_zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reserva_zonaRepository extends JpaRepository<Reserva_zona,Long> {
}
