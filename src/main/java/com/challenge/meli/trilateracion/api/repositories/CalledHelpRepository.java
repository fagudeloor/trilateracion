package com.challenge.meli.trilateracion.api.repositories;

import com.challenge.meli.trilateracion.api.model.domain.CalledHelp;
import com.challenge.meli.trilateracion.api.model.domain.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CalledHelpRepository extends JpaRepository<CalledHelp, Long> {

    @Query ("Select CH from CalledHelp CH where CH.id = " +
            "(SELECT MAX(c.id) from CalledHelp c join c.satellite s where s.name = ?1 and c.status = 1)")
    CalledHelp getCalledHelpUnprocessed(String name);

    @Modifying
    @Transactional
    @Query("UPDATE CalledHelp CH set CH.status = ?2 where CH = ?1")
    void updateStatus(CalledHelp calledHelp, Status status);
}
