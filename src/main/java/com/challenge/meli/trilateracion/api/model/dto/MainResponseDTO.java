package com.challenge.meli.trilateracion.api.model.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainResponseDTO {

    private LocationDTO locationDTO;
    private String message;

}
