package com.challenge.meli.trilateracion.api.model.mapper;

import com.challenge.meli.trilateracion.api.model.domain.SatelliteLocation;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SatelliteLocationMapper {

    SatelliteMapper INSTANCE = Mappers.getMapper(SatelliteMapper.class);

    SatelliteLocationDTO satelliteLocationTOSatelliteLocationDTO(SatelliteLocation satelliteLocation);

    SatelliteLocation satelliteLocationDTOTOSatelliteLocation(SatelliteLocationDTO satelliteLocationDTO);
}
