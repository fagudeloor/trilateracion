package com.challenge.meli.trilateracion.api.model.mapper;

import com.challenge.meli.trilateracion.api.model.domain.CalledHelp;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpSatelliteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalledHelpSatelliteMapper {

    CalledHelpSatelliteMapper INSTANCE = Mappers.getMapper(CalledHelpSatelliteMapper.class);

    CalledHelpSatelliteDTO calledHelpToCalledHelpSatelliteMapperDto(CalledHelp calledHelp);

    CalledHelp calledHelpSatelliteDtoMapperToCalledHelp(CalledHelpSatelliteDTO calledHelpSatelliteDTO);

}
