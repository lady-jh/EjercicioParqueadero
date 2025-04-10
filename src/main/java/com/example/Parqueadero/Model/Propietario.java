package com.example.Parqueadero.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_propietario;
    private String nombre;
    private String cedula;
    private LocalDate fecha_visita;
    private LocalTime hora_entrada;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"visitantes", "reserva_zonas", "reserva_parqueadero"})
    private List<Reserva_zona> reserva_zonas;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"visitantes", "reserva_zonas", "reserva_parqueadero"})
    private List<Visitante> visitantes;

    @OneToOne(mappedBy = "propietario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"visitantes", "reserva_zonas", "reserva_parqueadero"})
    private Reserva_parqueadero reserva_parqueadero;
}
