package com.example.Parqueadero.Repository;

import com.example.Parqueadero.Model.Zona_social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Zona_socialRepository extends JpaRepository<Zona_social,Long> {
}
