package org.oga.gestioncras.commands.services;

import org.oga.gestioncras.commands.dtos.CRAsRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface CRAsCommandService {
    CompletableFuture<String> createCRAs(CRAsRequestDTO crAsRequestDTO);
    CompletableFuture<String> updateCRAs(CRAsRequestDTO crAsRequestDTO);
    CompletableFuture<String> deleteCRAs(String craId);
    CompletableFuture<String> confirmCRAs(CRAsRequestDTO crAsRequestDTO);
    CompletableFuture<String> rejectedCRAs(CRAsRequestDTO crAsRequestDTO);

}
