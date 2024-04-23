package com.proyectojwt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_detalle_boleta")
public class DetalleBoleta {
    @EmbeddedId
    private DetalleBoletaPK pk;

    @ManyToOne
    @JoinColumn(name="id_boleta",referencedColumnName = "id",insertable = false,updatable =false)
    private Boleta boleta;//ASOCI.

    //Relación MUCHOS  a UNO "Boleta"
    @ManyToOne
    @JoinColumn(name="id_producto",referencedColumnName = "codigo_ele",insertable = false,updatable =false)
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;


}
