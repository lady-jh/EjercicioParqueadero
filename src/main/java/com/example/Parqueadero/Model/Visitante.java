package com.example.Parqueadero.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_visitante;
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    @JsonIgnore//Properties({"visitantes", "reserva_zonas", "reserva_parqueadero"})
    private Propietario propietario;
}
