package org.oga.gestioncras.queries.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.oga.gestioncras.enums.CRAsStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCRAsByStatusQueryDTO {
    private CRAsStatus status;
}

