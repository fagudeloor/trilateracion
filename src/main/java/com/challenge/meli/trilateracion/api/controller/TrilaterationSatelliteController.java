package com.challenge.meli.trilateracion.api.controller;


import com.challenge.meli.trilateracion.api.Constants;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;
import com.challenge.meli.trilateracion.api.services.TrilaterationSatelliteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.SATELLITE_CONTROLLER_BASE_URL)
public class TrilaterationSatelliteController {

    private final TrilaterationSatelliteService trilaterationSatelliteService;

    public TrilaterationSatelliteController(TrilaterationSatelliteService trilaterationSatelliteService) {
        this.trilaterationSatelliteService = trilaterationSatelliteService;
    }


    @PostMapping(Constants.SATELLITE_SAVE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSatelliteLocation(@RequestBody SatelliteLocationsDTO satelliteLocationsDTO){
        trilaterationSatelliteService.saveSatelliteLocation(satelliteLocationsDTO);
    }

    @GetMapping(Constants.SATELLITE_GET)
    public ResponseEntity<SatelliteLocationsDTO> fetchSatellitesLocation(){
        return new ResponseEntity<SatelliteLocationsDTO>(trilaterationSatelliteService.fetchSatellitesLocation(), HttpStatus.OK);
    }

}
