package com.example.Parqueadero.Repository;

import com.example.Parqueadero.Model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante,Long> {
}
