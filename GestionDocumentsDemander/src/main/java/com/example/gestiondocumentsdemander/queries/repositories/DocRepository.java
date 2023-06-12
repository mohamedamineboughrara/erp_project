package com.example.gestiondocumentsdemander.queries.repositories;

import com.example.gestiondocumentsdemander.queries.entities.DocDemander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface DocRepository extends JpaRepository<DocDemander,String> {
    @Query("SELECT c FROM DocDemander c WHERE c.status = 'ON_HOLD' or c.status ='UPDATED'")
    List<DocDemander> findByStatus();
}
