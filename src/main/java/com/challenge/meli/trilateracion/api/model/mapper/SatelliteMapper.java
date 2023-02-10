package com.challenge.meli.trilateracion.api.model.mapper;

import com.challenge.meli.trilateracion.api.model.domain.Satellite;
import com.challenge.meli.trilateracion.api.model.dto.SatelliteLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SatelliteMapper {

    SatelliteMapper INSTANCE = Mappers.getMapper(SatelliteMapper.class);

    SatelliteLocationDTO satelliteToSatelliteDto(Satellite satellite);

    Satellite satelliteDtoToSatellite(SatelliteLocationDTO satelliteDTO);
}
