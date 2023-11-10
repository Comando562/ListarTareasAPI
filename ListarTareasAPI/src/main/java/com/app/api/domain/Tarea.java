package com.app.api.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Tarea")
@Data
@Table(name="tarea")
@AllArgsConstructor
@ToString
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name="titulo")
    private String titulo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="Fecha")
    private Date Fecha;
    private boolean completado;

    public Tarea() {

    }
}
