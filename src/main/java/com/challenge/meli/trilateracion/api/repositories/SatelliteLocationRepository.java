package com.challenge.meli.trilateracion.api.repositories;

import com.challenge.meli.trilateracion.api.model.domain.Satellite;
import com.challenge.meli.trilateracion.api.model.domain.SatelliteLocation;
import com.challenge.meli.trilateracion.api.model.dto.LocationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SatelliteLocationRepository extends JpaRepository<SatelliteLocation, Long> {

    @Query("Select sl from SatelliteLocation sl where sl.id = (select max(s.id) from SatelliteLocation s join s.satellite where s.satellite = ?1)")
    public SatelliteLocation findLocation(Satellite satellite);
}
