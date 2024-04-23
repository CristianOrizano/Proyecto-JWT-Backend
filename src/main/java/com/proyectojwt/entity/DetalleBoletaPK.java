package com.proyectojwt.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

// cuando tienes una clave primaria compuesta,
// necesitas definir una clase incrustada que represente esa clave primaria.
// Esta clase debe ser serializable para que pueda ser usada correctamente por el motor de persistencia de JPA.
@Data
public class DetalleBoletaPK implements Serializable {
    @Column(name = "id_boleta")
    private int idBoleta;

    @Column(name = "id_producto")
    private int idProducto;
}
//las clases incrustadas que representan claves primarias compuestas se requiere q sean serializables.
// Esto es necesario para que puedan ser utilizadas correctamente en el proceso de persistencia de JPA.