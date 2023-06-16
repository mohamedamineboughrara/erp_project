package org.oga.gestioncras.mappers;

import org.oga.gestioncras.queries.dtos.CRAsResponseDTO;
import org.oga.gestioncras.queries.entities.CRAs;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T00:01:46+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Private Build)"
)
*/
@Component
public class CRAsMapperImpl implements CRAsMapper {

    @Override
    public CRAsResponseDTO CRAsToCRAsDTO(CRAs crAs) {
        if ( crAs == null ) {
            return null;
        }

        CRAsResponseDTO cRAsResponseDTO = new CRAsResponseDTO();

        cRAsResponseDTO.setTimeSpent( crAs.getTimeSpent() );
        cRAsResponseDTO.setDescription( crAs.getDescription() );
        cRAsResponseDTO.setStartDate( crAs.getStartDate() );
        cRAsResponseDTO.setEndDate( crAs.getEndDate() );
        cRAsResponseDTO.setIdProject( crAs.getIdProject() );
        cRAsResponseDTO.setIdResponsible( crAs.getIdResponsible() );
        cRAsResponseDTO.setIdCollaborator( crAs.getIdCollaborator() );
        cRAsResponseDTO.setComment( crAs.getComment() );
        cRAsResponseDTO.setProductivity( crAs.getProductivity() );
        cRAsResponseDTO.setStatus( crAs.getStatus() );

        return cRAsResponseDTO;
    }
}
