package com.example.Parqueadero.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Zona_social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_zona;
    private String nombre;
    private String ubicacion;
    private int capacidad;

    @OneToMany(mappedBy = "zona_social", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"zona_social", "propietario"})
    private List<Reserva_zona> reserva_zonas;

}
