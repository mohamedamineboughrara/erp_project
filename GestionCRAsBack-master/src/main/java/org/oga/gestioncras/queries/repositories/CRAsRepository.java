package org.oga.gestioncras.queries.repositories;

import org.oga.gestioncras.queries.entities.CRAs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CRAsRepository extends JpaRepository<CRAs,String> {
    @Query("SELECT c FROM CRAs c WHERE c.status = 'ON_HOLD' OR c.status = 'UPDATED'")
    List<CRAs> findByStatus();
}
