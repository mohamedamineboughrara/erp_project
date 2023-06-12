package com.example.gestiondocumentsdemander.mappers;


import com.example.gestiondocumentsdemander.queries.dtos.DocResponseDTO;
import com.example.gestiondocumentsdemander.queries.entities.DocDemander;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DocMapper {
    DocResponseDTO DocToDocDTO(DocDemander docDemander);
}
