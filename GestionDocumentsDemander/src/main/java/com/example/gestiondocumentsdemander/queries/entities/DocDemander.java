package com.example.gestiondocumentsdemander.queries.entities;

import com.example.gestiondocumentsdemander.enums.DocStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDemander {
    @Id
    private String docId;
    private String firstName;
    private String lastName;
    private String instituteName;
    private String post;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeDoc;
    @Enumerated(EnumType.STRING)
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
