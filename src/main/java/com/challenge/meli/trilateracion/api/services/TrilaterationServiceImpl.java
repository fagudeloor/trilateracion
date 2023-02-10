package com.challenge.meli.trilateracion.api.services;


import com.challenge.meli.trilateracion.api.model.domain.*;
import com.challenge.meli.trilateracion.api.model.dto.*;
import com.challenge.meli.trilateracion.api.model.mapper.CalledHelpMapper;
import com.challenge.meli.trilateracion.api.model.mapper.CalledHelpSatelliteMapper;
import com.challenge.meli.trilateracion.api.model.mapper.SatelliteMapper;
import com.challenge.meli.trilateracion.api.operation.ComputeTrilateration;
import com.challenge.meli.trilateracion.api.repositories.CalledHelpRepository;
import com.challenge.meli.trilateracion.api.repositories.ResponseCalledHelpRepository;
import com.challenge.meli.trilateracion.api.repositories.SatelliteLocationRepository;
import com.challenge.meli.trilateracion.api.repositories.SatelliteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrilaterationServiceImpl implements TrilaterationService{

    private final CalledHelpSatelliteMapper calledHelpSatelliteMapper;
    private final SatelliteMapper satelliteMapper;
    private final CalledHelpMapper calledHelpMapper;
    private final CalledHelpRepository calledHelpService;
    private final SatelliteRepository satelliteRepository;
    private final ResponseCalledHelpRepository responseCalledHelpRepository;
    private final SatelliteLocationRepository satelliteLocationRepository;
    private final TrilaterationSatelliteService trilaterationSatelliteService;

    public TrilaterationServiceImpl(CalledHelpSatelliteMapper calledHelpSatelliteMapper, SatelliteMapper satelliteMapper,
                                    CalledHelpMapper calledHelpMapper, CalledHelpRepository calledHelpService,
                                    SatelliteRepository satelliteRepository,
                                    ResponseCalledHelpRepository responseCalledHelpRepository,
                                    SatelliteLocationRepository satelliteLocationRepository, TrilaterationSatelliteService trilaterationSatelliteService) {
        this.calledHelpSatelliteMapper = calledHelpSatelliteMapper;
        this.satelliteMapper = satelliteMapper;
        this.calledHelpMapper = calledHelpMapper;
        this.calledHelpService = calledHelpService;
        this.satelliteRepository = satelliteRepository;
        this.responseCalledHelpRepository = responseCalledHelpRepository;
        this.satelliteLocationRepository = satelliteLocationRepository;
        this.trilaterationSatelliteService = trilaterationSatelliteService;
    }


    //Este método recibe la petición del controler con los datos de un satelites y la almacena en la BD
    @Override
    public CalledHelpDTO createNewCalledHelp(CalledHelpDTO calledHelpDTO, String satelliteName) {
        Satellite satellite = satelliteRepository.getByName(satelliteName);
        CalledHelp calledHelp = calledHelpMapper.calledHelpDtoToCalledHelp(calledHelpDTO);
        calledHelp.setSatellite(satellite);
        return saveCallHelp(calledHelp, Status.UNPROCESSED);
    }

    //Este método recibe la petición del controler con los datos de los 3 satelites y devuelve la localización
    @Override
    public MainResponseDTO createNewCalledHelp(CalledHelpSatellitesDTO calledHelpSatellitesDTO) {
        saveCallHelps(calledHelpSatellitesDTO);
        MainResponseDTO mainResponseDTO = ComputeTrilateration.computeTrilateration(calledHelpSatellitesDTO,
                trilaterationSatelliteService.fetchSatellitesLocation());
        saveResponseCalledHelp(mainResponseDTO);
        return mainResponseDTO;
    }

    //Devuelve la úbicación dada por los satelites anticipadamente
    @Override
    public MainResponseDTO getCalledHelp() {

        MainResponseDTO mainResponseDTO = ComputeTrilateration.computeTrilateration(getAllCalledHelpSatellites(),
                trilaterationSatelliteService.fetchSatellitesLocation());
        saveResponseCalledHelp(mainResponseDTO);
        return mainResponseDTO;
    }

    private CalledHelpDTO saveCallHelp(CalledHelp calledHelp, Status status) {
        calledHelp.setStatus(status);
        CalledHelp savedCalledHelp = calledHelpService.save(calledHelp);
        CalledHelpDTO returnCalledHelpDto = calledHelpMapper.calledHelpToCalledHelpDto(savedCalledHelp);

        return returnCalledHelpDto;
    }

    private void saveCallHelps(CalledHelpSatellitesDTO satellites) {
        satellites.getSatellites().forEach(calledHelpSatelliteDTO ->
                saveCallHelp(calledHelpSatelliteMapper.calledHelpSatelliteDtoMapperToCalledHelp(calledHelpSatelliteDTO),
                        Status.PROCESSED));
    }


    private CalledHelpSatellitesDTO getAllCalledHelpSatellites() {
        List<Satellite> satellites = satelliteRepository.findAll();

        List<CalledHelpSatelliteDTO> calledHelpSatelliteDTOs = new ArrayList<>();
        for(Satellite satellite : satellites){
            CalledHelp calledHelp = calledHelpService.getCalledHelpUnprocessed(satellite.getName());
            calledHelpService.updateStatus(calledHelp, Status.PROCESSED);
            CalledHelpSatelliteDTO calledHelpSatelliteDTO =
                    calledHelpSatelliteMapper.calledHelpToCalledHelpSatelliteMapperDto(calledHelp);
            calledHelpSatelliteDTOs.add(calledHelpSatelliteDTO);
        }
        CalledHelpSatellitesDTO calledHelpSatellitesDTO = new CalledHelpSatellitesDTO();
        calledHelpSatellitesDTO.setSatellites(calledHelpSatelliteDTOs);
        return calledHelpSatellitesDTO;
    }

    private void saveResponseCalledHelp(MainResponseDTO mainResponseDTO) {
        ResponseCalledHelp responseCalledHelp = new ResponseCalledHelp();
        responseCalledHelp.setPositionX(mainResponseDTO.getLocationDTO().getPositionX());
        responseCalledHelp.setPositionY(mainResponseDTO.getLocationDTO().getPositionY());
        responseCalledHelp.setMessage(mainResponseDTO.getMessage());
        responseCalledHelpRepository.save(responseCalledHelp);
    }

}
