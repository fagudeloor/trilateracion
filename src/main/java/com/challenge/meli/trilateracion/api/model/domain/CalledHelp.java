package com.challenge.meli.trilateracion.api.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class CalledHelp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double distance;
    private String[] message;
    private Status status;

    @ManyToOne
    private Satellite satellite;

}
