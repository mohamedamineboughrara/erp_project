package com.example.gestiondocumentsdemander.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @AllArgsConstructor @NoArgsConstructor
public class DocRequestDTO {
     private String docId;
     private String firstName;
     private String lastName;
     private String instituteName;
     private String post;
     private LocalDate startDate;
     private LocalDate endDate;
     private String typeDoc;
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
