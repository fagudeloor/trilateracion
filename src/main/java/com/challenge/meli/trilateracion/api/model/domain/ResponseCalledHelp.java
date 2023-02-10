package com.challenge.meli.trilateracion.api.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(exclude = {"satellite"})
@Entity
public class ResponseCalledHelp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double positionX, positionY;
    private String message;
    private Date dateCreated;

    @PrePersist
    public void updateTimeStamps() {
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }

}
