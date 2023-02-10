package com.challenge.meli.trilateracion.api.services;

import com.challenge.meli.trilateracion.api.model.domain.Satellite;
import com.challenge.meli.trilateracion.api.model.domain.SatelliteLocation;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationDTO;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationsDTO;
import com.challenge.meli.trilateracion.api.model.mapper.SatelliteLocationMapper;
import com.challenge.meli.trilateracion.api.model.mapper.SatelliteMapper;
import com.challenge.meli.trilateracion.api.repositories.SatelliteLocationRepository;
import com.challenge.meli.trilateracion.api.repositories.SatelliteRepository;
import com.challenge.meli.trilateracion.api.services.dto.SatelliteDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrilaterationSatelliteServiceImpl implements TrilaterationSatelliteService {

    private final SatelliteRepository satelliteRepository;
    private final SatelliteDtoService satelliteDtoService;
    private final SatelliteLocationRepository satelliteLocationRepository;
    private final SatelliteLocationMapper satelliteLocationMapper;
    private final SatelliteMapper satelliteMapper;


    public TrilaterationSatelliteServiceImpl(SatelliteDtoService satelliteDtoService,
                                             SatelliteLocationRepository satelliteLocationRepository,
                                             SatelliteMapper satelliteMapper, SatelliteRepository satelliteRepository, SatelliteLocationMapper satelliteLocationMapper,
                                             SatelliteMapper satelliteMapper1) {
        this.satelliteDtoService = satelliteDtoService;
        this.satelliteLocationRepository = satelliteLocationRepository;
        this.satelliteRepository = satelliteRepository;
        this.satelliteLocationMapper = satelliteLocationMapper;
        this.satelliteMapper = satelliteMapper1;
    }

    @Override
    public void saveSatelliteLocation(SatelliteLocationsDTO satelliteLocationsDTO) {
        for (SatelliteLocationDTO satelliteLocationDTO:satelliteLocationsDTO.getSatellitesLocation()){

            Satellite satellite = satelliteMapper.satelliteDtoToSatellite(satelliteLocationDTO);
            Satellite savedSatellite = satelliteDtoService.save(satellite);

            SatelliteLocation satelliteLocation = satelliteLocationMapper.
                    satelliteLocationDTOTOSatelliteLocation(satelliteLocationDTO);
            satelliteLocation.setSatellite(savedSatellite);
            SatelliteLocation satelliteLocationSaved = satelliteLocationRepository.save(satelliteLocation);
        }
    }

    @Override
    public SatelliteLocationsDTO fetchSatellitesLocation() {
        List<Satellite> allSatellites = satelliteRepository.findAll();
        List<SatelliteLocationDTO> satelliteLocationDTOS = new ArrayList<>();
        for(Satellite satellite: allSatellites){
            SatelliteLocation satelliteLocation = satelliteLocationRepository.findLocation(satellite);
            SatelliteLocationDTO satelliteLocationDTO = new SatelliteLocationDTO();
            satelliteLocationDTO.setPositionX(satelliteLocation.getPositionX());
            satelliteLocationDTO.setPositionY(satelliteLocation.getPositionY());
            satelliteLocationDTO.setName(satellite.getName());
            satelliteLocationDTOS.add(satelliteLocationDTO);
        }
        SatelliteLocationsDTO satelliteLocationsDTO = new SatelliteLocationsDTO(satelliteLocationDTOS);
        return satelliteLocationsDTO;
    }

}
