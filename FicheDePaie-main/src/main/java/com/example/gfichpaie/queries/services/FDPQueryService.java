package com.example.gfichpaie.queries.services;

import com.example.gfichpaie.events.FicheDePaieCreatedEvent;
import com.example.gfichpaie.events.FicheDePaieUpdatedEvent;
import com.example.gfichpaie.queries.dtos.GetAllFDPQueryDTO;
import com.example.gfichpaie.queries.entities.FDP;
import com.example.gfichpaie.queries.repositories.FDPRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import com.example.gfichpaie.queries.dtos.GetFdpUser;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FDPQueryService {
    private final FDPRepository fdpRepository;

    @EventHandler
    public void on(FicheDePaieCreatedEvent ficheDePaieCreatedEvent){

        log.info("FDPCreatedEventRecieved");
        FDP fdp=new FDP();
        fdp.setFicheId(ficheDePaieCreatedEvent.getId());
        fdp.setUserName(ficheDePaieCreatedEvent.getUserName());
        fdp.setDate(ficheDePaieCreatedEvent.getDate());
        fdp.setSalaireBrut(ficheDePaieCreatedEvent.getSalaireBrut());
        fdp.setImpots(ficheDePaieCreatedEvent.getImpots());
        fdp.setIdCollaborator(ficheDePaieCreatedEvent.getIdCollaborator());
        fdp.setSalaireNet(ficheDePaieCreatedEvent.getSalaireNet());

        fdp.setChargeSociale(ficheDePaieCreatedEvent.getChargeSociale());
        fdp.setPrime(ficheDePaieCreatedEvent.getPrime());
        fdp.setTjm(ficheDePaieCreatedEvent.getTjm());
        fdp.setStatus(ficheDePaieCreatedEvent.getStatus());

        fdpRepository.save(fdp);
    }
    @EventHandler
    public void on(FicheDePaieUpdatedEvent event) {
        log.info("FDPUpdatedEventReceived");
        Optional<FDP> optionalFdp = fdpRepository.findById(event.getId());
        optionalFdp.ifPresent(fdp -> {
            fdp.setUserName(event.getUserName());
            fdp.setDate(event.getDate());
            fdp.setSalaireBrut(event.getSalaireBrut());
            fdp.setImpots(event.getImpots());
            fdp.setSalaireNet(event.getSalaireNet());
            fdp.setIdCollaborator(event.getIdCollaborator());
            fdp.setChargeSociale(event.getChargeSociale());
            fdp.setPrime(event.getPrime());
            fdp.setTjm(event.getTjm());
            fdp.setStatus(event.getStatus());
            fdpRepository.save(fdp);
        });
    }


    @QueryHandler
    public FDP on (GetFdpUser query) {
        return fdpRepository.findByUserName(query.getUserName());
    }

    @QueryHandler
    public List<FDP> on(GetAllFDPQueryDTO getAllRequestDTO) {
        return fdpRepository.findAll();
    }
}
