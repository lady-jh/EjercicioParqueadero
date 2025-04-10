package com.example.Parqueadero.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva_parqueadero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;
    private LocalDate fecha;
    private LocalTime hora_inicio;

    @OneToOne
    @JoinColumn(name = "id_propietario")
    @JsonIgnore//Properties({"visitantes", "reserva_zonas", "reserva_parqueadero"})
    private Propietario propietario;
}
