package com.example.gestiondocumentsdemander.queries.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import com.example.gestiondocumentsdemander.enums.DocStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocResponseDTO {
    private String DocId;
    private String firstName;
    private String lastName;
    private String instituteName;
    private String post;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeDoc;
    private DocStatus status;
    private String filePath;
    private String adress;
    private String contractType;
    private String salary;
    private String supervisorName;
    private String workingHours;
    private String month;
    private String year;
    private String details;
}

