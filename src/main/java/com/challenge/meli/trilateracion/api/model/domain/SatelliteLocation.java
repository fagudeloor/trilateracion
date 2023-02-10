package com.challenge.meli.trilateracion.api.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(exclude = {"satellite"})
@Entity
public class SatelliteLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double positionX, positionY;
    private Date dateCreated;

    @ManyToOne
    private Satellite satellite;

    @PrePersist
    public void updateTimeStamps() {
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}
