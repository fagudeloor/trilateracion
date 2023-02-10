package com.challenge.meli.trilateracion.api.repositories;

import com.challenge.meli.trilateracion.api.model.domain.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

    @Query("Select S from Satellite S where S.name = ?1")
    Satellite getByName(String name);

}
