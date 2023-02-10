package com.challenge.meli.trilateracion.api.controller;


import com.challenge.meli.trilateracion.api.Constants;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatellitesDTO;
import com.challenge.meli.trilateracion.api.model.dto.MainResponseDTO;
import com.challenge.meli.trilateracion.api.services.TrilaterationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.TRILATERATION_CONTROLLER_BASE_URL)
public class TrilaterationController {


    private final TrilaterationService trilaterationService;

    public TrilaterationController(TrilaterationService trilaterationService) {
        this.trilaterationService = trilaterationService;
    }

    @PostMapping(Constants.SLASH)
    public ResponseEntity<MainResponseDTO> createNewCalledHelp(@RequestBody CalledHelpSatellitesDTO calledHelpSatellitesDTO){
        return new ResponseEntity<MainResponseDTO>(
                trilaterationService.createNewCalledHelp(calledHelpSatellitesDTO), HttpStatus.CREATED
        );
    }
}
