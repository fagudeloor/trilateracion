package com.challenge.meli.trilateracion.api.services;

import com.challenge.meli.trilateracion.api.model.dto.CalledHelpDTO;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatellitesDTO;
import com.challenge.meli.trilateracion.api.model.dto.MainResponseDTO;

public interface TrilaterationService {

    CalledHelpDTO createNewCalledHelp(CalledHelpDTO calledHelpDTO, String satelliteName);

    MainResponseDTO getCalledHelp();

    MainResponseDTO createNewCalledHelp(CalledHelpSatellitesDTO satellites);

}
