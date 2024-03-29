package com.example.Prueba.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "telefonos")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String citycode;
    private String countrycode;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    // Getters y setters
}
