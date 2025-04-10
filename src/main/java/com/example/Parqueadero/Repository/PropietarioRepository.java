package com.example.Parqueadero.Repository;

import com.example.Parqueadero.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario,Long> {
    //Mostrar propietarios con visitante
    @Query(value = "SELECT pp.* FROM propietario pp INNER JOIN visitante vs ON pp.id_propietario = vs.id_propietario", nativeQuery = true)
    List<Propietario> PropietariosConVisitantes();

    //Mostrar propietarios con reserva parqueadero
    @Query(value = "SELECT pp.* FROM propietario pp INNER JOIN reserva_parqueadero rp ON pp.id_propietario = rp.id_propietario", nativeQuery = true)
    List<Propietario> PropietariosConReservaParqueadero();

    //Mostrar propietarios con reserva zona social
    @Query(value = "SELECT pp.* FROM propietario pp INNER JOIN reserva_zona rz ON pp.id_propietario = rz.id_propietario", nativeQuery = true)
    List<Propietario> PropietariosConReservaZona();

    //Mostrar propietarios con visitante y parqueadero
    @Query(value = "SELECT pp.* FROM propietario pp INNER JOIN visitante vs ON pp.id_propietario = vs.id_propietario INNER JOIN reserva_parqueadero rp ON pp.id_propietario = rp.id_propietario", nativeQuery = true)
    List<Propietario> PropietariosConVisitanteYParqueadero();
}
