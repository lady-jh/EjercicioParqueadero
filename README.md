# EjercicioParqueadero
## Codigo para crear los registros
### 1. Zona_social
```json lines
{
  "nombre": "Zona BBQ",
  "ubicacion": "Zona verde junto al parque infantil",
  "capacidad": 30
}
{
  "nombre": "Piscina",
  "ubicacion": "Nivel 3 - Área recreativa externa",
  "capacidad": 25
}
{
  "nombre": "Gimnasio",
  "ubicacion": "Nivel 2 - Área deportiva",
  "capacidad": 50
}
{
  "nombre": "Spa",
  "ubicacion": "Torre 3 - Segundo piso",
  "capacidad": 40
}
{
  "nombre": "Cafetería",
  "ubicacion": "Entrada principal",
  "capacidad": 70
}
```
### 2. Propietarios
```json lines
{
  "nombre": "Juanin",
  "cedula": "0000000",
  "fecha_visita": "2025-01-01",
  "hora_entrada": "10:30:15",
  "reserva_zonas": [
    {
      "fecha": "2025-01-01",
      "hora_inicio": "10:30:05",
      "zona_social": {
        "id_zona": 6
      }
    }
  ],
  "visitantes": [
    {
      "nombre": "Mario Hugo",
      "cedula": "5555555",
      "telefono": "30241887",
      "correo": "mario@gmail.com"
    }
  ],
  "reserva_parqueadero": {
    "fecha": "2025-01-01",
    "hora_inicio": "10:30:05"
  }
}
{
  "nombre": "Tulio",
  "cedula": "11111111",
  "fecha_visita": "2025-02-02",
  "hora_entrada": "08:45:28",
  "reserva_zonas": [
    {
      "fecha": "2025-02-02",
      "hora_inicio": "10:30:05",
      "zona_social": {
        "id_zona": 7
      }
    }
  ],
  "visitantes": [
    {
      "nombre": "Marcela",
      "cedula": "66666666",
      "telefono": "30864413",
      "correo": "marcela@gmail.com"
    }
  ],
  "reserva_parqueadero": {
    "fecha": "2025-02-02",
    "hora_inicio": "10:30:05"
  }
}
{
  "nombre": "Rebeca",
  "cedula": "22222222",
  "fecha_visita": "2025-03-03",
  "hora_entrada": "14:00:44",
  "reserva_zonas": [
    {
      "fecha": "2025-03-03",
      "hora_inicio": "10:30:05",
      "zona_social": {
        "id_zona": 8
      }
    }
  ],
  "visitantes": [
    {
      "nombre": "Joaquin",
      "cedula": "777777",
      "telefono": "30155874",
      "correo": "joaquin@gmail.com"
    }
  ],
  "reserva_parqueadero": {
    "fecha": "2025-03-03",
    "hora_inicio": "10:30:05"
  }
}
{
  "nombre": "Bodoque",
  "cedula": "33333333",
  "fecha_visita": "2025-04-04",
  "hora_entrada": "06:10:58",
  "reserva_zonas": [
    {
      "fecha": "2025-04-04",
      "hora_inicio": "10:30:05",
      "zona_social": {
        "id_zona": 9
      }
    }
  ],
  "visitantes": [
    {
      "nombre": "Sergio",
      "cedula": "888888",
      "telefono": "30941658",
      "correo": "sergio@gmail.com"
    }
  ],
  "reserva_parqueadero": {
    "fecha": "2025-04-04",
    "hora_inicio": "10:30:05"
  }
}
{
  "nombre": "Patana",
  "cedula": "44444444",
  "fecha_visita": "2025-05-05",
  "hora_entrada": "19:28:00",
  "reserva_zonas": [
    {
      "fecha": "2025-05-05",
      "hora_inicio": "10:30:05",
      "zona_social": {
        "id_zona": 10
      }
    }
  ],
  "visitantes": [
    {
      "nombre": "Carmensa",
      "cedula": "9999999",
      "telefono": "3184586",
      "correo": "carmensa@gmail.com"
    }
  ],
  "reserva_parqueadero": {
    "fecha": "2025-05-05",
    "hora_inicio": "10:30:05"
  }
}
```
## Consultas
### 1. Mostrar propietario con visitante
Código:
En el metodo primero se trae una lista de propietarios que tienen al menos un visitante y se filtra la infomacion que se quiere devolver, en este caso solo se requiere el propietario y el visitante entonces se deja en null las reservas de zonas y de parqueadero de cada uno, para que al final solo devuelva lo necesario.
```java lines
@Query(value = "SELECT pp.* FROM propietario pp INNER JOIN visitante vs ON pp.id_propietario = vs.id_propietario", nativeQuery = true)
List<Propietario> PropietariosConVisitantes();

public List<Propietario> getPropietariosConVisitantes() {
    List<Propietario> propietarios = propietarioRepository.PropietariosConVisitantes();
    propietarios.forEach(p -> {
        p.setReserva_zonas(null);
        p.setReserva_parqueadero(null);
    });
    return propietarios;
}
    
@GetMapping("/visitantes")
public ResponseEntity<?> obtenerConVisitantes() {
    return ResponseEntity.ok(propietarioService.getPropietariosConVisitantes());
}
```

Respuesta:
```json
[
    {
        "id_propietario": 19,
        "nombre": "Juanin",
        "cedula": "0000000",
        "fecha_visita": "2025-01-01",
        "hora_entrada": "10:30:15",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 19,
                "nombre": "Mario Hugo",
                "cedula": "5555555",
                "telefono": "30241887",
                "correo": "mario@gmail.com"
            }
        ],
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 20,
        "nombre": "Tulio",
        "cedula": "11111111",
        "fecha_visita": "2025-02-02",
        "hora_entrada": "08:45:28",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 20,
                "nombre": "Marcela",
                "cedula": "66666666",
                "telefono": "30864413",
                "correo": "marcela@gmail.com"
            }
        ],
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 21,
        "nombre": "Rebeca",
        "cedula": "22222222",
        "fecha_visita": "2025-03-03",
        "hora_entrada": "14:00:44",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 21,
                "nombre": "Joaquin",
                "cedula": "777777",
                "telefono": "30155874",
                "correo": "joaquin@gmail.com"
            }
        ],
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 22,
        "nombre": "Bodoque",
        "cedula": "33333333",
        "fecha_visita": "2025-04-04",
        "hora_entrada": "06:10:58",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 22,
                "nombre": "Sergio",
                "cedula": "888888",
                "telefono": "30941658",
                "correo": "sergio@gmail.com"
            }
        ],
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 23,
        "nombre": "Patana",
        "cedula": "44444444",
        "fecha_visita": "2025-05-05",
        "hora_entrada": "19:28:00",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 23,
                "nombre": "Carmensa",
                "cedula": "9999999",
                "telefono": "3184586",
                "correo": "carmensa@gmail.com"
            }
        ],
        "reserva_parqueadero": null
    }
]
```
### 2. Mostrar propietario con reserva_parqueadero
Código: En este método se obtiene una lista de propietarios que tienen una reserva de parqueadero asociada. Como solo se quiere mostrar al propietario y su reserva de parqueadero, se limpia la información no necesaria, dejando en null los visitantes y las reservas de zona de cada propietario antes de devolver la respuesta.
```java lines
@Query(value = "SELECT pp.* FROM propietario pp INNER JOIN reserva_parqueadero rp ON pp.id_propietario = rp.id_propietario", nativeQuery = true)
List<Propietario> PropietariosConReservaParqueadero();

public List<Propietario> getPropietariosConReservaParqueadero() {
    List<Propietario> propietarios = propietarioRepository.PropietariosConReservaParqueadero();
    propietarios.forEach(p -> {
        p.setReserva_zonas(null);
        p.setVisitantes(null);
    });
    return propietarios;
}

@GetMapping("/rparqueadero")
public ResponseEntity<?> obtenerConReservaParqueadero() {
    return ResponseEntity.ok(propietarioService.getPropietariosConReservaParqueadero());
}
```
Respuesta:
```json
[
    {
        "id_propietario": 19,
        "nombre": "Juanin",
        "cedula": "0000000",
        "fecha_visita": "2025-01-01",
        "hora_entrada": "10:30:15",
        "reserva_zonas": null,
        "visitantes": null,
        "reserva_parqueadero": {
            "id_reserva": 19,
            "fecha": "2025-01-01",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 20,
        "nombre": "Tulio",
        "cedula": "11111111",
        "fecha_visita": "2025-02-02",
        "hora_entrada": "08:45:28",
        "reserva_zonas": null,
        "visitantes": null,
        "reserva_parqueadero": {
            "id_reserva": 20,
            "fecha": "2025-02-02",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 21,
        "nombre": "Rebeca",
        "cedula": "22222222",
        "fecha_visita": "2025-03-03",
        "hora_entrada": "14:00:44",
        "reserva_zonas": null,
        "visitantes": null,
        "reserva_parqueadero": {
            "id_reserva": 21,
            "fecha": "2025-03-03",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 22,
        "nombre": "Bodoque",
        "cedula": "33333333",
        "fecha_visita": "2025-04-04",
        "hora_entrada": "06:10:58",
        "reserva_zonas": null,
        "visitantes": null,
        "reserva_parqueadero": {
            "id_reserva": 22,
            "fecha": "2025-04-04",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 23,
        "nombre": "Patana",
        "cedula": "44444444",
        "fecha_visita": "2025-05-05",
        "hora_entrada": "19:28:00",
        "reserva_zonas": null,
        "visitantes": null,
        "reserva_parqueadero": {
            "id_reserva": 23,
            "fecha": "2025-05-05",
            "hora_inicio": "10:30:05"
        }
    }
]
```
### 3. Mostrar propietario con reserva_zona
Código: Este método obtiene los propietarios que tienen al menos una reserva en una zona social. Para simplificar la salida y evitar datos innecesarios, se asignan null tanto a los visitantes como a las reservas de parqueadero, ya que el enfoque está solo en el propietario y sus reservas de zona.
```java lines
@Query(value = "SELECT pp.* FROM propietario pp INNER JOIN reserva_zona rz ON pp.id_propietario = rz.id_propietario", nativeQuery = true)
List<Propietario> PropietariosConReservaZona();

public List<Propietario> getPropietariosConReservaZona() {
    List<Propietario> propietarios = propietarioRepository.PropietariosConReservaZona();
    propietarios.forEach(p -> {
        p.setVisitantes(null);
        p.setReserva_parqueadero(null);
    });
    return propietarios;
}

@GetMapping("/rzona")
public ResponseEntity<?> obtenerConReservaZona() {
    return ResponseEntity.ok(propietarioService.getPropietariosConReservaZona());
}
```
Respuesta:
```json
[
    {
        "id_propietario": 19,
        "nombre": "Juanin",
        "cedula": "0000000",
        "fecha_visita": "2025-01-01",
        "hora_entrada": "10:30:15",
        "reserva_zonas": [
            {
                "id_reserva": 19,
                "fecha": "2025-01-01",
                "hora_inicio": "10:30:05",
                "zona_social": {
                    "id_zona": 6,
                    "nombre": "Zona BBQ",
                    "ubicacion": "Zona verde junto al parque infantil",
                    "capacidad": 30
                }
            }
        ],
        "visitantes": null,
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 20,
        "nombre": "Tulio",
        "cedula": "11111111",
        "fecha_visita": "2025-02-02",
        "hora_entrada": "08:45:28",
        "reserva_zonas": [
            {
                "id_reserva": 20,
                "fecha": "2025-02-02",
                "hora_inicio": "10:30:05",
                "zona_social": {
                    "id_zona": 7,
                    "nombre": "Piscina",
                    "ubicacion": "Nivel 3 - Área recreativa externa",
                    "capacidad": 25
                }
            }
        ],
        "visitantes": null,
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 21,
        "nombre": "Rebeca",
        "cedula": "22222222",
        "fecha_visita": "2025-03-03",
        "hora_entrada": "14:00:44",
        "reserva_zonas": [
            {
                "id_reserva": 21,
                "fecha": "2025-03-03",
                "hora_inicio": "10:30:05",
                "zona_social": {
                    "id_zona": 8,
                    "nombre": "Gimnasio",
                    "ubicacion": "Nivel 2 - Área deportiva",
                    "capacidad": 50
                }
            }
        ],
        "visitantes": null,
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 22,
        "nombre": "Bodoque",
        "cedula": "33333333",
        "fecha_visita": "2025-04-04",
        "hora_entrada": "06:10:58",
        "reserva_zonas": [
            {
                "id_reserva": 22,
                "fecha": "2025-04-04",
                "hora_inicio": "10:30:05",
                "zona_social": {
                    "id_zona": 9,
                    "nombre": "Spa",
                    "ubicacion": "Torre 3 - Segundo piso",
                    "capacidad": 40
                }
            }
        ],
        "visitantes": null,
        "reserva_parqueadero": null
    },
    {
        "id_propietario": 23,
        "nombre": "Patana",
        "cedula": "44444444",
        "fecha_visita": "2025-05-05",
        "hora_entrada": "19:28:00",
        "reserva_zonas": [
            {
                "id_reserva": 23,
                "fecha": "2025-05-05",
                "hora_inicio": "10:30:05",
                "zona_social": {
                    "id_zona": 10,
                    "nombre": "Cafetería",
                    "ubicacion": "Entrada principal",
                    "capacidad": 70
                }
            }
        ],
        "visitantes": null,
        "reserva_parqueadero": null
    }
]
```
### 4. Mostrar propietario con visitante y reserva_ parqueadero
Código: En este metodo se listan propietarios que tienen tanto visitantes como una reserva de parqueadero. Para reducir la información se eliminan las reservas de zona de cada propietario asignándoles null, ya que solo se necesita mostrar el propietario, sus visitantes y su reserva de parqueadero.
```java lines
@Query(value = "SELECT pp.* FROM propietario pp INNER JOIN visitante vs ON pp.id_propietario = vs.id_propietario INNER JOIN reserva_parqueadero rp ON pp.id_propietario = rp.id_propietario", nativeQuery = true)
List<Propietario> PropietariosConVisitanteYParqueadero();

public List<Propietario> getPropietariosConVisitanteYParqueadero() {
    List<Propietario> propietarios = propietarioRepository.PropietariosConVisitanteYParqueadero();
    propietarios.forEach(p -> {
        p.setReserva_zonas(null);
    });
    return propietarios;
}

@GetMapping("/visitanteRparqueadero")
public ResponseEntity<?> obtenerConVisitantesYParqueadero() {
    return ResponseEntity.ok(propietarioService.getPropietariosConVisitanteYParqueadero());
}
```
Respuesta:
```json
[
    {
        "id_propietario": 21,
        "nombre": "Rebeca",
        "cedula": "22222222",
        "fecha_visita": "2025-03-03",
        "hora_entrada": "14:00:44",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 21,
                "nombre": "Joaquin",
                "cedula": "777777",
                "telefono": "30155874",
                "correo": "joaquin@gmail.com"
            }
        ],
        "reserva_parqueadero": {
            "id_reserva": 21,
            "fecha": "2025-03-03",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 22,
        "nombre": "Bodoque",
        "cedula": "33333333",
        "fecha_visita": "2025-04-04",
        "hora_entrada": "06:10:58",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 22,
                "nombre": "Sergio",
                "cedula": "888888",
                "telefono": "30941658",
                "correo": "sergio@gmail.com"
            }
        ],
        "reserva_parqueadero": {
            "id_reserva": 22,
            "fecha": "2025-04-04",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 20,
        "nombre": "Tulio",
        "cedula": "11111111",
        "fecha_visita": "2025-02-02",
        "hora_entrada": "08:45:28",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 20,
                "nombre": "Marcela",
                "cedula": "66666666",
                "telefono": "30864413",
                "correo": "marcela@gmail.com"
            }
        ],
        "reserva_parqueadero": {
            "id_reserva": 20,
            "fecha": "2025-02-02",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 19,
        "nombre": "Juanin",
        "cedula": "0000000",
        "fecha_visita": "2025-01-01",
        "hora_entrada": "10:30:15",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 19,
                "nombre": "Mario Hugo",
                "cedula": "5555555",
                "telefono": "30241887",
                "correo": "mario@gmail.com"
            }
        ],
        "reserva_parqueadero": {
            "id_reserva": 19,
            "fecha": "2025-01-01",
            "hora_inicio": "10:30:05"
        }
    },
    {
        "id_propietario": 23,
        "nombre": "Patana",
        "cedula": "44444444",
        "fecha_visita": "2025-05-05",
        "hora_entrada": "19:28:00",
        "reserva_zonas": null,
        "visitantes": [
            {
                "id_visitante": 23,
                "nombre": "Carmensa",
                "cedula": "9999999",
                "telefono": "3184586",
                "correo": "carmensa@gmail.com"
            }
        ],
        "reserva_parqueadero": {
            "id_reserva": 23,
            "fecha": "2025-05-05",
            "hora_inicio": "10:30:05"
        }
    }
]
```
