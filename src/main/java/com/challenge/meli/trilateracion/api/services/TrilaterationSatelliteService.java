package com.challenge.meli.trilateracion.api.services;

import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;

public interface TrilaterationSatelliteService {

    public void saveSatelliteLocation(SatelliteLocationsDTO satelliteLocationsDTO);

    public SatelliteLocationsDTO fetchSatellitesLocation();
}
