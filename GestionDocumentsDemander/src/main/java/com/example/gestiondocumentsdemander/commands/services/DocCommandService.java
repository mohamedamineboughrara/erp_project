package com.example.gestiondocumentsdemander.commands.services;

import com.example.gestiondocumentsdemander.commands.dtos.DocRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface DocCommandService {
    CompletableFuture<String> createDoc(DocRequestDTO docRequestDTO);
    CompletableFuture<String> updateDoc(DocRequestDTO docRequestDTO);
    CompletableFuture<String> uploadedDoc(DocRequestDTO docRequestDTO);
}
