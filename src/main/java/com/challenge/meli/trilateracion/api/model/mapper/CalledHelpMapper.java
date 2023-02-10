package com.challenge.meli.trilateracion.api.model.mapper;

import com.challenge.meli.trilateracion.api.model.domain.CalledHelp;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalledHelpMapper {

    CalledHelpMapper INSTANCE = Mappers.getMapper(CalledHelpMapper.class);

    CalledHelpDTO calledHelpToCalledHelpDto(CalledHelp calledHelp);

    CalledHelp calledHelpDtoToCalledHelp(CalledHelpDTO calledHelpDTO);
}
