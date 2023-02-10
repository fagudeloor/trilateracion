package com.challenge.meli.trilateracion.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalledHelpSatellitesDTO {

    private List<CalledHelpSatelliteDTO> satellites;
}
