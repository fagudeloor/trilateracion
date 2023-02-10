package com.challenge.meli.trilateracion.api.controller;

import com.challenge.meli.trilateracion.api.Constants;
import com.challenge.meli.trilateracion.api.model.dto.CalledHelpDTO;
import com.challenge.meli.trilateracion.api.model.dto.MainResponseDTO;
import com.challenge.meli.trilateracion.api.services.TrilaterationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.TRILATERATION_CONTROLLER_TOPSECRET_SLIPT)
public class TrilaterationSplitController {

    private final TrilaterationService trilaterationService;

    public TrilaterationSplitController(TrilaterationService trilaterationService) {
        this.trilaterationService = trilaterationService;
    }

    @PostMapping(Constants.TRILATERATION_CONTROLLER_KENOBI)
    public ResponseEntity<CalledHelpDTO> createNewCalledHelpKenobi(@RequestBody CalledHelpDTO calledHelpDTO){
        return new ResponseEntity<CalledHelpDTO>(
                trilaterationService.createNewCalledHelp(calledHelpDTO, Constants.KENOBI), HttpStatus.CREATED
        );
    }

    @PostMapping(Constants.TRILATERATION_CONTROLLER_SKYWALKER)
    public ResponseEntity<CalledHelpDTO> createNewCalledHelpSkylwaker(@RequestBody CalledHelpDTO calledHelpDTO){
        return new ResponseEntity<CalledHelpDTO>(
                trilaterationService.createNewCalledHelp(calledHelpDTO, Constants.SKYWALKER), HttpStatus.CREATED
        );
    }

    @PostMapping(Constants.TRILATERATION_CONTROLLER_SATO)
    public ResponseEntity<CalledHelpDTO> createNewCalledHelpSato(@RequestBody CalledHelpDTO calledHelpDTO){
        return new ResponseEntity<CalledHelpDTO>(
                trilaterationService.createNewCalledHelp(calledHelpDTO, Constants.SATO), HttpStatus.CREATED
        );
    }

    @GetMapping(Constants.SLASH)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MainResponseDTO> getResponseSplit(){
        return new ResponseEntity<MainResponseDTO>(trilaterationService.getCalledHelp(), HttpStatus.OK);
    }

}
